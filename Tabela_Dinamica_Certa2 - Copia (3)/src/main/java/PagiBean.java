import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import BancoDaTabela.TareafaBeanDaTabela;
import BancoDaTabela.TarefaTabela;





@SuppressWarnings("serial") 
@Named("tabela")
@SessionScoped
public class PagiBean implements Serializable{
	
private List<Despesas> despesas = new ArrayList<>();
	
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
		
		Despesas d = new Despesas(data,desc,valor); 
		d.setEdit(true);
		back =true;
		despesas.add(d);
		date = null;
		desc = null;
		valor= null;
		return null;
		
	}
	
	public String excluir(Despesas despesa) {
		
		despesas.remove(despesa); // aqui ele vai remover todos os objetos que estiverem na listas
		
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
				
				//parte do banco
		@EJB
		private TareafaBeanDaTabela tarefaBeanT; 
			
		@Inject
		private FacesContext context;
			
		private UIComponent searchInputText;
					
		private Integer tarefaId;
					
		private TarefaTabela tarefa;
					
		public void gravar(AjaxBehaviorEvent event) {// o bin vai chamar o metodo gravar, e vai 
			if(tarefa.getId()==null) { //se a tarefa existi, então a tarefa vai ser atualizada
				tarefaBeanT.inserir(tarefa);
			}else {
				tarefaBeanT.atualizar(tarefa); //quando for null ele vai "pegar outra tarefa" e manda para o tarefa, aquele tarefaBean.inserir(tarefa)
				}
		}
				
			public void pesquisar(AjaxBehaviorEvent event) { 
				tarefa = tarefaBeanT.carregar(tarefaId); //ela pega o input text e adiciona
					
				if(tarefa == null) { 
					context.addMessage(searchInputText.getClientId(context),
							new FacesMessage("Tarefa n�o encontrada")); 
					}
					tarefaId = null;	
					
			}
			
			public void excluir(AjaxBehaviorEvent event) {
				tarefaBeanT.excluir(tarefa);
				tarefa = null; //ele vai chamar o tarefa bin, e vai chamar a tarefa e vai excluir
			}

			public TarefaTabela getTarefa() { // ele cria uma tarefa nova
				if(tarefa==null) { // se a tarefa estivar vazia ele cria uma nova tarefa.
					tarefa = new TarefaTabela();
				}
				return tarefa; //se a tarefa existir, vc pega ela e faz um bind
			}
			
				public UIComponent getSearchInputText() {
					return searchInputText;
				}
	
				public void setSearchInputText(UIComponent searchInputText) {
					this.searchInputText = searchInputText;
				}
	
				public Integer getTarefaId() {
					return tarefaId;
				}
	
				public void setTarefaId(Integer tarefaId) {
					this.tarefaId = tarefaId;
				}

}


