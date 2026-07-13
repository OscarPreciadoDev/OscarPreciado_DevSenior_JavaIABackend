package AppUsuarios;

// Clase hija

public class Vendedor extends Usuario{

    // Constructor

    public Vendedor(String nombre, String email){
        super(nombre, email);
    }

    // Metodo sobreescrito del panel de usuario

    @Override
    public String panelInicio(){
        return("Panel de Vendedor: publicar y gestionar mis productos");
    }
}
