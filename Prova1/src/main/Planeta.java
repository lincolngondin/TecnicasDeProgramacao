package main;

public class Planeta extends CorpoCeleste{
	private boolean explodido;
	private int velocidadeDeTranslacao;
	private double velocidadeDeRotacao;
	private int distanciaDaEstrela;
	private int colisoesBug;
	private int colisoesDesenvolvedores;
	public int somaDeTodasAsVelocidadesDeTranslacao = 0;
	public int instantesVivos = 0;
	public double horasPassadas;
	public int anosPassados;

	public Planeta(int x, int y, int distanciaEstrela, int velocidadeTranslacao, double velocidadeRotacao, String nome, String descricao) {
		super(x, y, nome, descricao);
		this.explodido = false;
		this.velocidadeDeRotacao = velocidadeRotacao;
		this.velocidadeDeTranslacao = velocidadeTranslacao;
		this.distanciaDaEstrela = distanciaEstrela;
	}

	public boolean getExplodido() {
		return this.explodido;
	}

	public void diminuirVelocidade() {
		if(!this.explodido) {
			this.velocidadeDeTranslacao--;
			this.colisoesBug++;
			if(this.velocidadeDeTranslacao <= 0) {
				this.explodido = true;
			}
		}
	}

	public void aumentarVelocidade() {
		if(!this.explodido) {
			this.colisoesDesenvolvedores++;
			this.velocidadeDeTranslacao++;
		}
	}
	
	public int getVelocidadeDeTranslacao() {
		return this.velocidadeDeTranslacao;
	}
	
	public int getDistanciaDaEstrela() {
		return this.distanciaDaEstrela;
	}

	public int getColisoesDesenvolvedores() {
		return this.colisoesDesenvolvedores;
	}

	public int getColisoesBug() {
		return this.colisoesBug;
	}

	public double getVelocidadeDeRotacao() {
		return velocidadeDeRotacao;
	}
	
}
