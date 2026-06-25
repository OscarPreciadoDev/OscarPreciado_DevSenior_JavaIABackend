// Demuesta switch sin instrucciones break

public class N07DemostracionSwitchSinBreak {
    public static void main(String[] args) {
        
        int i;

        for(i = 0; i <10; i++){
            switch (i) {
                case 0:
                    System.out.println("~~ i es cero");
                case 1:
                    System.out.println("~~ i es uno");
                case 2:
                    System.out.println("~~ i es dos");
                default:
                    System.out.println("i esta entre tres y diez");

            }
            System.out.println();
        }

    } 
}
