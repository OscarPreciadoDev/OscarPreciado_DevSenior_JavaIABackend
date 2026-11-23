package com.devSenior.atiende.ticket;

public record ClasificacionIA(
		Categoria categoria,
		PrioridadTicket prioridad,
		Sentimiento sentimiento,
		String resumen,
		Long numeroPedido) {

	public boolean estaCompleta() {
		return categoria != null
				&& prioridad != null
				&& sentimiento != null
				&& resumen != null
				&& !resumen.isBlank()
				&& resumen.strip().split("\\s+").length <= 20;
	}
}
