package com.devSenior.atiende.ia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

class AsistenteIATest {

	@Test
	void completar_proveedorPrincipalResponde_noLlamaAlRespaldo() {
		ProveedorIA openai = mock(ProveedorIA.class);
		ProveedorIA claude = mock(ProveedorIA.class);
		RespuestaIA respuesta = new RespuestaIA(
				"MOLESTO", "openai", "gemini-test", 10, 4, BigDecimal.ZERO, 12);
		when(openai.nombre()).thenReturn("openai");
		when(claude.nombre()).thenReturn("claude");
		when(openai.completar("instrucciones", "mensaje")).thenReturn(respuesta);

		AsistenteIA asistente = new AsistenteIA(List.of(claude, openai));

		assertSame(respuesta, asistente.completar("instrucciones", "mensaje"));
		verify(openai).completar("instrucciones", "mensaje");
		verify(claude, never()).completar("instrucciones", "mensaje");
	}

	@Test
	void completar_proveedorPrincipalFallaCon429_usaClaudeComoRespaldo() {
		ProveedorIA openai = mock(ProveedorIA.class);
		ProveedorIA claude = mock(ProveedorIA.class);
		RespuestaIA respuesta = new RespuestaIA(
				"MOLESTO", "claude", "qwen3:1.7b", 12, 3, BigDecimal.ZERO, 15);
		when(openai.nombre()).thenReturn("openai");
		when(claude.nombre()).thenReturn("claude");
		when(openai.completar("instrucciones", "mensaje"))
				.thenThrow(HttpClientErrorException.create(
						HttpStatus.TOO_MANY_REQUESTS,
						"Demasiadas solicitudes",
						HttpHeaders.EMPTY,
						new byte[0],
						StandardCharsets.UTF_8));
		when(claude.completar("instrucciones", "mensaje")).thenReturn(respuesta);

		AsistenteIA asistente = new AsistenteIA(List.of(claude, openai));

		assertSame(respuesta, asistente.completar("instrucciones", "mensaje"));
		InOrder orden = inOrder(openai, claude);
		orden.verify(openai).completar("instrucciones", "mensaje");
		orden.verify(claude).completar("instrucciones", "mensaje");
	}

	@Test
	void completar_todosFallan_lanzaExcepcionIAProveedorNoDisponible() {
		ProveedorIA openai = mock(ProveedorIA.class);
		ProveedorIA claude = mock(ProveedorIA.class);
		when(openai.nombre()).thenReturn("openai");
		when(claude.nombre()).thenReturn("claude");
		when(openai.completar("instrucciones", "mensaje"))
				.thenThrow(HttpClientErrorException.create(
						HttpStatus.SERVICE_UNAVAILABLE,
						"Servicio no disponible",
						HttpHeaders.EMPTY,
						new byte[0],
						StandardCharsets.UTF_8));
		when(claude.completar("instrucciones", "mensaje"))
				.thenThrow(new ExcepcionRespuestaVaciaIA("claude"));

		AsistenteIA asistente = new AsistenteIA(List.of(openai, claude));

		ExcepcionIAProveedorNoDisponible excepcion = assertThrows(
				ExcepcionIAProveedorNoDisponible.class,
				() -> asistente.completar("instrucciones", "mensaje"));
		assertEquals("No hay proveedores de IA disponibles", excepcion.getMessage());
	}
}
