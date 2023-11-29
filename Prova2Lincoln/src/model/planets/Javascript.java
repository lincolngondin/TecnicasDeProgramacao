package model.planets;

import model.CelestialBodies;
import model.Planet;

public class Javascript extends Planet {
	private static final String description = "JavaScript (frequentemente abreviado como JS) é uma linguagem de programação interpretada estruturada, de script em alto nível com tipagem dinâmica fraca e multiparadigma (protótipos, orientado a objeto, imperativo e funcional). Juntamente com HTML e CSS, o JavaScript é uma das três principais tecnologias da World Wide Web.";
	public Javascript() {
		super(2, 0, 2, 3, 10, "Javascript", CelestialBodies.JAVASCRIPT, description);
	}
}
