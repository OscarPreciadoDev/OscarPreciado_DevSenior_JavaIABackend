package com.devSenior.atiende.chat;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devSenior.atiende.chat.dto.ChatRequest;
import com.devSenior.atiende.chat.dto.ChatResponse;
import com.devSenior.atiende.chat.dto.RolTurno;
import com.devSenior.atiende.chat.dto.TurnoChat;
import com.devSenior.atiende.ia.AsistenteIA;
import com.devSenior.atiende.ia.BibliotecaPrompts;
import com.devSenior.atiende.ia.ExcepcionRespuestaIAInvalida;
import com.devSenior.atiende.ia.LectorJsonIA;
import com.devSenior.atiende.ia.RespuestaIA;
import com.devSenior.atiende.ia.dto.FacturaIA;
import com.devSenior.atiende.pedido.PedidoService;
import com.devSenior.atiende.ticket.CanalTicket;
import com.devSenior.atiende.ticket.TicketServicio;
import com.devSenior.atiende.ticket.dto.CrearTicketPeticion;
import com.devSenior.atiende.ticket.dto.TicketRespuesta;

@Service
public class ChatbotService {

	private static final int MAXIMO_MENSAJE_TICKET = 2000;
	private static final String RESPUESTA_SEGURA =
			"Gracias por escribirnos. Una persona del equipo revisará su caso y se pondrá en contacto con usted pronto.";
	private static final Pattern PROMESA_COMERCIAL = Pattern.compile(
			"\\b(cupon(?:es)?|descuento(?:s)?|reembolso(?:s)?|devolucion(?:es)?|promocion(?:es)?)\\b");

	private final AsistenteIA asistenteIA;
	private final BibliotecaPrompts bibliotecaPrompts;
	private final PedidoService pedidoService;
	private final LectorJsonIA lectorJsonIA;
	private final TicketServicio ticketServicio;

	public ChatbotService(
			AsistenteIA asistenteIA,
			BibliotecaPrompts bibliotecaPrompts,
			PedidoService pedidoService,
			LectorJsonIA lectorJsonIA,
			TicketServicio ticketServicio) {
		this.asistenteIA = asistenteIA;
		this.bibliotecaPrompts = bibliotecaPrompts;
		this.pedidoService = pedidoService;
		this.lectorJsonIA = lectorJsonIA;
		this.ticketServicio = ticketServicio;
	}

	public ChatResponse responder(ChatRequest peticion) {
		String instrucciones = bibliotecaPrompts.cargar("chatbot", Map.of(
				"cliente", peticion.clienteNombre(),
				"datos", pedidoService.datosVerificados(peticion.numeroPedido())));
		String historial = peticion.historial().stream()
				.map(ChatbotService::formatearTurno)
				.collect(Collectors.joining("\n"));
		RespuestaIA respuestaIA = asistenteIA.completar(instrucciones, historial);
		RespuestaChatIA respuesta = lectorJsonIA.leer(respuestaIA, RespuestaChatIA.class);
		if (respuesta == null || !respuesta.estaCompleta()) {
			throw new ExcepcionRespuestaIAInvalida(respuestaIA.proveedor());
		}

		boolean respuestaInsegura = prometeBeneficioComercial(respuesta.respuesta());
		boolean escalado = respuesta.escalar() || respuestaInsegura;
		String textoRespuesta = respuestaInsegura ? RESPUESTA_SEGURA : respuesta.respuesta();
		Long ticketId = escalado ? crearTicketEscalado(peticion) : null;
		return new ChatResponse(textoRespuesta, escalado, ticketId, FacturaIA.de(respuestaIA));
	}

	private Long crearTicketEscalado(ChatRequest peticion) {
		String mensaje = mensajeClienteLimitado(peticion.historial());
		TicketRespuesta ticket = ticketServicio.crear(new CrearTicketPeticion(
				peticion.clienteNombre(),
				peticion.clienteContacto(),
				CanalTicket.CHAT_WEB,
				mensaje));
		return ticket.id();
	}

	private static String formatearTurno(TurnoChat turno) {
		String rol = turno.rol() == RolTurno.CLIENTE ? "Cliente" : "Grano";
		String texto = turno.texto().replace('\r', ' ').replace('\n', ' ').strip();
		return rol + ": " + texto;
	}

	private static String mensajeClienteLimitado(List<TurnoChat> historial) {
		StringBuilder mensaje = new StringBuilder();
		for (TurnoChat turno : historial) {
			if (turno.rol() != RolTurno.CLIENTE) {
				continue;
			}
			String texto = turno.texto().replace('\r', ' ').replace('\n', ' ').strip();
			int espacio = MAXIMO_MENSAJE_TICKET - mensaje.length();
			if (mensaje.length() > 0) {
				if (espacio == 0) {
					break;
				}
				mensaje.append('\n');
				espacio--;
			}
			if (espacio <= 0) {
				break;
			}
			if (texto.length() > espacio) {
				mensaje.append(texto, 0, espacio);
				break;
			}
			mensaje.append(texto);
		}
		return mensaje.toString();
	}

	private static boolean prometeBeneficioComercial(String texto) {
		String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD)
				.replaceAll("\\p{M}+", "")
				.toLowerCase(Locale.ROOT);
		return PROMESA_COMERCIAL.matcher(normalizado).find();
	}
}
