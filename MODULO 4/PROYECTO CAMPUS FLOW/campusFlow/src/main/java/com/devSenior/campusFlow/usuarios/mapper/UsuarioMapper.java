package com.devSenior.campusFlow.usuarios.mapper;


import com.devSenior.campusFlow.usuarios.dto.UsuarioResponse;
import com.devSenior.campusFlow.usuarios.model.Usuario;
import com.devSenior.campusFlow.usuarios.model.PreferenciasUsuario;

// Mape a un usuario a un usuario response
public class UsuarioMapper {


    // Mapea un usuario a un usuario response
    public static UsuarioResponse toResponse(Usuario usuario) {
        PreferenciasUsuario preferencias = usuario.getPreferencias();
        // Si las preferencias son nulas, crea una nueva preferencia con el tema claro y notificaciones activas
        if (preferencias == null) {
            preferencias = new PreferenciasUsuario();
        }
        // Crea un nuevo usuario response
        UsuarioResponse response = new UsuarioResponse();
        // Setea los atributos del usuario response
        response.setId(usuario.getId());
        response.setNombre(usuario.getNombre());
        response.setEmail(usuario.getEmail());
        response.setRol(usuario.getRol());
        response.setTema(preferencias.getTema());
        response.setNotificacionesActivas(preferencias.isNotificacionesActivas());
        // Retorna el usuario response
        return response;
    }
}
