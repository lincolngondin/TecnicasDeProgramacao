package lab2;
import java.util.ArrayList;

public class Venda {

	private Cliente cliente;
	private ArrayList<CachorroQuente> cachorrosQuentes;
	private float preco;
	private float valorDesconto;
	private int[] quantidadeTipos; // 0 - Salsicha, 1 - Linguica, 2 - Frango, 3 - Bacon
	
	public Venda(Cliente cliente) {
		this.cliente = cliente;
		this.preco = 0.0f;
		this.valorDesconto = 0.0f;
		this.quantidadeTipos = new int[4];
		for(int i = 0; i < 4; i++)
			this.quantidadeTipos[i] = 0;

		cachorrosQuentes = new ArrayList<CachorroQuente>();
	}
	
	public void realizarVenda(CachorroQuente c, int tipo) {
		quantidadeTipos[tipo]++;
		cachorrosQuentes.add(c);
		this.atualizarPreco();
	}
	
	private void atualizarPreco() {
		float preco0 = (quantidadeTipos[0]*2.0f);
		float preco1 = (quantidadeTipos[1]*3.0f);
		float preco2 = (quantidadeTipos[2]*2.5f);
		float preco3 = (quantidadeTipos[3]*3.5f);
		float desconto = 0.0f;
		if(quantidadeTipos[0]>2) {
			preco0 = preco0 - (preco0 * 0.1f);
			desconto += (preco0 * 0.1f);
		}
		if(quantidadeTipos[1]>2) {
			preco1 = preco1 - (preco1 * 0.12f);
			desconto += (preco1 * 0.12f);
		}
		if(quantidadeTipos[2]>3) {
			preco2 = preco2 - (preco2 * 0.13f);
			desconto += (preco2 * 0.13f);
		}
		if(quantidadeTipos[3]>4) {
			preco3 = preco3 - (preco3 * 0.14f);
			desconto += (preco3 * 0.14f);
		}
		this.preco = preco0 + preco1 + preco2 + preco3;
		this.valorDesconto = desconto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public ArrayList<CachorroQuente> getCachorrosQuentes() {
		return cachorrosQuentes;
	}
	
	public float getPreco() {
		return this.preco;
	}
	
	public float getValorDesconto() {
		return this.valorDesconto;
	}
	
}
