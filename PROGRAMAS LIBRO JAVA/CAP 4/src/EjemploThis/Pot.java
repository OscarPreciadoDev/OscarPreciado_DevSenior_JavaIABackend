package EjemploThis;

public class Pot {

    // Atributos de la clase Pot
    double b;
    int e;
    double val;

    // Constructor de la clase Pot
    Pot(double base, int exp){
        this.b = base;
        this.e = exp;

        // Valor inicial de la potencia
        this.val = 1;
        if(exp==0) return;

        // Realiza un ciclo repitiendo las iteraciones necesarias de producto por la base
        for(; exp>0; exp--) this.val = this.val * base;
    }

    // Metodo para obtener una potencia
    double obtener_pot() {
        return val;
    }


}