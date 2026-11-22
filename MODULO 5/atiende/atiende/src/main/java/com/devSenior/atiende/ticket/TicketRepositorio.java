package com.devSenior.atiende.ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepositorio extends JpaRepository<Ticket, Long> {

	@Query("SELECT t FROM Ticket t ORDER BY t.fechaCreacion DESC, t.id DESC")
	List<Ticket> buscarTodos();

	@Query("SELECT t FROM Ticket t WHERE t.estado = :estado ORDER BY t.fechaCreacion DESC, t.id DESC")
	List<Ticket> buscarPorEstado(@Param("estado") EstadoTicket estado);
}
