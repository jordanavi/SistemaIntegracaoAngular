package com.biblioteca.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDisciplina;
	private String disciplina;
	
	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdCategoria(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public List<Conteudo> getConteudo() {
		return conteudos;
	}

	public void setLivros(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="disciplina")
	private List<Conteudo> conteudos = new ArrayList<>();

	public Disciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}
