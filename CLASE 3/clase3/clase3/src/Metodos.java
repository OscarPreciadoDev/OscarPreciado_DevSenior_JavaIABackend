public class Metodos {
    public static void main(String[] args) {

        double propina = calcularPropina(800000,    0.10);
        System.out.print("Propina " + propina);

    }

    static double calcularPropina(double subtotal, double porcentaje){
        return subtotal * porcentaje;
    }
}
