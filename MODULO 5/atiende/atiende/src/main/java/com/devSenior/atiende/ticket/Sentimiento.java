package com.devSenior.atiende.ticket;

import java.util.Locale;
import java.util.Optional;

public enum Sentimiento {
    MOLESTO,
    NEUTRAL,
    CONTENTO;

    public static Optional<Sentimiento> desdeTextoIA(String texto) {
        if (texto == null) {
            return Optional.empty();
        }
        String limpio = texto.strip();
        if (limpio.startsWith("**") && limpio.endsWith("**") && limpio.length() > 4) {
            limpio = limpio.substring(2, limpio.length() - 2).strip();
        }
        if (limpio.endsWith(".")) {
            limpio = limpio.substring(0, limpio.length() - 1).strip();
        }
        try {
            return Optional.of(valueOf(limpio.toUpperCase(Locale.ROOT)));
        } catch (IllegalArgumentException excepcion) {
            return Optional.empty();
        }
    }
}