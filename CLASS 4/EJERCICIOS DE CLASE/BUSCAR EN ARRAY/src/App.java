
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        final int MAX = 3;
        Scanner sc = new Scanner(System.in);


        System.out.println("*** INGRESO DE ITEMS ***");
        String[] productos = leerItems(sc, MAX);

        mostrarItems(productos, MAX);
        System.out.println();

        System.out.println("*** BUSCAR ITEMS ***");

        System.out.println("Ingrese el nombre del item a buscar: ");
        String busqueda = sc.nextLine();

        
        boolean itemEncontrado = false; 
        for (int i = 0; i < productos.length ; i++){
            if (busqueda.equals(productos[i])){
                System.out.println("Item: "+ busqueda+ "  || Encontrado en la posicion: " + (i+1)+ ".");
                itemEncontrado = true;
                break;
            }
        }
        if (!itemEncontrado){
            System.out.println("El item: " + busqueda + " no fue encontrado en el inventario.");
        }
        sc.close();
    }

        public static String[] leerItems(Scanner sc, int MAX){
            
        String[] productos = new String[MAX];

        for (int i = 0; i<MAX ;i++){
            System.out.print("Ingrese un producto: ");
            productos[i] = sc.nextLine();
            }
        return productos;
        }

        public static void mostrarItems(String[] lista, int MAX){
        System.out.println("Lista de Items ingresados: ");

        for (int i=0; i<MAX;i++){
            System.out.println((i+1)+ ". " + lista[i]);
        }

    }
}
