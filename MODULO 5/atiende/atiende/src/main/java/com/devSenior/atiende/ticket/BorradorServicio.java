package com.devSenior.atiende.ticket;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.devSenior.atiende.ia.AsistenteIA;
import com.devSenior.atiende.ia.BibliotecaPrompts;
import com.devSenior.atiende.ia.ExcepcionRespuestaIAInvalida;
import com.devSenior.atiende.ia.LectorJsonIA;
import com.devSenior.atiende.ia.RespuestaIA;
import com.devSenior.atiende.ia.dto.FacturaIA;
import com.devSenior.atiende.pedido.PedidoService;
import com.devSenior.atiende.ticket.dto.BorradorResponse;
import com.devSenior.atiende.ticket.dto.TicketRespuesta;

@Service
public class BorradorServicio {

	private final TicketServicio ticketServicio;
	private final PedidoService pedidoService;
	private final AsistenteIA asistenteIA;
	private final BibliotecaPrompts bibliotecaPrompts;
	private final LectorJsonIA lectorJsonIA;

	public BorradorServicio(
			TicketServicio ticketServicio,
			PedidoService pedidoService,
			AsistenteIA asistenteIA,
			BibliotecaPrompts bibliotecaPrompts,
			LectorJsonIA lectorJsonIA) {
		this.ticketServicio = ticketServicio;
		this.pedidoService = pedidoService;
		this.asistenteIA = asistenteIA;
		this.bibliotecaPrompts = bibliotecaPrompts;
		this.lectorJsonIA = lectorJsonIA;
	}

	public BorradorResponse redactar(Long ticketId) {
		TicketRespuesta ticket = ticketServicio.buscarPorId(ticketId);
		String formato = ticket.canal() == CanalTicket.CORREO
				? "Correo electrónico (incluye asunto)"
				: "Mensaje (sin asunto)";
		String instrucciones = bibliotecaPrompts.cargar("borrador-respuesta", Map.of(
				"cliente", ticket.clienteNombre(),
				"formato", formato,
				"datos", pedidoService.datosVerificados(ticket.numeroPedido())));
		RespuestaIA respuesta = asistenteIA.completar(instrucciones, ticket.mensaje());
		BorradorIA borrador = lectorJsonIA.leer(respuesta, BorradorIA.class);
		if (borrador == null
				|| !borrador.estaCompleto()
				|| (ticket.canal() == CanalTicket.CORREO
						&& (borrador.asunto() == null || borrador.asunto().isBlank()))) {
			throw new ExcepcionRespuestaIAInvalida(respuesta.proveedor());
		}

		String asunto = ticket.canal() == CanalTicket.CORREO ? borrador.asunto() : null;
		return new BorradorResponse(asunto, borrador.cuerpo(), FacturaIA.de(respuesta));
	}
}
