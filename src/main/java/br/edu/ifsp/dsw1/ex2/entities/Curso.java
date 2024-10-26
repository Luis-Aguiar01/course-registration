package br.edu.ifsp.dsw1.ex2.entities;

import java.util.Objects;

public class Curso {
	
	private String titulo;
	
	public Curso(String titulo) {
		setTitulo(titulo);
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		if (titulo != null) {
			this.titulo = titulo;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return titulo;
	}
}
