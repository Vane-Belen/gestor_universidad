package com.servlet;

import com.controller.ControladoPersistenciaCarreras;
import com.controller.ControladoPersistenciaCursos;
import com.entitys.Carreras;
import com.entitys.Cursos;
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

@WebServlet(name = "CarrerasServlet", urlPatterns = {"/CarrerasServlet"})
public class CarrerasServlet extends HttpServlet {
    
    ControladoPersistenciaCarreras controlCarreras = new ControladoPersistenciaCarreras();
    ControladoPersistenciaCursos controlCursos = new ControladoPersistenciaCursos();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        List<Carreras> listaCarreras = new ArrayList<>();
        listaCarreras = controlCarreras.buscarCarreras();
        System.out.println("listaCarreras " + listaCarreras);
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaCarreras", listaCarreras);
        
        List<Cursos> listaCursos = new ArrayList<>();
        listaCursos = controlCursos.buscarCursos();
        System.out.println("listaCursos " + listaCursos);
        misesion.setAttribute("listaCursos", listaCursos);
        
        response.sendRedirect("inscripcionRamos.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
