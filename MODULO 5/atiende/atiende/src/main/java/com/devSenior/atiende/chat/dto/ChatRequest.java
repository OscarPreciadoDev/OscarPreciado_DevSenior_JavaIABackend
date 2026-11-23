package com.devSenior.atiende.chat.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ChatRequest(
		@NotBlank(message = "es obligatorio")
		@Size(max = 100, message = "supera el máximo permitido")
		String clienteNombre,

		@NotBlank(message = "es obligatorio")
		@Size(max = 120, message = "supera el máximo permitido")
		String clienteContacto,

		@Positive(message = "debe ser un número positivo")
		Long numeroPedido,

		@NotEmpty(message = "debe incluir al menos un turno")
		@Size(max = 20, message = "no puede superar 20 turnos")
		List<@NotNull(message = "no puede ser nulo") @Valid TurnoChat> historial) {

		@AssertTrue(message = "debe incluir al menos un turno del cliente")
		public boolean isHistorialConCliente() {
			return historial != null && historial.stream()
					.anyMatch(turno -> turno != null && turno.rol() == RolTurno.CLIENTE);
		}
}
