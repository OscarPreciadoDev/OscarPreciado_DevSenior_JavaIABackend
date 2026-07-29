package util;

public class Libreria {

    public Libreria() {}

    public final String menu = """
            
            =============== MENU PRINCIPAL ===============
            
            1. Agregar cliente
            2. Lista de clientes
            3. Actualizar datos de un cliente
            4. Eliminar cliente
            5. Salir de la App.
            
            ===============================================
            """;

    public final String encabezado = """
            ========= APP DE GESTION DE CLIENTES =========
            
            Bienvenido a la app de gestion de clientes,
            siga las opciones mostradas en pantalla para
            realizar la tarea que desee hacer.
            """;

    public final String pieDeApp = """
            
            ============== FIN DEL PROGRAMA ==============
            
            Gracias por usar nuestra app, vuelva pronto!!!
            
            ==============================================
            """;

    public final String instruccionEntrada = """
            
            ========== INGRESO DE NUEVO CLIENTE ==========
            
            Ingrese los datos del nuevo cliente.
            
            """;

    public final String encabezadoLista = """
            
            ============== LISTA DE CLIENTES ==============
            """;

    public final String encabezadoActualizar = """
           
           ============ ACTUALIZACION DE DATOS ============
           
           Ingrese el ID del usuario que desea actualizar.
           """;

    public final String encabezadoEliminar = """
            
            ============== ELIMINAR USUARIO ===============
            
            Ingrese el ID del usuario que desea eliminar.
            """;
}
