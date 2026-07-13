package AppUsuarios;

// Clase hija

public class Administrador extends Usuario{

    // Constructor

    public Administrador(String nombre, String email){
        super(nombre, email);
    }

    // Metodo sobreescrito del panel de usuario

    @Override
    public String panelInicio(){
        return("Panel de Admin: gestionar usuarios y reportes ");
    }
}
