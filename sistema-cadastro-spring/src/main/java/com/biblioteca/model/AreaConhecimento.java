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
public class AreaConhecimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAreaConhecimento;
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy="areaConhecimento")
	private List<Conteudo> conteudos = new ArrayList<>();

	//public AreaConhecimento(String string) {}

	public int getIdAreaConhecimento() {
		return idAreaConhecimento;
	}

	public void setIdAreaConhecimento(int idAreaConhecimento) {
		this.idAreaConhecimento = idAreaConhecimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conteudo> getConteudo() {
		return conteudos;
	}

	public void setConteudo(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

	public void areaConhecimento(String nome) {
		this.nome = nome;
	}
	
}
