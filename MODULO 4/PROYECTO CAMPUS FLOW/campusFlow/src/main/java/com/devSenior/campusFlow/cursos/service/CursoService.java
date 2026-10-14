package com.devSenior.campusFlow.cursos.service;


import java.util.List;
import com.devSenior.campusFlow.cursos.model.Curso;
import com.devSenior.campusFlow.cursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }
}