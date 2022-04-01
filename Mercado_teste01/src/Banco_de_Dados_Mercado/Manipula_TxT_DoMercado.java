package Banco_de_Dados_Mercado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Modelos.Produtos;
import Util_Mercado.Lista_Produtos;

public class Manipula_TxT_DoMercado {

	private static String nomeDoArquivo = "CadastroProduto.txt";

	public static void SalvaTxT() throws IOException {
		try(BufferedWriter buffer = new BufferedWriter(new FileWriter(nomeDoArquivo));
				PrintWriter pw = new PrintWriter(buffer)){
			for(Produtos a: Lista_Produtos.getInstance())
				pw.println(a);
		}
	}

	public static void LerTxT() throws FileNotFoundException, IOException{
		try(FileWriter arq = new FileWriter(nomeDoArquivo,true)){};

		String line;

		try(BufferedReader reader = new BufferedReader(new FileReader(nomeDoArquivo))){

			while ((line = reader.readLine()) != null && !"".equals(line)) {
				Produtos produto = new Produtos(line);
				Lista_Produtos.getInstance().add(produto);
			}
		}

	}
}
