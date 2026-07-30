// Importa la biblioteca a utilizar, y precisamente el apartado de JFrame
import javax.swing.JFrame;


public class MiPrimeraVentana {
    public static void main(String[] args){
        JFrame ventana = new JFrame("Mi primera ventana");  // Titulo
        ventana.setSize(400,300);                   // Tamaño en píxeles
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // que hacer al cerrar
        ventana.setVisible(true);                               // Mostrarla
    }
}
