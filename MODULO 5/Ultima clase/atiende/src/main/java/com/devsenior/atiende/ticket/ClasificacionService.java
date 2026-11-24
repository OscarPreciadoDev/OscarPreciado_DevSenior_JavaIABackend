package com.devsenior.atiende.ticket;

import com.devsenior.atiende.ia.AsistenteIA;
import com.devsenior.atiende.ia.BibliotecaPrompts;
import com.devsenior.atiende.ia.LectorJsonIA;
import com.devsenior.atiende.ia.RespuestaIA;
import com.devsenior.atiende.ia.RespuestaIAInvalidaException;
import com.devsenior.atiende.ia.dto.FacturaIA;
import com.devsenior.atiende.ticket.dto.ClasificacionResponse;
import com.devsenior.atiende.ticket.dto.TicketResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class ClasificacionService {

    private static final DateTimeFormatter FORMATO_DIA =
            DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy (yyyy-MM-dd)", Locale.forLanguageTag("es-CO"));
    private static final int MAXIMO_DIAS_FECHA_LIMITE = 60;

    private final TicketService ticketService;
    private final AsistenteIA asistenteIA;
    private final BibliotecaPrompts bibliotecaPrompts;
    private final LectorJsonIA lectorJsonIA;

    public ClasificacionService(TicketService ticketService, AsistenteIA asistenteIA,
                                BibliotecaPrompts bibliotecaPrompts, LectorJsonIA lectorJsonIA) {
        this.ticketService = ticketService;
        this.asistenteIA = asistenteIA;
        this.bibliotecaPrompts = bibliotecaPrompts;
        this.lectorJsonIA = lectorJsonIA;
    }

    public ClasificacionResponse clasificar(Long ticketId) {
        TicketResponse ticket = ticketService.buscarPorId(ticketId);
        LocalDate diaDelMensaje = ticket.fechaCreacion().toLocalDate();
        String instrucciones = bibliotecaPrompts.cargar("clasificacion", Map.of(
                "hoy", diaDelMensaje.format(FORMATO_DIA),
                "manana", diaDelMensaje.plusDays(1).toString()));
        RespuestaIA respuesta = asistenteIA.completar(instrucciones, ticket.mensaje());

        ClasificacionIA clasificacion = lectorJsonIA.leer(respuesta, ClasificacionIA.class);
        if (!clasificacion.estaCompleta()) {
            throw new RespuestaIAInvalidaException(respuesta.proveedor(), respuesta.texto());
        }
        Long numeroPedido = apareceEnElMensaje(clasificacion.numeroPedido(), ticket.mensaje())
                ? clasificacion.numeroPedido()
                : null;
        LocalDate fechaLimite = esFechaLimiteRazonable(clasificacion.fechaLimite(), diaDelMensaje)
                ? clasificacion.fechaLimite()
                : null;

        TicketResponse clasificado = ticketService.aplicarClasificacion(
                ticketId, clasificacion, numeroPedido, fechaLimite);
        return new ClasificacionResponse(clasificado, FacturaIA.de(respuesta));
    }

    private boolean apareceEnElMensaje(Long numeroPedido, String mensaje) {
        return numeroPedido != null
                && Pattern.compile("\\b" + numeroPedido + "\\b").matcher(mensaje).find();
    }

    private boolean esFechaLimiteRazonable(LocalDate fechaLimite, LocalDate diaDelMensaje) {
        return fechaLimite != null
                && !fechaLimite.isBefore(diaDelMensaje)
                && !fechaLimite.isAfter(diaDelMensaje.plusDays(MAXIMO_DIAS_FECHA_LIMITE));
    }
}