package com.devSenior.atiende.chat;

record RespuestaChatIA(String respuesta, Boolean escalar) {

	boolean estaCompleta() {
		return respuesta != null && !respuesta.isBlank() && escalar != null;
	}
}
