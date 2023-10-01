package lab2;

public class Professor extends Cliente {
	private int SIAPE;
	public Professor(String nome, int siape) {
		super(nome);
		this.SIAPE = siape;
	}
	
	public int getIdentificacao() {
		return this.SIAPE;
	}
}
