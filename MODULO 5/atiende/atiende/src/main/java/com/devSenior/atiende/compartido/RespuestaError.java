package com.devSenior.atiende.compartido;

import java.time.LocalDateTime;

public record RespuestaError(
		String codigo,
		String error,
		String mensaje,
		LocalDateTime fecha) {
}
