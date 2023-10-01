package lab2;

public class Aluno extends Cliente{

	private int matricula;
	
	public Aluno(String nome, int matricula) {
		super(nome);
		this.matricula = matricula;
	}

	public int getIdentificacao() {
		return matricula;
	}	
}
