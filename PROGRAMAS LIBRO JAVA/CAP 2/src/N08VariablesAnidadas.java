/*
    Este programa trata de declarar una variable
    en un alcance interno con el mismo nombre de
    una definida en un alcance externo

    *** Este programa no se compilara ***
*/

public class N08VariablesAnidadas {

    public static void main(String[] args) {
        
        int cuenta;                              // VARIABLE QUE SE REPETIRA

        for (cuenta = 0; cuenta <10; cuenta++ ) {
            
            ///int cuenta;                          // REPETICION INVALIDA DE VARIABLE "cuenta"
            
            for (cuenta =0; cuenta <2 ; cuenta ++){
                System.out.println("Este programa tiene un error!!!");
            }
        }

    }

}
