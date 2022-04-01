package Handler_Mercado;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelos.Produtos;
import Modelos.Tipo;

public class XMLHandler_Mercado  extends DefaultHandler {

		private StringBuilder texto;
		Produtos produto;
		Tipo tipos;
		
		@Override
		public void startDocument() throws SAXException {
			System.out.println("Incio Documento");
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)throws SAXException {
		
			if(qName.equals("Produtos")) {
				produto = new Produtos();
				tipos = new Tipo();
			} else {
				texto = new StringBuilder();
			}
		}
		@Override
		public void endDocument() throws SAXException {
		 System.out.println("Fim do Documento");
		}
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
		
		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			
		}
		@Override
		public void error(SAXParseException e) throws SAXException {
			
		}
		
		
		
	}

