// Demostracion Switch

public class N06DemostracionSwitch {
    public static void main(String[] args) {
        
        int i;

        for(i = 0; i <10; i++){
            switch (i) {
                case 0:
                    System.out.println("~~ i es cero");
                    break;
                case 1:
                    System.out.println("~~ i es uno");
                    break;
                case 2:
                    System.out.println("~~ i es dos");
                    break;
                default:
                    System.out.println("i esta entre tres y diez");
                    break;
            }
        }

    }
}
