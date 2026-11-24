package com.devsenior.atiende.ticket;

import com.devsenior.atiende.compartido.ArchivoNoValidoException;
import com.devsenior.atiende.ia.AsistenteIA;
import com.devsenior.atiende.ia.BibliotecaPrompts;
import com.devsenior.atiende.ia.LectorJsonIA;
import com.devsenior.atiende.ia.RespuestaIA;
import com.devsenior.atiende.ia.dto.FacturaIA;
import com.devsenior.atiende.pedido.EstadoPedido;
import com.devsenior.atiende.pedido.Pedido;
import com.devsenior.atiende.pedido.PedidoService;
import com.devsenior.atiende.ticket.dto.ComprobanteResponse;
import com.devsenior.atiende.ticket.dto.ComprobanteResponse.Resultado;
import com.devsenior.atiende.ticket.dto.TicketResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ComprobanteService {

    private static final Set<String> TIPOS_PERMITIDOS = Set.of("image/png", "image/jpeg", "application/pdf");

    private final TicketService ticketService;
    private final PedidoService pedidoService;
    private final AsistenteIA asistenteIA;
    private final BibliotecaPrompts bibliotecaPrompts;
    private final LectorJsonIA lectorJsonIA;

    public ComprobanteService(TicketService ticketService, PedidoService pedidoService,
                              AsistenteIA asistenteIA, BibliotecaPrompts bibliotecaPrompts,
                              LectorJsonIA lectorJsonIA) {
        this.ticketService = ticketService;
        this.pedidoService = pedidoService;
        this.asistenteIA = asistenteIA;
        this.bibliotecaPrompts = bibliotecaPrompts;
        this.lectorJsonIA = lectorJsonIA;
    }

    public ComprobanteResponse analizar(Long ticketId, MultipartFile archivo) {
        TicketResponse ticket = ticketService.buscarPorId(ticketId);
        byte[] contenido = leerArchivo(archivo);

        RespuestaIA respuesta = asistenteIA.completarConArchivo(
                bibliotecaPrompts.cargar("comprobante"),
                "Extrae los datos del documento adjunto.",
                contenido,
                archivo.getContentType());
        ComprobanteIA datos = lectorJsonIA.leer(respuesta, ComprobanteIA.class);

        Resultado resultado = verificar(datos, ticket);
        return new ComprobanteResponse(ticketId, datos, resultado, resultado.siguientePaso(),
                FacturaIA.de(respuesta));
    }

    Resultado verificar(ComprobanteIA datos, TicketResponse ticket) {
        if (!datos.esComprobante()) {
            return Resultado.NO_ES_COMPROBANTE;
        }
        Long numeroPedido = datos.numeroPedido() != null ? datos.numeroPedido() : ticket.numeroPedido();
        Optional<Pedido> pedido = numeroPedido == null ? Optional.empty() : pedidoService.buscar(numeroPedido);
        if (pedido.isEmpty()) {
            return Resultado.PEDIDO_NO_ENCONTRADO;
        }
        if (pedido.get().estado() != EstadoPedido.PENDIENTE_PAGO) {
            return Resultado.PEDIDO_NO_ESPERA_PAGO;
        }
        if (datos.valor() == null || datos.valor() != pedido.get().total()) {
            return Resultado.VALOR_DISTINTO;
        }
        return Resultado.COINCIDE;
    }

    private byte[] leerArchivo(MultipartFile archivo) {
        if (archivo.isEmpty() || !TIPOS_PERMITIDOS.contains(archivo.getContentType())) {
            throw new ArchivoNoValidoException("El archivo debe ser una imagen PNG o JPG, o un PDF");
        }
        try {
            return archivo.getBytes();
        } catch (IOException ex) {
            throw new ArchivoNoValidoException("No se pudo leer el archivo");
        }
    }
}