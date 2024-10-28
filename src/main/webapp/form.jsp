<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/geral.css"/>
    <link rel="stylesheet" href="css/form.css"/>
    <script src="scripts/form.js" defer charset="UTF-8"></script>
    <title>Formul�rio de Inscri��o</title>
</head>
<body>
	<header>
        <a href="inscritos.jsp">Lista da Inscri��es</a>
    </header>

    <h1 class="title">Formul�rio de Inscri��o Para os Cursos Dispon�veis</h1>

    <form action="sucess.jsp" method="POST" id="course-form">
        
        <div class="form-content">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" id="nome" placeholder="Digite o seu nome completo" required>
        </div>
        
        <div class="form-content">
            <label for="prontuario">Prontu�rio:</label>
            <input type="text" name="prontuario" id="prontuario" placeholder="Digite o seu prontu�rio" required>
        </div>

        <div class="form-content">
            <label for="email">E-mail:</label>
            <input type="email" name="email" id="email" placeholder="Digite o seu E-mail principal" required>
        </div>

        <div class="form-content">
            <label for="email2">E-mail Secund�rio (opcional):</label>
            <input type="email" name="email" id="email2" placeholder="Digite o seu E-mail secund�rio">
        </div>

        <div class="form-content cursos">
            <label>Cursos Dispon�veis</label>
            
            <div class="checkbox">
                <label for="spring">
                    <img src="assets/spring-logo.png"/> Desenvolvimento de Aplica��es Web com Java e Spring Boot
                </label>
                <input type="checkbox" name="cursos" id="spring" value="spring">
            </div>
            
            <div class="checkbox">
                <label for="kotlin">
                    <img src="assets/Kotlin_Icon.png"/> Kotlin para Desenvolvimento de Aplica��es Android
                </label>
                <input type="checkbox" name="cursos" id="kotlin" value="kotlin">
            </div>

            <div class="checkbox">
                <label for="web-services">
                    <img src="assets/api-icon.png"/> Java Web Services: REST e SOAP
                </label>
                <input type="checkbox" name="cursos" id="web-services" value="services">
            </div>
        </div>
        
        <div class="form-content">
            <input type="submit" value="Enviar" class="button">
        </div>
    </form>
</body>
</html>