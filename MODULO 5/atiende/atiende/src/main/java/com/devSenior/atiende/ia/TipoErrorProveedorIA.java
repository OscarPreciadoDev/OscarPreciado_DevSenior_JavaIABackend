package com.devSenior.atiende.ia;

public enum TipoErrorProveedorIA {
	CONFIGURACION,
	TEMPORAL;

	public static TipoErrorProveedorIA desdeEstadoHttp(int estado) {
		return switch (estado) {
			case 400, 401, 403, 404 -> CONFIGURACION;
			default -> TEMPORAL;
		};
	}
}
