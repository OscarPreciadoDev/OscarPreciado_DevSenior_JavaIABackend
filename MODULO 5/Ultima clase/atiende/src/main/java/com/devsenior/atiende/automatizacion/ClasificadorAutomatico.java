package com.devsenior.atiende.automatizacion;

import com.devsenior.atiende.ia.IaNoDisponibleException;
import com.devsenior.atiende.ia.RespuestaIAInvalidaException;
import com.devsenior.atiende.ticket.ClasificacionService;
import com.devsenior.atiende.ticket.TicketService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClasificadorAutomatico {

    private static final Logger log = LoggerFactory.getLogger(ClasificadorAutomatico.class);

    private final TicketService ticketService;
    private final ClasificacionService clasificacionService;
    private final int tamanoLote;
    private final int maximoIntentos;

    public ClasificadorAutomatico(TicketService ticketService, ClasificacionService clasificacionService,
                                  @Value("${atiende.automatizacion.lote}") int tamanoLote,
                                  @Value("${atiende.automatizacion.max-intentos}") int maximoIntentos) {
        this.ticketService = ticketService;
        this.clasificacionService = clasificacionService;
        this.tamanoLote = tamanoLote;
        this.maximoIntentos = maximoIntentos;
    }

    @Scheduled(fixedDelayString = "${atiende.automatizacion.intervalo-ms}",
            initialDelayString = "${atiende.automatizacion.intervalo-ms}")
    public void clasificarPendientes() {
        List<Long> pendientes = ticketService.pendientesDeClasificar(tamanoLote);
        if (pendientes.isEmpty()) {
            return;
        }
        log.info("Automatización: {} ticket(s) pendiente(s) de clasificar", pendientes.size());

        for (Long ticketId : pendientes) {
            try {
                clasificacionService.clasificar(ticketId);
                log.info("Automatización: ticket {} clasificado", ticketId);
            } catch (RespuestaIAInvalidaException ex) {
                ticketService.registrarFalloIA(ticketId, maximoIntentos);
                log.warn("Automatización: la IA respondió algo inválido para el ticket {}", ticketId);
            } catch (IaNoDisponibleException ex) {
                log.warn("Automatización: la IA no está disponible; se reintenta en la próxima vuelta");
                return;
            }
        }
    }
}
