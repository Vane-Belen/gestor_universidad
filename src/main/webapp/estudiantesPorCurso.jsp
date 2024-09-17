<%@page import="com.entitys.Estudiantes"%>
<%@page import="com.entitys.Cursos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Tu día</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body class="p-5" style="background-color: rgba(255, 255, 255, 0.5);">
        <form class="row g-3" action="DetalleCursoServlet" method="POST">
            <div class="col-auto">
                <label class="form-label">Seleccione un Curso</label>
            </div>
            <div class="col-auto">
                    <select class="form-select form-select-sm" name="curso" id="curso">
                        <option disabled selected>Cursos</option>
                        <%
                            List<Cursos> listaCursos = (List) request.getSession().getAttribute("listaCursos");
                            for (Cursos cursos : listaCursos) {
                        %>
                            <option value="<%=cursos.getIdCurso()%>"><%=cursos.getNombre()%> - <%=cursos.getCarrera()%></option>
                        <% }%>
                    </select>
                </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">Buscar Integrantes del Curso</button>
            </div>
        </form>

        <%
            List<Estudiantes> listaEstudiantes = (List<Estudiantes>) request.getAttribute("lista_estudiantes");
            if (listaEstudiantes != null && !listaEstudiantes.isEmpty()) {
        %>
        <table id="cursos" class="table">
            <thead>
                <tr>
                    <th scope="col">Codigo Estudiante</th>
                    <th scope="col">Rut</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Carrera</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Contacto</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Estudiantes estudiante : listaEstudiantes) {
                %>
                <tr>
                    <th scope="row" ><%=estudiante.getIdEstudiante()%></th>
                    <td><%=estudiante.getRut()%></td>
                    <td><%=estudiante.getNombre()%></td>
                    <td><%=estudiante.getApellido()%></td>
                    <td><%=estudiante.getCarrera()%></td>
                    <td><%=estudiante.getCorreo()%></td>
                    <td><%=estudiante.getContacto()%></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <% } %>

    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
