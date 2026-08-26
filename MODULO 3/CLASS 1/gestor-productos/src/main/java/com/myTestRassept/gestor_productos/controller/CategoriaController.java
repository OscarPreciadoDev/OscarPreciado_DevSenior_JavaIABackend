package com.myTestRassept.gestor_productos.controller;

import com.myTestRassept.gestor_productos.model.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;
    public CategoriaController (CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> obtenerCategorias() {
        return categoriaService.listarCategorias();
    }

    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.agregarCategoria(categoria);
    }
    MIN 1:47:54

}
