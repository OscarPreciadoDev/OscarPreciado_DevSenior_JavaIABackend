package dao;

import java.util.List;
import model.Miembro;


// Clase que define un comportamiento y declara "OPERACIONES"
// Como que puede hacer el miembro.

public interface MiembroDAO {
    void insertar(Miembro miembro);
    List<Miembro> listar();
    void actualizar(Miembro miembro);
    void eliminar(int id);
}
