package model;

import java.util.ArrayList;

public class Sistema {
	private Estrela estrela;
	private ArrayList<Planet> planetas;
	private Asteroides asteroides;
	private int maiorDistanciaSobreInfluencia = -1;
	private int instantesSolicitados = 0;

	public Sistema(Estrela estrela) {
		this.estrela = estrela;
		this.planetas = new ArrayList<Planet>();
	}

	public void adicionarPlaneta(Planet planeta) {
		this.planetas.add(planeta);
		if(planeta.getDistanciaDaEstrela() > maiorDistanciaSobreInfluencia) {
			this.maiorDistanciaSobreInfluencia = planeta.getDistanciaDaEstrela();
		}
	}
	
	public void criarAsteroides() {
		this.asteroides = new Asteroides(this.maiorDistanciaSobreInfluencia*2+ 1);
	}

	public void moverSistema(Instant instant) {
		this.instantesSolicitados++;
		this.asteroides.adicionarBugsEDevs(instant.qBug, instant.qDev);

		for(Planet planeta : planetas) {
			if(!planeta.getExplodido()) {
				int instante = 0;
				switch(planeta.getCelestialBodyType()) {
					case PYTHON:
						instante = instant.pythonInstant;
						break;
					case JAVASCRIPT:
						instante = instant.javascriptInstant;
						break;
					case RUBY_ON_RAILS:
						instante = instant.rubyOnRailsInstant;
						break;
					case PHP:
						instante = instant.PHPInstant;
						break;
					case CSHARP:
						instante = instant.csharpInstant;
						break;
					case CPLUS_PLUS:
						instante = instant.cplusplusInstant;
						break;
					case C:
						instante = instant.cInstant;
						break;
					default:
						break;
				}

				planeta.horasPassadas += instante*planeta.getVelocidadeDeRotacao();
				planeta.somaDeTodasAsVelocidadesDeTranslacao+=planeta.getVelocidadeDeTranslacao();
				planeta.instantesVivos++;
				int movimentos = planeta.getVelocidadeDeTranslacao() * instante;
				int distancia = planeta.getDistanciaDaEstrela();
				for(int mov = 0; mov < movimentos; mov++) {
					if(planeta.posicao.x == distancia && planeta.posicao.y != -distancia) {
						planeta.posicao.y--;
					}
					else if(planeta.posicao.y == -distancia && planeta.posicao.x != -distancia ) {
						planeta.posicao.x--;
					}
					else if(planeta.posicao.x == -distancia && planeta.posicao.y != distancia) {
						planeta.posicao.y++;
					}
					else {
						planeta.posicao.x++;
					}
					
					// Passagem de ano
					if(planeta.posicao.y == 0 && planeta.posicao.x > 0) {
						planeta.anosPassados++;
					}
				}
				
				if(this.asteroides.checarPosicao(planeta.posicao.x + estrela.posicao.x, planeta.posicao.y + estrela.posicao.y)) {
					int i = 0;
					for(Obstaculo obs : this.asteroides.getBugsEDevsList()) {
						if((obs.getPosicao().x == planeta.posicao.x+estrela.posicao.x) && (obs.getPosicao().y == planeta.posicao.y+estrela.posicao.y)) {
							if(obs instanceof Bug) {
								planeta.diminuirVelocidade();
							}
							else {
								planeta.aumentarVelocidade();
							}
							this.asteroides.removerObstaculo(i);
							break;
						}
						i++;
					}
				}
			}
		}
	}

	public Estrela getEstrela() {
		return this.estrela;
	}
	
	public ArrayList<Planet> getPlanetas(){
		return this.planetas;
	}
	
	public Asteroides getAsteroides() {
		return this.asteroides;
	}
	
	public int getInstantesSolicitados() {
		return this.instantesSolicitados;
	}
}
