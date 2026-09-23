package com.myTestRassept.gestor_productos.dto;

public class RegistroRequest {


    private String email;
    private String password;

    // Este registro puede llevar mas campos como nombre, apellido, etc..

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
