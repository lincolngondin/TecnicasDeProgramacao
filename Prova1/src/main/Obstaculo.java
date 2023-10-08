package main;

public abstract class Obstaculo {
	private Ponto posicao;
	
	public Obstaculo(int x, int y) {
		this.posicao = new Ponto(x, y);
	}
	
	public Ponto getPosicao() {
		return this.posicao;
	}
}
