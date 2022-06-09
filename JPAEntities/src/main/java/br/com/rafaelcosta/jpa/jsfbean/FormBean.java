package br.com.rafaelcosta.jpa.jsfbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rafaelcosta.jpa.ejbbean.TarefaBean;
import br.com.rafaelcosta.jpa.model.Tarefa;

@Named("form")
@RequestScoped // é o tempo de vida do bean, aplication scoop enquanto seu servidor fica ligado ele fica "vivo"
public class FormBean implements Serializable {
	
	@EJB
	private TarefaBean tarefaBean; // aqui esta criando uma variavel que recebe "informacoes" da tabelaBean

	@Inject
	private FacesContext context; // ele pega a informaçao de todo formulario
	
	private UIComponent searchInputText; // os 3 primeiros codigos injetam codigos
	
	private Integer tarefaId;
	
	private Tarefa tarefa;
	
	public void gravar(AjaxBehaviorEvent event) {// o bin vai chamar o metodo gravar, e vai 
		if(tarefa.getId()==null) { //se a tarefa existi, então a tarefa vai ser atualizada
			tarefaBean.inserir(tarefa);
		}else {
			tarefaBean.atualizar(tarefa); //quando for null ele vai "pegar outra tarefa" e manda para o tarefa, aquele tarefaBean.inserir(tarefa)
		}		
	}
	
	public void pesquisar(AjaxBehaviorEvent event) { 
		tarefa = tarefaBean.carregar(tarefaId); //ela pega o input text e adiciona
		
		if(tarefa == null) { 
			context.addMessage(searchInputText.getClientId(context),
					new FacesMessage("Tarefa n�o encontrada")); 
		}
		tarefaId = null;	
	}
	
	public void excluir(AjaxBehaviorEvent event) {
		tarefaBean.excluir(tarefa);
		tarefa = null; //ele vai chamar o tarefa bin, e vai chamar a tarefa e vai excluir
	}
	public Tarefa getTarefa() { // ele cria uma tarefa nova
		if(tarefa==null) { // se a tarefa estivar vazia ele cria uma nova tarefa.
			tarefa = new Tarefa();
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
