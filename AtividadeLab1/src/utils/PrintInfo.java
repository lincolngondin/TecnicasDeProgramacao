package utils;

import main.Barraca;
import main.Venda;

public class PrintInfo {
	public static void mostrarCompras(Barraca barraca) {
		System.out.println("Barraca de cachorro quentes UFC:\n");
		for(int i = 0; i < barraca.getVendasFeitas(); i++) {
			Venda vendaAtual = barraca.getVendas()[i];
			System.out.format("Aluno(a) %s - %d comprou %d cachorro(s) quente(s)\n",
					vendaAtual.getComprador().getNome(), 
					vendaAtual.getComprador().getMatricula(), 
					vendaAtual.getComprasFeitas()
					);

			for(int cachorro = 0; cachorro < vendaAtual.getComprasFeitas(); cachorro++) {
				System.out.format("%d - Proteina[%s] Queijo[%s] Adicionais[%s] Bebida[%s]\n", 
						cachorro+1,
						vendaAtual.getCompras()[cachorro].getProteina(), 
						vendaAtual.getCompras()[cachorro].getQueijo(), 
						vendaAtual.getCompras()[cachorro].getAdicionais(), 
						vendaAtual.getCompras()[cachorro].getBebida()
						);
			}
			System.out.println();

		}	
	}

}
