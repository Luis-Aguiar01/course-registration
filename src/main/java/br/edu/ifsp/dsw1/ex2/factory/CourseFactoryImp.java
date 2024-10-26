package br.edu.ifsp.dsw1.ex2.factory;

import br.edu.ifsp.dsw1.ex2.entities.Curso;

public class CourseFactoryImp implements CourseFactory {
	
	@Override
	public Curso createCourse(String type) {
		if (type.equals("kotlin")) {
			return new Curso("Kotlin para Desenvolvimento de Aplicações Android");
		} 
		else if (type.equals("spring")) {
			return new Curso("Desenvolvimento de Aplicações Web com Java e Spring Boot");
		} 
		else {
			return new Curso("Java Web Services: REST e SOAP");
		}
	}
}
