package Aplicacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDeDados.ManipulacaoArquivoTXT;
import BancoDeDados.ManipulacaoArquivoXML;
import Modelos.Alunos;
import Modelos.Endereco;
import Util.ListaDeAlunos;
import View.ViewCRUDAlunos;

public class CRUDAluno {

	public static void SalvarAluno(BufferedReader reader) throws IOException, ParserConfigurationException, SAXException, TransformerException {

		Alunos aluno = new Alunos();
		Endereco enderecoAluno = new Endereco();
		String[] dadosAluno = ViewCRUDAlunos.ViewMenuSalvarAluno(reader);

		aluno.setNome(dadosAluno[0]);
		aluno.setCpf(Integer.parseInt(dadosAluno[1]));
		aluno.setCurso(dadosAluno[2]);
		enderecoAluno.setRua(dadosAluno[3]);
		enderecoAluno.setNumero(Integer.parseInt(dadosAluno[4]));
		enderecoAluno.setBairro(dadosAluno[5]);
		enderecoAluno.setCidade(dadosAluno[6]);
		enderecoAluno.setEstado(dadosAluno[7]);
		enderecoAluno.setCep(Integer.parseInt(dadosAluno[8]));
		aluno.setEndereco(enderecoAluno);

		ListaDeAlunos.getInstance().add(aluno);

		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
	}

	public static void ListarAlunosSalvos() throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {

		ListaDeAlunos.getInstance().clear();		
		//ManipulacaoArquivoTXT.LerArquivoTXT(listaDeAlunos);		
		ManipulacaoArquivoXML.LerArquivoXML();		
		ViewCRUDAlunos.ViewListaDeAlunosEditada();

	}

	public static void DeletarAluno(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {

		int indice = ViewCRUDAlunos.ViewMenuEditarOuDeletarAluno("deletar", reader);

		ListaDeAlunos.getInstance().remove(indice);

		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
	}

	public static void EditarAluno(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, SAXException {

		String[] dadosEditados = {"",""};
		int indice = ViewCRUDAlunos.ViewMenuEditarOuDeletarAluno("editar", reader);

		Alunos aluno = ListaDeAlunos.getInstance().get(indice);

		dadosEditados = ViewCRUDAlunos.ViewOpcaoEdicao(reader);

		switch (Integer.parseInt(dadosEditados[0])) {
		case 1:
			aluno.setNome(dadosEditados[1]);
			break;
		case 2:
			aluno.setCpf(Integer.parseInt(dadosEditados[1]));
			break;
		case 3:
			aluno.setCurso(dadosEditados[1]);
			break;
		case 4:
			aluno.getEndereco().setRua(dadosEditados[1]);
			break;
		case 5:
			aluno.getEndereco().setNumero(Integer.parseInt(dadosEditados[1]));
			break;
		case 6:
			aluno.getEndereco().setBairro(dadosEditados[1]);
			break;
		case 7:
			aluno.getEndereco().setCidade(dadosEditados[1]);
			break;
		case 8:
			aluno.getEndereco().setEstado(dadosEditados[1]);
			break;
		case 9:
			aluno.getEndereco().setCep(Integer.parseInt(dadosEditados[1]));
			break;
		}		
		ListaDeAlunos.getInstance().set(indice, aluno);
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
	}
}
