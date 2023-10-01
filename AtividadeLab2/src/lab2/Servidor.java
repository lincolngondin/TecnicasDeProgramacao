package lab2;

public class Servidor extends Cliente{
	private int SIAPE;
	public Servidor(String nome, int siape) {
		super(nome);
		this.SIAPE = siape;
	}
	
	public int getIdentificacao() {
		return this.SIAPE;
	}
}
