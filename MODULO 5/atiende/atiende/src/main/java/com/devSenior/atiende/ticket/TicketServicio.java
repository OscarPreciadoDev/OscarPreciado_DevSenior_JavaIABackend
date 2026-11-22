package com.devSenior.atiende.ticket;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devSenior.atiende.compartido.ExcepcionTicketNoEncontrado;
import com.devSenior.atiende.compartido.ExcepcionTransicionNoPermitida;
import com.devSenior.atiende.ticket.dto.CrearTicketPeticion;
import com.devSenior.atiende.ticket.dto.TicketRespuesta;

@Service
@Transactional
public class TicketServicio {

	private final TicketRepositorio ticketRepositorio;
	private final TicketMapeador ticketMapeador;

	public TicketServicio(TicketRepositorio ticketRepositorio, TicketMapeador ticketMapeador) {
		this.ticketRepositorio = ticketRepositorio;
		this.ticketMapeador = ticketMapeador;
	}

	public TicketRespuesta crear(CrearTicketPeticion peticion) {
		Ticket ticket = new Ticket();
		ticket.setClienteNombre(peticion.clienteNombre());
		ticket.setClienteContacto(peticion.clienteContacto());
		ticket.setCanal(peticion.canal());
		ticket.setMensaje(peticion.mensaje());
		ticket.setEstado(EstadoTicket.ABIERTO);
		ticket.setPrioridad(PrioridadTicket.MEDIA);
		return ticketMapeador.aRespuesta(ticketRepositorio.save(ticket));
	}

	@Transactional(readOnly = true)
	public List<TicketRespuesta> listar(EstadoTicket estado) {
		List<Ticket> tickets = estado == null
				? ticketRepositorio.buscarTodos()
				: ticketRepositorio.buscarPorEstado(estado);
		return tickets.stream().map(ticketMapeador::aRespuesta).toList();
	}

	@Transactional(readOnly = true)
	public TicketRespuesta buscarPorId(Long id) {
		return ticketMapeador.aRespuesta(buscarTicket(id));
	}

	public TicketRespuesta cambiarEstado(Long id, EstadoTicket destino) {
		Ticket ticket = buscarTicket(id);
		if (!ticket.getEstado().puedeCambiarA(destino)) {
			throw new ExcepcionTransicionNoPermitida(
					"No se puede cambiar el estado de " + ticket.getEstado() + " a " + destino);
		}
		ticket.setEstado(destino);
		return ticketMapeador.aRespuesta(ticketRepositorio.saveAndFlush(ticket));
	}

	private Ticket buscarTicket(Long id) {
		return ticketRepositorio.findById(id)
				.orElseThrow(() -> new ExcepcionTicketNoEncontrado(id));
	}
}
