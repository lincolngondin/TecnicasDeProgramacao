package main;

public class Venda {
	private CachorroQuente[] compras;
	private Aluno comprador;
	private int comprasFeitas;

	private Venda() {
		this.compras = new CachorroQuente[10];
	}

	public Venda(Aluno aluno){
		this();
		this.comprador = aluno;
		this.comprasFeitas = 0;
	}
	
	public void adicionarCompra(CachorroQuente cq) {
		if(this.comprasFeitas >= 10) {
			return;
		}
		compras[this.comprasFeitas] = cq;
		this.comprasFeitas++;
	}

	public int getComprasFeitas() {
		return this.comprasFeitas;
	}

	public Aluno getComprador() {
		return this.comprador;
	}
	
	public CachorroQuente[] getCompras() {
		return this.compras;
	}
}
