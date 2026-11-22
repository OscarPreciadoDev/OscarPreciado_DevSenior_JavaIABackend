package com.devSenior.atiende.ticket;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EstadoTicketTest {

	@ParameterizedTest
	@CsvSource({
			"ABIERTO, EN_PROCESO",
			"ABIERTO, CERRADO",
			"EN_PROCESO, RESUELTO",
			"RESUELTO, CERRADO",
			"RESUELTO, EN_PROCESO"
	})
	void puedeCambiarA_transicionPermitida_devuelveTrue(EstadoTicket origen, EstadoTicket destino) {
		assertTrue(origen.puedeCambiarA(destino));
	}

	@ParameterizedTest
	@CsvSource({
			"ABIERTO, RESUELTO",
			"EN_PROCESO, ABIERTO",
			"EN_PROCESO, CERRADO",
			"RESUELTO, ABIERTO",
			"CERRADO, ABIERTO",
			"CERRADO, EN_PROCESO"
	})
	void puedeCambiarA_transicionBloqueada_devuelveFalse(EstadoTicket origen, EstadoTicket destino) {
		assertFalse(origen.puedeCambiarA(destino));
	}
}
