package com.tarea.gestion_estudiantes;

import com.entitys.Carreras;
import com.tarea.gestion_estudiantes.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CarrerasJpaController implements Serializable {

    public CarrerasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CarrerasJpaController(){
        emf = Persistence.createEntityManagerFactory("persistenceGestorEstudiantes");
    }
    
    public List<Carreras> buscarCarreras() {
        EntityManager em = getEntityManager();
        
        try {
            String jpql = "SELECT c FROM Carreras c";
            Query query = em.createQuery(jpql);
            List<Carreras> resultados = query.getResultList();
            return resultados;
        } finally {
            em.close();
        }
    }
}
