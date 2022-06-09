package BancoTabelaCerta5;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;


@Named("formT")
@RequestScoped
public class Form_Tabela_Certa5 implements Serializable{
	
	@EJB
	private Tarefa_Bean_Certa5 tarefaBeanT;
	
	@Inject
	private FacesContext context;
	
	private UIComponent searchInputText;
	
	private Integer tarefaId;
	
	private Tarefa_Tabela_Certa_5  tarefa;
	
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
		public Tarefa_Tabela_Certa_5 getTarefa() { // ele cria uma tarefa nova
			if(tarefa==null) { // se a tarefa estivar vazia ele cria uma nova tarefa.
				tarefa = new Tarefa_Tabela_Certa_5();
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
