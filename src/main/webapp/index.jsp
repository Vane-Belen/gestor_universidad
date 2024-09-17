<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Tu día</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body style="background-image: url('img/fondo.jpg');background-size: cover;
            background-position: center;">

        <nav class="navbar navbar-expand-lg" style="background-color: #e3f2fd;">
            <!--propiedades(estilos)  -->
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">Mi Portal</a>
                <button class="navbar-toggler" type="button"
                        data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 nav-pills">
                        <li class="nav-item"><a class="nav-link" href="cursos.jsp" target="miContenedor">Mis Cursos</a></li>
                        <li class="nav-item"><a class="nav-link" href="CarrerasServlet" target="miContenedor">Toma de Ramos</a></li>
                        <li class="nav-item"><a class="nav-link" href="EstudiantesServlet" target="miContenedor">Estudiantes</a></li>
                        <li class="nav-item"><a class="nav-link" href="registroEstudiantes.jsp" target="miContenedor">Registrar Nuevo Estudiante</a></li>
                        <li class="nav-item"><a class="nav-link" href="DetalleCursoServlet" target="miContenedor">Detalle Curso</a></li>
                        <li class="nav-item"><a class="nav-link" href="EliminarMasivoEstudianteServlet" target="miContenedor">Eliminación Masiva Estudiante</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div style="height:900px;">
            <iframe name="miContenedor" src="bienvenida.jsp" style="height:100%; width:100%;" frameBorder="0"></iframe>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>

</html>
