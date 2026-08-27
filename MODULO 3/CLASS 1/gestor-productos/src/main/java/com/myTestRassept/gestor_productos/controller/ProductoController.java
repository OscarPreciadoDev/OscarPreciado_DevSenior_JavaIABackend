package com.myTestRassept.gestor_productos.controller;                  // Ubicacion de la clase.

import org.springframework.web.bind.annotation.*;                       // Librerias usadas en esta clase.
import java.util.List;

import com.myTestRassept.gestor_productos.model.Producto;               // Clases del proyecto utilizadas.
import com.myTestRassept.gestor_productos.service.ProductoService;

@RestController                                                         // @Rest+@ResponseBody indica que la clase da peticiones en JSON
@RequestMapping("/api/productos")                                       // Prefijo de ruta para los endpoints de esta clase
public class ProductoController {                                       // Inicio de declaracion de la clase

    // INYECCION DE DEPENDENCIAS

    private final ProductoService productoService;                      // Indica que esta clase tendra un atributo ProductoService inmutable (dependencia)
    public ProductoController(ProductoService productoService) {        // La inyecta en este constructor
        this.productoService = productoService;
    }

    // METODOS QUE DISPONE ESTE CONTROLLER

    @GetMapping                                                         // Mapea un metodo a peticiones HTTP GET.
    public List<Producto> obtenerProductos() {                          // Este metodo obtiene lista de productos.
        return productoService.listarProductos();                       // Pasa la instruccion al service.
    }

    @GetMapping("/categoria/{categoriaId}")                             // Mapea un metodo a peticiones HTTP GET.
    public List<Producto> obtenerPorCategoria(                          // Este metodo obtiene productos filtrados por categoria.
            @PathVariable Long categoriaId) {                           // Extrae una URL y lo inyecta como parametro del metodo
        return productoService.listarPorCategoria(categoriaId);         // Pasa la instruccion al service
    }

    @PostMapping                                                        // Mapea un metodo a peticiones HTTP POST.
    public Producto crearProducto(@RequestBody Producto producto) {     // Busca un metodo que crea producto.
        return productoService.agregarProducto(producto);
        AQUI VAMOS
    }
}