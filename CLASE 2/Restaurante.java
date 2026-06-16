public class Restaurante {
    public static void main(String argsp[]){
        double cuenta = 80000;
        double propina = cuenta *0.10;
        double total = cuenta + propina;

        System.out.println(">> Cuenta: "+ cuenta);
        System.out.println(">> Propina: "+propina);
        System.out.println(">> Total: "+total);

    }
}