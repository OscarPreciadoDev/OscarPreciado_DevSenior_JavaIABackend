package com.myTestRassept.gestor_productos.controller;                  // Ubicacion de la clase.

import org.springframework.web.bind.annotation.*;                       // Librerias usadas en esta clase.
import java.util.List;

import com.myTestRassept.gestor_productos.model.Marca;                  // Clases del proyecto utilizadas.
import com.myTestRassept.gestor_productos.service.MarcaService;


@RestController                                                         // @Rest+@ResponseBody indica que la clase da peticiones en JSON
@RequestMapping("api/marcas")                                           // Prefijo de ruta para los endpoints de esta clase
public class MarcaController {                                          // Inicio de declaracion de la clase

    // INYECCION DE DEPENDENCIAS

    private final MarcaService marcaService;                            // Indica que esta clase tendra un atributo MarcaService inmutable (dependencia)
    public MarcaController(MarcaService marcaService) {                 // La inyecta en este constructor
        this.marcaService = marcaService;
    }

    // METODOS QUE DISPONE ESTE CONTROLLER

    @GetMapping                                                         // Mapea un metodo a peticiones HTTP GET.
    public List<Marca> obtenerMarcas() {                                // Este metodo obtiene lista de marcas.
        return marcaService.listarMarcas();                             // Pasa la isntruccion al service.
    }

    @PostMapping                                                        // Mapea un metodo a peticiones HTTP POST.
    public Marca crearMarca(@RequestBody Marca marca) {                 // Busca un metodo que crea categorias.
        return marcaService.agregarMarca(marca);                        // Pasa la instruccion al service.
    }
}
