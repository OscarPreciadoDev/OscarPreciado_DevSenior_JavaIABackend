package com.devSenior.atiende.ia;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Order(1)
public class ProveedorOpenAi implements ProveedorIA {

	private final IaProperties iaProperties;
	private final IaProperties.ProveedorProperties propiedades;
	private final RestClient restClient;

	public ProveedorOpenAi(IaProperties iaProperties) {
		this.iaProperties = iaProperties;
		this.propiedades = iaProperties.getOpenai();
		this.restClient = ClienteHttpIA.crear(propiedades.getUrl(), iaProperties.getTimeoutSegundos());
	}

	@Override
	public String nombre() {
		return "openai";
	}

	@Override
	public RespuestaIA completar(String instrucciones, String mensaje) {
		long inicio = System.nanoTime();
		Map<String, Object> solicitud = Map.of(
				"model", propiedades.getModelo(),
				"messages", List.of(
						Map.of("role", "system", "content", instrucciones),
						Map.of("role", "user", "content", mensaje)),
				"max_tokens", iaProperties.getMaxTokens());

		Map<?, ?> respuesta = restClient.post()
				.uri("/chat/completions")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + propiedades.getLlave())
				.body(solicitud)
				.retrieve()
				.body(new ParameterizedTypeReference<Map<String, Object>>() {
				});

		Object opciones = respuesta == null ? null : respuesta.get("choices");
		Object primeraOpcion = opciones instanceof List<?> lista && !lista.isEmpty() ? lista.get(0) : null;
		Map<?, ?> eleccion = DatosRespuestaIA.mapa(primeraOpcion);
		Map<?, ?> mensajeRespuesta = DatosRespuestaIA.mapa(eleccion.get("message"));
		String texto = DatosRespuestaIA.texto(mensajeRespuesta.get("content"));
		if (texto.isBlank()) {
			throw new ExcepcionRespuestaVaciaIA(nombre());
		}

		Map<?, ?> uso = DatosRespuestaIA.mapa(respuesta.get("usage"));
		long tokensEntrada = DatosRespuestaIA.numero(uso, "prompt_tokens");
		long tokensSalida = DatosRespuestaIA.numero(uso, "completion_tokens");
		return new RespuestaIA(
				texto,
				nombre(),
				propiedades.getModelo(),
				tokensEntrada,
				tokensSalida,
				DatosRespuestaIA.calcularCosto(tokensEntrada, tokensSalida, propiedades),
				DatosRespuestaIA.duracionMilisegundos(inicio));
	}
}
