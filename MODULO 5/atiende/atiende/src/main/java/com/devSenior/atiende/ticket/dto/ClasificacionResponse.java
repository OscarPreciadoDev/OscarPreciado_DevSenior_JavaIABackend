package com.devSenior.atiende.ticket.dto;

import com.devSenior.atiende.ia.dto.FacturaIA;

public record ClasificacionResponse(
		TicketRespuesta ticket,
		FacturaIA factura
) {
}