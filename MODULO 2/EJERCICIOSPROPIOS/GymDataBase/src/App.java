
// Se importan las librerias utilizadas en Conexion BD

import dao.MiembroDAO;
import dao.MiembroDAOImpl;


// Definicion de la clase que permite el punto de acceso de la app
class App {

    // Metodo principal
    public static void main(String[] args) {
        MiembroDAO miembroDAO = new MiembroDAOImpl();

        System.out.println("=== INSERTAR ===");
        miembroDAO.insertar(new Miembro("Laura Gomez", "laura@mail.com", "Mensual"));
        miembroDAO.insertar(new Miembro("Pedro Diaz", "pedro@mail.com", "Anual"));

        System.out.println("\n=== LISTAR ===");
        miembroDAO.listar().forEach(System.out::println);

        System.out.println("\n=== ACTUALIZAR ===");
        miembroDAO.actualizar(
                new Miembro(1, "Laura Gomez Ruiz", "laura.ruiz@mail.com", "Trimestral")
        );

        System.out.println("\n=== LISTAR TRAS ACTUALIZAR ===");
        miembroDAO.listar().forEach(System.out::println);

        System.out.println("\n=== ELIMINAR ===");
        miembroDAO.eliminar(2);

        System.out.println("\n=== LISTAR FINAL ===");
        miembroDAO.listar().forEach(System.out::println);
    }
}
