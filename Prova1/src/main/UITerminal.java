package main;

import java.util.Scanner;
import java.util.ArrayList;

public class UITerminal implements UI {
	private Scanner scanner;

	public UITerminal(){
		this.scanner = new Scanner(System.in);
	}

	public void desenharMenu() {
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                       BEM-VINDO AO SISTEMA                         |");
		System.out.println("|                             JAVALAR                                |");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("** OPCOES: ");
		System.out.println("1) Indicar nova rodada(instante)");
		System.out.println("2) Colocar Bugs e Desenvolvedores");
		System.out.println("3) Sair\n");
	}

	public int solicitarOpcao() {
		System.out.print("Digite o numero da sua opcao: ");
		return scanner.nextInt();
	}

	public int solicitarNovoInstante() {
		System.out.print("Digite o valor do instante: ");
		return scanner.nextInt();
	}

	public int solicitarQuantidadeDeBugs() {
		System.out.print("Digite a quantidade de bugs para essa rodada: ");
		return scanner.nextInt();
	}

	public int solicitarQuantidadeDeDesenvolvedores() {
		System.out.print("Digite a quantidade de desenvolvedores para essa rodada: ");
		return scanner.nextInt();
	}

	public void mostrarInformacoesSair(Sistema sistema) {
		System.out.println("\n\n+--------------------------------------------------------------------+");
		System.out.println("|                    Relatório da Jogada                             |");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.format("Foram solicitados pelo usuario %d instantes!\n", sistema.getInstantesSolicitados());
		System.out.format("O sistema javalar com sua estrela %s possui %d planetas, são eles:\n", sistema.getEstrela().getNome(), sistema.getPlanetas().size());
		for(Planeta planeta: sistema.getPlanetas()) {
			System.out.format("Planeta %s", planeta.getNome());
			if(planeta.getExplodido()) {
				System.out.print(" (explodiu)");
			}
			System.out.println();
			System.out.format("Velocidade de rotacao: %.2f[horas/instante]\n", planeta.getVelocidadeDeRotacao());
			System.out.format("Velocidade média de translacao: %d[unidades/instante]\n", planeta.somaDeTodasAsVelocidadesDeTranslacao/planeta.instantesVivos);
			System.out.format("Numero de colisoes com bugs: %d\n", planeta.getColisoesBug());
			System.out.format("Numero de colisoes com desenvolvedores: %d\n", planeta.getColisoesDesenvolvedores());
			System.out.format("Dias passados em horas: %.2f\n", planeta.horasPassadas);
			System.out.format("Anos javalar: %d\n", planeta.anosPassados);
			System.out.format("Descricao do planeta: %s\n\n", planeta.getDescricao());
		}
	}
	
	public void mostrarInformacoesSobreAlinhamentos(Sistema sistema) {
		int numeroPlanetasNorte = 0;
		int numeroPlanetasSul = 0;
		int numeroAlinhamentosVerticais = 0;
		int numeroAlinhamentosDiagonais = 0;
		String planetasAlinhadosVerticalmente = "";
		String planetasAlinhadosDiagonalmente = "";
		for(Planeta p : sistema.getPlanetas()) {
			if(p.posicao.y == 0) {
				numeroAlinhamentosVerticais++;
				planetasAlinhadosVerticalmente += " " + p.getNome() + " ";
			}
			if(p.posicao.y == p.posicao.x) {
				numeroAlinhamentosDiagonais++;
				planetasAlinhadosDiagonalmente += " " + p.getNome() + " ";
			}
			if(p.posicao.x > 0) {
				numeroPlanetasNorte++;
			}
			if(p.posicao.x < 0) {
				numeroPlanetasSul++;
			}
		}
		System.out.println("\n+--------------------------------------------------------------------+");
		System.out.println("|                  Alinhamentos Planetários e distancias             |");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("Numeros de planetas no norte (acima de Java): %d planeta(s)\n", numeroPlanetasNorte);
		System.out.printf("Numeros de planetas no sul (abaixo de Java) : %d planeta(s)\n", numeroPlanetasSul);
		if(numeroAlinhamentosVerticais > 1) {
			System.out.printf("Houve %d planetas que se alinharam na vertical, são eles: %s\n", numeroAlinhamentosVerticais, planetasAlinhadosVerticalmente);
		}
		else {
			System.out.println("Não houve alinhamento de planetas na vertical!");
		}

		if(numeroAlinhamentosDiagonais > 1) {
			System.out.printf("Houve %d planetas que se alinharam na diagonal, são eles: %s\n", numeroAlinhamentosDiagonais, planetasAlinhadosDiagonalmente);
		}
		else {
			System.out.println("Não houve alinhamento de planetas na diagonal!");
		}
		
		System.out.println("Distancia entre planetas: ");
		int qPlanets = sistema.getPlanetas().size();
		ArrayList<Planeta> planetas = sistema.getPlanetas();
		for(int p1 = 0; p1 < qPlanets; p1++) {
			System.out.printf("%s para :\n", planetas.get(p1).getNome());
			for(int p2 = 0; p2 < qPlanets; p2++) {
				if(p1 != p2) {
					int dx = planetas.get(p2).posicao.x - planetas.get(p1).posicao.x;
					int dy = planetas.get(p2).posicao.y - planetas.get(p1).posicao.y;
					int distancia = Math.abs(dx * dy);
					float distanciaEuclidiana = (float) Math.sqrt((dx*dx) + (dy*dy));
					System.out.printf("%-14s= Dist(Area): %2d | Dist(Euclidiana): %.2f\n", planetas.get(p2).getNome(), distancia, distanciaEuclidiana);
				}
			}
			System.out.println("");
		}

		
	}

	public void mostrarVelocidadesDeTranslacao(Sistema sistema) {
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                  Velocidade de Translacao dos planetas,            |");
		System.out.println("|                       Dias passados e anos javalar                 |");
		System.out.println("+--------------------------------------------------------------------+");
		for(Planeta p : sistema.getPlanetas()) {
			System.out.printf("%s- Vel:%d  Dias(horas):%.2f  Ano:%d\n", p.getNome(), p.getVelocidadeDeTranslacao(), p.horasPassadas, p.anosPassados);
		}
		System.out.println("\n");
	}
	
	public void mostrarNumeroDevEBugs(Sistema sistema) {
		System.out.println("\n\n");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                  BUGS E DESENVOLVEDORES                            |");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("\nForam inseridos %d bugs e %d desenvolvedores\n", sistema.getAsteroides().getQBugs(), sistema.getAsteroides().getQDevs());
		System.out.println("Bugs nas seguintes posições:");
		if(sistema.getAsteroides().getQBugs() != 0) {
			int bug = 0;
			for(Obstaculo obs : sistema.getAsteroides().getBugsEDevsList()) {
				if(obs instanceof Bug) {
					//System.out.printf("Bug #%d na posição (%d,%d)\n",bug+1, obs.getPosicao().x, obs.getPosicao().y);
					System.out.printf("(%d,%d) ", obs.getPosicao().x, obs.getPosicao().y);
					bug++;
					if(bug %10 == 0) {
						System.out.println();
					}
				}
			}
		}
		else {
			System.out.println("Não há nenhum bug no sistema javalar!");
		}
		
		System.out.println("\nDesenvolvedores nas seguintes posições:");
		if(sistema.getAsteroides().getQDevs() != 0) {
			int dev = 0;
			for(Obstaculo obs : sistema.getAsteroides().getBugsEDevsList()) {
				if(obs instanceof Desenvolvedor) {
					System.out.printf("(%d,%d) ", obs.getPosicao().x, obs.getPosicao().y);
					dev++;
					if(dev % 10 == 0) {
						System.out.println();
					}
				}
			}
		}
		else {
			System.out.println("Não há nenhum desenvolvedor no sistema javalar!");
		}
		
	}
	
}
