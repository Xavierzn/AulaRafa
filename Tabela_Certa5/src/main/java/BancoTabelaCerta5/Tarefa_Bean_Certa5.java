package BancoTabelaCerta5;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Tarefa_Bean_Certa5 {
	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Tarefa_Tabela_Certa_5 tarefa) {
		em.persist(tarefa);
	}
	
	public void atualizar(Tarefa_Tabela_Certa_5  tarefa) {
		em.merge(tarefa); // o metodo merge faz um update, atualiza a infromação
	}
	
	public Tarefa_Tabela_Certa_5 carregar(int id) { // ele pega as "informações do bancdo de dados"
		return em.find(Tarefa_Tabela_Certa_5.class, id); //o find ele pergunta qual é class do objeto, e procura o id. Pelo Id uma Tarefa
	}
	
	public void excluir(Tarefa_Tabela_Certa_5 tarefa) {
		tarefa = carregar(tarefa.getId()); // pega uma terefa pelo id e carrega a tarefa
		em.remove(tarefa);
	}

}
