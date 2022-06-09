package BancoDaTabela;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class TareafaBeanDaTabela {

	@PersistenceContext
	private EntityManager em;
	
	public void inserir(TarefaTabela tarefa) {
		em.persist(tarefa);
	}
	
	public void atualizar(TarefaTabela tarefa) {
		em.merge(tarefa); // o metodo merge faz um update, atualiza a infromação
	}
	
	public TarefaTabela carregar(int id) { // ele pega as "informações do bancdo de dados"
		return em.find(TarefaTabela.class, id); //o find ele pergunta qual é class do objeto, e procura o id. Pelo Id uma Tarefa
	}
	
	public void excluir(TarefaTabela tarefa) {
		tarefa = carregar(tarefa.getId()); // pega uma terefa pelo id e carrega a tarefa
		em.remove(tarefa);
	}

	/*public void inserir(TarefaTabela tarefa) {
		// TODO Auto-generated method stub
		
	}*/

}
