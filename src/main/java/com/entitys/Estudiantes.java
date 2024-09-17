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
import javax.validation.constraints.Size;

@Entity
@Table(name = "estudiantes")
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findByIdEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Estudiantes.findByRut", query = "SELECT e FROM Estudiantes e WHERE e.rut = :rut"),
    @NamedQuery(name = "Estudiantes.findByNombre", query = "SELECT e FROM Estudiantes e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estudiantes.findByApellido", query = "SELECT e FROM Estudiantes e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Estudiantes.findByCarrera", query = "SELECT e FROM Estudiantes e WHERE e.carrera = :carrera"),
    @NamedQuery(name = "Estudiantes.findByCorreo", query = "SELECT e FROM Estudiantes e WHERE e.correo = :correo"),
    @NamedQuery(name = "Estudiantes.findByContacto", query = "SELECT e FROM Estudiantes e WHERE e.contacto = :contacto")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "rut")
    private String rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "carrera")
    private String carrera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "contacto")
    private String contacto;

    public Estudiantes() {
    }

    public Estudiantes(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiantes(Integer idEstudiante, String rut, String nombre, String apellido, String carrera, String correo, String contacto) {
        this.idEstudiante = idEstudiante;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.correo = correo;
        this.contacto = contacto;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiante != null ? idEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.idEstudiante == null && other.idEstudiante != null) || (this.idEstudiante != null && !this.idEstudiante.equals(other.idEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entitys.Estudiantes[ idEstudiante=" + idEstudiante + " ]";
    }
    
}
