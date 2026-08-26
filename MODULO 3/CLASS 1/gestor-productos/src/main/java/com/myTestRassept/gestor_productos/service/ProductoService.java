package com.myTestRassept.gestor_productos.service;


import com.myTestRassept.gestor_productos.model.Categoria;
import com.myTestRassept.gestor_productos.model.Marca;
import com.myTestRassept.gestor_productos.model.Producto;
import com.myTestRassept.gestor_productos.repository.categoriaRepository;
import com.myTestRassept.gestor_productos.repository.marcaRepository;
import com.myTestRassept.gestor_productos.repository.productoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    //Inyección de dependencias
    private final productoRepository productoRepository;
    private final categoriaRepository categoriaRepository;
    private final marcaRepository marcaRepository;

    @Autowired
    public ProductoService(productoRepository productoRepository,
                           categoriaRepository categoriaRepository,
                           marcaRepository marcaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.marcaRepository = marcaRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public List<Producto> listarPorCategoria(Long categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }

    public Producto agregarProducto(Producto producto) {
        resolverCategoria(producto);
        resolverMarca(producto);
        return productoRepository.save(producto);
    }

    private void resolverCategoria(Producto producto) {
        if (producto.getCategoria() != null
                && producto.getCategoria().getId() != null) {
            Categoria categoria = categoriaRepository
                    .findById(producto.getCategoria().getId())
                    .orElse(null);
            producto.setCategoria(categoria);
        }
    }

    private void resolverMarca(Producto producto) {
        if (producto.getMarca() != null
                && producto.getMarca().getId() != null) {
            Marca marca = marcaRepository
                    .findById(producto.getMarca().getId())
                    .orElse(null);
            producto.setMarca(marca);
        }
    }
}