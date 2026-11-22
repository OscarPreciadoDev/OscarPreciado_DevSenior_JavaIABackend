package com.devSenior.atiende.ia;

import java.net.http.HttpClient;
import java.time.Duration;

import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

final class ClienteHttpIA {

	private ClienteHttpIA() {
	}

	static RestClient crear(String url, int timeoutSegundos) {
		HttpClient httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(timeoutSegundos))
				.build();
		JdkClientHttpRequestFactory fabrica = new JdkClientHttpRequestFactory(httpClient);
		fabrica.setReadTimeout(Duration.ofSeconds(timeoutSegundos));
		return RestClient.builder()
				.baseUrl(url)
				.requestFactory(fabrica)
				.build();
	}
}
