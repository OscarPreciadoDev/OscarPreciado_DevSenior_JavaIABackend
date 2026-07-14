package AppUsuarios.controller;

// Importa las Clases

import AppUsuarios.model.Usuario;
import AppUsuarios.model.Cliente;
import AppUsuarios.model.Administrador;
import AppUsuarios.model.Vendedor;
import AppUsuarios.service.PlataformaService;

public class App {

    // Metodo main

    public static void main(String[] args) {
        Usuario[] usuarios = {
                new Cliente("Ana", "ana@mail.com"),
                new Administrador("Luis","luis@mail.com"),
                new Vendedor("Marta","marta@mail.com")
        };

        PlataformaService servicio = new PlataformaService();

        System.out.println("--- Paneles ---");

        // Despliega el panel de Usuarios mandando como parámetros el arreglo de Usuarios

        servicio.mostrarPaneles(usuarios);

        System.out.println("--- Notificaciones ---");

        // Manda notificación usando el metodo implementado en servicio

        servicio.notificarATodos(usuarios, "Oferta del dia");



    }


}
