package br.edu.ifsp.dsw1.ex2.factory;

import br.edu.ifsp.dsw1.ex2.entities.Curso;

public interface CourseFactory {
	Curso createCourse(String type);
}
