package AppUsuariosUpper.model;

// Interface de notificaciones: delega el envío al canal correspondiente

public interface Notificable {

    CanalNotificacion getCanalNotificacion();

    default String recibirNotificacion(String mensaje) {
        return getCanalNotificacion().enviar((Usuario) this, mensaje);
    }
}
