package br.com.rafaelcosta.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // o entity tabela/entidade cria uma tabela no mysql 
public class Tarefa {

	@Id 
	@GeneratedValue
	private Integer id; // entidade do objeto
	
	private String descricao;
	
	private Integer prioridade; // esta em integer em vez de int, para n receber null
	
	private Boolean concluida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}	
	
	
	
}
