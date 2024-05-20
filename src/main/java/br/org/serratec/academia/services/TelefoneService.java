package br.org.serratec.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.academia.entities.Telefone;
import br.org.serratec.academia.repositories.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	TelefoneRepository telefoneRep;

	public List<Telefone> listarTelefones() {
		return telefoneRep.findAll();
	}

	public Telefone buscarTelefoneId(Integer id) {
		return telefoneRep.findById(id).orElse(null);
	}

	public Telefone salvarTelefone(Telefone telefone) {
		return telefoneRep.save(telefone);
	}

	public Telefone atualizarTelefone(Telefone telefone) {
		return telefoneRep.save(telefone);
	}

	public Boolean deletarTelefone(Telefone telefone) {
		if (telefone == null)
			return false;

		Telefone telefoneExistente = buscarTelefoneId(telefone.getTelefoneId());
		if (telefoneExistente == null)
			return false;

		telefoneRep.delete(telefone);

		Telefone telefoneContinuaExistindo = buscarTelefoneId(telefone.getTelefoneId());
		if (telefoneContinuaExistindo == null)
			return true;

		return false;

	}
}
