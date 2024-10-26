package br.edu.ifsp.dsw1.ex2.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Aluno {
	
	private final String prontuario;
	private final String nome;
	private final List<String> emails;
	private final List<Curso> cursos;
	
	public Aluno(String prontuario, String nome) {
		this.prontuario = prontuario;
		this.nome = nome;
		emails = new LinkedList<>();
		cursos = new LinkedList<>();
	}

	public String getProntuario() {
		return prontuario;
	}

	public String getNome() {
		return nome;
	}

	public List<String> getEmails() {
		return emails;
	}

	public List<Curso> getCursos() {
		return cursos;
	}
	
	public void addEmail(String email) {
		emails.add(email);
	}
	
	public void addCourse(Curso curso) {
		cursos.add(curso);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(prontuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(prontuario, other.prontuario);
	}

	@Override
	public String toString() {
		return "Aluno [prontuario=" + prontuario + ", nome=" + nome + ", emails=" + emails + ", cursos=" + cursos + "]";
	}
}
