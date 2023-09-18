package main;

public class Barraca {
	private Venda[] vendas;
	private int vendasFeitas;
	public Barraca() {
		this.vendas = new Venda[20];
	}
	public void adicionarVenda(Venda venda) {
		if(this.vendasFeitas >= 20) {
			return;
		}
		vendas[this.vendasFeitas] = venda;
		this.vendasFeitas++;
	}
	public int getVendasFeitas() {
		return this.vendasFeitas;
	}
	public Venda[] getVendas() {
		return this.vendas;
	}
}
