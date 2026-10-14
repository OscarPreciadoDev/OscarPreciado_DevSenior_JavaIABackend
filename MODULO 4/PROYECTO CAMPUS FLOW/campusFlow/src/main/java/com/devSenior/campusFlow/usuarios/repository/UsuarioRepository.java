package com.devSenior.campusFlow.usuarios.repository;

// Importa el Optional para manejar los resultados opcionales
import java.util.Optional;


import com.devSenior.campusFlow.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


// Interface que extiende de JpaRepository para la entidad Usuario
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Busca un usuario por su email
    Optional<Usuario> findByEmail(String email);
}