package Modelos;

public class Tipo {
	String nomeTipo;
	
	public Tipo(String[] dados) {
		
		String[] tipo = dados[4].split("=");
		
		this.nomeTipo = tipo[1].trim();
	}
	
	public Tipo() {
		
	}

	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	@Override
	public String toString() {
		return "Tipo [nomeTipo=" + nomeTipo + "]";
	}
	
	
}
