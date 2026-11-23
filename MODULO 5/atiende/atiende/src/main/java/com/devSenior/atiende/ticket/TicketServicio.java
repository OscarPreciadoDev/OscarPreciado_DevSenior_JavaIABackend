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
		TicketRespuesta respuesta = ticketMapeador.aRespuesta(buscarTicket(id));
		// #region agent log
		agenteLog("H5", "TicketServicio.buscarPorId", "fechas leidas en GET",
				"{\"id\":" + respuesta.id()
						+ ",\"fechaCreacion\":\"" + respuesta.fechaCreacion()
						+ "\",\"fechaActualizacion\":\"" + respuesta.fechaActualizacion()
						+ "\",\"iguales\":" + respuesta.fechaCreacion().equals(respuesta.fechaActualizacion()) + "}");
		// #endregion
		return respuesta;
	}

	public TicketRespuesta cambiarEstado(Long id, EstadoTicket destino) {
		Ticket ticket = buscarTicket(id);
		if (!ticket.getEstado().puedeCambiarA(destino)) {
			throw new ExcepcionTransicionNoPermitida(
					"No se puede cambiar el estado de " + ticket.getEstado() + " a " + destino);
		}
		ticket.setEstado(destino);
		// #region agent log
		agenteLog("H1", "TicketServicio.cambiarEstado:antes", "entidad antes de saveAndFlush",
				fechasJson(ticket, true));
		// #endregion
		Ticket guardado = ticketRepositorio.saveAndFlush(ticket);
		// #region agent log
		agenteLog("H2", "TicketServicio.cambiarEstado:despues", "entidad devuelta por saveAndFlush",
				fechasJson(guardado, guardado == ticket));
		// #endregion
		TicketRespuesta respuesta = ticketMapeador.aRespuesta(guardado);
		// #region agent log
		agenteLog("H4", "TicketServicio.cambiarEstado:dto", "DTO armado tras el flush",
				"{\"id\":" + respuesta.id()
						+ ",\"fechaCreacion\":\"" + respuesta.fechaCreacion()
						+ "\",\"fechaActualizacion\":\"" + respuesta.fechaActualizacion()
						+ "\",\"iguales\":" + respuesta.fechaCreacion().equals(respuesta.fechaActualizacion()) + "}");
		// #endregion
		return respuesta;
	}

	public TicketRespuesta aplicarClasificacion(Long id, ClasificacionIA clasificacion, Long numeroPedido) {
		Ticket ticket = buscarTicket(id);
		ticket.setCategoria(clasificacion.categoria());
		ticket.setPrioridad(clasificacion.prioridad());
		ticket.setSentimiento(clasificacion.sentimiento());
		ticket.setResumen(clasificacion.resumen());
		ticket.setNumeroPedido(numeroPedido);
		return ticketMapeador.aRespuesta(ticketRepositorio.saveAndFlush(ticket));
	}

	// #region agent log
	private static String fechasJson(Ticket ticket, boolean mismaInstancia) {
		return "{\"id\":" + ticket.getId()
				+ ",\"identidad\":" + System.identityHashCode(ticket)
				+ ",\"estado\":\"" + ticket.getEstado()
				+ "\",\"fechaCreacion\":\"" + ticket.getFechaCreacion()
				+ "\",\"fechaActualizacion\":\"" + ticket.getFechaActualizacion()
				+ "\",\"iguales\":" + ticket.getFechaCreacion().equals(ticket.getFechaActualizacion())
				+ ",\"mismaInstancia\":" + mismaInstancia + "}";
	}

	private static void agenteLog(String hypothesisId, String location, String message, String dataJson) {
		try (var escritor = java.nio.file.Files.newBufferedWriter(
				java.nio.file.Path.of("c:\\Users\\oprec\\Documents\\_ Code\\DEV SENIOR\\JAVA IA ENGINNER\\JAVA IA BACKEND DEVELOPER\\REPOSITORIO\\MODULO 5\\.cursor\\debug-5231f2.log"),
				java.nio.charset.StandardCharsets.UTF_8,
				java.nio.file.StandardOpenOption.CREATE,
				java.nio.file.StandardOpenOption.APPEND)) {
			escritor.write("{\"sessionId\":\"5231f2\",\"runId\":\"pre-fix\",\"hypothesisId\":\"" + hypothesisId
					+ "\",\"location\":\"" + location + "\",\"message\":\"" + message + "\",\"data\":" + dataJson
					+ ",\"timestamp\":" + System.currentTimeMillis() + "}\n");
		} catch (Exception ignorada) {
		}
	}
	// #endregion

	private Ticket buscarTicket(Long id) {
		return ticketRepositorio.findById(id)
				.orElseThrow(() -> new ExcepcionTicketNoEncontrado(id));
	}
}
