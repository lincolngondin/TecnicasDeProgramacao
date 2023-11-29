package model.planets;

import model.CelestialBodies;
import model.Planet;

public class PHP extends Planet{
	private static final String description = "PHP (um acrônimo recursivo para 'PHP: Hypertext Preprocessor', originalmente Personal Home Page) é uma linguagem interpretada livre, usada originalmente apenas para o desenvolvimento de aplicações presentes e atuantes no lado do servidor, capazes de gerar conteúdo dinâmico na World Wide Web. Figura entre as primeiras linguagens passíveis de inserção em documentos HTML, dispensando em muitos casos o uso de arquivos externos para eventuais processamentos de dados.";
	public PHP() {
		super(4, 0, 4, 2, 60, "PHP", CelestialBodies.PHP, description);
	}
}
