package main;

public class App {
	private boolean rodando = true;
	private UITerminal userInterface;
	private Sistema sistema;

	public App(){
		this.userInterface = new UITerminal();
		this.sistema = new Sistema(new Estrela(8, 8, "Java", "Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems, que em 2008 foi adquirido pela empresa Oracle Corporation. Diferente das linguagens de programação modernas, que são compiladas para código nativo, Java é compilada para um bytecode que é interpretado por uma máquina virtual (Java Virtual Machine, abreviada JVM)."));
		this.sistema.adicionarPlaneta(new Planeta(1, 0, 1, 4, 24, "Python", "Python é uma linguagem de programação de alto nível, interpretada de script, imperativa, orientada a objetos, funcional, de tipagem dinâmica e forte. Foi lançada por Guido van Rossum em 1991. Atualmente, possui um modelo de desenvolvimento comunitário, aberto e gerenciado pela organização sem fins lucrativos Python Software Foundation."));
		this.sistema.adicionarPlaneta(new Planeta(2, 0, 2, 3, 10, "Javascript", "JavaScript (frequentemente abreviado como JS) é uma linguagem de programação interpretada estruturada, de script em alto nível com tipagem dinâmica fraca e multiparadigma (protótipos, orientado a objeto, imperativo e funcional). Juntamente com HTML e CSS, o JavaScript é uma das três principais tecnologias da World Wide Web."));
		this.sistema.adicionarPlaneta(new Planeta(3, 0, 3, 2, 48, "Ruby On Rails", "Ruby on Rails é um framework livre que promete aumentar velocidade e facilidade no desenvolvimento de sites orientados a banco de dados (database-driven web sites), uma vez que é possível criar aplicações com base em estruturas pré-definidas. Frequentemente referenciado como Rails ou RoR, o Ruby on Rails é um projeto de código aberto escrito na linguagem de programação Ruby."));
		this.sistema.adicionarPlaneta(new Planeta(4, 0, 4, 2, 60, "PHP", "PHP (um acrônimo recursivo para 'PHP: Hypertext Preprocessor', originalmente Personal Home Page) é uma linguagem interpretada livre, usada originalmente apenas para o desenvolvimento de aplicações presentes e atuantes no lado do servidor, capazes de gerar conteúdo dinâmico na World Wide Web. Figura entre as primeiras linguagens passíveis de inserção em documentos HTML, dispensando em muitos casos o uso de arquivos externos para eventuais processamentos de dados."));
		this.sistema.adicionarPlaneta(new Planeta(5, 0, 5, 1, 4, "C#", "C# é uma linguagem de programação, multiparadigma, de tipagem forte, desenvolvida pela Microsoft como parte da plataforma .NET. A sua sintaxe orientada a objetos foi baseada no C++ mas inclui muitas influências de outras linguagens de programação, como Object Pascal e, principalmente, Java. O código fonte é compilado para Common Intermediate Language (CIL) que é interpretado pela máquina virtual Common Language Runtime (CLR)."));
		this.sistema.adicionarPlaneta(new Planeta(6, 0, 6, 2, 0.5, "C++", "C++ (em português: Pronuncia-se 'cê mais mais') é uma linguagem de programação compilada multi-paradigma (seu suporte inclui linguagem imperativa, orientada a objetos e genérica) e de uso geral. Desde os anos 1990 é uma das linguagens comerciais mais populares, sendo bastante usada também na academia por seu grande desempenho e base de utilizadores."));
		this.sistema.adicionarPlaneta(new Planeta(7, 0, 7, 10, 0.1, "C", "C é uma linguagem de programação compilada de propósito geral, estruturada, imperativa, procedural, padronizada pela Organização Internacional para Padronização (ISO), criada em 1972 por Dennis Ritchie na empresa AT&T Bell Labs para desenvolvimento do sistema operacional Unix (originalmente escrito em Assembly)."));
		this.sistema.criarAsteroides();
	}

	public void iniciar() {
		while(this.rodando) {
			userInterface.desenharMenu();
			int opcao = userInterface.solicitarOpcao();
			switch(opcao) {
				case 1:
					int valorInstante = userInterface.solicitarNovoInstante();
					this.sistema.moverSistema(valorInstante);
					//userInterface.logHelper(this.sistema);
					userInterface.mostrarNumeroDevEBugs(this.sistema);
					userInterface.mostrarInformacoesSobreAlinhamentos(this.sistema);
					userInterface.mostrarVelocidadesDeTranslacao(this.sistema);
					break;
					
				case 2:
					int qBugsAdicionar = userInterface.solicitarQuantidadeDeBugs();
					int qDevsAdicionar = userInterface.solicitarQuantidadeDeDesenvolvedores();
					this.sistema.getAsteroides().adicionarBugsEDevs(qBugsAdicionar, qDevsAdicionar);
					break;

				case 3:
					rodando = false;
					break;
				default:
					break;
			}
		}
		
		userInterface.mostrarInformacoesSair(this.sistema);
	}
	

}
