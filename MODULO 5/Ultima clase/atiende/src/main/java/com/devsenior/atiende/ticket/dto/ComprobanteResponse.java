package com.devsenior.atiende.ticket.dto;

import com.devsenior.atiende.ia.dto.FacturaIA;
import com.devsenior.atiende.ticket.ComprobanteIA;

public record ComprobanteResponse(
        Long ticketId,
        ComprobanteIA datosExtraidos,
        Resultado resultado,
        String siguientePaso,
        FacturaIA factura
) {

    public enum Resultado {
        COINCIDE("Confirmar en el banco que el dinero llegó y luego pasar el pedido a preparación."),
        VALOR_DISTINTO("El valor no coincide con el total del pedido: revisar con el cliente antes de despachar."),
        PEDIDO_NO_ENCONTRADO("No se encontró el pedido: pedirle al cliente el número correcto."),
        PEDIDO_NO_ESPERA_PAGO("Ese pedido no está pendiente de pago: revisar si es un pago duplicado."),
        NO_ES_COMPROBANTE("El archivo no parece un comprobante de pago: pedirle al cliente otro archivo.");

        private final String siguientePaso;

        Resultado(String siguientePaso) {
            this.siguientePaso = siguientePaso;
        }

        public String siguientePaso() {
            return siguientePaso;
        }
    }
}