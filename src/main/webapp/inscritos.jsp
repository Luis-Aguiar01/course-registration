<%@page import="br.edu.ifsp.dsw1.ex2.entities.Aluno"%>
<%@page import="br.edu.ifsp.dsw1.ex2.entities.Curso"%>
<%@page import="br.edu.ifsp.dsw1.ex2.factory.CourseFactoryImp"%>
<%@page import="br.edu.ifsp.dsw1.ex2.factory.CourseFactory"%>
<%@page import="br.edu.ifsp.dsw1.ex2.repository.AlunoDAOImp"%>
<%@page import="br.edu.ifsp.dsw1.ex2.repository.AlunoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
	String course = request.getParameter("curso");
	
	AlunoDAO repository = AlunoDAOImp.getInstance();
	CourseFactory factory = new CourseFactoryImp();
	
	Curso currentCourse = null;
	
	if (course != null) {
		currentCourse = factory.createCourse(course);
	}
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/inscritos.css">
    <link rel="stylesheet" href="css/geral.css">
    <title>Inscritos</title>
</head>
<body>
	<% if (course == null) { %>
    
	    <form action="inscritos.jsp" method="GET">
	        <label>Escolha o Curso Para a Consulta:</label>
	        
	        <select name="curso" required>
	            <option value="" disabled selected>
	                Selecione uma opção
	            </option>
	
	            <option value="spring">
	                Desenvolvimento de Aplicações Web com Java e Spring Boot
	            </option>
	
	            <option value="kotlin">
	                Kotlin para Desenvolvimento de Aplicações Android
	            </option>
	
	            <option value="services">
	                Java Web Services: REST e SOAP
	            </option>
	        </select>
	
	        <input type="submit" value="Consultar" class="button">
	    </form>
	    
	    <a href="form.jsp">
	        <button class="button back">Voltar</button>
	    </a>
    
    <% } else { %>
    
	    <h1>Inscritos no Curso de <%= currentCourse.getTitulo() %></h1>
	
	    <table>
	        <thead>
	            <tr>
	                <th>Nome</th>
	                <th>Prontuário</th>
	                <th>E-mail Principal</th>
	                <th>E-mail Secundário</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<% for (var aluno : repository.getAll()) { %>
	        		<% if (isInCourse(aluno, currentCourse)) {%>
			            <tr>
			                <td><%= aluno.getNome() %></td>
			                <td><%= aluno.getProntuario() %></td>
			                
			                <% for (var email : aluno.getEmails()) { %>
			                	<td><%= email %></td>
			                <% } %>
			                
			                <% if (aluno.getEmails().size() == 1) { %>
			                	<td>-</td>
			                <% } %>
			            </tr>
			         <% } %>
	            <% } %>
	        </tbody>
	    </table>
	    
	    <a href="inscritos.jsp">
	        <button class="button back">Voltar</button>
	    </a>
    
    <% } %>
</body>
</html>

<%! 
public boolean isInCourse(Aluno aluno, Curso curso) {
	return aluno.getCursos().stream()
			.anyMatch(c -> c.equals(curso));	
}
%>
    