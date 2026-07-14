package AppUsuariosUpper.model;

// Clase hija

public class Vendedor extends Usuario implements Notificable {

    // Constructor

    public Vendedor(String nombre, String email){
        super(nombre, email);
    }

    // Metodo sobreescrito del panel de usuario

    @Override
    public String panelInicio(){
        return("Panel de Vendedor: publicar y gestionar mis productos");
    }

    @Override
    public CanalNotificacion getCanalNotificacion() {
        return new NotificacionSms();
    }
}
