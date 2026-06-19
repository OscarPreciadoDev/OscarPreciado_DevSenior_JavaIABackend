/*
    Use el teorema de pitagoras para encontrar la longitud de la hipotenusa dadas las longitudes de los dos lados opuestos
*/

public class Hipotenusa {
    public static void main(String[] args) {
        
        double x,y,z;

        x = 3;
        y = 4;

        z = Math.sqrt(x*x + y*y);

        System.out.println(">> La hipotenusa es: "+z);
        
    }
}
