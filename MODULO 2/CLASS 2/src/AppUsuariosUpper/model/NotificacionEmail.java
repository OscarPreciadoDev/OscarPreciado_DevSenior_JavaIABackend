package AppUsuariosUpper.model;

public class NotificacionEmail implements CanalNotificacion {

    @Override
    public String enviar(Usuario usuario, String mensaje) {
        return "Email a " + usuario.getEmail() + ": " + mensaje;
    }
}
