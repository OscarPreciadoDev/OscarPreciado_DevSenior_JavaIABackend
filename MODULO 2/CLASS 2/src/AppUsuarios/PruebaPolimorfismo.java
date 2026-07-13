package AppUsuarios;

// Prueba de polimorfismo, se crea un array donde los elementos guardados
// son de las clases creadas con los parámetros definidos (nombre, email)

public class PruebaPolimorfismo  {
    public static void main(String[] args) {
        Usuario[] usuarios = {
                new Cliente("Ana", "ana@mail.com"),
                new Administrador("Luis","luis@mail.com"),
                new Vendedor("Marta","marta@mail.com")
        };

        // Recorre el array e imprime el nombre, y el panel de inicio


        for (Usuario u : usuarios) {
            System.out.println(u.getNombre() + " --> " + u.panelInicio());
            System.out.println(u);
        }
    }
}
