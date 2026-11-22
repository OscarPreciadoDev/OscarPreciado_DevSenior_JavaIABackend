package com.devSenior.atiende.compartido;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import tools.jackson.core.JacksonException;

@RestControllerAdvice
public class ManejadorExcepciones {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<RespuestaError> datosInvalidos(MethodArgumentNotValidException excepcion) {
		String mensaje = excepcion.getBindingResult().getFieldErrors().stream()
				.map(error -> "El campo " + error.getField() + " " + error.getDefaultMessage())
				.collect(Collectors.joining(". "));
		if (mensaje.isBlank()) {
			mensaje = "Los datos enviados no son válidos";
		}
		return respuesta(HttpStatus.BAD_REQUEST, "DATOS_INVALIDOS", "Datos inválidos", mensaje);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<RespuestaError> peticionIlegible(HttpMessageNotReadableException excepcion) {
		String campo = campoDeJackson(excepcion);
		String mensaje = campo == null
				? "El cuerpo de la petición no es válido"
				: "El campo " + campo + " no es válido";
		return respuesta(HttpStatus.BAD_REQUEST, "PETICION_INVALIDA", "Petición inválida", mensaje);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<RespuestaError> parametroInvalido(MethodArgumentTypeMismatchException excepcion) {
		String nombre = excepcion.getName() == null ? "parámetro" : excepcion.getName();
		return respuesta(
				HttpStatus.BAD_REQUEST,
				"PETICION_INVALIDA",
				"Petición inválida",
				"El parámetro " + nombre + " no es válido");
	}

	@ExceptionHandler(ExcepcionTicketNoEncontrado.class)
	public ResponseEntity<RespuestaError> noEncontrado(ExcepcionTicketNoEncontrado excepcion) {
		return respuesta(
				HttpStatus.NOT_FOUND,
				"TICKET_NO_ENCONTRADO",
				"Ticket no encontrado",
				excepcion.getMessage());
	}

	@ExceptionHandler(ExcepcionTransicionNoPermitida.class)
	public ResponseEntity<RespuestaError> transicionNoPermitida(ExcepcionTransicionNoPermitida excepcion) {
		return respuesta(
				HttpStatus.CONFLICT,
				"TRANSICION_NO_PERMITIDA",
				"Transición no permitida",
				excepcion.getMessage());
	}

	private ResponseEntity<RespuestaError> respuesta(HttpStatus estado, String codigo, String error, String mensaje) {
		return ResponseEntity.status(estado)
				.body(new RespuestaError(codigo, error, mensaje, LocalDateTime.now()));
	}

	private String campoDeJackson(Throwable throwable) {
		String campo = null;
		Throwable actual = throwable;
		while (actual != null) {
			if (actual instanceof JacksonException jackson) {
				var ruta = jackson.getPath();
				if (ruta != null) {
					for (int indice = ruta.size() - 1; indice >= 0; indice--) {
						String nombre = ruta.get(indice).getPropertyName();
						if (nombre != null && !nombre.isBlank()) {
							campo = nombre;
							break;
						}
					}
				}
			}
			actual = actual.getCause();
		}
		return campo;
	}
}
