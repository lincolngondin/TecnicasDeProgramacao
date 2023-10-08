package main;

abstract public class CorpoCeleste {
	public Ponto posicao;
	private String nome;
	private String descricao;

	public CorpoCeleste(int x, int y, String nome, String descricao) {
		this.posicao = new Ponto(x, y);
		this.descricao = descricao;
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public String getNome() {
		return this.nome;
	}
}
