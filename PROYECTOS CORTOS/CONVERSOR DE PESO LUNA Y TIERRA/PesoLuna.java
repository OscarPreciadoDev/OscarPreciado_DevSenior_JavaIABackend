public class PesoLuna {
    public static void main(String args[]){

        double gravedadT,gravedadL,masa,pesoT, pesoL;

        masa = 15;
        gravedadT = 9.8;
        gravedadL = gravedadT * 0.17;

        pesoT = masa * gravedadT;
        pesoL = masa * gravedadL;

        System.out.println(">> Su peso en tierra es: " + pesoT);
        System.out.println(">> Su peso en la luna es: " + pesoL);

    }
}