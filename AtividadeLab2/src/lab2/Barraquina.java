package lab2;

import java.util.ArrayList;
import java.util.Scanner;

public class Barraquina {

	private Scanner dados;
	private ArrayList<Venda> listaVenda;
	private int vendaAtual = -1;

	public Barraquina() {
		System.out.println("Bem vindo a barraquinha de técnicas!\n");
		dados = new Scanner(System.in);
		listaVenda = new ArrayList<Venda>();
		menuOperacoes();
	}

	private void menuOperacoes() {
		int op = 0;
		Cliente comprador = null;
		Venda venda= null;
		CachorroQuente cachorroQuenteEscolhido;
		do {
			op = itensDoMenu();
			switch (op) {
				case 1:
					comprador = registrarCliente();
					venda = new Venda(comprador);
					listaVenda.add(venda);
					vendaAtual++;
					break;
				case 2:
					if(comprador != null) {

						String tipoQueijo = escolherTipoQueijo();
						ArrayList<String> ingredientes = new ArrayList<String>();
						this.escolherIngredientes(ingredientes);
						String bebida = this.escolherBebida();
						cachorroQuenteEscolhido = escolherCachorroQuente(tipoQueijo, ingredientes, bebida);
						
						int tipo;
						if(cachorroQuenteEscolhido instanceof Salsicha) {
							tipo = 0;
						}
						else if(cachorroQuenteEscolhido instanceof Linguica) {
							tipo = 1;
						}
						else if(cachorroQuenteEscolhido instanceof Frango) {
							tipo = 2;
						}
						else {
							tipo = 3;
						}
						this.listaVenda.get(this.vendaAtual).realizarVenda(cachorroQuenteEscolhido, tipo);

					}
					else {
						System.out.println("Cadastre pelo menos um cliente!\n");
					}

					break;

				case 3:
					this.mostrarVenda(comprador, venda);
					break;
					
				case 4:
					int q = 0;
					for(Venda v: this.listaVenda) {
						q += v.getCachorrosQuentes().size();
					}
					System.out.printf("Foram vendidos %d cachorro quente ate agora!\n\n", q);
					break;
				case 5:
					this.mostrarVendasPorTipoCliente();
					break;
				case 6:
					this.mostrarTipoCachorroQuenteMaisVendido();
					break;
				case 7:
					this.mostrarBebidaMaisVendida();
					break;
				case 8:
					this.mostrarValorArrecadado();
					break;
				case 9:
					this.mostrarValorDoDesconto();
					
				default:
					break;
			}

		} while (op != -1);
		System.out.println("Bye!");

	}

	private int itensDoMenu() {
		System.out.println("Escolha uma opção para registra a venda ou digite -1 para sair!");
		System.out.println("1: Informar os dados do cliente comprador");
		System.out.println("2: Escolher cachorro quente");
		System.out.println("3: Mostrar os itens que eu comprei");
		System.out.println("4: Mostrar a quantidade de cachorro quente vendido no total");
		System.out.println("5: Mostrar a quantidade de cachorro quente vendido por tipo de cliente");
		System.out.println("6: Qual o tipo de cachorro quente mais vendido");
		System.out.println("7: Qual a bebida mais vendida");
		System.out.println("8: Valor total arrecadado com as vendas");
		System.out.println("9: Valor total em descontos");
		return dados.nextInt();
	}

	private String escolherTipoQueijo() {
		System.out.println("Escolha a opcao de queijo: [1 - Mussarela, 2 - Prato, 3 - Parmesao , 4- Coalho]");
		int queijo = dados.nextInt();
		String tipoQueijo = null;

		switch (queijo) {
		case 1:
			tipoQueijo = "Mussarela";
			break;
		case 2:
			tipoQueijo = "Prato";
			break;
		case 3:
			tipoQueijo = "Parmesao";
			break;
		case 4:
			tipoQueijo = "Coalho";
			break;
		default:
			break;
		}
		return tipoQueijo;
	}

	private CachorroQuente escolherCachorroQuente(String tipoQueijo, ArrayList<String> ingredientes, String bebida) {
		System.out.println("\n Escolha a opcao de cachorro quente: [1 - Salsicha, 2 - Linguica, 3 - Frango, 4- Bacon]");
		int tipo = dados.nextInt();
		CachorroQuente c = null;
		switch (tipo) {
		case 1:
			c = new Salsicha(tipoQueijo, ingredientes, bebida);
			break;
		case 2:
			c = new Linguica(tipoQueijo, ingredientes, bebida);
			break;
		case 3:
			c = new Frango(tipoQueijo, ingredientes, bebida);
			break;
		case 4:
			c = new Bacon(tipoQueijo, ingredientes, bebida);
			break;

		default:
			break;
		}
		System.out.println("\n Cachorro quente adicionado na sua atual compra!\n");
		return c;
	}
	
	private void escolherIngredientes(ArrayList<String> ing) {
		System.out.println("\nGostaria de adicionar ingredientes adicionais?: [1 - Sim, 2 - Não]");
		int es = dados.nextInt();
		if(es != 2) {
			boolean continua = true;
			while(continua) {
				System.out.println("\nEscolha os ingredientes para adicionar: [1 - Maionese, 2 - Ketchup, 3 - Ovo, 4 - Batata palha, 5 - Para de adicionar]");
				int escolha2 = dados.nextInt();
				switch(escolha2) {
					case 1:
						ing.add("Maionese");
						break;
					case 2:
						ing.add("Ketchup");
						break;
					case 3:
						ing.add("Ovo");
						break;
					case 4:
						ing.add("Batata palha");
						break;
					default:
						continua = false;
				}
			}
		}
		else {
			return;
		}
	}
	
	private String escolherBebida() {
		System.out.println("\nEscolha a bebida para acompanhar: [1 - Coca-cola, 2 - Del Rio, 3 - Suco do Chaves, 4 - Nenhuma]");
		int escolha = dados.nextInt();
		switch(escolha) {
		case 1:
			return "Coca-cola";
		case 2:
			return "Del Rio";
		case 3:
			return "Suco do Chaves";
		case 4:
			return "";
		default:
			return "";
		}
	}

	private Cliente registrarCliente() {
		System.out.print("\n Nome: ");
		String nome = dados.next();
		System.out.print("\nVoce e: [1 - Aluno, 2 - Servidor, 3 - Professor]");
		int client = dados.nextInt();
		if(client == 1) {
			System.out.print("\n matricula:");
			int matricula = dados.nextInt();
			return new Aluno(nome, matricula);
		}
		else if(client == 2){
			System.out.print("\n siape:");
			int siape = dados.nextInt();
			return new Servidor(nome, siape);
		}
		else {
			System.out.print("\n siape:");
			int siape = dados.nextInt();
			return new Professor(nome, siape);
		}
	}
	
	private void mostrarVenda(Cliente comprador, Venda venda) {
		if(comprador != null || venda != null) {
			System.out.printf("Olá %s voce comprou %d cachorro quente até o momento!\n", comprador.getNome(), venda.getCachorrosQuentes().size());
			int i = 0;
			for(CachorroQuente cq : venda.getCachorrosQuentes()) {
				i++;
				System.out.printf("%d: \nCliente: %s - Identificacao: %d\n", i, comprador.getNome(), comprador.getIdentificacao());
				System.out.print("Cachorro quente: ");
				if(cq instanceof Salsicha) {
					System.out.println("Salsicha");
				}
				else if(cq instanceof Frango) {
					System.out.println("Frango");
				}
				else if(cq instanceof Linguica) {
					System.out.println("Linguica");
				}
				else {
					System.out.println("Bacon");
				}
				System.out.println("Ingredientes: " + String.join(" + ", cq.ingredientes));
				System.out.println("Bebida: " + cq.bebida + "\n");

			}
			System.out.println("\n");
		}
		else {
			System.out.println("Nenhum cliente foi cadastrado ainda!\n");
		}
	}
	
	private void mostrarVendasPorTipoCliente() {
		int qAluno = 0;
		int qServidor = 0;
		int qProfessor = 0;
		for(Venda v : this.listaVenda) {
			if(v.getCliente() instanceof Aluno) {
				qAluno = v.getCachorrosQuentes().size();
			}
			else if(v.getCliente() instanceof Servidor) {
				qServidor = v.getCachorrosQuentes().size();
			}
			else {
				qProfessor = v.getCachorrosQuentes().size();
			}
		}
		System.out.printf("Foram vendidos:\nAlunos: %d \nServidores: %d \nProfessores: %d \n\n", qAluno, qServidor, qProfessor);
	}
	
	private void mostrarTipoCachorroQuenteMaisVendido() {
		int[] qVendas = {0, 0, 0, 0};

		for(Venda v : this.listaVenda) {
			for(CachorroQuente cq : v.getCachorrosQuentes()) {
				if(cq instanceof Salsicha) {
					qVendas[0]++;
				}
				else if(cq instanceof Linguica) {
					qVendas[1]++;
				}
				else if(cq instanceof Frango) {
					qVendas[2]++;
				}
				else {
					qVendas[3]++;
				}
			}
		}
		int qMaisVendido = qVendas[0];
		for(int i = 0; i < 4; i++) {
			if(qVendas[i] > qMaisVendido) {
				qMaisVendido = qVendas[i];
			}
		}

		System.out.printf("O(s) seguinte(s) cachorro quente fo(i/ram) vendido(s) mais vezes em um total de %d vezes: ", qMaisVendido);
		for(int i = 0; i < 4; i++) {
			if(qVendas[i] == qMaisVendido) {
				String tipo;
				if(i == 0) {
					tipo = "[Salsicha]";
				}
				else if(i == 1) {
					tipo = "[Linguica]";
				}
				else if(i == 2) {
					tipo = "[Frango]";
				}
				else {
					tipo = "[Bacon]";
				}
				
				System.out.printf(" %s ", tipo);
			}
		}
		System.out.println("\n");
	}
	
	private void mostrarBebidaMaisVendida() {
		int[] qVendas = {0, 0, 0};
		for(Venda v : this.listaVenda) {
			for(CachorroQuente cq : v.getCachorrosQuentes()) {
				if(cq.bebida == "Coca-cola") {
					qVendas[0]++;
				}
				else if(cq.bebida == "Del Rio") {
					qVendas[1]++;
				}
				else if(cq.bebida == "Suco do Chaves") {
					qVendas[2]++;
				}
			}
		}

		int qMaisVendido = qVendas[0];
		for(int i = 0; i < 3; i++) {
			if(qVendas[i] > qMaisVendido) {
				qMaisVendido = qVendas[i];
			}
		}

		System.out.print("A(s) seguinte(s) bebida(s) fo(i/ram) vendido(s) mais vezes: ");
		for(int i = 0; i < 3; i++) {
			if(qVendas[i] == qMaisVendido) {
				String tipo;
				if(i == 0) {
					tipo = "[Coca-cola]";
				}
				else if(i == 1) {
					tipo = "[Del Rio]";
				}
				else {
					tipo = "[Suco do Chaves]";
				}
				
				System.out.printf(" %s ", tipo);
			}
		}
		System.out.println("\n");

	}

	private void mostrarValorArrecadado() {
		float valor = 0.0f;
		for(Venda v : this.listaVenda) {
			valor += v.getPreco();
		}
		System.out.printf("O valor arrecado até o momento foi de %.2fR$\n\n", valor);
	}

	private void mostrarValorDoDesconto() {
		float valor = 0.0f;
		for(Venda v : this.listaVenda) {
			valor += v.getValorDesconto();
		}
		System.out.printf("O valor total dado em desconto foi de %.2fR$\n\n", valor);
	}

}
