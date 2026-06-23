public class N02CharDemostracion {
    
    public static void main(String[] args) {
        
        char ch;

        ch = 'x'; // El caracter se declara entre comillas sencillas

        System.out.println(">> ch contiene :" + ch);

        ch++; // Es posible incrementar char

        System.out.println(">> ch es ahora :" + ch);

        ch = 90; // da a ch el valor Z (como un valor entero que representa la ubicacion de un caracter Unicode)

        System.out.println(">> ch es ahora :" + ch);

    }
}
