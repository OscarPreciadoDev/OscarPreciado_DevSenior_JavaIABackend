package com.devSenior.atiende.ia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

class AsistenteIATest {

	@Test
	void completar_proveedorPrincipalFalla_usaClaudeComoRespaldo() {
		ProveedorIA openai = mock(ProveedorIA.class);
		ProveedorIA claude = mock(ProveedorIA.class);
		RespuestaIA respuesta = new RespuestaIA(
				"MOLESTO", "claude", "qwen3:1.7b", 12, 3, BigDecimal.ZERO, 15);
		when(openai.nombre()).thenReturn("openai");
		when(claude.nombre()).thenReturn("claude");
		when(openai.completar("instrucciones", "mensaje"))
				.thenThrow(HttpClientErrorException.create(
						HttpStatus.UNAUTHORIZED,
						"No autorizado",
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
	void completar_todosFallan_lanzaServicioNoDisponible() {
		ProveedorIA openai = mock(ProveedorIA.class);
		ProveedorIA claude = mock(ProveedorIA.class);
		when(openai.nombre()).thenReturn("openai");
		when(claude.nombre()).thenReturn("claude");
		when(openai.completar("instrucciones", "mensaje"))
				.thenThrow(new ExcepcionRespuestaVaciaIA("openai"));
		when(claude.completar("instrucciones", "mensaje"))
				.thenThrow(new ExcepcionRespuestaVaciaIA("claude"));

		AsistenteIA asistente = new AsistenteIA(List.of(openai, claude));

		ResponseStatusException excepcion = assertThrows(
				ResponseStatusException.class,
				() -> asistente.completar("instrucciones", "mensaje"));
		assertEquals(HttpStatus.SERVICE_UNAVAILABLE, excepcion.getStatusCode());
	}
}
