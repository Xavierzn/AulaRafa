package br.com.rafaelcosta.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {

	@Id // o @id ele gera o id para cada objeto
	@GeneratedValue
	private Integer id;
	
	@Column(length = 100, nullable = false) // o @column mapea o campo ou a propriedade que será mapeada
	private String nome;
	
	@Column(nullable = false)
	private Double valor;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor
				+ "]";
	}
}
