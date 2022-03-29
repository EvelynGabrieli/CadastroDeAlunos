package Modelos;

public class Aluno {
	
	private String nome;
	private int cpf;
	private String curso;
	private Endereco endereco;
	
	
	public Aluno(String dados) {
	
		String[] atributos = dados.split(","); //fracionar as informações que estão em dados, de acordo com o caractere estipulado. Vai dividir as informações e guardar em matriz
		//for(int x = 0; x < atributos.length;x++) //length é usado quando não sabem a quantidade de informação, ele conta 
	//	System.out.println(atributos[x]);
		
		String[] nome = atributos[1].split("=");
		String[] cpf = atributos[2].split("=");
		String[] curso = atributos[3].split("=");
		
		Endereco enderecoAluno = new Endereco(atributos);
		
		this.nome = nome[1].trim();
		this.cpf = Integer.parseInt(cpf[1].trim());
		this.curso = curso[1].trim();
		this.endereco = enderecoAluno;
	}
	
	public Aluno() {
		super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "Aluno, Nome= " + nome + ", CPF= " + cpf + ", Curso= " + curso + ", Endereço= " + endereco; 
	}
	
	
	
	
}
