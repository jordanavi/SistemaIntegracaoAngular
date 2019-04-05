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

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;

@RestController
@RequestMapping(value = "/livros")
@CrossOrigin(origins = "http://localhost")
public class LivroResource {

	@Autowired
	private LivroRepository repository;

	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Livro livro) {
		livro.getCategoria().setIdCategoria(livro.getCategoria().getIdCategoria());
		livro.getEditora().setIdEditora(livro.getEditora().getIdEditora());
		repository.save(livro);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getIsbn())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@Valid @RequestBody Livro livro) {
		repository.save(livro);
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
	public ResponseEntity<List<Livro>> findAll() {
		List<Livro> livros = repository.findAll();
		return ResponseEntity.ok().body(livros);
	}

}
