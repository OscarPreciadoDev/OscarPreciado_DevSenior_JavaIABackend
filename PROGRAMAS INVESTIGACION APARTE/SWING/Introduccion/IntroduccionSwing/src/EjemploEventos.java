import javax.swing.*;

// Se utilizan estos elementos de libreria para reaccionar ante eventos
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploEventos {
    public static void main(String[] args){
        JFrame ventana = new JFrame("EVENTOS");
        ventana.setSize(300,200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());

        JButton boton = new JButton("Saludar");
        JLabel etiqueta = new JLabel("Esperando clic...");

        // Aquí se le indica al boton que hacer cuando se presione

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("!Hola Mundo!");
            }
        });

        ventana.add(boton);
        ventana.add(etiqueta);
        ventana.setVisible(true);
    }
}
