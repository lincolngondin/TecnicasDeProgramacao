package model.planets;

import model.CelestialBodies;
import model.Planet;

public class RubyOnRails extends Planet{
	private static final String description = "Ruby on Rails é um framework livre que promete aumentar velocidade e facilidade no desenvolvimento de sites orientados a banco de dados (database-driven web sites), uma vez que é possível criar aplicações com base em estruturas pré-definidas. Frequentemente referenciado como Rails ou RoR, o Ruby on Rails é um projeto de código aberto escrito na linguagem de programação Ruby.";
	public RubyOnRails() {
		super(3, 0, 3, 2, 48, "Ruby On Rails", CelestialBodies.RUBY_ON_RAILS, description);
	}
}
