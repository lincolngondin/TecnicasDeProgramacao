package model;

import model.planets.*;

public class JavalarSystem extends Sistema {
	public JavalarSystem() {
		super(new Java());
		this.putPlanets();
		this.criarAsteroides();
	}
	public void putPlanets() {
		this.adicionarPlaneta(new Python());
		this.adicionarPlaneta(new Javascript());
		this.adicionarPlaneta(new RubyOnRails());
		this.adicionarPlaneta(new PHP());
		this.adicionarPlaneta(new CSharp());
		this.adicionarPlaneta(new CPlusPlus());
		this.adicionarPlaneta(new C());
	}
}
