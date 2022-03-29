package Handler;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelos.Aluno;
import Modelos.Endereco;
import Util.ListaDeAlunos;

public class XMLHandlerAlunos extends DefaultHandler {
	private StringBuilder texto;
	Aluno aluno;
	Endereco enderecoAluno;
	
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Início do Documento");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Fim do Documento");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("aluno")) {
			aluno = new Aluno();
			enderecoAluno = new Endereco();
		}else {
			texto = new StringBuilder();
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equals("nome")){
			
			aluno.setNome(texto.toString());
				}else if (qName.equals("CPF")){
					aluno.setCpf(Integer.parseInt(texto.toString()));
			
			}else if (qName.equals("curso")) {
				aluno.setCurso(texto.toString());
			
			}else if (qName.equals("rua")) {
				enderecoAluno.setRua(texto.toString());	
			
			} else if (qName.equals("numero")){
				enderecoAluno.setNum(Integer.parseInt(texto.toString()));
			
			} else if (qName.equals("estado")) {
				enderecoAluno.setEstado(texto.toString());
			
			} else if(qName.equals("cidade")) {
				enderecoAluno.setCidade(texto.toString());	
			
			} else if (qName.equals("bairro")) {
				enderecoAluno.setBairro(texto.toString());
			
			} else if(qName.equals("cep")) {
				enderecoAluno.setCep(Integer.parseInt(texto.toString()));
				aluno.setEndereco(enderecoAluno);
				ListaDeAlunos.getInstance().add(aluno);
				
	
			}
	}


	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		 texto.append(ch, start, length);
		
		
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		
	}

}
