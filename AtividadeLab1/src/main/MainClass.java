package main;

import utils.PrintInfo;

public class MainClass {

	public static void main(String[] args) {
		// Barraca de cachorro quente que armazena todas as compras
		Barraca barraca = new Barraca();

		// Alunos mais suas commpras
		Aluno joao = new Aluno("Joao", 123);
		Venda compraJoao = new Venda(joao);
		compraJoao.adicionarCompra(new CachorroQuente("bacon", "mussarela","Del Rio", "Maionese + Ketchup"));
		compraJoao.adicionarCompra(new CachorroQuente("frango", "parmesão","Coca-cola", "Maionese + Ketchup + Batata Palha"));
		barraca.adicionarVenda(compraJoao);

		Aluno maria = new Aluno("Maria", 234);
		Venda compraMaria = new Venda(maria);
		compraMaria.adicionarCompra(new CachorroQuente("bacon", "mussarela","Coca-cola", "Maionese + Ketchup"));
		compraMaria.adicionarCompra(new CachorroQuente("frango", "parmesão","Coca-cola", "Batata Palha"));
		compraMaria.adicionarCompra(new CachorroQuente("linguiça", "mussarela","Suco do Chaves", "Ketchup + Ovo"));
		barraca.adicionarVenda(compraMaria);

		Aluno pedro = new Aluno("Pedro", 345);
		Venda compraPedro = new Venda(pedro);
		compraPedro.adicionarCompra(new CachorroQuente("bacon", "mussarela","Del Rio", "Maionese + Ketchup"));
		compraPedro.adicionarCompra(new CachorroQuente("frango", "parmesão","Coca-cola", "Maionese + Ketchup + Batata Palha"));
		compraPedro.adicionarCompra(new CachorroQuente("salsicha", "coalho","Suco do Chaves", "Ovo + Batata Palha"));
		compraPedro.adicionarCompra(new CachorroQuente("linguiça", "prato","Del Rio", "Ketchup"));
		barraca.adicionarVenda(compraPedro);

		Aluno fischer = new Aluno("Fischer", 456);
		Venda compraFischer = new Venda(fischer);
		compraFischer.adicionarCompra(new CachorroQuente("bacon", "mussarela","Del Rio", "Maionese + Ketchup"));
		compraFischer.adicionarCompra(new CachorroQuente("frango", "parmesão","Coca-cola", "Ketchup + Batata Palha"));
		compraFischer.adicionarCompra(new CachorroQuente("linguiça", "prato","Del Rio", "Ovo"));
		barraca.adicionarVenda(compraFischer);

		PrintInfo.mostrarCompras(barraca);
		

	}

}
