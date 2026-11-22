package com.devSenior.atiende.ia;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

final class DatosRespuestaIA {

	private DatosRespuestaIA() {
	}

	static Map<?, ?> mapa(Object valor) {
		return valor instanceof Map<?, ?> mapa ? mapa : Map.of();
	}

	static String texto(Object valor) {
		return valor instanceof String texto ? texto : "";
	}

	static long numero(Map<?, ?> mapa, String campo) {
		Object valor = mapa.get(campo);
		return valor instanceof Number numero ? numero.longValue() : 0;
	}

	static BigDecimal calcularCosto(
			long tokensEntrada,
			long tokensSalida,
			IaProperties.ProveedorProperties propiedades) {
		BigDecimal costoEntrada = propiedades.getPrecioEntradaMillon()
				.multiply(BigDecimal.valueOf(tokensEntrada));
		BigDecimal costoSalida = propiedades.getPrecioSalidaMillon()
				.multiply(BigDecimal.valueOf(tokensSalida));
		return costoEntrada.add(costoSalida)
				.divide(BigDecimal.valueOf(1_000_000), 10, RoundingMode.HALF_UP);
	}

	static long duracionMilisegundos(long inicio) {
		return (System.nanoTime() - inicio) / 1_000_000;
	}
}
