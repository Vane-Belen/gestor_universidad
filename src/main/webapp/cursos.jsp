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
        <form class="row g-3" action="CursosServlet" method="POST">
            <div class="col-auto">
                <label class="form-label">Rut Estudiante</label>
            </div>
            <div class="col-auto">
                <input type="text" class="form-control" id="rut" name="rut">
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">Buscar Mis Cursos</button>
            </div>
        </form>

        <%

            List<Cursos> listaCursos = (List<Cursos>) request.getAttribute("lista_curso");
            if (listaCursos != null && !listaCursos.isEmpty()) {
        %>
        <table id="cursos" class="table">
            <thead>
                <tr>
                    <th scope="col">ID Curso</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Fecha Inicio</th>
                    <th scope="col">Fecha Termino</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Cursos curso : listaCursos) {
                %>
                <tr>
                    <th scope="row"><%=curso.getIdCurso()%></th>
                    <td><%=curso.getNombre()%></td>
                    <td><%=curso.getFechaInicio()%></td>
                    <td><%=curso.getFechaTermino()%></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <% } %>

    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
