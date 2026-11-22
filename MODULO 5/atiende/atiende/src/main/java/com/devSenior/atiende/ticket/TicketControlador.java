package com.devSenior.atiende.ticket;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devSenior.atiende.ticket.dto.CambiarEstadoPeticion;
import com.devSenior.atiende.ticket.dto.CrearTicketPeticion;
import com.devSenior.atiende.ticket.dto.TicketRespuesta;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tickets")
public class TicketControlador {

	private final TicketServicio ticketServicio;

	public TicketControlador(TicketServicio ticketServicio) {
		this.ticketServicio = ticketServicio;
	}

	@PostMapping
	public ResponseEntity<TicketRespuesta> crear(@Valid @RequestBody CrearTicketPeticion peticion) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ticketServicio.crear(peticion));
	}

	@GetMapping
	public List<TicketRespuesta> listar(@RequestParam(required = false) EstadoTicket estado) {
		return ticketServicio.listar(estado);
	}

	@GetMapping("/{id}")
	public TicketRespuesta buscarPorId(@PathVariable Long id) {
		return ticketServicio.buscarPorId(id);
	}

	@PatchMapping("/{id}/estado")
	public TicketRespuesta cambiarEstado(
			@PathVariable Long id,
			@Valid @RequestBody CambiarEstadoPeticion peticion) {
		return ticketServicio.cambiarEstado(id, peticion.estado());
	}
}
