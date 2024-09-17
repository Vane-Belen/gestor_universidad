<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body class="p-3" style="background-color: rgba(255, 255, 255, 0.5);">
        
        <div class="px-3  text-center">
            <h3 class="fw-bold text-body-emphasis">Registrar Alumno</h3>
        </div>
        
        <div class="container w-50 mt-2">
            <form action="EstudiantesServlet" method="POST">
                <div class="mb-3">
                    <label for="Nombre" class="form-label">Rut</label>
                    <input type="text" class="form-control" id="rut" name="rut">
                </div>
                <div class="mb-3">
                    <label for="Nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre">
                </div>
                <div class="mb-3">
                    <label for="Apellido" class="form-label">Apellido</label>
                    <input type="text" class="form-control" id="apellido" name="apellido">
                </div>
                <div class="mb-3">
                    <label for="Cargo" class="form-label">Carrera</label>
                    <input type="text" class="form-control" id="carrera" name="carrera">
                </div>
                <div class="mb-3">
                    <label for="Área" class="form-label">Correo</label>
                    <input type="text" class="form-control" id="correo" name="correo">
                </div>
                <div class="mb-3">
                    <label for="Área" class="form-label">Telefono</label>
                    <input type="text" class="form-control" id="telefono" name="telefono">
                </div>
                
                <div class="d-grid gap-2 col-2 mx-auto">
                    <button type="submit" class="btn btn-primary">Registrar</button>
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