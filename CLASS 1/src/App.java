

import javax.swing.JOptionPane;                                     // Importa la libreria swing (Ventanas de interfaces)

public class App {                                                  // Una clase es una plantilla
                                                                    // Un public es un modificador de acceso (Public/Private/Protegido)
                                                                    // Main : Metodo principal
                                                                    // declarar tipo de dato 
    public static void main(String[] args) throws Exception {

        // Declarar variables de: datos de edad, salario, promedio, sexo, estado

        int edad;
        double salario;
        float promedio;
        char sexo;
        boolean estado;
        String nombres;

        // Entrada de datos por ventana emergente
        nombres = JOptionPane.showInputDialog("Digite el nombre del estudiante: ");

        edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad del estudiante: "));

        salario = Double.parseDouble(JOptionPane.showInputDialog("Digite el salario del estudiante: "));

        promedio = Float.parseFloat(JOptionPane.showInputDialog("Digite el promedio del estudiante: "));

        sexo = JOptionPane.showInputDialog("Digite el sexo del estudiante: ").charAt(0);

        estado = Boolean.parseBoolean(JOptionPane.showInputDialog("Digite el estado del estudiante : "));

        // Salida de datos por consola

        JOptionPane.showMessageDialog(null, "Nombre: "+ nombres);
        JOptionPane.showMessageDialog(null, "Edad: "+ edad);
        JOptionPane.showMessageDialog(null, "Salario: "+ salario);
        JOptionPane.showMessageDialog(null, "Promedio: "+ promedio);
        JOptionPane.showMessageDialog(null, "Sexo: "+ sexo);
        JOptionPane.showMessageDialog(null, "Estado: "+ estado);
        
    }
}
