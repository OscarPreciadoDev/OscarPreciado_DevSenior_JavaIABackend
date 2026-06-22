public class Pedido {
    double CalcularTotal(double subtotal, double porcentaje){
        double propina = subtotal * porcentaje;
        return subtotal + propina;
    }
}
