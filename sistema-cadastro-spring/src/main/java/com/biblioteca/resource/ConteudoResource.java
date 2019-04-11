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

import com.biblioteca.model.Conteudo;
import com.biblioteca.repository.ConteudoRepository;

@RestController
@RequestMapping(value = "/conteudos")
@CrossOrigin(origins = "http://localhost")
public class ConteudoResource {

	@Autowired
	private ConteudoRepository repository;

	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Conteudo conteudo) {
		conteudo.getDisciplina().setIdCategoria(conteudo.getDisciplina().getIdDisciplina());
		conteudo.getareaConhecimento().setIdAreaConhecimento(conteudo.getareaConhecimento().getIdAreaConhecimento());
		repository.save(conteudo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conteudo.getCodigo())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@Valid @RequestBody Conteudo conteudo) {
		repository.save(conteudo);
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

	@GetMapping
	public ResponseEntity<List<Conteudo>> findAll() {
		List<Conteudo> conteudos = repository.findAll();
		return ResponseEntity.ok().body(conteudos);
	}

}
