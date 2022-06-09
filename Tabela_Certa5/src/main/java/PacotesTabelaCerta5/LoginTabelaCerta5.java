package PacotesTabelaCerta5;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("login")
@RequestScoped
public class LoginTabelaCerta5 implements Serializable {
	
	private String nome;
	private String senha;
	
	@PostConstruct
	public void oncreate() {
		System.out.println("Bem criado"); // constroi o bean
	}
	
	@PreDestroy
	public void ondestroy() { // ele executa esse metodo antes do bean ser distruido
		System.out.println("Bem será destruido"); 
	}
	
	public String dologin() {
		if("abc".equals(nome) && "123".equals(senha) ) { //aqui ele esta comparando a senha e o usuario
			return "sucesso";
		}
		return null; // toda vez que retorna null, o jsf recarrega a mesma pagina
		
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
