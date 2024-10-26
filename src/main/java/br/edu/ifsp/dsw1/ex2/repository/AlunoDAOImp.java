package br.edu.ifsp.dsw1.ex2.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import br.edu.ifsp.dsw1.ex2.entities.Aluno;

public class AlunoDAOImp implements AlunoDAO {
	
	private static AlunoDAOImp instance;
	private final List<Aluno> alunos;
	
	private AlunoDAOImp() {
		alunos = new LinkedList<>();
	}
	
	@Override
	public void adicionarAluno(Aluno aluno) {
		if (!alunos.contains(aluno)) {
			alunos.add(aluno);
		}
	}

	@Override
	public void removerAluno(Aluno aluno) {
		if (alunos.contains(aluno)) {
			alunos.remove(aluno);
		}
	}

	@Override
	public Optional<Aluno> procurarPorProntuario(String prontuario) {
		return alunos.stream()
				.filter(a -> a.getProntuario().equals(prontuario))
				.findFirst();
	}
	
	@Override
	public List<Aluno> getAll() {
		return alunos;
	}
	
	public static AlunoDAO getInstance() {
		if (instance == null) {
			instance = new AlunoDAOImp();
		}
		return instance;
	}
}
