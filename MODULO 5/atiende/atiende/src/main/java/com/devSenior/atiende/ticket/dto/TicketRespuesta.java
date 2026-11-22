package com.devSenior.atiende.ticket.dto;

import java.time.LocalDateTime;

import com.devSenior.atiende.ticket.CanalTicket;
import com.devSenior.atiende.ticket.EstadoTicket;
import com.devSenior.atiende.ticket.PrioridadTicket;

public record TicketRespuesta(
		Long id,
		String clienteNombre,
		String clienteContacto,
		CanalTicket canal,
		String mensaje,
		EstadoTicket estado,
		PrioridadTicket prioridad,
		LocalDateTime fechaCreacion,
		LocalDateTime fechaActualizacion) {
}
