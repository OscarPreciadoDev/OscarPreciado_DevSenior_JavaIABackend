package com.devSenior.campusFlow.cursos.model;


import java.util.ArrayList;
import java.util.List;
import com.devSenior.campusFlow.usuarios.model.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relaciona que el curso le pertenece a un instructor
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Usuario instructor;

    // relaciona que el curso le pertenece a muchos estudiantes
    @ManyToMany
    @JoinTable(
            // nombre de la tabla que relaciona el curso con los estudiantes
            name = "curso_estudiante",
            // columna que relaciona el curso con el estudiante
            joinColumns = @JoinColumn(name = "curso_id"),
            // columna que relaciona el estudiante con el curso
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    // Crea una lista de estudiantes que le pertenecen al curso
    private List<Usuario> estudiantes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getInstructor() {
        return instructor;
    }

    public void setInstructor(Usuario instructor) {
        this.instructor = instructor;
    }

    public List<Usuario> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Usuario> estudiantes) {
        this.estudiantes = estudiantes;
    }
}