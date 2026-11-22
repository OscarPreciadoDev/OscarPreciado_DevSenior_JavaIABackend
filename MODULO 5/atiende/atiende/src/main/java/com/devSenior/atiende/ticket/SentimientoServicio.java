package com.devSenior.atiende.ticket;

import org.springframework.stereotype.Service;

import com.devSenior.atiende.ia.AsistenteIA;
import com.devSenior.atiende.ia.ExcepcionRespuestaIAInvalida;
import com.devSenior.atiende.ia.RespuestaIA;
import com.devSenior.atiende.ticket.dto.AnalisisSentimientoRespuesta;
import com.devSenior.atiende.ticket.dto.TicketRespuesta;

@Service
public class SentimientoServicio {

	private static final String INSTRUCCIONES = """
			Eres analista de atención al cliente de una tienda online de café.
			Clasifica el sentimiento del mensaje del cliente:
			- MOLESTO: queja, reclamo, retraso o frustración.
			- NEUTRAL: pregunta o solicitud de información.
			- CONTENTO: agradecimiento o elogio.
			Responde SOLO con una palabra: MOLESTO, NEUTRAL o CONTENTO.
			""";

	private final TicketServicio ticketServicio;
	private final AsistenteIA asistenteIA;

	public SentimientoServicio(TicketServicio ticketServicio, AsistenteIA asistenteIA) {
		this.ticketServicio = ticketServicio;
		this.asistenteIA = asistenteIA;
	}

	public AnalisisSentimientoRespuesta analizar(Long ticketId) {
		TicketRespuesta ticket = ticketServicio.buscarPorId(ticketId);
		RespuestaIA respuesta = asistenteIA.completar(INSTRUCCIONES, ticket.mensaje());

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
