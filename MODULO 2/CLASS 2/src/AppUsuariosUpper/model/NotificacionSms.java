package AppUsuariosUpper.model;

public class NotificacionSms implements CanalNotificacion {

    @Override
    public String enviar(Usuario usuario, String mensaje) {
        return "SMS al vendedor " + usuario.getNombre() + ": " + mensaje;
    }
}
