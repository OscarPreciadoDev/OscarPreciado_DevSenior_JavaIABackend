package Ejemplos2;

public class Gato extends Animal{

    public Gato(String nombre){
        super(nombre);
    }


    // Sobreescribe el metodo generico por uno especifico de Gato
    @Override
    public String hacerSonido(){
        return("Miau");
    }
}
