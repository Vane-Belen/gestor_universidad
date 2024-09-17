package com.tarea.gestion_estudiantes;

import com.entitys.Cursos;
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

public class CursosJpaController implements Serializable {

    public CursosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CursosJpaController(){
        emf = Persistence.createEntityManagerFactory("persistenceGestorEstudiantes");
    }
    
    public List<Cursos> buscarCursos() {
        EntityManager em = getEntityManager();
        
        try {
            String jpql = "SELECT c FROM Cursos c";
            Query query = em.createQuery(jpql);
            List<Cursos> resultados = query.getResultList();
            return resultados;
        } finally {
            em.close();
        }
    }
    
    public Cursos buscarCursoPorId(int idCurso) {
        EntityManager em = getEntityManager();
        
        try {
            String jpql = "SELECT c FROM Cursos c WHERE c.idCurso = :idCurso";
            Query query = em.createQuery(jpql);
            query.setParameter("idCurso", idCurso);
            List<Cursos> resultados = query.getResultList();
            return resultados.get(0);
        } finally {
            em.close();
        }
    }
    
}
