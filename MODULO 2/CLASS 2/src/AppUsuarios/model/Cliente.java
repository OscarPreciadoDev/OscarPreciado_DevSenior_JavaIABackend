package AppUsuarios.model;

// Clase hija

public class Cliente extends Usuario implements Notificable {

    // Atributos de cliente

    // Constructor llamando al constructor padre

    public Cliente(String nombre, String email){
        super(nombre, email);
        int puntos = 0;
    }

    // Metodo sobreescrito del panel de usuario

    @Override
    public String panelInicio(){
        return("Panel de Cliente: ver productos y mis compras");
    }


    // Implementa el metodo contratado en la interfaz "Notificable"

    @Override
    public String recibirNotificacion(String mensaje) {
        return "Email a " + email + ": " + mensaje;
    }

}
