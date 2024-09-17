package com.servlet;

import com.controller.ControladoPersistenciaEstudiantes;
import com.controller.ControladorPersistenciaInscripcion;
import com.entitys.Estudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InscribirRamoServlet", urlPatterns = {"/InscribirRamoServlet"})
public class InscribirRamoServlet extends HttpServlet {
    
    ControladoPersistenciaEstudiantes controlEstudiantes = new ControladoPersistenciaEstudiantes();
    ControladorPersistenciaInscripcion controlInscripcion = new ControladorPersistenciaInscripcion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        String rut = request.getParameter("rut_alumno");
        int id_curso = Integer.parseInt(request.getParameter("curso"));
        
        Estudiantes estudiante = controlEstudiantes.buscarEstudiantesPorRut(rut);
        
        int insert = controlInscripcion.inscribirRamo(estudiante.getIdEstudiante(), id_curso);
        
        request.setAttribute("message", "Ramo Inscrito");
        request.getRequestDispatcher("inscripcionRamos.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
