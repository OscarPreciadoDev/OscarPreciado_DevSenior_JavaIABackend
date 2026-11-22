package com.devSenior.atiende.ia;

public class ExcepcionRespuestaIAInvalida extends RuntimeException {

	public ExcepcionRespuestaIAInvalida(String proveedor) {
		super("El proveedor de IA " + proveedor + " devolvió un sentimiento no válido");
	}
}
