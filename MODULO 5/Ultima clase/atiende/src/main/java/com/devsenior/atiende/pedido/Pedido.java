package com.devsenior.atiende.pedido;

import java.time.LocalDate;

public record Pedido(
        Long numero,
        String producto,
        long total,
        EstadoPedido estado,
        String transportadora,
        String numeroGuia,
        LocalDate entregaEstimada
) {
}