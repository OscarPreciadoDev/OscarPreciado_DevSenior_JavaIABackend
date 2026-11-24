package com.devsenior.atiende.ticket;

import java.time.LocalDate;

public record ClasificacionIA(
        Categoria categoria,
        Prioridad prioridad,
        Sentimiento sentimiento,
        String resumen,
        Long numeroPedido,
        LocalDate fechaLimite
) {

    public boolean estaCompleta() {
        return categoria != null
                && prioridad != null
                && sentimiento != null
                && resumen != null
                && !resumen.isBlank()
                && resumen.length() <= 300;
    }
}