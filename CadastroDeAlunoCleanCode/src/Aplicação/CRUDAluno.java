package Aplicação;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDeDados.ManipulacaoArquivoTXT;
import BancoDeDados.ManipulacaoArquivoXML;
import Modelos.Aluno;
import Modelos.Endereco;
import Util.ListaDeAlunos;
import View.ViewCRUDAluno;

public class CRUDAluno {

	public static void SalvarAluno(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException, SAXException {
		

		Aluno aluno =  new Aluno ();
		Endereco enderecoAluno = new Endereco();

		
		
		String[] dadosAluno = ViewCRUDAluno.ViewMenuSalvarAluno(reader);

			aluno.setNome(dadosAluno[0]);
			aluno.setCpf(Integer.parseInt(dadosAluno[1]));;
			aluno.setCurso(dadosAluno[2]);
			enderecoAluno.setRua(dadosAluno[3]);
			enderecoAluno.setNum(Integer.parseInt(dadosAluno[4]));
			enderecoAluno.setBairro(dadosAluno[5]);
			enderecoAluno.setCidade(dadosAluno[6]);
			enderecoAluno.setEstado(dadosAluno[7]);
			enderecoAluno.setCep(Integer.parseInt(dadosAluno[8]));
			aluno.setEndereco(enderecoAluno);
			ListaDeAlunos.getInstance().add(aluno);

			//True para salvar um embaixo do outro
			
			//Buffered não aceita objetos, então é preciso disso para aceitar objeto.
			//try força o fechamento do comando. Depois de executar, ao terminar ele fecha automaticamente
			
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
		ViewCRUDAluno.ViewMsgFinal(0);




	}
	public static void ListarAlunosSalvos() throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
		ListaDeAlunos.getInstance().clear();
		
		//ManipulacaoArquivoTXT.LerArquivoTXT(listaDeAlunos);
		
		ManipulacaoArquivoXML.LerArquivoXML();

		ViewCRUDAluno.ViewListaDeAlunosEditada();
		
		}
		
	

	public static void DeletarAluno(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {
		
		int indice = ViewCRUDAluno.ViewMenuListaIndexada("deletar", reader);

		ListaDeAlunos.getInstance().remove(indice);

		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
		

	}



	public static void EditarAluno (BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {
		

		int indice = ViewCRUDAluno.ViewMenuListaIndexada("editar", reader);
		String[] dadosEditados = {"",""};
		Aluno alunos = ListaDeAlunos.getInstance().get(indice);

		dadosEditados = ViewCRUDAluno.ViewOpcaoEdicao(reader);
		

		switch(Integer.parseInt(dadosEditados[0])) {
		case 1:
			alunos.setNome(dadosEditados[1]);
			break;
		case 2:
			alunos.setCpf(Integer.parseInt(dadosEditados[1]));
			break;
		case 3:
			alunos.setCurso(dadosEditados[1]);
			break;
		case 4:
			alunos.getEndereco().setRua(dadosEditados[1]);
			break;
		case 5:
			alunos.getEndereco().setNum(Integer.parseInt(dadosEditados[1]));
			break;
		case 6:
			alunos.getEndereco().setBairro(dadosEditados[1]);
			break;
		case 7:
			alunos.getEndereco().setCidade(dadosEditados[1]);  
			break;
		case 8:
			alunos.getEndereco().setEstado(dadosEditados[1]);
			break;
		case 9:
			alunos.getEndereco().setCep(Integer.parseInt(dadosEditados[1]));
			break;

		}

		ListaDeAlunos.getInstance().set(indice, alunos);
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
	ViewCRUDAluno.ViewMsgFinal(1);

		
	}
}

