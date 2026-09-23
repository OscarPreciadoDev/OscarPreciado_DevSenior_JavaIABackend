package com.myTestRassept.gestor_productos.dto;

// Login request se encarga de transportar las credenciales. La contraseña llega al flujo de autenticacion, pero no se compara manualmente, ni se incluye en la respuesta

public class LoginRequest {

    private String email;
    private String password;

    // Este registro puede llevar más campos como nombre, apellido, etc.

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
