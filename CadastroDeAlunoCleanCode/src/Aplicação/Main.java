package Aplicação;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import View.ViewCRUDAluno;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {

		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in)); // Criar espaço de armazenamento, para ler as informações.
 
														
		int menu = 0;
		while (menu != 5) {

			menu = ViewCRUDAluno.ViewMenuPrincipal(reader);

				switch (menu) {

				case 1:
					CRUDAluno.SalvarAluno(reader);
					break;
					
				case 2:
					CRUDAluno.ListarAlunosSalvos();
				
					break;

				case 3:
					CRUDAluno.DeletarAluno(reader);
					break;


				case 4:
					CRUDAluno.EditarAluno(reader);
					break;
				case 5:
					ViewCRUDAluno.ViewMsgFinal(3);
				}

		}


	}
}
