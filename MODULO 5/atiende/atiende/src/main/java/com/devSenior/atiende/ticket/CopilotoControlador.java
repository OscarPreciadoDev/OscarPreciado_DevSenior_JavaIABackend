package com.devSenior.atiende.ticket;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devSenior.atiende.ticket.dto.BorradorResponse;
import com.devSenior.atiende.ticket.dto.ClasificacionResponse;

@RestController
@RequestMapping("/api/tickets/{id}")
public class CopilotoControlador {

	private final ClasificacionServicio clasificacionServicio;
	private final BorradorServicio borradorServicio;

	public CopilotoControlador(
			ClasificacionServicio clasificacionServicio,
			BorradorServicio borradorServicio) {
		this.clasificacionServicio = clasificacionServicio;
		this.borradorServicio = borradorServicio;
	}

	@PostMapping("/clasificacion")
	public ClasificacionResponse clasificar(@PathVariable Long id) {
		return clasificacionServicio.clasificar(id);
	}

	@PostMapping("/borrador")
	public BorradorResponse redactar(@PathVariable Long id) {
		return borradorServicio.redactar(id);
	}
}
