
import javax.swing.*;
import java.awt.*;

public class EjemploFlowLayout {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Uso de FlowLayout");
        ventana.setSize(300,200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Aquí se utiliza el FlowLayout
        ventana.setLayout(new FlowLayout());

        ventana.add(new JButton("Uno"));
        ventana.add(new JButton("Dos"));
        ventana.add(new JButton("Tres"));

        ventana.setVisible(true);


    }
}
