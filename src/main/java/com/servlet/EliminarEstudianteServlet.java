package com.servlet;

import com.controller.ControladoPersistenciaEstudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EliminarEstudianteServlet", urlPatterns = {"/EliminarEstudianteServlet"})
public class EliminarEstudianteServlet extends HttpServlet {
    
    ControladoPersistenciaEstudiantes controlEstudiantes = new ControladoPersistenciaEstudiantes();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
        
        System.out.println("request "+ request.getParameter("id_estudiante"));
        int id = Integer.parseInt(request.getParameter("id_estudiante"));
        
        controlEstudiantes.eliminarEstudiante(id);

        String alertMessage = "Se elimino el Registro del Estudiante";
        request.setAttribute("alertMessage", alertMessage);

        request.getRequestDispatcher("lista_estudiantes.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
