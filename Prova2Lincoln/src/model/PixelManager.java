package model;

public class PixelManager {
	private CelestialBodies[] celestialBodies;
	private int width;
	private int height;

	public PixelManager(int width, int height) {
		this.width = width;
		this.height = height;
		this.celestialBodies = new CelestialBodies[width*height];
		this.removeAllBodies();
	}

	public void update(Sistema system) {
		this.removeAllBodies();
		// Coloca estrela
		this.celestialBodies[ ((system.getEstrela().posicao.y)*width) + system.getEstrela().posicao.x] = CelestialBodies.JAVA;
		// Coloca os dev e os bugs
		this.putObstacles(system.getAsteroides());
		// Coloca os planetas
		for(Planet planet : system.getPlanetas()) {
			int x = planet.posicao.x + system.getEstrela().posicao.x;
			int y = planet.posicao.y + system.getEstrela().posicao.y;
			int posIndex = (y*width) + x;
			this.celestialBodies[posIndex] = planet.getCelestialBodyType();
		}
	}
	
	private void removeAllBodies() {
		for(int i = 0; i < this.width*this.height; i++) this.celestialBodies[i] = CelestialBodies.NOTHING;
	}

	private void putObstacles(Asteroides obstacles) {
		for(Obstaculo obstaculo : obstacles.getBugsEDevsList()) {
			int x = obstaculo.getPosicao().x;
			int y = obstaculo.getPosicao().y;
			int posIndex = (y*width) + x ;
			this.celestialBodies[posIndex] = obstaculo.getCelestialBodyType();
		}
	}

	public CelestialBodies getCelestialBody(int i) {
		return this.celestialBodies[i];
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
}
