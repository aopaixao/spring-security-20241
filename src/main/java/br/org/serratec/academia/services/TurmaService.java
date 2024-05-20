package br.org.serratec.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.academia.entities.Turma;
import br.org.serratec.academia.repositories.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository turmaRep;

	public List<Turma> listarTurma() {
		return turmaRep.findAll();
	}

	public Turma buscarTurmaId(Integer id) {
		return turmaRep.findById(id).orElse(null);
	}

	public Turma salvarTurma(Turma turma) {
		return turmaRep.save(turma);
	}

	public Turma atualizaTurma(Turma turma) {
		return turmaRep.save(turma);
	}

	public Boolean deletarTurma(Turma turma) {
		if (turma == null)
			return false;

		Turma turmaExistente = buscarTurmaId(turma.getTurmaId());
		if (turmaExistente == null)
			return false;

		turmaRep.delete(turma);

		Turma turmaContinuaExistindo = buscarTurmaId(turma.getTurmaId());
		if (turmaContinuaExistindo == null)
			return true;

		return false;

	}

}
