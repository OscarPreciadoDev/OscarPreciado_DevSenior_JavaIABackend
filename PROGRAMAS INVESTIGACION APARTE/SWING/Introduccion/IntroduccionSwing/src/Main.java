import javax.swing.*;
import java.awt.*;

// Ejemplo Aislado de Swing - no depende de ningún DAO ni proyecto externo.
// Solo sirve para entender los 3 conceptos clave: componentes, layout y eventos.
public class Main {

    public static void main(String[] args) {

        // 1. La ventana principal (contenedor raiz)
        JFrame ventana = new JFrame("Ejemplo de Swing - Contador");
        ventana.setSize(300, 150);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout()); // los componentes se acomodan en fila

        // 2. Componentes visuales
        JLabel etiqueta = new JLabel("Valor actual: 0");
        JButton boton = new JButton("Sumar 1");

        // Variable que guarda el estado del contador.
        // Debe ser "efectivamente final" o un arreglo/objeto para poder
        // modificarse dentro del ActionListener (una lambda).
        int[] contador = {0};

        // 3. El evento: qué pasa cuando se hace click en el boton
        boton.addActionListener(e -> {
            contador[0]++;
            etiqueta.setText("Valor actual: " + contador[0]);
        });

        // Se agregan los componentes a la ventana
        ventana.add(etiqueta);
        ventana.add(boton);

        // Finalmente, se hace visible la ventana
        ventana.setVisible(true);
    }
}
 