package br.com.rafaelcosta.jpa.ejbbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.jpa.model.Tarefa;

@Stateless
public class TarefaBean { // essa classe faz a logica de negocios

	@PersistenceContext // o Persist manda todo o codigo e monda o banco de dados do mysql
	private EntityManager em; // o entitymanager puxa a informação do mysql
	
	public void inserir(Tarefa tarefa) {
		em.persist(tarefa);
	}
	
	public void atualizar(Tarefa tarefa) {
		em.merge(tarefa); // o metodo merge faz um update, atualiza a infromação
	}
	
	public void excluir(Tarefa tarefa) {
		tarefa = carregar(tarefa.getId()); // pega uma terefa pelo id e carrega a tarefa
		em.remove(tarefa);
	}
	
	public Tarefa carregar(int id) { // ele pega as "informações do bancdo de dados"
		return em.find(Tarefa.class, id); //o find ele pergunta qual é class do objeto, e procura o id. Pelo Id uma Tarefa
	}
}
