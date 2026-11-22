package com.devSenior.atiende.ia;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "atiende.ia")
public class IaProperties {

	private int timeoutSegundos = 30;
	private int maxTokens = 1024;
	private ProveedorProperties openai = new ProveedorProperties();
	private ProveedorProperties claude = new ProveedorProperties();

	public int getTimeoutSegundos() {
		return timeoutSegundos;
	}

	public void setTimeoutSegundos(int timeoutSegundos) {
		this.timeoutSegundos = timeoutSegundos;
	}

	public int getMaxTokens() {
		return maxTokens;
	}

	public void setMaxTokens(int maxTokens) {
		this.maxTokens = maxTokens;
	}

	public ProveedorProperties getOpenai() {
		return openai;
	}

	public void setOpenai(ProveedorProperties openai) {
		this.openai = openai;
	}

	public ProveedorProperties getClaude() {
		return claude;
	}

	public void setClaude(ProveedorProperties claude) {
		this.claude = claude;
	}

	public static class ProveedorProperties {

		private String url;
		private String modelo;
		private String llave;
		private BigDecimal precioEntradaMillon = BigDecimal.ZERO;
		private BigDecimal precioSalidaMillon = BigDecimal.ZERO;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getLlave() {
			return llave;
		}

		public void setLlave(String llave) {
			this.llave = llave;
		}

		public BigDecimal getPrecioEntradaMillon() {
			return precioEntradaMillon;
		}

		public void setPrecioEntradaMillon(BigDecimal precioEntradaMillon) {
			this.precioEntradaMillon = precioEntradaMillon;
		}

		public BigDecimal getPrecioSalidaMillon() {
			return precioSalidaMillon;
		}

		public void setPrecioSalidaMillon(BigDecimal precioSalidaMillon) {
			this.precioSalidaMillon = precioSalidaMillon;
		}
	}
}
