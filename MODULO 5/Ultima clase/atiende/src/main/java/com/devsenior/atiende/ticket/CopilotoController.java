package com.devsenior.atiende.ticket;

import com.devsenior.atiende.ticket.dto.BorradorResponse;
import com.devsenior.atiende.ticket.dto.ClasificacionResponse;
import com.devsenior.atiende.ticket.dto.TicketEnFilaResponse;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
public class CopilotoController {

    private final ClasificacionService clasificacionService;
    private final BorradorService borradorService;
    private final FilaService filaService;

    public CopilotoController(ClasificacionService clasificacionService, BorradorService borradorService,
                              FilaService filaService) {
        this.clasificacionService = clasificacionService;
        this.borradorService = borradorService;
        this.filaService = filaService;
    }

    @PostMapping("/{id}/clasificacion")
    public ClasificacionResponse clasificar(@PathVariable Long id) {
        return clasificacionService.clasificar(id);
    }

    @PostMapping("/{id}/borrador")
    public BorradorResponse redactarBorrador(@PathVariable Long id) {
        return borradorService.redactar(id);
    }

    @GetMapping("/fila")
    public List<TicketEnFilaResponse> filaDeTrabajo() {
        return filaService.filaDeTrabajo();
    }
}