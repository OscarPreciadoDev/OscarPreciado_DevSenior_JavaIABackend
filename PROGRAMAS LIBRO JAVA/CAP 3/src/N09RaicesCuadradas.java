// Muestre raices cuadradas de 1 a 99 y error de redondeo

public class N09RaicesCuadradas {
    public static void main(String[] args) {
        double num,rcuad,erred;

        for(num = 1.0; num <100.0; num++){
            rcuad = Math.sqrt(num);
            System.out.println("La raiz cuadrada de " +num+ " es "+rcuad);
        
            // calcula el error de redondeo

            erred = num - (rcuad * rcuad);
            System.out.println("El error de redondeo es " + erred);
            System.out.println();
        }
    }

}
