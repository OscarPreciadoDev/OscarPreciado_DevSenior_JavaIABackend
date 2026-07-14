package AppUsuariosUpper.service;

// Se importan la clase Usuario y la interfaz Notificable

import AppUsuariosUpper.model.Usuario;
import AppUsuariosUpper.model.Notificable;

public class PlataformaService {

    // Despliega un listado de Usuarios con sus paneles de inicio correspondientes

    public void mostrarPaneles(Usuario[] usuarios) {
        for (Usuario u: usuarios) {
            System.out.println(u.getNombre() + " --> " + u.panelInicio());
        }
    }

    //

    public void notificarATodos(Usuario[] usuarios, String mensaje) {
        for (Usuario u: usuarios) {
            // Verifica si el usuario implementa el metodo notificable
            if (u instanceof Notificable) {
                //
                Notificable n = (Notificable) u;
                System.out.println(n.recibirNotificacion(mensaje));
            }
        }
    }


}
