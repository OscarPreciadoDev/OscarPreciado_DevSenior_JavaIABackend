/*  MENU
    Tiene una sola responsabilidad: Dibujar las opciones y leer cual eligio el usuario. Nada mas. No hacer operaciones; Para eso esta operaciones */

import java.util.Scanner;

public class Menu {

    public static void mostrar(){
        System.out.println();
        System.out.println("***  GESTOR DE INVENTARIO ***");
        System.out.println("1. Registrar producto");
        System.out.println("2. Listar Inventario");
        System.out.println("3. Actualizar cantidad");
        System.out.println("4. Ver valor total");
        System.out.println("5. Salir");
    }

    
    public static int LeerOpcion(Scanner sc){
        return Validador.leerEntero(sc, "Elige una opcion: ");
    }
}
