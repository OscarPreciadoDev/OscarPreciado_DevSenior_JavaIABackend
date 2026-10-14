package com.devSenior.campusFlow.usuarios.dto;


import com.devSenior.campusFlow.usuarios.model.RolUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// Request que recibe los datos de un usuario para crearlo
public class CrearUsuarioRequest {

    // Un nombre de usuario que no puede ser nulo o estar en blanco
    @NotBlank
    private String nombre;

    // Un email que no puede ser nulo o estar en blanco y debe ser un email valido
    @NotBlank
    @Email
    private String email;

    // Un password que no puede ser nulo o estar en blanco y debe tener un minimo de 8 caracteres
    @NotBlank
    @Size(min = 8, message = "La contraseña debe tener mínimo 8 caracteres")
    private String password;

    // Un rol que de tipo RolUsuario y que no puede ser nulo
    @NotNull
    private RolUsuario rol;


    // Getters y setters para los atributos

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }
}
