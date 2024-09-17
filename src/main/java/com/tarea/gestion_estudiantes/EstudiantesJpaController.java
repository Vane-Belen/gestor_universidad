package com.tarea.gestion_estudiantes;

import com.entitys.Estudiantes;
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

public class EstudiantesJpaController implements Serializable {

    public EstudiantesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public EstudiantesJpaController(){
        emf = Persistence.createEntityManagerFactory("persistenceGestorEstudiantes");
    }
    
    public List<Estudiantes> buscarEstudiantes() {
        EntityManager em = getEntityManager();
        
        try {
            String jpql = "SELECT e FROM Estudiantes e";
            Query query = em.createQuery(jpql);
            List<Estudiantes> resultados = query.getResultList();
            return resultados;
        } finally {
            em.close();
        }
    }
    
    public int eliminarEstudiante(int id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            String jpql = "DELETE FROM Estudiantes e WHERE e.idEstudiante = :id";
            Query query = em.createQuery(jpql);
            query.setParameter("id", id);
            int eliminacion = query.executeUpdate();
            tx.commit();
            return eliminacion;

        } finally {
            em.close();
        }
    }
    
    public Estudiantes buscarEstudiantesPorRut(String rut) {
        EntityManager em = getEntityManager();
        
        try {
            String jpql = "SELECT e FROM Estudiantes e WHERE e.rut = :rut";
            Query query = em.createQuery(jpql);
            query.setParameter("rut", rut);
            List<Estudiantes> resultados = query.getResultList();
            return resultados.get(0);
        } finally {
            em.close();
        }
    }
    
    public Estudiantes buscarEstudiantePorId(int id) {
        EntityManager em = getEntityManager();
        
        try {
            String jpql = "SELECT e FROM Estudiantes e WHERE e.idEstudiante = :idEstudiante";
            Query query = em.createQuery(jpql);
            query.setParameter("idEstudiante", id);
            List<Estudiantes> resultados = query.getResultList();
            return resultados.get(0);
        } finally {
            em.close();
        }
    }
    
    public int registrarEstudiante(String rut, String nombre, String apellido, String carrera, String correo, String telefono) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            String jpql = "INSERT INTO estudiantes(rut, nombre, apellido, carrera, correo, contacto) VALUES (?,?,?,?,?,?)";
            Query query = em.createNativeQuery(jpql);
            query.setParameter(1, rut);
            query.setParameter(2, nombre);
            query.setParameter(3, apellido);
            query.setParameter(4, carrera);
            query.setParameter(5, correo);
            query.setParameter(6, telefono);
            int insert = query.executeUpdate();
            tx.commit();
            return insert;

        } finally {
            em.close();
        }
    }
    
}
