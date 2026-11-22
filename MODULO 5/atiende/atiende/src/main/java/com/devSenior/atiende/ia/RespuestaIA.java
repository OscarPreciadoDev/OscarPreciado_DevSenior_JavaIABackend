package com.devSenior.atiende.ia;

import java.math.BigDecimal;

public record RespuestaIA(
		String texto,
		String proveedor,
		String modelo,
		long tokensEntrada,
		long tokensSalida,
		BigDecimal costoEstimadoUsd,
		long milisegundos) {
}
