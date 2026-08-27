package com.myTestRassept.gestor_productos.service;

import com.myTestRassept.gestor_productos.model.Categoria;
import com.myTestRassept.gestor_productos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    // Inyección de dependencias.
    private final CategoriaRepository categoriaRepository;

    // Constructor obligatorio.
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Metodo para listar las categorías.
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    // Metodo para agregar una categoria.
    public Categoria agregarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
