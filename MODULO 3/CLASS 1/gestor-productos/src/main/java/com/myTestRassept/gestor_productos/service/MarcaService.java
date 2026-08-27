package com.myTestRassept.gestor_productos.service;

import com.myTestRassept.gestor_productos.model.Marca;
import com.myTestRassept.gestor_productos.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    // Inyección de dependencias
    private final MarcaRepository marcaRepository;

    // Constructor obligatorio
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    // Metodo para listar las marcas
    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

    // Metodo para agregar una marca
    public Marca agregarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }
}

