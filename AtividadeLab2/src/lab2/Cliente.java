package lab2;

public abstract class Cliente {
	private String nome;
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public abstract int getIdentificacao();
}
