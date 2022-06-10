package br.com.rafaelcosta.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pagamento implements Serializable {
	
	// este enum vai pradonizar a forma de pagamento
	public enum TipoPagamento {
		CARTAO_CREDITO,
		BOLETO
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	
	@Enumerated(EnumType.STRING) //esta linha manda as informaões do enum, os metodos de pagamentos
	@Column(name = "tipo_pagto", length = 20, nullable = false)// esta linha cria uma coluna com o nome no banco
	private TipoPagamento tipoPagto;
	
	@OneToOne(mappedBy = "pagamento")//esta linha esta chamando o pagamento pelo produto, "está colocando uma chave estrangeira na tabela"
	private Pedido pedido;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoPagamento getTipoPagto() {
		return tipoPagto;
	}

	public void setTipoPagto(TipoPagamento tipoPagto) {
		this.tipoPagto = tipoPagto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", tipoPagto=" + tipoPagto + "]";
	}
}
