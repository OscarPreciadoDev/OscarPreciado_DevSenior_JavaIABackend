package com.devSenior.atiende.compartido;

public class ExcepcionTicketNoEncontrado extends RuntimeException {

	public ExcepcionTicketNoEncontrado(Long id) {
		super("No existe un ticket con id " + id);
	}
}
