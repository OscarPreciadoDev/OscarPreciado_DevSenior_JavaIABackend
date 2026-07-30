package ui;

// Importaciones de Swing y Awt
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TodoFrame extends JFrame {

    // --- Componentes del formulario ---
    private final JTextField campoTarea = new JTextField(20);
    private final JButton btnAgregar = new JButton("Agregar");
    private final JButton btnEliminar = new JButton("Eliminar seleccionada");

    // --- Componentes de la lista ---
    // DefaultListModel es el "contenedor de datos" de un JList,
    // igual que DefaultTableModel lo era para JTable.
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final JList<String> listaTareas = new JList<>(modeloLista);

    // --- Contador ---
    private final JLabel etiquetaContador = new JLabel("Tareas: 0");

    public TodoFrame() {
        super("Lista de Tareas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        add(construirPanelSuperior(), BorderLayout.NORTH);
        add(new JScrollPane(listaTareas), BorderLayout.CENTER); // JScrollPane para que la lista tenga scroll
        add(etiquetaContador, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e ->insertar());
        btnEliminar.addActionListener(e ->eliminar());

        listaTareas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() ==2 ) {
                    marcarCompletada();
                }
            }
        });

        // TODO: agregar los ActionListener de btnAgregar y btnEliminar aqui
    }

    // Agrupa el campo de texto y los dos botones en un panel superior
    private JPanel construirPanelSuperior() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(campoTarea);
        panel.add(btnAgregar);
        panel.add(btnEliminar);

        return panel;
    }

    private void insertar(){
        if (campoTarea.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe ingresar una tarea.");
            return;
        }
        modeloLista.addElement(campoTarea.getText());
        JOptionPane.showMessageDialog(this, "Tarea agregada exitosamente.");
        campoTarea.setText("");
        actualizar();
    }

    private void eliminar(){
        int itemEliminar = listaTareas.getSelectedIndex();

        if (itemEliminar == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una tarea.");
            return;
        }
        modeloLista.remove(itemEliminar);
        JOptionPane.showMessageDialog(this, "Tarea eliminada exitosamente.");
        actualizar();
    }

    private void actualizar(){
        int cantTareas = modeloLista.getSize();
        etiquetaContador.setText("Tareas: " + cantTareas);
    }

    private void marcarCompletada(){
        int indice = listaTareas.getSelectedIndex();
        if (indice == -1) return;

        String tarea = modeloLista.getElementAt(indice);
        modeloLista.set(indice, "✔ " + tarea);
    }


    // TODO: metodo para agregar una tarea al modeloLista OK
    // TODO: metodo para eliminar la tarea seleccionada del modeloLista
    // TODO: metodo para actualizar el texto de etiquetaContador
}
