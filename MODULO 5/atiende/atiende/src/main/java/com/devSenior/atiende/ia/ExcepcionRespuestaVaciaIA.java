package com.devSenior.atiende.ia;

public class ExcepcionRespuestaVaciaIA extends RuntimeException {

	public ExcepcionRespuestaVaciaIA(String proveedor) {
		super("El proveedor " + proveedor + " devolvió una respuesta vacía o incompleta");
	}
}
