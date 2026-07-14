package AppUsuariosUpper.model;

// Define cómo se envía una notificación (email, SMS, etc.)

public interface CanalNotificacion {
    String enviar(Usuario usuario, String mensaje);
}
