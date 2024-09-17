package com.servlet;

import com.controller.ControladoPersistenciaEstudiantes;
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

@WebServlet(name = "EstudiantesServlet", urlPatterns = {"/EstudiantesServlet"})
public class EstudiantesServlet extends HttpServlet {
    
    ControladoPersistenciaEstudiantes controlEstudiantes = new ControladoPersistenciaEstudiantes();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        List<Estudiantes> listaEstudiantes = new ArrayList<>();
        listaEstudiantes = controlEstudiantes.traerEstudiantes();
        System.out.println("listaEstudiantes " + listaEstudiantes);
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaEstudiantes", listaEstudiantes);
        response.sendRedirect("lista_estudiantes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String carrera = request.getParameter("carrera");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        
        int registroInsertado = controlEstudiantes.registrarEstudiante(rut, nombre, apellido, carrera, correo, telefono);
        
        System.out.println("registroInsertado " + registroInsertado);
        
        request.setAttribute("message", "Alumno Registrado");
        request.getRequestDispatcher("registroEstudiantes.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
