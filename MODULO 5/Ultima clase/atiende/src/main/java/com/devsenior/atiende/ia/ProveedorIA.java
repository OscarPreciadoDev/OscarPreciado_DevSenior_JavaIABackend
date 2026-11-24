package com.devsenior.atiende.ia;

public interface ProveedorIA {

    String nombre();

    RespuestaIA completar(String instrucciones, String mensaje);

    default RespuestaIA completarConArchivo(String instrucciones, String mensaje,
                                            byte[] archivo, String tipoArchivo) {
        throw new ProveedorIAException(nombre(), "no está configurado para leer archivos", true);
    }
}
