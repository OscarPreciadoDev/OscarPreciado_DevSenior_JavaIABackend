package com.devSenior.atiende.ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devSenior.atiende.compartido.ExcepcionTicketNoEncontrado;
import com.devSenior.atiende.compartido.ExcepcionTransicionNoPermitida;
import com.devSenior.atiende.ticket.dto.CrearTicketPeticion;

class TicketServicioTest {

	private TicketRepositorio ticketRepositorio;
	private TicketServicio ticketServicio;

	@BeforeEach
	void inicializar_servicio_conRepositorioMock() {
		ticketRepositorio = mock(TicketRepositorio.class);
		ticketServicio = new TicketServicio(ticketRepositorio, new TicketMapeador());
	}

	@Test
	void crear_ticketNuevo_asignaEstadoAbiertoYPrioridadMedia() {
		when(ticketRepositorio.save(any(Ticket.class)))
				.thenAnswer(invocacion -> invocacion.getArgument(0));
		CrearTicketPeticion peticion = new CrearTicketPeticion(
				"Alex", "alex@example.com", CanalTicket.CORREO, "Necesito ayuda con mi pedido");

		com.devSenior.atiende.ticket.dto.TicketRespuesta respuesta = ticketServicio.crear(peticion);

		assertEquals(EstadoTicket.ABIERTO, respuesta.estado());
		assertEquals(PrioridadTicket.MEDIA, respuesta.prioridad());
	}

	@Test
	void buscarPorId_idInexistente_lanzaExcepcionTicketNoEncontrado() {
		when(ticketRepositorio.findById(99L)).thenReturn(Optional.empty());

		assertThrows(ExcepcionTicketNoEncontrado.class, () -> ticketServicio.buscarPorId(99L));
	}

	@Test
	void cambiarEstado_transicionPermitida_actualizaEstado() {
		Ticket ticket = ticketConEstado(EstadoTicket.ABIERTO);
		when(ticketRepositorio.findById(1L)).thenReturn(Optional.of(ticket));
		when(ticketRepositorio.saveAndFlush(ticket)).thenReturn(ticket);

		var respuesta = ticketServicio.cambiarEstado(1L, EstadoTicket.EN_PROCESO);

		assertEquals(EstadoTicket.EN_PROCESO, ticket.getEstado());
		assertEquals(EstadoTicket.EN_PROCESO, respuesta.estado());
		verify(ticketRepositorio).saveAndFlush(ticket);
	}

	@Test
	void cambiarEstado_transicionBloqueada_lanzaExcepcionYSinGuardar() {
		Ticket ticket = ticketConEstado(EstadoTicket.ABIERTO);
		when(ticketRepositorio.findById(1L)).thenReturn(Optional.of(ticket));

		assertThrows(ExcepcionTransicionNoPermitida.class,
				() -> ticketServicio.cambiarEstado(1L, EstadoTicket.RESUELTO));

		verify(ticketRepositorio, never()).saveAndFlush(any(Ticket.class));
	}

	private Ticket ticketConEstado(EstadoTicket estado) {
		Ticket ticket = new Ticket();
		ticket.setId(1L);
		ticket.setClienteNombre("Alex");
		ticket.setClienteContacto("alex@example.com");
		ticket.setCanal(CanalTicket.CORREO);
		ticket.setMensaje("Necesito ayuda con mi pedido");
		ticket.setEstado(estado);
		ticket.setPrioridad(PrioridadTicket.MEDIA);
		ticket.setFechaCreacion(LocalDateTime.now());
		ticket.setFechaActualizacion(LocalDateTime.now());
		return ticket;
	}
}
