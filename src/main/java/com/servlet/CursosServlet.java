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

@WebServlet(name = "CursosServlet", urlPatterns = {"/CursosServlet"})
public class CursosServlet extends HttpServlet {

    ControladoPersistenciaEstudiantes controlEstudiantes = new ControladoPersistenciaEstudiantes();
    ControladorPersistenciaInscripcion controlInscripcion = new ControladorPersistenciaInscripcion();
    ControladoPersistenciaCursos controlCursos = new ControladoPersistenciaCursos();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String rut = request.getParameter("rut");
        
        Estudiantes estudiante = controlEstudiantes.buscarEstudiantesPorRut(rut);
        
        List<CursosInscritos> listaInscripciones = controlInscripcion.buscarCursosPorEstudiante(estudiante.getIdEstudiante());
        
        System.out.println("listaCursos " + listaInscripciones);
        System.out.println("listaCursos " + listaInscripciones.size());
        
        List<Cursos> listaCursos = new ArrayList();
        
        for(int i = 0; i < listaInscripciones.size(); i++){
            System.out.println("detalleCurso " + listaInscripciones.get(i).getIdCurso());
            
            Cursos detalleCurso = controlCursos.buscarCursoPorId(listaInscripciones.get(i).getIdCurso());
            System.out.println("detalleCurso " + detalleCurso);
            
            listaCursos.add(detalleCurso);
        }
        
        System.out.println("listaCursos " + listaCursos);
        
        request.setAttribute("lista_curso", listaCursos);
        request.getRequestDispatcher("cursos.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
