package com.tarea.gestion_estudiantes;

import com.entitys.CursosInscritos;
import com.tarea.gestion_estudiantes.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CursosInscritosJpaController implements Serializable {

    public CursosInscritosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public CursosInscritosJpaController(){
        emf = Persistence.createEntityManagerFactory("persistenceGestorEstudiantes");
    }
    
    public List<CursosInscritos> buscarCursosPorEstudiante(int idEstudiante) {
        EntityManager em = getEntityManager();
        
        try {
            String jpql = "SELECT c FROM CursosInscritos c WHERE c.idEstudiante = :idEstudiante";
            Query query = em.createQuery(jpql);
            query.setParameter("idEstudiante", idEstudiante);
            List<CursosInscritos> resultados = query.getResultList();
            return resultados;
        } finally {
            em.close();
        }
    }
    
    public List<CursosInscritos> buscarInscripcionesPorCurso(int idCurso) {
        EntityManager em = getEntityManager();
        
        try {
            String jpql = "SELECT c FROM CursosInscritos c WHERE c.idCurso = :idCurso";
            Query query = em.createQuery(jpql);
            query.setParameter("idCurso", idCurso);
            List<CursosInscritos> resultados = query.getResultList();
            return resultados;
        } finally {
            em.close();
        }
    }
    
    public int inscribirRamo(int id_estudiante, int id_curso) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            String jpql = "INSERT INTO cursos_inscritos ( id_estudiante, id_curso) VALUES (?, ?)";
            Query query = em.createNativeQuery(jpql);
            query.setParameter(1, id_estudiante);
            query.setParameter(2, id_curso);
            int insert = query.executeUpdate();
            tx.commit();
            return insert;

        } finally {
            em.close();
        }
    }
}
