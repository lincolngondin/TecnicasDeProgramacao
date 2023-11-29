package model.planets;

import model.CelestialBodies;
import model.Planet;

public class Python extends Planet{
	private static final String description = "Python é uma linguagem de programação de alto nível, interpretada de script, imperativa, orientada a objetos, funcional, de tipagem dinâmica e forte. Foi lançada por Guido van Rossum em 1991. Atualmente, possui um modelo de desenvolvimento comunitário, aberto e gerenciado pela organização sem fins lucrativos Python Software Foundation.";
	public Python() {
		super(1, 0, 1, 4, 24, "Python", CelestialBodies.PYTHON, description);
	}
}
