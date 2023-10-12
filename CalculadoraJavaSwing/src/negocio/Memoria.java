package negocio;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Memoria {

	private ArrayList<String> numeros;
	private boolean showingResult = false;

	public Memoria() {
		numeros = new ArrayList<String>();
	}

	public String getNumeros() {
		String resultado = "";
		for (String num : numeros) {
			resultado += ""+ num;
		}
		return resultado;
	}
	
//	primeiraParte opera��o segundaParte =  resultado
	public void setNumero(String numero) {
		if(this.showingResult) {
			this.numeros = new ArrayList<String>();
			this.showingResult = false;
		}
		if(numero.equals("=")) {
			double result = this.calculateFromString();
			this.numeros = new ArrayList<String>();
			this.numeros.add(String.format("%.2f", result));
			this.showingResult = true;
		}
		else {
			this.numeros.add(numero);
		}
	}
	
	private double calculateFromString() {
		String input = this.getNumeros();
		String pattern = "([\\-]?[0-9]+[[\\.]?[0-9]+]?)([+\\-\\*\\/])([\\-]?[0-9]+[[\\.]?[0-9]+]?)";

		double result = 0.0;
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(input);
		if(m.find()) {
			float firstValue = Float.parseFloat(m.group(1));
			float secondValue = Float.parseFloat(m.group(3));
			String op = m.group(2);
			if(op.equals("+")) {
				result = firstValue+secondValue;
			}
			else if(op.equals("-")) {
				result = firstValue-secondValue;
			}
			else if(op.equals("*")) {
				result = firstValue*secondValue;
			}
			else if(op.equals("/")){
				result = firstValue/secondValue;
			}
			return result;
			
		}
		else {
			System.out.println("Invalid Operation!!");
			return result;
		}
		
		
	}

}
