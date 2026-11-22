package com.devSenior.atiende.ia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TipoErrorProveedorIATest {

	@Test
	void desdeEstadoHttp_clasificaErroresDeConfiguracion() {
		for (int estado : new int[] { 400, 401, 403, 404 }) {
			assertEquals(
					TipoErrorProveedorIA.CONFIGURACION,
					TipoErrorProveedorIA.desdeEstadoHttp(estado),
					"HTTP " + estado);
		}
	}

	@Test
	void desdeEstadoHttp_clasificaErroresTemporales() {
		for (int estado : new int[] { 429, 500, 503, 529 }) {
			assertEquals(
					TipoErrorProveedorIA.TEMPORAL,
					TipoErrorProveedorIA.desdeEstadoHttp(estado),
					"HTTP " + estado);
		}
	}
}
