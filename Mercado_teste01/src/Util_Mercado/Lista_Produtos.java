package Util_Mercado;

import java.util.ArrayList;
import java.util.List;

import Modelos.Produtos;

public class Lista_Produtos {

	private static List<Produtos> listaDeProdutos = new ArrayList<Produtos>();
	
	public static List<Produtos> getInstance(){
		return listaDeProdutos;
	}
}
