package com.myTestRassept.gestor_productos.dto;

public class AuthResponse {

    // token correspondiente al proceso de devolucion de una autorizacion.

    private String token;

    // Constructor

    public AuthResponse(String token) {
        this.token = token;
    }

    // getter

    public String getToken() {
        return token;
    }
}
