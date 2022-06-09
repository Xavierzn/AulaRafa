
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PageBeanTabelaCerta5 {
private List<DespesasTabelaCerta5> despesas = new ArrayList<>();
	
	String date;
	String desc;
	Double valor;
	Boolean back = false; 
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor1) {
		valor = valor1;
	}
	
public String inserir(String data,String desc,Double valor) {
		
		DespesasTabelaCerta5 d = new DespesasTabelaCerta5(data,desc,valor); 
		d.setEdit(true);
		back =true;
		despesas.add(d);
		date = null;
		desc = null;
		valor= null;
		return null;
		
	}

		public String excluir(DespesasTabelaCerta5 despesa) {
			despesas.remove(despesa);
			return null;
}
		public String gravar (DespesasTabelaCerta5 despesa) {
			despesa.setEdit(false);
			
			return null;
		}
		
		public List<DespesasTabelaCerta5> getDespesas() {
			return despesas;
		}
		
		public Boolean getBack() {
			return back;
		}
		
		public void setBack(Boolean back) {
			this.back = back;
		}
		
		// Parte Do Login
		private String nome;
		private String senha;
					
		@PostConstruct
		public void oncreate() {
			System.out.println("Bean Criado");
						
		}
			
		@PreDestroy
		public void ondestroy() {
				System.out.println("Bean Destruido");
		}
		
		public String dologin() {
			if("abc".equals(nome) && "123".equals(senha) ) {
				return "despesas2"; //esse return te joga para a proxima pagina, n se esqueca de colocar o nome da pagina
		}
			return null;
		}
		
		public String getNome() {
			return nome;
		}
	
		public void setNome(String nome) {
				this.nome = nome;
		}
	
		public String getSenha() {
				return senha;
		}
	
		public void setSenha(String senha) {		
			this.senha = senha;
		}
}
