package com.myTestRassept.gestor_productos.repository;

import com.myTestRassept.gestor_productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long>{

    // Busca un elemento por ID.
    List<Producto> findByCategoriaId(Long categoriaId);

    // Busca un elemento sin importar si es mayuscula o minuscula.
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
