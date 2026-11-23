package com.devSenior.atiende.ticket;

import org.springframework.stereotype.Service;

import com.devSenior.atiende.ia.AsistenteIA;
import com.devSenior.atiende.ia.BibliotecaPrompts;
import com.devSenior.atiende.ia.ExcepcionRespuestaIAInvalida;
import com.devSenior.atiende.ia.RespuestaIA;
import com.devSenior.atiende.ticket.dto.AnalisisSentimientoRespuesta;
import com.devSenior.atiende.ticket.dto.TicketRespuesta;

@Service
public class SentimientoServicio {

	private final TicketServicio ticketServicio;
	private final AsistenteIA asistenteIA;
	private final BibliotecaPrompts bibliotecaPrompts;

	public SentimientoServicio(
			TicketServicio ticketServicio,
			AsistenteIA asistenteIA,
			BibliotecaPrompts bibliotecaPrompts) {
		this.ticketServicio = ticketServicio;
		this.asistenteIA = asistenteIA;
		this.bibliotecaPrompts = bibliotecaPrompts;
	}

	public AnalisisSentimientoRespuesta analizar(Long ticketId) {
		TicketRespuesta ticket = ticketServicio.buscarPorId(ticketId);
		RespuestaIA respuesta = asistenteIA.completar(bibliotecaPrompts.cargar("sentimiento"), ticket.mensaje());

		Sentimiento sentimiento = Sentimiento.desdeTextoIA(respuesta.texto())
				.orElseThrow(() -> new ExcepcionRespuestaIAInvalida(respuesta.proveedor()));

		return new AnalisisSentimientoRespuesta(
				ticketId,
				sentimiento,
				respuesta.proveedor(),
				respuesta.modelo(),
				respuesta.tokensEntrada(),
				respuesta.tokensSalida(),
				respuesta.costoEstimadoUsd(),
				respuesta.milisegundos());
	}
}
