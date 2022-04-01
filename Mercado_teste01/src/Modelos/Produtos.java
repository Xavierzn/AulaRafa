package Modelos;

public class Produtos {
		String nome;
		double preco;
		
		public Produtos(String dados) {
			String[] atributos = dados.split(",");
			String[] nome = atributos[1].split("=");
			String[] preco = atributos[2].split("=");
			
			Tipo tipos = new Tipo(atributos);
			
			this.nome = nome[1].trim();
			this.preco = Integer.parseInt(preco[1].trim());
		
		}
		
		public Produtos() {
			
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public double getPreco() {
			return preco;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}
		
		@Override
		public String toString() {
			return "Produtos [nome=" + nome + ", preco=" + preco + "]";
		}
		
		
}
