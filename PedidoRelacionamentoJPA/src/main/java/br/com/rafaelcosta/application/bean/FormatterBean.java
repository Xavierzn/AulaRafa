package br.com.rafaelcosta.application.bean;


import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named // da um nome para o bean por exemplo o bean se chama tabelaBean, essa linha "renomeia" o bean
@ApplicationScoped // o @ApplicationScoped é o cara que vai colocar a configuração do do sistema
public class FormatterBean implements Serializable {

	private static final Locale LOCALE_BR = new Locale("pt", "BR"); // esta linha seta a localização do projeto e pais
	
	public String formatarMoeda(double valor) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(LOCALE_BR);
		return nf.format(valor);
	}
}
