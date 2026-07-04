public class Casting {
    public static void main(String[] args) {
        
        int enteros = 5;
        double aDecimal = enteros; // implicita, se convierte automaticamente a double

        System.out.println(aDecimal); // 5.0

        double precio = 9.99;

        int precioRedondeado = (int) precio; // explicita el (int) es el casting

        System.out.println(precioRedondeado); // 9 (corta, no redondea !! )

    }
}
