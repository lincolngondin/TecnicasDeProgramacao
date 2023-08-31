package Lista1;
public class MainClass {
	public static void main(String[] args) {
		int A = 10;
		int B = 20;
		
		//Questao 1
		System.out.println("Questao 1:");
		if(A > 10) {
			System.out.println("A > 10");
		}
		if((A + B) == 20) {
			System.out.println("A + B == 20");
		}
		else {
			System.out.println("numero não válido");
		}
		
		//Questao 2
		System.out.println("\nQuestao 2:");
		if(A < 10) {
			System.out.println("A < 10");
		}
		else if((A + B) == 20) {
			System.out.println("A + B == 20");
		}
		else {
			System.out.println("número não válido");
		}
		
		//Questao 3
		System.out.println("\nQuestao 3:");
		if(A == 10) {
			System.out.println("A == 10");
		}
		if((A + B) == 20) {
			System.out.println("A + B == 20");
		}
		if(B == 10) {
			System.out.println("B == 10");
		}
		
		//Questao 4
		System.out.println("\nQuestao 4:");
		if( (A > 10) || ( (A + B) == 20)) {
			System.out.println("número válido");
		}
		else {
			if(A == B) {
				System.out.println("A é igual B; A e B são diferentes de 10; A é menor que 10");
			}
			else {
				System.out.println("número não válido");
			}
		}
		
		//Questao 5
		System.out.println("\nQuestao 5:");
		if( (A > 10) || ((A + B) == 20)) {
			System.out.println("número válido");
		}
		else {
			System.out.println("número não válido");
		}
		
		//Questao 6
		System.out.println("\nQuestao 6:");
		if(A > 10) {
			System.out.println("A > 10");
		}
		else {
			System.out.println("A <= 10");
		}
		if( (A + B) == 20) {
			System.out.println("A + B == 20");
		}
		else {
			System.out.println("A + B != 20");
		}

		//Questao 7
		System.out.println("\nQuestao 7:");
		if((A > 10) || ((A + B) == 20)){
			System.out.println("números válidos");
		}
		if(A <= 10) {
			System.out.println("número não válido");
		}
		
		//Questao 8
		System.out.println("\nQuestao 8:");
		if(A > 10) {
			System.out.println("A > 10");
		}
		if((A + B) == 20) {
			System.out.println("A + B == 20");
		}
		else {
			System.out.println("número não válido");
		}

		//Questao 9
		System.out.println("\nQuestao 9:");
		if( (A > 10) && ((A + B) == 20)) {
			System.out.println("A + B == 20");
		}
		else {
			System.out.println("número não valido");
		}
		
		//Questao 10
		System.out.println("\nQuestao 10:");
		if(!(A > 10)) {
			System.out.println("número menor que 10");
		}
		if(!((A + B) == 20)) {
			System.out.println("número diferente de 20");
		}
		
		//Questao 11
		System.out.println("\nQuestao 11:");
		if(!(A > 10)) {
			if((A + B) == 20) {
				System.out.println("A + B == 20");
			}
			else {
				System.out.println("número não válido");
			}
		}
		
		//Questao 12
		System.out.println("\nQuestao 12:");
		if(A > 10) {
			System.out.println("A > 10");
		}
		else if((A + B) == 20) {
			System.out.println("A + B == 20");
		}
		else {
			System.out.println("números não válidos");
		}
		System.out.println("Sejam bem-vindos à disciplina de Técnicas de Programação");
		
		
		//Questao 13
		System.out.println("\nQuestao 13:");
		if(A > 10) {
			System.out.println("A > 10");
		}
		if((A + B) == 20) {
			System.out.println("A + B == 20");
		}
		if((A <= 10) && ((A + B) != 20)) {
			System.out.println("números não válidos");
		}

		
		//Questao 14
		System.out.println("\nQuestao 14:");
		if(A > 10) {
			System.out.println("A > 10");
			if((A + B) == 20) {
				System.out.println("A + B == 20");
			}
			else {
				System.out.println("número não válido");
			}
		}
		
		//Questao 15
		System.out.println("\nQuestao 15:");
		if(A < 10) {
			System.out.println("A < 10");
		}
		if((A + B) == 20) {
			System.out.println("A + B == 20");
		}
		if((A >= 10) && ((A + B) != 20)) {
			System.out.println("número não válido");
		}
		
		//Questao 16
		System.out.println("\nQuestao 16:");
		if(A == 10) {
			System.out.println("A == 10");
		}
		if((A + B) == 20) {
			System.out.println("A + B == 20");
		}
		if(B == 10) {
			System.out.println("B == 10");
		}
		
		//Questao 17
		System.out.println("\nQuestao 17:");
		if((A > 10) || ((A + B) == 20)) {
			System.out.println("número válido");
		}
		else {
			if(A == B) {
				System.out.println("A == B");
			}
			if(A != 10 && B != 10 && A < 10) {
				System.out.println("A é menor que 10");
			}
			else {
				System.out.println("número não válido");
			}
		}
		
		//Questao 18
		System.out.println("\nQuestao 18:");
		if((A > 10) || ((A + B) == 20)){
			System.out.println("número válido");
		}
		else {
			System.out.println("número não válido");
		}
		
		//Questao 19
		System.out.println("\nQuestao 19:");
		if(A > 10) {
			System.out.println("A > 10");
		}
		else {
			System.out.println("A <= 10");
		}
		if((A + B) == 20) {
			System.out.println("A + B == 20");
		}
		else {
			System.out.println("A + B != 20");
		}
		
		//Questao 20
		System.out.println("\nQuestao 20:");
		if((A > 10) || ((A + B) == 20)) {
			System.out.println("números válidos");
		}
		else {
			System.out.println("número não válido");
		}
		System.out.println("Sejam bem-vindos à disciplina de Técnicas de Programação");
		
		
		
		
		
	}

}
