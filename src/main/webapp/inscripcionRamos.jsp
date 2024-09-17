<%@page import="com.entitys.Cursos"%>
<%@page import="com.entitys.Carreras"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body class="p-5" style="background-color: rgba(255, 255, 255, 0.5);">
        
        <div class="px-4  text-center">
            <h3 class="fw-bold text-body-emphasis">Inscripcion de Ramos</h3>
        </div>

        <div class="container w-50 mt-3">
            <form action="InscribirRamoServlet" method="POST">
                <div class="mb-3">
                    <label for="dificultad" class="form-label">Seleccione una Carrera</label>
                    <select class="form-select form-select-sm" name="carrera" id="carrera">
                        <option disabled selected>Carreras</option>
                        <%
                            List<Carreras> listaCarreras = (List) request.getSession().getAttribute("listaCarreras");
                            for (Carreras carrera : listaCarreras) {
                        %>
                            <option value="<%=carrera.getIdCarrera()%>"><%=carrera.getNombreCarrera()%></option>
                        <% }%>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="rut" class="form-label">Rut Alumno</label> 
                    <input type="text" class="form-control" id="rut_alumno" name="rut_alumno">
                </div>
                <div class="mb-3">
                    <label for="curso" class="form-label">Seleccione un Curso</label>
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

                <div class="d-grid gap-2 col-3 mx-auto">
                    <button type="submit" class="btn btn-primary">Tomar Ramo</button>
                </div>

            </form>
        </div>
        
        <div id="message" style="display:none;" class="px-4  text-center">
            <h3 class="fw-bold text-body-emphasis"><%= request.getAttribute("message") %></h3>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
    
    <script>
        function showMessage() {
            var messageElement = document.getElementById('message');
            if (messageElement && messageElement !== null) {
                messageElement.style.display = 'block';

                setTimeout(function() {
                    messageElement.style.display = 'none';
                }, 3000);
            }
        }

        window.onload = showMessage;
    </script>

</html>


