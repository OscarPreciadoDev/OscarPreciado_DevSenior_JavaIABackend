// Demuestra una escalera if-else-if

public class N05EscaleraIfElseIf {
    public static void main(String[] args) {
        
        int x;

        for(x = 0; x < 6; x++){
            if (x == 1) 
                System.out.println("~~ x es uno");
            else if (x == 2) 
                System.out.println("~~ x es dos"); 
            else if (x == 3) 
                System.out.println("~~ x es tres");
            else if (x == 4) 
                System.out.println("~~ x es cuatro");
            else 
                System.out.println("~~ x no esta entre 1 y 4");;
        }   

    }
}
