package Banco_de_Dados_Mercado;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class Manipula_XML_DoMercado {

	private static String nomeDoArquivo = "CadastroProdutos.xml";
	
	public static void SalvarXMl() throws ParserConfigurationException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		
	}
	
}
