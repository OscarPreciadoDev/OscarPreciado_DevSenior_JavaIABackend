// Explicacion de ifs anidados 

public class N03IfAnidados {
    public static void main(String[] args) {
        int a,b,c,d,i,j,k;

        a=b=c=d=i=j=k=1;
        

        if ( i == 10 ) {
            if ( j < 20 ) a = b;
            if ( k > 100 ) c = d;
            else a = c;     // Alude a if (k > 100) que es el if mas cercano de bloque 
        }
        else a = d;         // Alude a if (1 == 10) que es el if mas cercano de bloque

        System.out.println(a); 
    }        
}
