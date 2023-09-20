package main;

public class Utilidades {
	
	// Metodo questao 1
	public static int somar(int[] vetor) {
		int soma = 0;
		for(int i = 2; i < vetor.length-2; i++) {
			soma+=vetor[i];
		}
		return soma;
	}

	// Metodo questao 2
	public static void pares(int a, int b) {
		System.out.format("Valores pares entre %d e %d:\n", a, b);
		for(int i = a; i < b; i++) {
			if(i%2 == 0) {
				System.out.println(i);
			}
		}
		System.out.println("");
	}
	
	// Metodo questao 3
	public static int media(int[] vetor1, int[] vetor2) {
		int n = 0;
		int soma1 = 0;
		int soma2 = 0;
		for(int i = 0; i < vetor1.length; i++) {
			soma1 += vetor1[i];
			n++;
		}
		for(int y = 0; y < vetor2.length; y++) {
			soma2+=vetor2[y];
			n++;
		}
		return (soma1+soma2)/n;
	}

	//Metodo questao 4
	public static double mediaPonderada(double[] notas, double[] pesos) {
		double soma = 0;
		double n = 0;
		for(int idx = 0; idx < notas.length; idx++) {
			soma+= (notas[idx] * pesos[idx]);
			n += pesos[idx];
		}
		return soma/n;
	}

	// Metodo questao 5
	public static int contagem(int[] vetor1, int[] vetor2, int valor) {
		int count = 0;
		for(int index = 0; index < vetor1.length; index++) {
			if(valor == vetor1[index]) {
				count++;
			}
		}
		for(int index = 0; index < vetor2.length; index++) {
			if(valor == vetor2[index]) {
				count++;
			}
		}
		return count;
	}

	// Metodo questao 6
	public static int[] copiar(int[] vet) {
		int[] copia = new int[vet.length];
		for(int i = 0;i < vet.length;i++) {
			copia[i] = vet[i];
		}
		return copia;
	}

	// Metodo questao 7
	public static int[] ordenarCrescente(int[] vet) {
		int[] newVet = vet.clone();
		int i = 1;
		while(i < newVet.length) {
			int j = i;
			while(j > 0 && newVet[j-1] > newVet[j]) {
				int temp = newVet[j];
				newVet[j] = newVet[j-1];
				newVet[j-1] = temp; 
				j--;
			}
			i++;
		}
		return newVet;
	}
	
	// Metodo questao 8
	public static boolean verificarOrdenacao(int[] vet) {
		for(int v1 = 0; v1 < vet.length; v1++) {
			for(int v2 = v1+1; v2 < vet.length; v2++) {
				if(vet[v1] > vet[v2]) {
					return false;
				}
			}
		}
		return true;
	}

	// Metodo questao 9
	public static int maiorValorK(int[] vet, int K) {
		int[] vetOrd = Utilidades.ordenarCrescente(vet);
		if(K >= vet.length) {
			return vetOrd[0];
		}
		else {
			return vetOrd[vet.length-K];
		}

	}

	// Metodo questao 10
	public static int menorValorK(int[] vet, int K) {
		int[] vetOrd = Utilidades.ordenarCrescente(vet);
		if(K >= vet.length) {
			return vetOrd[vet.length-1];
		}
		else {
			return vetOrd[K-1];
		}
	}
	
	// Metodo questao 11
	public static boolean verificarIgualdade(int[] vet1, int[] vet2) {
		if(vet1.length != vet2.length) {
			return false;
		}
		for(int i = 0; i < vet1.length; i++) {
			if(vet1[i] != vet2[i]) {
				return false;
			}
		}
		return true;
	}

	// Metodo questao 12
	public static double potencia(int base, int expoente) {
		double result = 1;
		if(expoente == 0) return 1;
		if(expoente < 0) {
			for(int i = 0; i<(expoente*-1); i++) {
				result *= base;
			}
			return 1/result;
		}
		else {
			for(int i = 0; i<expoente; i++) {
				result *= base;
			}
			return result;
		}
	}
	
	// Metodo questao 13
	public static boolean primo(int valor) {
		if(valor == 0 || valor == 1) return false;
		for(int i = 2; i < valor; i++) {
			if(valor % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// Metodo questao 14
	public static int[] buscarOcorrencias(int[] vet1, int[] vet2) {
		int n = 0;
		for(int i = 0; i < vet1.length; i++) {
			for(int y = 0; y < vet2.length; y++) {
				if(vet1[i] == vet2[y]) {
					n++;
				}
			}
		}
		int[] newVet = new int[n];
		int a= 0;
		for(int i = 0; i < vet1.length; i++) {
			for(int y = 0; y < vet2.length; y++) {
				if(vet1[i] == vet2[y]) {
					newVet[a] = vet1[i];
					a++;
				}
			}
		}
		return newVet;
	}

	// Metodo questao 15
	public static int[] removerElementos(int[] vet, int elemento) {
		int n = vet.length;
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] == elemento) {
				n--;
			}
		}
		int[] newVet = new int[n];
		int c = 0;
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] != elemento) {
				newVet[c] = vet[i];
				c++;
			}
		}
		return newVet;
	}
	
	// Metodo questao 16
	public static boolean verificarPalindromo(String str) {
		int n = str.length();
		for(int i = 0; i < n; i++) {
			if(str.charAt(i) != str.charAt(n-i-1)) {
				return false;
			}
		}
		return true;
	}
	
	// Metodo questao 17
	public static boolean verificarPrimo(int n) {
		return Utilidades.primo(n);
	}
	
	// Metodo questao 18
	public static String inverterString(String str) {
		String copia = new String();
		int l = str.length();
		for(int i = l-1; i > -1; i--) {
			copia += str.charAt(i);
		}
		return copia;
	}

	// Metodo questao 19
	public static double calcularJurosCompostos(double valorInicial, double taxaDeJuros, double periodos) {
		double value = 1;
		for(int i = 0; i < periodos; i++) {
			value*=(1 + taxaDeJuros);
		}
		double montante = valorInicial * value; 
		return montante;
	}
	
	// Metodo questao 20
	public static boolean verificarPerfeito(int n) {
		int soma = 0;
		for(int i = 1; i <= n/2; i++) {
			if(n % i == 0) {
				soma += i;
			}
		}
		return soma == n;
	}
	
	// Metodo questao 21
	public static void diminuirVetor(int n ) {
		int[] vet;
		
		for(int b = n; b>0; b--) {
			vet = new int[b];
			for(int i = 0; i < vet.length; i++) {
				vet[i] = i+1;
			}
			System.out.print("Vetor " + (n-b+1) + " - ");
			for(int i = 0; i < vet.length; i++) {
				System.out.print(vet[i] + " ");
			}
			System.out.println();
		}
	}
	
	// Metodos para questao 22
	public static void imprimirElementosA(int linhas, int colunas) {
		for(int y = 0; y < linhas; y++) {
			for(int x = 0; x < y+1; x++) {
				System.out.print(x+"    ");
			}
			System.out.println();
		}
	}
	
	public static void imprimirElementosB1(int linhas, int colunas) {
		int pos = 0;
		for(int y = 0; y < linhas; y++) {
			for(int x = 0; x < colunas; x++) {
				if(pos %2 == 0) {
					System.out.print("@   ");
				}
				else {
					System.out.print("*   ");
				}
				pos++;
			}
			System.out.println();
		}
	}

	public static void imprimirElementosB2(int linhas, int colunas) {
		for(int y = 0; y < linhas; y++) {
			for(int x = 0; x < colunas; x++) {
				if(x == colunas/2 || y == linhas/2) {
					System.out.print("@  ");
				}
				else if(y%2==0) {
					System.out.print(colunas-x-1 + "  ");
				}
				else {
					System.out.print(x + "  ");
				}
			}
			System.out.println();
		}
	}
	
	public static void imprimirElementosC(int linhas, int colunas) {
		for(int y = 0; y < linhas; y++) {
			for(int x = 0; x < colunas; x++) {
				if(x == 0) {
					System.out.print(y + "  ");
				}
				else if(x == colunas-1) {
					System.out.print(colunas-y-1 + "  ");
				}
				else if(y == 0) {
					System.out.print(x + "  ");
				}
				else if(y == linhas-1) {
					System.out.print(linhas-1-x + "  ");
				}
				else {
					System.out.print("*" + "  ");
				}
			}
			System.out.println();
		}
	}

	public static void imprimirElementosD(int linhas, int colunas) {
		for(int y = 0; y < linhas; y++) {
			for(int x = 0; x < colunas; x++) {
				if(x == colunas/2) {
					System.out.print("||" + "  ");
				}
				else if(y == linhas/2) {
					System.out.print("=" + "  ");
				}
				else if(x < colunas/2 && y < linhas/2) {
					System.out.print("#" + "  ");
				}
				else if(x < colunas/2 && y > linhas/2) {
					System.out.print("*" + "  ");
				}
				else if(x > colunas/2 && y < linhas/2) {
					System.out.print("!" + "  ");
				}
				else if(x > colunas/2 && y > linhas/2) {
					System.out.print("%" + "  ");
				}
			}
			System.out.println();
		}
	}

	public static void imprimirElementosE(int linhas, int colunas) {
		for(int y = 0; y < linhas; y++) {
			for(int x = 0; x < colunas; x++) {
				if(x == y || linhas-y-1 == x) {
					System.out.print(x + "  ");
				}
				else {
					System.out.print("*" + "  ");
				}
			}
			System.out.println();
		}
	}
	
}
