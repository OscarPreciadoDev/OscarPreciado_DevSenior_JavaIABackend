package com.devSenior.atiende.chat.dto;

import com.devSenior.atiende.ia.dto.FacturaIA;

public record ChatResponse(
		String respuesta,
		boolean escalado,
		Long ticketId,
		FacturaIA factura) {
}
