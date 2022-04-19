import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
@SuppressWarnings("serial")

public class pagBean implements Serializable{

private String nome;
	
	@Inject
	private Flash flash;
	
	public String Processar() {
		flash.put("nomeDoUsuario", nome);
		return "result?faces-redirect=true"; //força o carregamento para a outra pagina
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
