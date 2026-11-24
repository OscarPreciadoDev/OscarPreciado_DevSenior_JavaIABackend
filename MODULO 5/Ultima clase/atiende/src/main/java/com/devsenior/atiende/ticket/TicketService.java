package com.devsenior.atiende.ticket;

import com.devsenior.atiende.compartido.RecursoNoEncontradoException;
import com.devsenior.atiende.ticket.dto.TicketRequest;
import com.devsenior.atiende.ticket.dto.TicketResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    @Transactional
    public TicketResponse crear(TicketRequest request) {
        Ticket ticket = ticketMapper.toEntity(request);
        ticket.setEstado(EstadoTicket.ABIERTO);
        ticket.setPrioridad(Prioridad.MEDIA);
        ticket.setEstadoIA(EstadoIA.PENDIENTE);
        return ticketMapper.toResponse(ticketRepository.save(ticket));
    }

    @Transactional(readOnly = true)
    public List<TicketResponse> listar(EstadoTicket estado) {
        List<Ticket> tickets = (estado == null)
                ? ticketRepository.findAllByOrderByFechaCreacionDesc()
                : ticketRepository.findByEstadoOrderByFechaCreacionDesc(estado);
        return tickets.stream()
                .map(ticketMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public TicketResponse buscarPorId(Long id) {
        return ticketMapper.toResponse(obtenerTicket(id));
    }

    @Transactional
    public TicketResponse cambiarEstado(Long id, EstadoTicket nuevoEstado) {
        Ticket ticket = obtenerTicket(id);
        if (!ticket.getEstado().puedeCambiarA(nuevoEstado)) {
            throw new TransicionInvalidaException(ticket.getEstado(), nuevoEstado);
        }
        ticket.setEstado(nuevoEstado);
        return ticketMapper.toResponse(ticketRepository.saveAndFlush(ticket));
    }

    @Transactional
    public TicketResponse aplicarClasificacion(Long id, ClasificacionIA clasificacion,
                                               Long numeroPedido, LocalDate fechaLimite) {
        Ticket ticket = obtenerTicket(id);
        ticket.setCategoria(clasificacion.categoria());
        ticket.setPrioridad(clasificacion.prioridad());
        ticket.setSentimiento(clasificacion.sentimiento());
        ticket.setResumen(clasificacion.resumen());
        ticket.setNumeroPedido(numeroPedido);
        ticket.setFechaLimite(fechaLimite);
        ticket.setEstadoIA(EstadoIA.CLASIFICADO);
        return ticketMapper.toResponse(ticketRepository.saveAndFlush(ticket));
    }

    @Transactional(readOnly = true)
    public List<Long> pendientesDeClasificar(int cantidad) {
        return ticketRepository.findByEstadoIAOrderByFechaCreacionAsc(EstadoIA.PENDIENTE, PageRequest.of(0, cantidad))
                .stream()
                .map(Ticket::getId)
                .toList();
    }

    @Transactional
    public void registrarFalloIA(Long id, int maximoIntentos) {
        Ticket ticket = obtenerTicket(id);
        ticket.setIntentosIA(ticket.getIntentosIA() + 1);
        if (ticket.getIntentosIA() >= maximoIntentos) {
            ticket.setEstadoIA(EstadoIA.FALLIDO);
        }
        ticketRepository.save(ticket);
    }

    @Transactional(readOnly = true)
    public List<TicketResponse> listarPorAtender() {
        return ticketRepository.findByEstadoIn(List.of(EstadoTicket.ABIERTO, EstadoTicket.EN_PROCESO))
                .stream()
                .map(ticketMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<TicketResponse> creadosDesde(LocalDateTime desde) {
        return ticketRepository.findByFechaCreacionGreaterThanEqual(desde)
                .stream()
                .map(ticketMapper::toResponse)
                .toList();
    }

    private Ticket obtenerTicket(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe el ticket con id " + id));
    }
}