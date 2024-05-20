package br.org.serratec.academia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.academia.entities.Turma;
import br.org.serratec.academia.services.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	TurmaService turmaService;

	@GetMapping
	public ResponseEntity<List<Turma>> listarTurma() {
		return new ResponseEntity<>(turmaService.listarTurma(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> buscarPorId(@PathVariable Integer id) {
		Turma turma  = turmaService.buscarTurmaId(id);

		if (turma == null) {
			return new ResponseEntity<>(turma, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(turma, HttpStatus.OK);
		}
	}
	
	@GetMapping("/porid")
	public ResponseEntity<Turma> buscarPorTurmaId(@RequestParam Integer id) {
		return new ResponseEntity<>(turmaService.buscarTurmaId(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Turma> salvar(@RequestBody Turma turma) {
		return new ResponseEntity<>(turmaService.salvarTurma(turma), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Turma> atualizar(@RequestBody Turma turma) {
		return new ResponseEntity<>(turmaService.atualizaTurma(turma), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletarTurma(@RequestBody Turma turma ) {
		if (turmaService.deletarTurma(turma)) {
			return new ResponseEntity<>("Deletado com Sucesso!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Não foi possível deletar!", HttpStatus.BAD_REQUEST);
		}
	}

}
