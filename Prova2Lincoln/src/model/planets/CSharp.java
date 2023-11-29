package model.planets;

import model.CelestialBodies;
import model.Planet;

public class CSharp extends Planet {
	private static final String description = "C# é uma linguagem de programação, multiparadigma, de tipagem forte, desenvolvida pela Microsoft como parte da plataforma .NET. A sua sintaxe orientada a objetos foi baseada no C++ mas inclui muitas influências de outras linguagens de programação, como Object Pascal e, principalmente, Java. O código fonte é compilado para Common Intermediate Language (CIL) que é interpretado pela máquina virtual Common Language Runtime (CLR).";
	public CSharp() {
		super(5, 0, 5, 1, 4, "C#", CelestialBodies.CSHARP, description);
	}
}
