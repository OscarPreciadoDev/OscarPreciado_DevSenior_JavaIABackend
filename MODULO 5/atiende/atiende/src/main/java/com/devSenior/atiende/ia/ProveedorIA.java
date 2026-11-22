package com.devSenior.atiende.ia;

public interface ProveedorIA {

	String nombre();

	RespuestaIA completar(String instrucciones, String mensaje);
}
