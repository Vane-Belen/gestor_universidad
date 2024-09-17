<%@page import="com.entitys.Estudiantes"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Mi Portal</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body class="p-5" style="background-color: rgba(255, 255, 255, 0.5);">
        <form class="row g-3" action="EliminarEstudianteServlet" method="POST">
            <div class="col-auto">
                <label class="form-label">Codigo Estudiante</label>
            </div>
            <div class="col-auto">
                <input type="text" class="form-control" id="id_estudiante" name="id_estudiante">
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-danger mb-3">Eliminar Estudiante</button>
            </div>
        </form>

        <table class="table">
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
                    List<Estudiantes> listaEstudiantes = (List) request.getSession().getAttribute("listaEstudiantes");
                    int cont = 1;
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
                <% cont = cont + 1;%>
                <% }%>
            </tbody>
        </table>
        <%
            String alertMessage = (String) request.getAttribute("alertMessage");
            if (alertMessage != null) {
        %>
        <script type="text/javascript">
            alert('<%= alertMessage%>');
            window.location.href = 'bienvenida.jsp';// Mostrar la alerta
        </script>
        <%
            }
        %>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>



