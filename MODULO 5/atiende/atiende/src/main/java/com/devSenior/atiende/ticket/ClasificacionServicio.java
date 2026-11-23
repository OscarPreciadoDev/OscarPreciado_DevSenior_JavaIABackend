package com.devSenior.atiende.ticket;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.devSenior.atiende.ia.AsistenteIA;
import com.devSenior.atiende.ia.BibliotecaPrompts;
import com.devSenior.atiende.ia.ExcepcionRespuestaIAInvalida;
import com.devSenior.atiende.ia.LectorJsonIA;
import com.devSenior.atiende.ia.RespuestaIA;
import com.devSenior.atiende.ia.dto.FacturaIA;
import com.devSenior.atiende.ticket.dto.ClasificacionResponse;
import com.devSenior.atiende.ticket.dto.TicketRespuesta;

@Service
public class ClasificacionServicio {

	private final TicketServicio ticketServicio;
	private final AsistenteIA asistenteIA;
	private final BibliotecaPrompts bibliotecaPrompts;
	private final LectorJsonIA lectorJsonIA;

	public ClasificacionServicio(
			TicketServicio ticketServicio,
			AsistenteIA asistenteIA,
			BibliotecaPrompts bibliotecaPrompts,
			LectorJsonIA lectorJsonIA) {
		this.ticketServicio = ticketServicio;
		this.asistenteIA = asistenteIA;
		this.bibliotecaPrompts = bibliotecaPrompts;
		this.lectorJsonIA = lectorJsonIA;
	}

	public ClasificacionResponse clasificar(Long ticketId) {
		TicketRespuesta ticket = ticketServicio.buscarPorId(ticketId);
		RespuestaIA respuesta = asistenteIA.completar(
				bibliotecaPrompts.cargar("clasificacion"),
				ticket.mensaje());
		ClasificacionIA clasificacion = lectorJsonIA.leer(respuesta, ClasificacionIA.class);
		if (clasificacion == null || !clasificacion.estaCompleta()) {
			throw new ExcepcionRespuestaIAInvalida(respuesta.proveedor());
		}

		Long numeroPedido = numeroPedidoMencionado(clasificacion.numeroPedido(), ticket.mensaje())
				? clasificacion.numeroPedido()
				: null;
		TicketRespuesta ticketClasificado = ticketServicio.aplicarClasificacion(
				ticketId,
				clasificacion,
				numeroPedido);
		return new ClasificacionResponse(ticketClasificado, FacturaIA.de(respuesta));
	}

	private static boolean numeroPedidoMencionado(Long numeroPedido, String mensaje) {
		if (numeroPedido == null || mensaje == null) {
			return false;
		}
		Pattern numeroCompleto = Pattern.compile(
				"(?<![\\p{L}\\p{N}_])" + Pattern.quote(numeroPedido.toString()) + "(?![\\p{L}\\p{N}_])");
		return numeroCompleto.matcher(mensaje).find();
	}
}
