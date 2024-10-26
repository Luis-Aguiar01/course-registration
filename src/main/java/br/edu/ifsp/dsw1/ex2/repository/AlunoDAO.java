package br.edu.ifsp.dsw1.ex2.repository;

import java.util.List;
import java.util.Optional;

import br.edu.ifsp.dsw1.ex2.entities.Aluno;

public interface AlunoDAO {
	void adicionarAluno(Aluno aluno);
	void removerAluno(Aluno aluno);
	Optional<Aluno> procurarPorProntuario(String prontuario);
	List<Aluno> getAll();
}
