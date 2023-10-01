package lab2;

import java.util.ArrayList;

public abstract class CachorroQuente {

	protected String queijo;
	protected ArrayList<String> ingredientes;
	protected String bebida;
	
	public CachorroQuente(String queijo, ArrayList<String> ingredientes, String bebida) {
		this.queijo = queijo;		
		this.ingredientes = ingredientes;
		this.bebida = bebida;
	}
	
	public void adicionarIngredientes(String ingrediente) {
		
		ingredientes.add(ingrediente);
	}
}
