package com.devSenior.atiende.ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devSenior.atiende.ia.AsistenteIA;
import com.devSenior.atiende.ia.BibliotecaPrompts;
import com.devSenior.atiende.ia.ExcepcionRespuestaIAInvalida;
import com.devSenior.atiende.ia.RespuestaIA;
import com.devSenior.atiende.ticket.dto.AnalisisSentimientoRespuesta;
import com.devSenior.atiende.ticket.dto.TicketRespuesta;

class SentimientoServicioTest {

	private TicketServicio ticketServicio;
	private AsistenteIA asistenteIA;
	private SentimientoServicio sentimientoServicio;

	@BeforeEach
	void inicializarServicio() {
		ticketServicio = mock(TicketServicio.class);
		asistenteIA = mock(AsistenteIA.class);
		sentimientoServicio = new SentimientoServicio(ticketServicio, asistenteIA, new BibliotecaPrompts());
		when(ticketServicio.buscarPorId(1L)).thenReturn(ticketDePrueba());
	}

	@Test
	void analizar_respuestaValida_devuelveAnalisisConMetadatos() {
		when(asistenteIA.completar(org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.eq("Estoy muy molesto")))
				.thenReturn(new RespuestaIA(
						"MOLESTO", "openai", "gemini-test", 25, 4,
						new BigDecimal("0.00002"), 42));

		AnalisisSentimientoRespuesta respuesta = sentimientoServicio.analizar(1L);

		assertEquals(1L, respuesta.ticketId());
		assertEquals(Sentimiento.MOLESTO, respuesta.sentimiento());
		assertEquals("openai", respuesta.proveedor());
		assertEquals("gemini-test", respuesta.modelo());
		assertEquals(25L, respuesta.tokensEntrada());
		assertEquals(4L, respuesta.tokensSalida());
		assertEquals(new BigDecimal("0.00002"), respuesta.costoEstimadoUsd());
		assertEquals(42L, respuesta.milisegundos());
	}

	@Test
	void analizar_respuestaFueraDeCatalogo_lanzaExcepcionDeRespuestaInvalida() {
		when(asistenteIA.completar(org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.eq("Estoy muy molesto")))
				.thenReturn(new RespuestaIA(
						"CONTENO", "openai", "gemini-test", 25, 4,
						BigDecimal.ZERO, 42));

		assertThrows(ExcepcionRespuestaIAInvalida.class, () -> sentimientoServicio.analizar(1L));
	}

	private static TicketRespuesta ticketDePrueba() {
		return new TicketRespuesta(
				1L,
				"Laura",
				"laura@example.com",
				CanalTicket.CORREO,
				"Estoy muy molesto",
				EstadoTicket.ABIERTO,
				PrioridadTicket.MEDIA,
				LocalDateTime.now(),
				LocalDateTime.now());
	}
}
