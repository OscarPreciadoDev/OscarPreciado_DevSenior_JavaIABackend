/*
    Calcule el numero de pulgadas cubicas en una milla cubica
*/

public class N10PulgadasAMetros {
    public static void main(String args[]){

        long pc;
        long pm;

        pm = 5280 * 12;

        pc = pm * pm * pm;

        System.out.println(">> Hay " + pc + " pulgadas cubicas en una milla cubica.");

    }
}
