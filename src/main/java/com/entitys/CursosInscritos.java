package com.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cursos_inscritos")
@NamedQueries({
    @NamedQuery(name = "CursosInscritos.findAll", query = "SELECT c FROM CursosInscritos c"),
    @NamedQuery(name = "CursosInscritos.findByIdInscripcion", query = "SELECT c FROM CursosInscritos c WHERE c.idInscripcion = :idInscripcion"),
    @NamedQuery(name = "CursosInscritos.findByIdEstudiante", query = "SELECT c FROM CursosInscritos c WHERE c.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "CursosInscritos.findByIdCurso", query = "SELECT c FROM CursosInscritos c WHERE c.idCurso = :idCurso")})
public class CursosInscritos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inscripcion")
    private Integer idInscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estudiante")
    private int idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_curso")
    private int idCurso;

    public CursosInscritos() {
    }

    public CursosInscritos(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public CursosInscritos(Integer idInscripcion, int idEstudiante, int idCurso) {
        this.idInscripcion = idInscripcion;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
    }

    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInscripcion != null ? idInscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosInscritos)) {
            return false;
        }
        CursosInscritos other = (CursosInscritos) object;
        if ((this.idInscripcion == null && other.idInscripcion != null) || (this.idInscripcion != null && !this.idInscripcion.equals(other.idInscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entitys.CursosInscritos[ idInscripcion=" + idInscripcion + " ]";
    }
    
}
