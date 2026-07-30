import javax.swing.*;
import java.awt.*;

public class EjemploBorderLayout {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ejemplo BorderLayout");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400,400);
        ventana.setLayout(new BorderLayout());

        ventana.add(new JButton("Norte"), BorderLayout.NORTH);
        ventana.add(new JButton("Sur"), BorderLayout.SOUTH);
        ventana.add(new JButton("Centro"), BorderLayout.CENTER);


        ventana.setVisible(true);
    }
}

