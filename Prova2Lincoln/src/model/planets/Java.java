package model.planets;

import model.CelestialBodies;
import model.Estrela;

public class Java extends Estrela {
	private static final String description = "Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems, que em 2008 foi adquirido pela empresa Oracle Corporation. Diferente das linguagens de programação modernas, que são compiladas para código nativo, Java é compilada para um bytecode que é interpretado por uma máquina virtual (Java Virtual Machine, abreviada JVM).";
	public Java() {
		super(7, 7, "Java", CelestialBodies.JAVA, description);
	}
}
