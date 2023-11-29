package model;

public abstract class Obstaculo {
	private Ponto posicao;
	private CelestialBodies celestialBodyType;
	
	public Obstaculo(int x, int y, CelestialBodies cb) {
		this.posicao = new Ponto(x, y);
		this.celestialBodyType = cb;
	}
	
	public Ponto getPosicao() {
		return this.posicao;
	}
	
	public CelestialBodies getCelestialBodyType() {
		return this.celestialBodyType;
	}
}
