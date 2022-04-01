package Aplicacao;

import java.io.BufferedReader;
import java.io.IOException;

import Modelos.Produtos;
import Modelos.Tipo;

public class Mercado_tras {

	public static void SalvaProduto(BufferedReader ler) throws NumberFormatException, IOException {
		Produtos produto = new Produtos();
		Tipo tipo = new Tipo();
		String [] dadosProdutos = View.ViewMercado.ViewMenuSalvarAluno(ler);
		
		tipo.setNomeTipo(dadosProdutos[0]);
		produto.setNome(dadosProdutos[1]);
		produto.setPreco(Integer.parseInt(dadosProdutos[2]));
		
		
	}
}
