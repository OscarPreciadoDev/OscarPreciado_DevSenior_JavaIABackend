import javax.swing.*;
import java.awt.*;

public class EjemploCompleto {
    public static void main(String[] args) {

        // Se utiliza dentro del EDT
        SwingUtilities.invokeLater(() -> {

            // Ventana
            JFrame ventana = new JFrame("Contador");
            // Settee de tamaño de ventana
            ventana.setSize(250, 150);
            // Instrucción de cierre de app al cerrar ventana
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Se setea un layOut tipo Flow
            ventana.setLayout(new FlowLayout());

            // Un label que inicialmente dira '0'
            JLabel etiquetaNumero = new JLabel("0");
            // Un boton para sumar
            JButton botonSumar = new JButton("Sumar");

            int[] contador = {0}; // truco para modificar una variable dentro del lambda

            // Cuando se presione el boton de sumar
            botonSumar.addActionListener(e -> {
                // Se aumentara el contador
                contador[0]++;
                // Se asignara este valor al texto del label
                etiquetaNumero.setText(String.valueOf(contador[0]));
            });


            // En la ventana iran los elementos programados
            ventana.add(etiquetaNumero);
            ventana.add(botonSumar);
            ventana.setVisible(true);
        });
    }
}