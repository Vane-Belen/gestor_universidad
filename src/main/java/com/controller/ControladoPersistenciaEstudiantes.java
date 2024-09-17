package com.controller;

import com.entitys.Estudiantes;
import com.tarea.gestion_estudiantes.EstudiantesJpaController;
import java.util.List;

public class ControladoPersistenciaEstudiantes {
    
    EstudiantesJpaController estJPA = new EstudiantesJpaController();
    
    //Operación READ
    public List<Estudiantes> traerEstudiantes() {
        return estJPA.buscarEstudiantes();
    }
    
    public Estudiantes buscarEstudiantesPorRut(String rut) {
        return estJPA.buscarEstudiantesPorRut(rut);
    }
    
    public Estudiantes buscarEstudiantePorId(int id) {
        return estJPA.buscarEstudiantePorId(id);
    }
    
    //Operación DELETE
    public Integer eliminarEstudiante(Integer id) {
        return estJPA.eliminarEstudiante(id);
    }
    
    public int registrarEstudiante(String rut, String nombre, String apellido, String carrera, String correo, String telefono) {
        return estJPA.registrarEstudiante(rut, nombre, apellido, carrera, correo, telefono);
    }
}
