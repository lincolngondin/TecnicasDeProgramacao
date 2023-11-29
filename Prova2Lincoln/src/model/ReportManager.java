package model;

public class ReportManager {

	public Report createReport(Sistema sistema, String nome, String matricula, String filename) {
		Report rp = new Report(nome, matricula, filename);
		putPlanetInfo(sistema, rp);
		putObstacleInfo(sistema, rp);
		return rp;
	}

	private void putPlanetInfo(Sistema sistema, Report rp) {
		for(Planet planet : sistema.getPlanetas()) {
			switch(planet.getCelestialBodyType()) {
				case PYTHON:
					rp.bug_python = planet.getColisoesBug();
					rp.dev_python = planet.getColisoesDesenvolvedores();
					rp.v_python = (int) planet.getVelocidadeMediaTranslacao();
					rp.d_python = (int) planet.horasPassadas;
					rp.a_python = planet.anosPassados;
					break;
				case JAVASCRIPT:
					rp.bug_javascript = planet.getColisoesBug();
					rp.dev_javascript = planet.getColisoesDesenvolvedores();
					rp.v_javascript = (int) planet.getVelocidadeMediaTranslacao();
					rp.d_javascript = (int) planet.horasPassadas;
					rp.a_javascript = planet.anosPassados;
					break;
				case RUBY_ON_RAILS:
					rp.bug_ruby = planet.getColisoesBug();
					rp.dev_ruby = planet.getColisoesDesenvolvedores();
					rp.v_ruby = (int) planet.getVelocidadeMediaTranslacao();
					rp.d_ruby = (int) planet.horasPassadas;
					rp.a_ruby = planet.anosPassados;
					break;
				case PHP:
					rp.bug_php = planet.getColisoesBug();
					rp.dev_php = planet.getColisoesDesenvolvedores();
					rp.v_php = (int) planet.getVelocidadeMediaTranslacao();
					rp.d_php = (int) planet.horasPassadas;
					rp.a_php = planet.anosPassados;
					break;
				case CSHARP:
					rp.bug_csharp = planet.getColisoesBug();
					rp.dev_csharp = planet.getColisoesDesenvolvedores();
					rp.v_csharp = (int) planet.getVelocidadeMediaTranslacao();
					rp.d_csharp = (int) planet.horasPassadas;
					rp.a_csharp = planet.anosPassados;
					break;
				case CPLUS_PLUS:
					rp.bug_cmais = planet.getColisoesBug();
					rp.dev_cmais = planet.getColisoesDesenvolvedores();
					rp.v_cmais = (int) planet.getVelocidadeMediaTranslacao();
					rp.d_cmais = (int) planet.horasPassadas;
					rp.a_cmais = planet.anosPassados;
					break;
				case C:
					rp.bug_c = planet.getColisoesBug();
					rp.dev_c = planet.getColisoesDesenvolvedores();
					rp.v_c = (int) planet.getVelocidadeMediaTranslacao();
					rp.d_c = (int) planet.horasPassadas;
					rp.a_c = planet.anosPassados;
					break;
				default:
					break;
			}
		}
	}
	
	private void putObstacleInfo(Sistema sistema, Report rp) {
		for(Obstaculo obstaculo : sistema.getAsteroides().getBugsEDevsList()) {
			switch(obstaculo.getCelestialBodyType()) {
				case DEV:
					if(obstaculo.getPosicao().y < 8 && obstaculo.getPosicao().x < 8) {
						rp.dev_q3++;
					}
					else if(obstaculo.getPosicao().y < 8 && obstaculo.getPosicao().x >= 8) {
						rp.dev_q1++;
					}
					else if(obstaculo.getPosicao().y >= 8 && obstaculo.getPosicao().x < 8) {
						rp.dev_q4++;
					}
					else {
						rp.dev_q2++;
					}
					break;
				case BUG:
					if(obstaculo.getPosicao().y < 8 && obstaculo.getPosicao().x < 8) {
						rp.bug_q3++;
					}
					else if(obstaculo.getPosicao().y < 8 && obstaculo.getPosicao().x >= 8) {
						rp.bug_q1++;
					}
					else if(obstaculo.getPosicao().y >= 8 && obstaculo.getPosicao().x < 8) {
						rp.bug_q4++;
					}
					else {
						rp.bug_q2++;
					}
					break;
				default:
					break;
			}
		}
	}
	
}
