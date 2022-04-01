package View;

import java.io.BufferedReader;
import java.io.IOException;

public class ViewMercado {

	public static int ViewMenuMercado(BufferedReader reader)throws NumberFormatException, IOException {
		System.out.println("1 para cadastras\n"
				+ "2 para listar produtor\n"
				+ "3 para editar produtos"
				+ "4 sair");
		
		return Integer.parseInt(reader.readLine());
	}
	
	public static String[] ViewMenuSalvarAluno(BufferedReader reader)throws NumberFormatException, IOException{
		String[] menuProdutos = {"nome", "preco", "nomeTipo"};
		
		String[] dadosProdutos = {"","",""};
		
		for(int i=0; i < menuProdutos.length; i++) {
			System.out.println(menuProdutos[i]);
			dadosProdutos[i] = reader.readLine();
			
		}
		
		return dadosProdutos;
	}
}
