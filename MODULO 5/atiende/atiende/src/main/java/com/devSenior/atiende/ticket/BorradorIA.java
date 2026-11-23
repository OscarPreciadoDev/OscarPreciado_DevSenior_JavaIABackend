package com.devSenior.atiende.ticket;

public record BorradorIA(String asunto, String cuerpo) {

	public boolean estaCompleto() {
		return cuerpo != null && !cuerpo.isBlank();
	}
}
