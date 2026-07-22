package EjemploThis;

public class DemoPot {
    public static void main(String[] args){
        Pot x = new Pot(4.0,2);
        Pot y = new Pot(2.5, 1);
        Pot z = new Pot(5.7, 0);

        System.out.println(x.b + " Elevado a la " + x.e + " potencia es " + x.obtener_pot());
        System.out.println(y.b + " Elevado a la " + y.e + " potencia es " + y.obtener_pot());
        System.out.println(z.b + " Elevado a la " + z.e + " potencia es " + z.obtener_pot());
    }
}
