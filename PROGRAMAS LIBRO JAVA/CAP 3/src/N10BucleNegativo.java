// Ejecucion negativa de un bucle

public class N10BucleNegativo {
    public static void main(String[] args) {
        
        int x;

        for (x=100; x>-100 ;x-=5){
            System.out.println(x);
        }

        int cuenta;

        for(cuenta=10; cuenta < 5; cuenta++){
            x +=cuenta; // Esta instruccion no se
        }
    }
}
