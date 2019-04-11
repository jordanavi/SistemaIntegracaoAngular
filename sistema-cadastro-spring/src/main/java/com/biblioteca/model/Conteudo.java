package com.biblioteca.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
public class Conteudo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	private String nome;
	private String descricao;
	private String competencia;

	@ManyToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;

	@ManyToOne
	@JoinColumn(name = "areaConhecimento_id")
	private AreaConhecimento areaConhecimento;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCompetencia() {
		return competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setCategoria(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public AreaConhecimento getareaConhecimento() {
		return areaConhecimento;
	}

	public void setEditora(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public Conteudo(Integer codigo, String nome, String descricao, String competencia, Disciplina disciplina, AreaConhecimento areaConhecimento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.competencia = competencia;
		this.disciplina = disciplina;
		this.areaConhecimento = areaConhecimento;
	}
}
