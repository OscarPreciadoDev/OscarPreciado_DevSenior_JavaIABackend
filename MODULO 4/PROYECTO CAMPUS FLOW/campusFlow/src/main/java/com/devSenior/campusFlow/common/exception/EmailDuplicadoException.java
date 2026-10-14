package com.devSenior.campusFlow.common.exception;

// Excepcion que se lanza cuando un email ya esta en uso
public class EmailDuplicadoException extends RuntimeException {

    public EmailDuplicadoException(String mensaje) {
        super(mensaje);
    }
}