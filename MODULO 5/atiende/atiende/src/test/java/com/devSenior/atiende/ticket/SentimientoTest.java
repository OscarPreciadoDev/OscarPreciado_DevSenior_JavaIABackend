package com.devSenior.atiende.ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class SentimientoTest {

	@Test
	void desdeTextoIA_aceptaValoresEsperados() {
		assertAll(
				() -> assertEquals(Optional.of(Sentimiento.MOLESTO), Sentimiento.desdeTextoIA("MOLESTO")),
				() -> assertEquals(Optional.of(Sentimiento.MOLESTO), Sentimiento.desdeTextoIA("molesto")),
				() -> assertEquals(Optional.of(Sentimiento.NEUTRAL), Sentimiento.desdeTextoIA(" Neutral.")),
				() -> assertEquals(Optional.of(Sentimiento.CONTENTO), Sentimiento.desdeTextoIA("**CONTENTO**")));
	}

	@Test
	void desdeTextoIA_rechazaValoresFueraDelCatalogoOVariaciones() {
		assertTrue(Sentimiento.desdeTextoIA("CONTENO").isEmpty());
		assertTrue(Sentimiento.desdeTextoIA("MOLEYSTO").isEmpty());
		assertTrue(Sentimiento.desdeTextoIA("NEGATIVO").isEmpty());
		assertTrue(Sentimiento.desdeTextoIA("El cliente está molesto").isEmpty());
		assertTrue(Sentimiento.desdeTextoIA("").isEmpty());
	}
}
