package com.devsenior.atiende.ticket;

import com.devsenior.atiende.ticket.dto.TicketResponse;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CalculadoraUrgencia {

    public record Puntaje(int valor, List<String> razones) {
    }

    public Puntaje calcular(TicketResponse ticket, long diasDeRetraso, LocalDate hoy) {
        int puntos = 0;
        List<String> razones = new ArrayList<>();

        int porPrioridad = switch (ticket.prioridad()) {
            case URGENTE -> 40;
            case ALTA -> 30;
            case MEDIA -> 15;
            case BAJA -> 5;
        };
        puntos += porPrioridad;
        razones.add("Prioridad " + ticket.prioridad() + ": +" + porPrioridad);

        if (ticket.sentimiento() == Sentimiento.MOLESTO) {
            puntos += 15;
            razones.add("Cliente molesto: +15");
        }

        if (ticket.fechaLimite() != null) {
            long diasParaLaFecha = ChronoUnit.DAYS.between(hoy, ticket.fechaLimite());
            if (diasParaLaFecha < 0) {
                puntos += 25;
                razones.add("Fecha límite vencida: +25");
            } else if (diasParaLaFecha <= 2) {
                puntos += 25;
                razones.add("Fecha límite en " + enDias(diasParaLaFecha) + ": +25");
            } else if (diasParaLaFecha <= 7) {
                puntos += 10;
                razones.add("Fecha límite en " + enDias(diasParaLaFecha) + ": +10");
            }
        }

        if (diasDeRetraso > 0) {
            int porRetraso = (int) Math.min(diasDeRetraso * 5, 20);
            puntos += porRetraso;
            razones.add("Pedido con " + enDias(diasDeRetraso) + " de retraso: +" + porRetraso);
        }

        return new Puntaje(puntos, razones);
    }

    private String enDias(long dias) {
        return dias == 1 ? "1 día" : dias + " días";
    }
}
