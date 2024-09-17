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

@WebServlet(name = "EliminarMasivoEstudianteServlet", urlPatterns = {"/EliminarMasivoEstudianteServlet"})
public class EliminarMasivoEstudianteServlet extends HttpServlet {

    ControladoPersistenciaEstudiantes controlEstudiantes = new ControladoPersistenciaEstudiantes();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        List<Estudiantes> listaEstudiantes = new ArrayList<>();
        listaEstudiantes = controlEstudiantes.traerEstudiantes();
        System.out.println("listaEstudiantes " + listaEstudiantes);
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaEstudiantes", listaEstudiantes);
        response.sendRedirect("masivoEstudiantes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String identificador = request.getParameter("identificador");
        System.out.println("identificador " + identificador);
        
        String[] listaId = identificador.split(";");
        System.out.println("lista " + listaId);
        
        for(int i = 0; i < listaId.length; i++){
            controlEstudiantes.eliminarEstudiante(Integer.parseInt(listaId[i]));
        }
        
        String alertMessage = "Se eliminaron los registros indicados";
        request.setAttribute("alertMessage", alertMessage);

        request.getRequestDispatcher("masivoEstudiantes.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
