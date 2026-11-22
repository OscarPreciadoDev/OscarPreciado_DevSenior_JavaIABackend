package com.devSenior.atiende.compartido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.devSenior.atiende.ia.ExcepcionIAProveedorNoDisponible;
import com.devSenior.atiende.ia.ExcepcionRespuestaIAInvalida;

class ManejadorExcepcionesIATest {

	private final ManejadorExcepciones manejador = new ManejadorExcepciones();

	@Test
	void respuestaIAInvalida_responde502ConErrorEstructurado() {
		var respuesta = manejador.respuestaIAInvalida(new ExcepcionRespuestaIAInvalida("openai"));

		assertEquals(HttpStatus.BAD_GATEWAY, respuesta.getStatusCode());
		assertEquals("RESPUESTA_IA_INVALIDA", respuesta.getBody().codigo());
	}

	@Test
	void proveedoresNoDisponibles_responde503ConErrorEstructurado() {
		var respuesta = manejador.proveedoresIANoDisponibles(new ExcepcionIAProveedorNoDisponible());

		assertEquals(HttpStatus.SERVICE_UNAVAILABLE, respuesta.getStatusCode());
		assertEquals("IA_NO_DISPONIBLE", respuesta.getBody().codigo());
	}
}
