package com.devSenior.atiende.ticket.dto;

import com.devSenior.atiende.ia.dto.FacturaIA;

public record BorradorResponse(
		String asunto,
		String cuerpo,
		FacturaIA factura) {
}
