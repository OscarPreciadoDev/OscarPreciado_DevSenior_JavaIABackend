package com.devSenior.atiende.ticket.dto;

import java.time.LocalDateTime;

import com.devSenior.atiende.ticket.CanalTicket;
import com.devSenior.atiende.ticket.Categoria;
import com.devSenior.atiende.ticket.EstadoTicket;
import com.devSenior.atiende.ticket.PrioridadTicket;
import com.devSenior.atiende.ticket.Sentimiento;

public record TicketRespuesta(
		Long id,
		String clienteNombre,
		String clienteContacto,
		CanalTicket canal,
		String mensaje,
		EstadoTicket estado,
		PrioridadTicket prioridad,
		Categoria categoria,
		Sentimiento sentimiento,
		String resumen,
		Long numeroPedido,
		LocalDateTime fechaCreacion,
		LocalDateTime fechaActualizacion) {
}
