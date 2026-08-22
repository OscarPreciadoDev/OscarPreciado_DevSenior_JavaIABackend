package com.myTestRassept.gestor_productos.service;


import com.myTestRassept.gestor_productos.model.Producto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    // Lista en memoria que actúa como BD temporal
    private List<Producto> productos = new ArrayList<>();

    // Devuelve una lista de productos que se hayan almacenado hasta el momento
    public List<Producto> listarProductos() {
        return productos;
    }

    // agrega productos a una lista
    public Producto agregarProducto(Producto producto) {
        productos.add(producto);
        return producto;
    }
}