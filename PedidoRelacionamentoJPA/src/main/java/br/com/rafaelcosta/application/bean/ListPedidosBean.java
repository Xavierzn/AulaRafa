package br.com.rafaelcosta.application.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafaelcosta.application.ejb.PedidoBean;
import br.com.rafaelcosta.application.model.Pedido;


@Named
@RequestScoped
public class ListPedidosBean implements Serializable {

	@EJB
	private PedidoBean pedidoBean;
	
	private List<Pedido> pedidos;
	
	@PostConstruct
	public void init() {
		pedidos = pedidoBean.listar();
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public String pagar(Integer pedidoId, String tipo) throws Exception  { // aqui ele vai acerta a forma de pagamento se vai ser cartão ou boleto
		pedidoBean.pagar(pedidoId, tipo);
		return "pedidos?faces-redirect=true";
	}
	
	public String excluir(Integer pedidoId) { // esta linha ira excluir o pedido atraves do id
		pedidoBean.excluir(pedidoId);
		return "pedidos?faces-redirect=true";
	}
}
