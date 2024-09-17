package com.servlet;

import com.controller.ControladoPersistenciaCursos;
import com.controller.ControladoPersistenciaEstudiantes;
import com.controller.ControladorPersistenciaInscripcion;
import com.entitys.Cursos;
import com.entitys.CursosInscritos;
import com.entitys.Estudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DetalleCursoServlet", urlPatterns = {"/DetalleCursoServlet"})
public class DetalleCursoServlet extends HttpServlet {

    ControladoPersistenciaCursos controlCursos = new ControladoPersistenciaCursos();
    ControladorPersistenciaInscripcion controlInscripcion = new ControladorPersistenciaInscripcion();
    ControladoPersistenciaEstudiantes controlEstudiantes = new ControladoPersistenciaEstudiantes();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cursos> listaCursos = new ArrayList<>();
        listaCursos = controlCursos.buscarCursos();
        System.out.println("listaCursos " + listaCursos);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaCursos", listaCursos);
        
        response.sendRedirect("estudiantesPorCurso.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int id = Integer.parseInt(request.getParameter("curso"));
        List<CursosInscritos> listaInscripciones = controlInscripcion.buscarInscripcionesPorCurso(id);
        
        List<Estudiantes> listaEstudiantes = new ArrayList();
        
        for(int i = 0; i < listaInscripciones.size(); i++){
            System.out.println("detalleCurso " + listaInscripciones.get(i).getIdEstudiante());
            
            Estudiantes detalleEstudiante = controlEstudiantes.buscarEstudiantePorId(listaInscripciones.get(i).getIdEstudiante());
            System.out.println("detalleCurso " + detalleEstudiante);
            
            listaEstudiantes.add(detalleEstudiante);
        }
        
        request.setAttribute("lista_estudiantes", listaEstudiantes);
        request.getRequestDispatcher("estudiantesPorCurso.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
