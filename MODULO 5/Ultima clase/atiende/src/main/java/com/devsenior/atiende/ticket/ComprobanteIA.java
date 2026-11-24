package com.devsenior.atiende.ticket;

import java.time.LocalDate;

public record ComprobanteIA(
        boolean esComprobante,
        String banco,
        Long valor,
        LocalDate fecha,
        String referencia,
        Long numeroPedido
) {
}
