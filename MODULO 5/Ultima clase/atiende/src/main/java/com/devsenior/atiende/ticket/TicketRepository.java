package com.devsenior.atiende.ticket;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

       List<Ticket> findAllByOrderByFechaCreacionDesc();

    List<Ticket> findByEstadoOrderByFechaCreacionDesc(EstadoTicket estado);

    List<Ticket> findByEstadoIAOrderByFechaCreacionAsc(EstadoIA estadoIA, Pageable pagina);

    List<Ticket> findByEstadoIn(List<EstadoTicket> estados);

    List<Ticket> findByFechaCreacionGreaterThanEqual(LocalDateTime desde);
}