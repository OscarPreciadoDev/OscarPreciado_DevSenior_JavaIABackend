package AppUsuariosUpper.model;

// Usuario invitado: hereda de Usuario pero no recibe notificaciones

public class UsuarioInvitado extends Usuario {

    public UsuarioInvitado(String nombre, String email) {
        super(nombre, email);
    }

    @Override
    public String panelInicio() {
        return "Panel de Usuario Invitado: explorar productos sin cuenta";
    }
}
