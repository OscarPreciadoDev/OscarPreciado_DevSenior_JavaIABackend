package com.devSenior.atiende.ia;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class BibliotecaPrompts {

	private static final Pattern VARIABLE = Pattern.compile("\\{\\{([^{}]+)\\}\\}");

	public String cargar(String nombre) {
		return cargar(nombre, Map.of());
	}

	public String cargar(String nombre, Map<String, String> variables) {
		String ruta = "prompts/" + nombre + ".txt";
		String contenido;
		try (InputStream recurso = getClass().getClassLoader().getResourceAsStream(ruta)) {
			if (recurso == null) {
				throw new IllegalStateException("No existe el prompt: " + nombre);
			}
			contenido = new String(recurso.readAllBytes(), StandardCharsets.UTF_8);
		} catch (IOException excepcion) {
			throw new IllegalStateException("No se pudo leer el prompt: " + nombre, excepcion);
		}

		Matcher coincidencias = VARIABLE.matcher(contenido);
		StringBuilder resultado = new StringBuilder();
		while (coincidencias.find()) {
			String valor = variables.get(coincidencias.group(1));
			coincidencias.appendReplacement(
					resultado,
					Matcher.quoteReplacement(valor == null ? coincidencias.group() : valor));
		}
		coincidencias.appendTail(resultado);

		if (resultado.indexOf("{{") >= 0) {
			throw new IllegalStateException("El prompt contiene variables sin reemplazar: " + nombre);
		}
		return resultado.toString();
	}
}
