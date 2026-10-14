package com.devSenior.campusFlow.usuarios.dto;

import com.devSenior.campusFlow.usuarios.model.TemaVisual;
import jakarta.validation.constraints.NotBlank;

// Request que recibe los datos de un usuario para actualizarlo
public class ActualizarUsuarioRequest {

    // Un nombre de usuario que no puede ser nulo o estar en blanco
    @NotBlank
    private String nombre;

    // Un tema visual que de tipo TemaVisual (este no estaba solicitado en la creacion del usuario, y ademas es opcional)
    private TemaVisual tema;

    // Un boolean que indica si las notificaciones del usuario estan activas, ademas es opcional
    private Boolean notificacionesActivas;

    // OJO: No se actualiza el email del usuario, ya que es unico y no se puede cambiar y ademas la contraseña tampoco se actualiza en este request

    // Getters y setters para los atributos


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TemaVisual getTema() {
        return tema;
    }

    public void setTema(TemaVisual tema) {
        this.tema = tema;
    }

    public Boolean getNotificacionesActivas() {
        return notificacionesActivas;
    }

    public void setNotificacionesActivas(Boolean notificacionesActivas) {
        this.notificacionesActivas = notificacionesActivas;
    }
}