package com.devSenior.atiende.ia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.Test;

class ProveedorIATest {

	@Test
	void completarOpenAi_enviaChatCompletionsYCalculaUsoYCosto() throws IOException {
		AtomicReference<String> ruta = new AtomicReference<>();
		AtomicReference<String> autorizacion = new AtomicReference<>();
		AtomicReference<String> cuerpo = new AtomicReference<>();
		HttpServer servidor = iniciarServidor(
				"/chat/completions",
				"{\"choices\":[{\"message\":{\"content\":\"MOLESTO\"}}],"
						+ "\"usage\":{\"prompt_tokens\":10,\"completion_tokens\":4}}",
				ruta,
				autorizacion,
				cuerpo);
		try {
			IaProperties propiedades = propiedades(servidor, false);

			RespuestaIA respuesta = new ProveedorOpenAi(propiedades).completar("instrucciones", "mensaje privado");

			assertEquals("MOLESTO", respuesta.texto());
			assertEquals("openai", respuesta.proveedor());
			assertEquals(10, respuesta.tokensEntrada());
			assertEquals(4, respuesta.tokensSalida());
			assertEquals(0, respuesta.costoEstimadoUsd().compareTo(new BigDecimal("0.000013")));
			assertEquals("/chat/completions", ruta.get());
			assertEquals("Bearer llave-de-prueba", autorizacion.get());
			assertTrue(cuerpo.get().contains("\"max_tokens\":1024"));
			assertTrue(cuerpo.get().contains("\"role\":\"system\""));
			assertTrue(cuerpo.get().contains("\"content\":\"mensaje privado\""));
			assertTrue(respuesta.milisegundos() >= 0);
		} finally {
			servidor.stop(0);
		}
	}

	@Test
	void completarClaude_ignoraBloquesQueNoSonTextoYDeshabilitaThinking() throws IOException {
		AtomicReference<String> ruta = new AtomicReference<>();
		AtomicReference<String> autorizacion = new AtomicReference<>();
		AtomicReference<String> cuerpo = new AtomicReference<>();
		HttpServer servidor = iniciarServidor(
				"/v1/messages",
				"{\"content\":[{\"type\":\"thinking\",\"thinking\":\"interno\"},"
						+ "{\"type\":\"text\",\"text\":\"MOLESTO\"},"
						+ "{\"type\":\"tool_use\",\"name\":\"ignorar\"}],"
						+ "\"usage\":{\"input_tokens\":10,\"output_tokens\":4}}",
				ruta,
				autorizacion,
				cuerpo);
		try {
			IaProperties propiedades = propiedades(servidor, true);

			RespuestaIA respuesta = new ProveedorClaude(propiedades).completar("instrucciones", "mensaje");

			assertEquals("MOLESTO", respuesta.texto());
			assertEquals("claude", respuesta.proveedor());
			assertEquals(10, respuesta.tokensEntrada());
			assertEquals(4, respuesta.tokensSalida());
			assertEquals(0, respuesta.costoEstimadoUsd().compareTo(new BigDecimal("0.000013")));
			assertEquals("/v1/messages", ruta.get());
			assertEquals("llave-de-prueba", autorizacion.get());
			assertTrue(cuerpo.get().contains("\"thinking\":{\"type\":\"disabled\"}"));
			assertTrue(cuerpo.get().contains("\"max_tokens\":1024"));
		} finally {
			servidor.stop(0);
		}
	}

	private static IaProperties propiedades(HttpServer servidor, boolean claude) {
		IaProperties propiedades = new IaProperties();
		propiedades.setTimeoutSegundos(5);
		IaProperties.ProveedorProperties proveedor = claude
				? propiedades.getClaude()
				: propiedades.getOpenai();
		proveedor.setUrl("http://127.0.0.1:" + servidor.getAddress().getPort());
		proveedor.setModelo(claude ? "qwen3:1.7b" : "gemini-test");
		proveedor.setLlave("llave-de-prueba");
		proveedor.setPrecioEntradaMillon(new BigDecimal("0.30"));
		proveedor.setPrecioSalidaMillon(new BigDecimal("2.50"));
		return propiedades;
	}

	private static HttpServer iniciarServidor(
			String contexto,
			String respuesta,
			AtomicReference<String> ruta,
			AtomicReference<String> autorizacion,
			AtomicReference<String> cuerpo) throws IOException {
		HttpServer servidor = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
		servidor.createContext(contexto, solicitud -> {
			ruta.set(solicitud.getRequestURI().getPath());
			autorizacion.set(solicitud.getRequestHeaders().getFirst(
					contexto.equals("/v1/messages") ? "x-api-key" : "Authorization"));
			cuerpo.set(new String(solicitud.getRequestBody().readAllBytes(), StandardCharsets.UTF_8));
			byte[] bytes = respuesta.getBytes(StandardCharsets.UTF_8);
			solicitud.getResponseHeaders().set("Content-Type", "application/json");
			solicitud.sendResponseHeaders(200, bytes.length);
			solicitud.getResponseBody().write(bytes);
			solicitud.close();
		});
		servidor.start();
		return servidor;
	}
}
