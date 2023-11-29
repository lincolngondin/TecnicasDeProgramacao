package model;

abstract public class CorpoCeleste {
	public Ponto posicao;
	private String nome;
	private String descricao;
	private CelestialBodies bodyType;

	public CorpoCeleste(int x, int y, String nome, CelestialBodies cb, String descricao) {
		this.posicao = new Ponto(x, y);
		this.descricao = descricao;
		this.nome = nome;
		this.bodyType = cb;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public String getNome() {
		return this.nome;
	}
	
	public CelestialBodies getCelestialBodyType() {
		return this.bodyType;
	}
}
