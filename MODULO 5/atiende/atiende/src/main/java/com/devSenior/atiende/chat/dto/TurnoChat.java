package com.devSenior.atiende.chat.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TurnoChat(
		@NotNull(message = "es obligatorio")
		RolTurno rol,

		@NotBlank(message = "es obligatorio")
		@Size(max = 500, message = "supera el máximo permitido")
		String texto) {
}
