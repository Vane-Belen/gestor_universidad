
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
        <main>
            <div class="px-4 py-5 my-5 text-center">
                <img class="d-block mx-auto mb-4" src="img/journal-bookmark.svg" alt="" width="72" height="57">
                <h1 class="display-5 fw-bold text-body-emphasis">Mi Portal Universitario</h1>
                <div class="col-lg-6 mx-auto">
                    <p class="lead mb-4"> Te damos la bienvenida a nuestra plataforma, la cual te ayudara a ingresar datos y tambien poder revisarlos.</p>
                    <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
                        <a class="btn btn-primary btn-lg px-4 gap-3" href="cursos.jsp" target="miContenedor">Mis Cursos</a>
                        <a class="btn btn-outline-secondary btn-lg px-4" href="DetalleCursoServlet" target="miContenedor">Detalle Curso</a>
                    </div>
                </div>
            </div>

        </main>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>