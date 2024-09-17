package com.controller;

import com.entitys.Cursos;
import com.tarea.gestion_estudiantes.CursosJpaController;
import java.util.List;

public class ControladoPersistenciaCursos {
    
    CursosJpaController controlCurso = new CursosJpaController();
    
    public List<Cursos> buscarCursos() {
        return controlCurso.buscarCursos();
    }
    
    public Cursos buscarCursoPorId(int idCurso) {
        return controlCurso.buscarCursoPorId(idCurso);
    }
}
