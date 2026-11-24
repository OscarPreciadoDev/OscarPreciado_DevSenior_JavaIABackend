package com.devsenior.atiende.ticket.dto;

import com.devsenior.atiende.ticket.Categoria;
import com.devsenior.atiende.ticket.EstadoIA;
import com.devsenior.atiende.ticket.Prioridad;
import java.util.List;

public record TicketEnFilaResponse(
        Long id,
        String clienteNombre,
        Categoria categoria,
        Prioridad prioridad,
        EstadoIA estadoIA,
        String resumen,
        int puntaje,
        List<String> razones
) {
}