package main;

import java.util.ArrayList;
import java.util.Random;

public class Asteroides {
	private ArrayList<Obstaculo> bugsEDevs;
	private int qBugs = 0;
	private int qDevs = 0;
	private boolean[] posicoesOcupadas;
	private int[] randomPool;
	private int diametroSistema;
	private Random randomEngine;

	public Asteroides(int diametroSistema){
		this.diametroSistema = diametroSistema;
		this.randomEngine = new Random();
		this.posicoesOcupadas = new boolean[diametroSistema*diametroSistema];
		this.randomPool = new int[diametroSistema*diametroSistema];
		this.bugsEDevs = new ArrayList<Obstaculo>();
		for(int i = 0; i < diametroSistema*diametroSistema; i++) {
			this.posicoesOcupadas[i] = false;
			this.randomPool[i] = i;
		}
		this.posicoesOcupadas[0] = true;
	}
	
	public void adicionarBugsEDevs(int quantidadeBugs, int quantidadeDevs) {
		int n = this.diametroSistema*this.diametroSistema;
		int bugsAdicionado = 0;
		int devsAdicionado = 0;
		int adicionado = 0;
		this.randomizarValoresPossiveis();
		for(int i = 0; i < n; i++) {
			if(bugsAdicionado >= quantidadeBugs && devsAdicionado >= quantidadeDevs) {
				break;
			}
			if(!this.posicoesOcupadas[this.randomPool[i]]) {
				int pos = this.randomPool[i];
				int y = pos / this.diametroSistema;
				int x = pos % this.diametroSistema;
				if(adicionado % 2 == 0) {
					if(bugsAdicionado < quantidadeBugs) {
						this.bugsEDevs.add(new Bug(x, y));
						this.posicoesOcupadas[pos] = true;
						this.qBugs++;
						bugsAdicionado++;
						adicionado++;
					}
					else {
						if(devsAdicionado < quantidadeDevs) {
							this.bugsEDevs.add(new Desenvolvedor(x, y));
							this.posicoesOcupadas[pos] = true;
							this.qDevs++;
							devsAdicionado++;
							adicionado++;
						}
					}
				}
				else {
					if(devsAdicionado < quantidadeDevs) {
						this.bugsEDevs.add(new Desenvolvedor(x, y));
						this.posicoesOcupadas[pos] = true;
						this.qDevs++;
						devsAdicionado++;
						adicionado++;
					}
					else {
						if(bugsAdicionado < quantidadeBugs) {
							this.bugsEDevs.add(new Bug(x, y));
							this.posicoesOcupadas[pos] = true;
							this.qBugs++;
							bugsAdicionado++;
							adicionado++;
						}
					}
				}
			}
		}
	}
	
	public ArrayList<Obstaculo> getBugsEDevsList(){
		return this.bugsEDevs;
	}
	
	private void randomizarValoresPossiveis() {
		int n = this.diametroSistema*this.diametroSistema;
		for(int i = 0; i < n; i++) {
			int newPos = this.randomEngine.nextInt(n);
			int temp = this.randomPool[newPos];
			this.randomPool[newPos] = this.randomPool[i];
			this.randomPool[i] = temp;
		}
	}
	
	public boolean checarPosicao(int x, int y) {
		int pos = x * this.diametroSistema + y;
		if(pos >= this.diametroSistema*this.diametroSistema) {
			return false;
		}
		else {
			return this.posicoesOcupadas[pos];
		}
	}
	
	public void removerObstaculo(int indice) {
		if(this.bugsEDevs.get(indice) instanceof Bug) {
			this.qBugs--;
		}
		else {
			this.qDevs--;
		}
		this.posicoesOcupadas[bugsEDevs.get(indice).getPosicao().y * this.diametroSistema + bugsEDevs.get(indice).getPosicao().x] = false;
		this.bugsEDevs.remove(indice);
	}
	
	public int getQDevs() {
		return this.qDevs;
	}

	public int getQBugs() {
		return this.qBugs;
	}
	
}
