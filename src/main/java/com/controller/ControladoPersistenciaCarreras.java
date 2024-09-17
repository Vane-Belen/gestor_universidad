
package com.controller;

import com.entitys.Carreras;
import com.tarea.gestion_estudiantes.CarrerasJpaController;
import java.util.List;

public class ControladoPersistenciaCarreras {
    
    CarrerasJpaController carrerasJPA = new CarrerasJpaController();
    
    //Operación READ
    public List<Carreras> buscarCarreras() {
        return carrerasJPA.buscarCarreras();
    }
}

