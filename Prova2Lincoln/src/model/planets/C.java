package model.planets;

import model.CelestialBodies;
import model.Planet;

public class C extends Planet{
	private static final String description = "C é uma linguagem de programação compilada de propósito geral, estruturada, imperativa, procedural, padronizada pela Organização Internacional para Padronização (ISO), criada em 1972 por Dennis Ritchie na empresa AT&T Bell Labs para desenvolvimento do sistema operacional Unix (originalmente escrito em Assembly).";
	public C() {
		super(7, 0, 7, 10, 0.1, "C", CelestialBodies.C, description);
	}
}
