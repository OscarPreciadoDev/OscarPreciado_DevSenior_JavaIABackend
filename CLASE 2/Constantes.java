/*
    Son datos que no pueden modificarse, estas variables se declaran en mayuscula ya que son CONSTANTES
    se definen iniciando con "final"
*/

public class Constantes {
    public static void main(String args[]){
        final double IVA = 0.19;
        final int DIAS_SEMANA = 7;

        System.out.println(">> El valor del IVA es: "+IVA);
        System.out.println(">> Los dias de la semana son: "+DIAS_SEMANA);

        // IVA = 20;
        // Daria error
    }
}
