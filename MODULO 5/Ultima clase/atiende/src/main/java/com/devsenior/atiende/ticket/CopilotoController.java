package com.devsenior.atiende.ticket;

import com.devsenior.atiende.ticket.dto.BorradorResponse;
import com.devsenior.atiende.ticket.dto.ClasificacionResponse;
import com.devsenior.atiende.ticket.dto.ComprobanteResponse;
import com.devsenior.atiende.ticket.dto.TicketEnFilaResponse;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/tickets")
public class CopilotoController {

    private final ClasificacionService clasificacionService;
    private final BorradorService borradorService;
    private final FilaService filaService;
    private final ComprobanteService comprobanteService;

    public CopilotoController(ClasificacionService clasificacionService, BorradorService borradorService,
                              FilaService filaService, ComprobanteService comprobanteService) {
        this.clasificacionService = clasificacionService;
        this.borradorService = borradorService;
        this.filaService = filaService;
        this.comprobanteService = comprobanteService;
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

    @PostMapping(value = "/{id}/comprobante", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ComprobanteResponse analizarComprobante(@PathVariable Long id,
                                                   @RequestParam("archivo") MultipartFile archivo) {
        return comprobanteService.analizar(id, archivo);
    }
}