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

import com.biblioteca.model.AreaConhecimento;
import com.biblioteca.repository.AreaConhecimentoRepository;

@RestController
@RequestMapping(value = "/areaconhecimentos")
@CrossOrigin(origins = "http://localhost")
public class AreaConhecimentoResource {

	@Autowired
	private AreaConhecimentoRepository repository;

	@GetMapping
	public ResponseEntity<List<AreaConhecimento>> findAll() {
		List<AreaConhecimento> areaConhecimentos = repository.findAll();
		return ResponseEntity.ok().body(areaConhecimentos);
	}

	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody AreaConhecimento areaConhecimento) {
		repository.save(areaConhecimento);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(areaConhecimento.getIdAreaConhecimento()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@Valid @RequestBody AreaConhecimento areaConhecimento) {
		repository.save(areaConhecimento);
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
