package dao;

import config.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MiembroDAOImpl implements MiembroDAO {

    @Override
    public void insertar(Miembro miembro) {
        String sql = "INSERT INTO miembro (nombre, email, plan) VALUES (?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, miembro.getNombre());
            ps.setString(2, miembro.getEmail());
            ps.setString(3, miembro.getPlan());

            int filas = ps.executeUpdate();
            System.out.println("Filas insertadas: " + filas);
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    @Override
    public List<Miembro> listar() {
        List<Miembro> miembros = new ArrayList<>();
        String sql = "SELECT id, nombre, email, plan FROM miembro";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Miembro miembro = new Miembro(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("plan")
                );
                miembros.add(miembro);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }

        return miembros;
    }

    @Override
    public void actualizar(Miembro miembro) {
        String sql = "UPDATE miembro SET nombre = ?, email = ?, plan = ? WHERE id = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, miembro.getNombre());
            ps.setString(2, miembro.getEmail());
            ps.setString(3, miembro.getPlan());
            ps.setInt(4, miembro.getId());
            System.out.println("Filas actualizadas: " + ps.executeUpdate());
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM miembro WHERE id = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            System.out.println("Filas eliminadas: " + ps.executeUpdate());
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
