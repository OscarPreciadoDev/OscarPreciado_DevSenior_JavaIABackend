package com.devSenior.atiende.ticket.dto;

import java.math.BigDecimal;

import com.devSenior.atiende.ticket.Sentimiento;

public record AnalisisSentimientoRespuesta(
		Long ticketId,
		Sentimiento sentimiento,
		String proveedor,
		String modelo,
		long tokensEntrada,
		long tokensSalida,
		BigDecimal costoEstimadoUsd,
		long milisegundos) {
}
