package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import Modelos.Aluno;
import Util.ListaDeAlunos;

public class ManipulacaoArquivoTXT {
	private static String nomeDoArquivo = "CadastroDeAluno.txt";

		public static void SalvarArquivoTXT() throws IOException {
			
			try(BufferedWriter buffer = new BufferedWriter(new FileWriter(nomeDoArquivo));
					PrintWriter pw = new PrintWriter(buffer)){
				for(Aluno a: ListaDeAlunos.getInstance()) {
					pw.println(a);
				}

			}
		}
		
		public static void LerArquivoTXT() throws FileNotFoundException, IOException {
			
			
			try(FileWriter arq = new FileWriter(nomeDoArquivo, true)){};
			
			String line;

			try(BufferedReader reader = new BufferedReader(new FileReader(nomeDoArquivo)))  { //Para ler. Neste caso, o arquivo txt, todas as informações que estão la.

				while((line = reader.readLine())!= null && !"" .equals(line)) {
					Aluno aluno = new Aluno(line);
					ListaDeAlunos.getInstance().add(aluno);
				}
			} 
			
		}
	}

