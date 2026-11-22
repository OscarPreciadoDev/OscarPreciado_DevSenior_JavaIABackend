package com.devSenior.atiende.ticket;

import org.springframework.stereotype.Component;

import com.devSenior.atiende.ticket.dto.TicketRespuesta;

@Component
public class TicketMapeador {

	public TicketRespuesta aRespuesta(Ticket ticket) {
		return new TicketRespuesta(
				ticket.getId(),
				ticket.getClienteNombre(),
				ticket.getClienteContacto(),
				ticket.getCanal(),
				ticket.getMensaje(),
				ticket.getEstado(),
				ticket.getPrioridad(),
				ticket.getFechaCreacion(),
				ticket.getFechaActualizacion());
	}
}
