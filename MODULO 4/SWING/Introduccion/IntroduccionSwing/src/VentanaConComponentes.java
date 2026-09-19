import javax.swing.*;

public class VentanaConComponentes {
    public static void main(String[] args) {
        JFrame ventana=new JFrame("Ventana con componentes");
        ventana.setSize(400,400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null); // posicionamiento manual

        JLabel etiqueta = new  JLabel("Esto es una etiqueta:");
        etiqueta.setBounds(50,30,200,30); // x, y, ancho, alto

        JButton boton = new JButton("Esto es un botón");
        boton.setBounds(50,80,120,30);

        // Agrega los elementos a la ventana
        ventana.add(etiqueta);
        ventana.add(boton);


        ventana.setVisible(true);
    }

}
