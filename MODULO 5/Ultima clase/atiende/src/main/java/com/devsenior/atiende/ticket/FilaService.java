package com.devsenior.atiende.ticket;

import com.devsenior.atiende.pedido.PedidoService;
import com.devsenior.atiende.ticket.dto.TicketEnFilaResponse;
import com.devsenior.atiende.ticket.dto.TicketResponse;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FilaService {

    private final TicketService ticketService;
    private final PedidoService pedidoService;
    private final CalculadoraUrgencia calculadoraUrgencia;

    public FilaService(TicketService ticketService, PedidoService pedidoService,
                       CalculadoraUrgencia calculadoraUrgencia) {
        this.ticketService = ticketService;
        this.pedidoService = pedidoService;
        this.calculadoraUrgencia = calculadoraUrgencia;
    }

    public List<TicketEnFilaResponse> filaDeTrabajo() {
        LocalDate hoy = LocalDate.now();
        return ticketService.listarPorAtender().stream()
                .map(ticket -> enFila(ticket, hoy))
                .sorted(Comparator.comparingInt(TicketEnFilaResponse::puntaje).reversed())
                .toList();
    }

    private TicketEnFilaResponse enFila(TicketResponse ticket, LocalDate hoy) {
        long diasDeRetraso = pedidoService.diasDeRetraso(ticket.numeroPedido());
        CalculadoraUrgencia.Puntaje puntaje = calculadoraUrgencia.calcular(ticket, diasDeRetraso, hoy);
        return new TicketEnFilaResponse(ticket.id(), ticket.clienteNombre(), ticket.categoria(),
                ticket.prioridad(), ticket.estadoIA(), ticket.resumen(), puntaje.valor(), puntaje.razones());
    }
}