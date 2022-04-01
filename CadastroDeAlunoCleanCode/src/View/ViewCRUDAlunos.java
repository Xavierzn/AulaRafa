 package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import Modelos.Alunos;
import Util.ListaDeAlunos;

public class ViewCRUDAlunos {

	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException {
		
		System.out.println("1 - Cadastrar Alunos\n"
						+ "2 - Listar Alunos\n"
						+ "3 - Deletar Alunos\n"
						+ "4 - Editar Alunos\n"
						+ "5 - Sair");

		return Integer.parseInt(reader.readLine());	
	}
	
	public static String[] ViewMenuSalvarAluno(BufferedReader reader) throws IOException {
		String[] menuAluno = {"Nome do Aluno", "CPF", "Curso","Endereço: \n Rua",
									"Número","Bairro","Cidade", "Estado", "CEP"};
		String[] dadosAluno = {"","","","","","","","",""};
		
		for(int i=0; i < menuAluno.length; i++) {
			System.out.println(menuAluno[i]);
			dadosAluno[i] = reader.readLine();			
		}
			
		return dadosAluno;
	}
	
	public static int ViewMenuEditarOuDeletarAluno(String editar_deletar,BufferedReader reader) throws NumberFormatException, IOException {		

		for (int i = 0; i < ListaDeAlunos.getInstance().size(); i++)
			System.out.println(i + " - " + ListaDeAlunos.getInstance().get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do aluno que deseja "+ editar_deletar);
						
		return Integer.parseInt(reader.readLine());
	}
	
	public static String[] ViewOpcaoEdicao (BufferedReader reader) throws IOException {		
		String[] dadosEditados = {"",""};
		
		System.out.println("escolha o Atributo que deseja alterar:");
		System.out.println("1 - Nome\n" 
							+ "2 - CPF\n" 
							+ "3 - Curso\n"
							+ "Endereço:\n"
							+ "4 - Rua\n"
							+ "5 - Numero\n"
							+ "6 - Bairro\n"
							+ "7 - Cidade\n"
							+ "8 - Estado\n"
							+ "9 - CEP\n");

		dadosEditados[0] = reader.readLine();
		System.out.println("Escreva o novo valor do atributo");
		dadosEditados[1] = reader.readLine();		
		
		return dadosEditados;
	}
	
	public static void ViewListaDeAlunosEditada() {
		
		for (Alunos a : ListaDeAlunos.getInstance()) {
			System.out.println("|-----------Aluno-----------");
			System.out.println("| Nome = " + a.getNome());
			System.out.println("| CPF = " + a.getCpf());
			System.out.println("| Curso = " + a.getCurso());
			System.out.println("| Endereço: ");
			System.out.println("|  Rua = " + a.getEndereco().getRua());
			System.out.println("|  Número = " + a.getEndereco().getNumero());
			System.out.println("|  Bairro = " + a.getEndereco().getBairro());
			System.out.println("|  Cidade = " + a.getEndereco().getCidade());
			System.out.println("|  estado = " + a.getEndereco().getEstado());
			System.out.println("|  CEP = " + a.getEndereco().getCep());
			System.out.println("|---------------------------");			
		}

		System.out.println();	
	}
	
	public static void ViewMsgFinal(int op) {
		
		String[] msgFinal = {"Aluno salvo com sucesso!!",
								"Aluno editado com sucesso!!",
								"Aluno deletado com sucesso!!",
								"Fim do Programa!!"};
		
		System.out.println(msgFinal[op]);
	}
}
