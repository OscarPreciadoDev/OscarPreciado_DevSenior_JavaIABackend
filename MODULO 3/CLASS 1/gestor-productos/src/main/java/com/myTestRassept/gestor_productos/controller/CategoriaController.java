package com.myTestRassept.gestor_productos.controller;                  // Ubicacion de la clase.

import com.myTestRassept.gestor_productos.service.ProductoService;
import org.springframework.web.bind.annotation.*;                       // Librerias usadas en esta clase.
import java.util.List;

import com.myTestRassept.gestor_productos.model.Categoria;              // Clases del proyecto utilizadas.
import com.myTestRassept.gestor_productos.service.CategoriaService;


@RestController                                                         // @Rest+@ResponseBody indica que la clase da peticiones en JSON
@RequestMapping("api/categorias")                                       // Prefijo de ruta para los endpoints de esta clase
public class CategoriaController {                                      // Inicio de declaracion de la clase

    // INYECCION DE DEPENDENCIAS

    private final CategoriaService categoriaService;                    // Indica que esta clase tendra un atributo CategoriaService inmutable (dependencia)

    public CategoriaController (CategoriaService categoriaService) {    // La inyecta en este constructor
        this.categoriaService = categoriaService;
    }

    // METODOS QUE DISPONE ESTE CONTROLLER

    @GetMapping                                                         // Mapea un metodo a peticiones HTTP GET.
    public List<Categoria> obtenerCategorias() {                        // Este metodo obtiene lista de categorias.
        return categoriaService.listarCategorias();                     // Pasa la instruccion al service.
    }

    @PostMapping("/crear")                                                  // Mapea un metodo a peticiones HTTP POST.
    public Categoria crearCategoria(@RequestBody Categoria categoria) { // Busca un metodo que crea categorias.
        return categoriaService.agregarCategoria(categoria);            // Pasa la instruccion al service.
    }
}
