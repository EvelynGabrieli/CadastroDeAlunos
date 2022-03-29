package View;

import java.io.BufferedReader;
import java.io.IOException;


import Modelos.Aluno;
import Util.ListaDeAlunos;

public class ViewCRUDAluno {

	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException {


		System.out.println("1 - Cadastrar Aluno");
		System.out.println("2 - Listar Alunos");
		System.out.println("3 - Deletar Aluno");
		System.out.println("4 - Editar Aluno");
		System.out.println("5 - Sair");

		return Integer.parseInt(reader.readLine());

	}

	public static String[] ViewMenuSalvarAluno(BufferedReader reader) throws IOException {
		String[] menuAluno = {"Nome do Aluno", "CPF", "Curso", "Endereço: \nRua", "Número", "Bairro", "Cidade", "Estado", "CEP"};

		String[] dadosAluno = {"","","","","","","","",""};


		for(int i=0; i < dadosAluno.length; i++) {
			System.out.println(menuAluno[i]);
			dadosAluno[i] = reader.readLine();

		}

		return dadosAluno;
	}

	public static int ViewMenuListaIndexada(String editar_deletar, BufferedReader reader) throws NumberFormatException, IOException {
		for(int i=0; i<ListaDeAlunos.getInstance().size(); i++) 
			System.out.println(i+" - "+ ListaDeAlunos.getInstance().get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do aluno que deseja " + editar_deletar);

		return Integer.parseInt(reader.readLine());

	}
	
	public static String[] ViewOpcaoEdicao(BufferedReader reader) throws IOException {
		String[] dadosEditados = {"",""};
		
		System.out.println("Escolha o atributo que deseja alterar: ");
		System.out.println("1 - Nome");
		System.out.println("2 - CPF");
		System.out.println("3 - Curso");
		System.out.println("4 - Rua");
		System.out.println("5 - Número");
		System.out.println("6 - Bairro");
		System.out.println("7 - Cidade");
		System.out.println("8 - Estado");
		System.out.println("9 - CEP");
		
		dadosEditados[0] = reader.readLine();                                                                     
		System.out.println("Escreva o novo valor do atributo: ");
		dadosEditados[1] = reader.readLine();
		
		return dadosEditados;
	}
	
	public static void ViewListaDeAlunosEditada() {
		
		for(Aluno a: ListaDeAlunos.getInstance()) {
			System.out.println("-------------Aluno-------------");
			System.out.println("Nome: " + a.getNome());
			System.out.println("CPF: " + a.getCpf());
			System.out.println("Curso: " + a.getCurso());
			System.out.println("Rua: " + a.getEndereco().getRua() + ", n°" + a.getEndereco().getNum());
			System.out.println(a.getEndereco().getBairro() + " - " + a.getEndereco().getCidade());
			System.out.println(a.getEndereco().getEstado() + " / CEP: " + a.getEndereco().getCep());
			System.out.println("-------------------------------");
			
		}
		
	}

	public static void ViewMsgFinal(int op) {
	

		String[] msgFinal = {"Aluno salvo com sucesso!",
								"Aluno editado com sucesso",
								"Aluno deletado com sucesso",
								"Fim do programa"};
		
		System.out.println(msgFinal[op]);
		
	}
}
