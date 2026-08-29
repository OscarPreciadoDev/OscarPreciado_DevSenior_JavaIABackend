package com.myTestRassept.gestor_productos.controller;                  // Ubicacion de la clase.

import org.springframework.web.bind.annotation.*;                       // Librerias usadas en esta clase.
import java.util.List;

import com.myTestRassept.gestor_productos.model.Producto;               // Clases del proyecto utilizadas.
import com.myTestRassept.gestor_productos.service.ProductoService;
import com.myTestRassept.gestor_productos.dto.ProductoDTO;

@RestController                                                         // @Rest+@ResponseBody indica que la clase da peticiones en JSON
@RequestMapping("/api/productos")                                       // Prefijo de ruta para los endpoints de esta clase
public class ProductoController {                                       // Inicio de declaracion de la clase

    // INYECCION DE DEPENDENCIAS

    private final ProductoService productoService;                      // Indica que esta clase tendra un atributo ProductoService inmutable (dependencia)
    public ProductoController(ProductoService productoService) {        // La inyecta en este constructor
        this.productoService = productoService;
    }

    // METODOS QUE DISPONE ESTE CONTROLLER

    @GetMapping
    public List<ProductoDTO> obtenerProductos() {
        return productoService.listarProductos()
                .stream()
                .map(ProductoDTO::new)
                .toList();
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<ProductoDTO> obtenerPorCategoria(
            @PathVariable Long categoriaId) {
        return productoService.listarPorCategoria(categoriaId)
                .stream()
                .map(ProductoDTO::new)
                .toList();
    }

    @PostMapping
    public ProductoDTO crearProducto(@RequestBody Producto producto) {
        Producto guardado = productoService.agregarProducto(producto);
        return new ProductoDTO(guardado);
    }
}