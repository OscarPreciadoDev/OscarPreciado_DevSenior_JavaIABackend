package com.devSenior.atiende.ticket.dto;

import com.devSenior.atiende.ticket.EstadoTicket;

import jakarta.validation.constraints.NotNull;

public record CambiarEstadoPeticion(
		@NotNull(message = "es obligatorio")
		EstadoTicket estado) {
}
