package com.devSenior.atiende.ia;

public class ExcepcionIAProveedorNoDisponible extends RuntimeException {

	public ExcepcionIAProveedorNoDisponible() {
		super("No hay proveedores de IA disponibles");
	}
}
