import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SuppressWarnings("serial") 
@SessionScoped
@Named("Logint")

public class LoginTabela implements Serializable {
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
					return "sucesso po";
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
