<%@page import="br.edu.ifsp.dsw1.ex2.factory.CourseFactoryImp"%>
<%@page import="br.edu.ifsp.dsw1.ex2.factory.CourseFactory"%>
<%@page import="br.edu.ifsp.dsw1.ex2.entities.Aluno"%>
<%@page import="br.edu.ifsp.dsw1.ex2.repository.AlunoDAOImp"%>
<%@page import="br.edu.ifsp.dsw1.ex2.repository.AlunoDAO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 
	Map<String, String[]> parameters = request.getParameterMap();
	AlunoDAO repository = AlunoDAOImp.getInstance();
	CourseFactory factory = new CourseFactoryImp();
	Aluno aluno = null;
	
	if (parameters != null && !parameters.isEmpty()) {
		var name = parameters.get("nome")[0];
		var prontuario = parameters.get("prontuario")[0];
		
		aluno = new Aluno(prontuario, name);
		
		var emails = parameters.get("email");
		
		for (var email : emails) {
			if (!email.isBlank()) {
				aluno.addEmail(email);
			}
		}
		
		var courses = parameters.get("cursos");
		
		for (var course : courses) {
			var newCourse = factory.createCourse(course);
			aluno.addCourse(newCourse);
		}
		
		repository.adicionarAluno(aluno);
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/geral.css">
    <link rel="stylesheet" href="css/sucess.css"/>
    <title>Cadastro Concluído!</title>
</head>
<body>
    <div class="info-container">
        <h1 class="title">Cadastro Concluído com Sucesso!</h1>

        <h2>Verifique os dados da sua inscrição abaixo:</h2>
        
        <p><span>Prontuário:</span> <%= aluno.getProntuario() %> </p>
        <p><span>Nome Completo:</span> <%= aluno.getNome() %> </p>
        
        <% for (var email : aluno.getEmails()) { 
        	if (email.contains("@aluno.ifsp.edu.br")) {%>
        		<p class="bold">E-mail: <%= email %> </p>
         <% } else { %>
        	 	<p><span>E-mail:</span> <%= email %> </p>
         <% } %>
       <% } %>
        	
        <p><span>Cursos Inscritos:</span></p>
        <ul>
        	<% for (var curso : aluno.getCursos()) {%>
            	<li><%=curso%></li>
            <% } %>
        </ul>
    </div>
    
    <a href="form.jsp">
        <button class="button">Voltar</button>
    </a>
</body>
</html>