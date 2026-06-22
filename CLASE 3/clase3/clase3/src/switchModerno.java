public class switchModerno {
    public static void main(String[] args) {
        
        int opcion = 2;

        switch (opcion) {
            case 1 -> System.out.println(">> Nuevo pedido");
            case 2 -> System.out.println(">> Aplicar descuento");
            case 3 -> System.out.println(">> Cerrar caja");
            default -> System.out.println(">> Opcion Invalida");
        }

    }
}
