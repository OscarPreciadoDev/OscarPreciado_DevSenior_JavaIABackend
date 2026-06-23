/*
    En este prouecto se creara un programa que calcule la distancia en metros, entre un escucha y un trueno. El sonido viaja aproximadamente a 340 metros por segundo en el aire, Por lo tanto, conociendo el intervalo entre el momento que ve el relampago y el momento en el que el sonido lo alcanza a usted podra calcular la distancia al trueno. Para este proyecto, suponga que el intervalo es de 7.2 segundos
*/

public class N15DistanciaDeUnTrueno {
    public static void main(String[] args) {
        
        double distancia;

        distancia = 7.2 * 340;

        System.out.println(">> El true se encuentra a "+distancia+" metros de distancia.");

    }
}