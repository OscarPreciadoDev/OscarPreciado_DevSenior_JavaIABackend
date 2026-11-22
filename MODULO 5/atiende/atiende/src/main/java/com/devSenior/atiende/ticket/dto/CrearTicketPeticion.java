package com.devSenior.atiende.ticket.dto;

import com.devSenior.atiende.ticket.CanalTicket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CrearTicketPeticion(
		@NotBlank(message = "es obligatorio")
		@Size(max = 100, message = "supera el máximo permitido")
		String clienteNombre,

		@NotBlank(message = "es obligatorio")
		@Size(max = 120, message = "supera el máximo permitido")
		String clienteContacto,

		@NotNull(message = "es obligatorio")
		CanalTicket canal,

		@NotBlank(message = "es obligatorio")
		@Size(max = 2000, message = "supera el máximo permitido")
		String mensaje) {
}
