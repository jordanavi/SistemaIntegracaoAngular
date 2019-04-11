package com.biblioteca.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.biblioteca.model.Disciplina;
import com.biblioteca.repository.DisciplinaRepository;

@RestController
@RequestMapping(value = "/disciplinas")
@CrossOrigin(origins = "http://localhost")
public class DisciplinaResource {

	@Autowired
	private DisciplinaRepository repository;

	@GetMapping
	public ResponseEntity<List<Disciplina>> findAll() {
		List<Disciplina> disciplinas = repository.findAll();
		return ResponseEntity.ok().body(disciplinas);
	}

	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Disciplina disciplina) {
		repository.save(disciplina);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(disciplina.getDisciplina()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@Valid @RequestBody Disciplina disciplina) {
		repository.save(disciplina);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "{codigo}")
	public ResponseEntity<?> excluir(@PathVariable Integer codigo) {
		try {
			repository.deleteById(codigo);
			return ResponseEntity.ok(codigo);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
