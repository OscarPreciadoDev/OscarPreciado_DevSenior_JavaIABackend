package com.devSenior.campusFlow.usuarios.dto;


import com.devSenior.campusFlow.usuarios.model.RolUsuario;
import com.devSenior.campusFlow.usuarios.model.TemaVisual;

// Responde con los datos de un usuario
public class UsuarioResponse {

    // Sus atributos principales y preferencia de tema visual y notificaciones activas
    private Long id;
    private String nombre;
    private String email;
    private RolUsuario rol;
    private TemaVisual tema;
    private boolean notificacionesActivas;

    // OJO: No se incluye la contraseña en el response por seguridad

    // Getters y setters para los atributos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public TemaVisual getTema() {
        return tema;
    }

    public void setTema(TemaVisual tema) {
        this.tema = tema;
    }

    public boolean isNotificacionesActivas() {
        return notificacionesActivas;
    }

    public void setNotificacionesActivas(boolean notificacionesActivas) {
        this.notificacionesActivas = notificacionesActivas;
    }
}
