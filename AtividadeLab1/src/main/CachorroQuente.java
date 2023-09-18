package main;

public class CachorroQuente {
	private String proteina;
	private String queijo;
	private String bebida;
	private String adicionais;
	public CachorroQuente(String proteina, String queijo, String bebida, String adicionais){
		this.proteina = proteina;
		this.queijo = queijo;
		this.bebida = bebida;
		this.adicionais = adicionais;
	}
	public String getProteina() {
		return proteina;
	}
	public String getBebida() {
		return bebida;
	}
	public String getQueijo() {
		return queijo;
	}
	public String getAdicionais() {
		return adicionais;
	}
}
