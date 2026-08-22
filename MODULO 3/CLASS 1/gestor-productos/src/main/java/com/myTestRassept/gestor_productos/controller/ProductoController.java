package com.myTestRassept.gestor_productos.controller;

import com.myTestRassept.gestor_productos.model.Producto;
import com.myTestRassept.gestor_productos.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos") // base de la dirección donde se encontraran TODAS las rutas, mapeo principal de las solicitudes

public class ProductoController {

    // Inyección de dependencias por constructor
    private final ProductoService productoService;


    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Utiliza la tarea que puede gestionar el productoService
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.listarProductos();
    }

    // Recibe información para crear un producto nuevo
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }
}