package com.devSenior.atiende.ia;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AsistenteIA {

	private static final Logger LOGGER = LoggerFactory.getLogger(AsistenteIA.class);

	private final List<ProveedorIA> proveedores;

	public AsistenteIA(List<ProveedorIA> proveedores) {
		this.proveedores = proveedores.stream()
				.sorted((primero, segundo) -> Integer.compare(
						orden(primero.nombre()),
						orden(segundo.nombre())))
				.toList();
	}

	public RespuestaIA completar(String instrucciones, String mensaje) {
		for (ProveedorIA proveedor : proveedores) {
			try {
				return proveedor.completar(instrucciones, mensaje);
			} catch (RestClientResponseException excepcion) {
				registrarFalloHttp(proveedor, excepcion.getStatusCode().value());
			} catch (RestClientException | ExcepcionRespuestaVaciaIA excepcion) {
				LOGGER.warn("Fallo temporal del proveedor de IA {}", proveedor.nombre());
			}
		}
		throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "No hay proveedores de IA disponibles");
	}

	private static int orden(String nombre) {
		return switch (nombre) {
			case "openai" -> 0;
			case "claude" -> 1;
			default -> 2;
		};
	}

	private static void registrarFalloHttp(ProveedorIA proveedor, int codigo) {
		if (codigo == 400 || codigo == 401 || codigo == 403 || codigo == 404) {
			LOGGER.error("Error de configuración en proveedor de IA {} (HTTP {})", proveedor.nombre(), codigo);
		} else {
			LOGGER.warn("Fallo temporal en proveedor de IA {} (HTTP {})", proveedor.nombre(), codigo);
		}
	}
}
