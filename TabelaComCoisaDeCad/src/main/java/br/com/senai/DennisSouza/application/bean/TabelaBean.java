package br.com.senai.DennisSouza.application.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import br.com.senai.DennisSouza.application.model.Despesas;

@SuppressWarnings("serial") //tira anuncios de advertência
@Named("tabela")
@SessionScoped //tempo de vida da página, o "session" mantém os dados enquanto o navegador estiver aberto
public class TabelaBean implements Serializable{
	
	private List<Despesas> despesas = new ArrayList<>();
	//lista que trabalha com o jsf
	String data1;
	String desc1;
	Double Valor1;
	Boolean a = false; 
	
	
	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public Double getValor1() {
		return Valor1;
	}

	public void setValor1(Double valor1) {
		Valor1 = valor1;
	}

	
	
	
	
	public String inserir(String data,String desc,Double Valor) {
		
		Despesas d = new Despesas(data,desc,Valor); //instância da listdatamodel
		d.setEdit(true);
		a =true;
		despesas.add(d);
		data1 = null;
		desc1 = null;
		Valor1= null;
		return null;
		
	}
	
	public String excluir(Despesas despesa) {
		
		despesas.remove(despesa);
		
		return null;
	}
	
	public String editar(Despesas despesa) {
		despesa.setEdit(true); 
		
		return null;
	}
	
	public String gravar (Despesas despesa) {
		despesa.setEdit(false);
		
		return null;
	}
	
	public List<Despesas> getDespesas() {
		return despesas;
	}

	public Boolean getA() {
		return a;
	}

	public void setA(Boolean a) {
		this.a = a;
	}

}
