package com.devSenior.atiende.ia.dto;

import java.math.BigDecimal;

import com.devSenior.atiende.ia.RespuestaIA;

public record FacturaIA(
		String proveedor,
		String modelo,
		long tokensEntrada,
		long tokensSalida,
		BigDecimal costoEstimadoUsd,
		long milisegundos) {

	public static FacturaIA de(RespuestaIA respuesta) {
		return new FacturaIA(
				respuesta.proveedor(),
				respuesta.modelo(),
				respuesta.tokensEntrada(),
				respuesta.tokensSalida(),
				respuesta.costoEstimadoUsd(),
				respuesta.milisegundos());
	}
}
