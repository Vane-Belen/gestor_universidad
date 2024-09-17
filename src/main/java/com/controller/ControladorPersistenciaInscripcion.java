package com.controller;

import com.entitys.CursosInscritos;
import com.tarea.gestion_estudiantes.CursosInscritosJpaController;
import java.util.List;

public class ControladorPersistenciaInscripcion {
    
    CursosInscritosJpaController inscripcionJPA = new CursosInscritosJpaController();
    
    public int inscribirRamo(int id_estudiante, int id_curso) {
        return inscripcionJPA.inscribirRamo(id_estudiante, id_curso);
    }
    
    public List<CursosInscritos> buscarCursosPorEstudiante(int idEstudiante) {
        return inscripcionJPA.buscarCursosPorEstudiante(idEstudiante);
    }
    
    public List<CursosInscritos> buscarInscripcionesPorCurso(int idCurso) {
        return inscripcionJPA.buscarInscripcionesPorCurso(idCurso);
    }
}
