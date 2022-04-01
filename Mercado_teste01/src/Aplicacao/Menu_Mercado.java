package Aplicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu_Mercado {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader ler = new BufferedReader(new InputStreamReader (System.in));
		
		int menu = 0;

		while(menu !=4) {
			switch(menu) {

			case 1:
			menu = View.ViewMercado.ViewMenuMercado(ler);
				break;
				
			case 2:
				View.ViewMercado.ViewMenuSalvarAluno(ler);
				break;
			}
		}
	}

}
