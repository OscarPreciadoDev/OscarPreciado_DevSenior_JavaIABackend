package com.devSenior.atiende.ia;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Order(2)
public class ProveedorClaude implements ProveedorIA {

	private final IaProperties iaProperties;
	private final IaProperties.ProveedorProperties propiedades;
	private final RestClient restClient;

	public ProveedorClaude(IaProperties iaProperties) {
		this.iaProperties = iaProperties;
		this.propiedades = iaProperties.getClaude();
		this.restClient = ClienteHttpIA.crear(propiedades.getUrl(), iaProperties.getTimeoutSegundos());
	}

	@Override
	public String nombre() {
		return "claude";
	}

	@Override
	public RespuestaIA completar(String instrucciones, String mensaje) {
		long inicio = System.nanoTime();
		Map<String, Object> solicitud = Map.of(
				"model", propiedades.getModelo(),
				"max_tokens", iaProperties.getMaxTokens(),
				"system", instrucciones,
				"messages", List.of(Map.of("role", "user", "content", mensaje)),
				"thinking", Map.of("type", "disabled"));

		Map<?, ?> respuesta = restClient.post()
				.uri("/v1/messages")
				.contentType(MediaType.APPLICATION_JSON)
				.header("x-api-key", propiedades.getLlave())
				.header("anthropic-version", "2023-06-01")
				.body(solicitud)
				.retrieve()
				.body(new ParameterizedTypeReference<Map<String, Object>>() {
				});

		Object bloques = respuesta == null ? null : respuesta.get("content");
		StringBuilder textoRespuesta = new StringBuilder();
		if (bloques instanceof List<?> lista) {
			for (Object bloque : lista) {
				Map<?, ?> bloqueTexto = DatosRespuestaIA.mapa(bloque);
				if ("text".equals(bloqueTexto.get("type"))) {
					textoRespuesta.append(DatosRespuestaIA.texto(bloqueTexto.get("text")));
				}
			}
		}
		String texto = textoRespuesta.toString();
		if (texto.isBlank()) {
			throw new ExcepcionRespuestaVaciaIA(nombre());
		}

		Map<?, ?> uso = DatosRespuestaIA.mapa(respuesta.get("usage"));
		long tokensEntrada = DatosRespuestaIA.numero(uso, "input_tokens");
		long tokensSalida = DatosRespuestaIA.numero(uso, "output_tokens");
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
