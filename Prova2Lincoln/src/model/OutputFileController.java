package model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;

public class OutputFileController {
	public static OutputFile getOutputFile(ArrayList<Report> dados) {
		OutputFile out = new OutputFile();
		
		Hashtable<String, _user> alunos = new Hashtable<String, _user>();
		
		int[] quadrantesBugsTotais = {0, 0, 0, 0};
		int[] quadrantesDevsTotais = {0, 0, 0, 0};
		int[] vezesPlanetasForamAtingidos = {0, 0, 0, 0, 0, 0, 0};
		
		float pythonVelocidadeTotal = 0;
		float javascriptVelocidadeTotal = 0;
		float rubyVelocidadeTotal = 0;
		float phpVelocidadeTotal = 0;
		float csharpVelocidadeTotal = 0;
		float cppVelocidadeTotal = 0;
		float cVelocidadeTotal = 0;
		
		int horasTotaisPassadas = 0;
		int anosTotaisPassados = 0;
		int quantidadeTotalDeBugsOcorridas = 0;
		int quantidadeTotalDeDevsOcorridas = 0;
		
		for(Report report : dados) {
			if(!alunos.containsKey(report.nome)) {
				alunos.put(report.nome, new _user(report.nome, report.matricula));
			}
			alunos.get(report.nome).quantidadeApareceu++;
			
			vezesPlanetasForamAtingidos[0] += report.bug_python;
			vezesPlanetasForamAtingidos[1] += report.bug_javascript;
			vezesPlanetasForamAtingidos[2] += report.bug_ruby;
			vezesPlanetasForamAtingidos[3] += report.bug_php;
			vezesPlanetasForamAtingidos[4] += report.bug_csharp;
			vezesPlanetasForamAtingidos[5] += report.bug_cmais;
			vezesPlanetasForamAtingidos[6] += report.bug_c;

			quadrantesBugsTotais[0] += report.bug_q1;
			quadrantesBugsTotais[1] += report.bug_q2;
			quadrantesBugsTotais[2] += report.bug_q3;
			quadrantesBugsTotais[3] += report.bug_q4;

			quadrantesDevsTotais[0] += report.dev_q1;
			quadrantesDevsTotais[1] += report.dev_q2;
			quadrantesDevsTotais[2] += report.dev_q3;
			quadrantesDevsTotais[3] += report.dev_q4;

			pythonVelocidadeTotal += report.v_python;
			javascriptVelocidadeTotal += report.v_javascript;
			rubyVelocidadeTotal += report.v_ruby;
			phpVelocidadeTotal += report.v_php;
			csharpVelocidadeTotal += report.v_csharp;
			cppVelocidadeTotal += report.v_cmais;
			cVelocidadeTotal += report.v_c;
			
			
			horasTotaisPassadas += report.d_python + report.d_javascript + report.d_ruby + report.d_php+ report.d_csharp + report.d_cmais + report.d_c;
			anosTotaisPassados += report.a_python + report.a_javascript + report.a_ruby + report.a_php + report.a_csharp + report.a_cmais + report.a_c;
			quantidadeTotalDeBugsOcorridas += 
					  report.bug_q1 + report.bug_q2 + report.bug_q3 + report.bug_q4
					+ report.bug_python + report.bug_javascript + report.bug_ruby
					+ report.bug_php + report.bug_csharp + report.bug_cmais + report.bug_c;
			
			quantidadeTotalDeDevsOcorridas += 
					  report.dev_q1 + report.dev_q2 + report.dev_q3 + report.dev_q4
					+ report.dev_python + report.dev_javascript + report.dev_ruby
					+ report.dev_php + report.dev_csharp + report.dev_cmais + report.dev_c;
			
		}
		
		int indicePlanetaMaisMorreu = 0;
		int quantidadeDeVezesMaisMorreuFoiAtingido = vezesPlanetasForamAtingidos[0];

		int indicePlanetaMaisViveu = 0;
		int quantidadeDeVezesMaisViveuFoiAtingido = vezesPlanetasForamAtingidos[0];

		for(int i = 0; i < 7; i++) {
			if(vezesPlanetasForamAtingidos[i] > quantidadeDeVezesMaisMorreuFoiAtingido) {
				quantidadeDeVezesMaisMorreuFoiAtingido = vezesPlanetasForamAtingidos[i];
				indicePlanetaMaisMorreu = i;
			}
			if(vezesPlanetasForamAtingidos[i] < quantidadeDeVezesMaisViveuFoiAtingido) {
				quantidadeDeVezesMaisViveuFoiAtingido = vezesPlanetasForamAtingidos[i];
				indicePlanetaMaisViveu = i;
			}
		}
		switch(indicePlanetaMaisMorreu) {
		case 0:
			out.planetaMaisMorreu = "Python";
			break;
		case 1:
			out.planetaMaisMorreu = "Javascript";
			break;
		case 2:
			out.planetaMaisMorreu = "Ruby";
			break;
		case 3:
			out.planetaMaisMorreu = "PHP";
			break;
		case 4:
			out.planetaMaisMorreu = "C#";
			break;
		case 5:
			out.planetaMaisMorreu = "C++";
			break;
		case 6:
			out.planetaMaisMorreu = "C";
			break;
		}
		switch(indicePlanetaMaisViveu) {
		case 0:
			out.planetaMaisVida = "Python";
			break;
		case 1:
			out.planetaMaisVida = "Javascript";
			break;
		case 2:
			out.planetaMaisVida = "Ruby";
			break;
		case 3:
			out.planetaMaisVida = "PHP";
			break;
		case 4:
			out.planetaMaisVida = "C#";
			break;
		case 5:
			out.planetaMaisVida = "C++";
			break;
		case 6:
			out.planetaMaisVida = "C";
			break;
		}
		
		
		String nomeAlunoMaisAnalisou = "";
		String matriculaAlunoMaisAnalisou = "";
		int quantidade = -1;
		for(String key : alunos.keySet()){
			_user temp = alunos.get(key);
			if(temp.quantidadeApareceu > quantidade) {
				quantidade = temp.quantidadeApareceu;
				nomeAlunoMaisAnalisou = temp.name;
				matriculaAlunoMaisAnalisou = temp.matricula;
			}
		}
		out.matricula = matriculaAlunoMaisAnalisou;
		out.nome = nomeAlunoMaisAnalisou;
		
		out.mediaVelocidadePython = pythonVelocidadeTotal/dados.size();
		out.mediaVelocidadeJavascript = javascriptVelocidadeTotal/dados.size();
		out.mediaVelocidadeRubyOnRails = rubyVelocidadeTotal/dados.size();
		out.mediaVelocidadePHP = phpVelocidadeTotal/dados.size();
		out.mediaVelocidadeCSharp = csharpVelocidadeTotal/dados.size();
		out.mediaVelocidadeCPlusPlus = cppVelocidadeTotal/dados.size();
		out.mediaVelocidadeC = cVelocidadeTotal/dados.size();
		
		int quadranteBugConcentram = 0;
		int q = -1;

		for(int i = 0; i < 4; i++) {
			if(quadrantesBugsTotais[i] > q) {
				quadranteBugConcentram = i;
				q = quadrantesBugsTotais[i];
			}
		}
		out.quadranteBugsConcentram = quadranteBugConcentram;

		int quadranteDevConcentram = 0;
		q = -1;

		for(int i = 0; i < 4; i++) {
			if(quadrantesDevsTotais[i] > q) {
				quadranteDevConcentram = i;
				q = quadrantesDevsTotais[i];
			}
		}
		out.quadranteDevsConcentram = quadranteDevConcentram;
		
		out.quantidadeTotalDeHoras = horasTotaisPassadas;
		out.quantidadeDeAnosTotais = anosTotaisPassados;
		out.quantidadeTotalDeBugs = quantidadeTotalDeBugsOcorridas;
		out.quantidadeTotalDeDevs = quantidadeTotalDeDevsOcorridas;
		out.totalInstantesAnalisados = dados.size();
		
		return out;
	}

	public static boolean saveFile(OutputFile file) {
		FileWriter outputFile = null;
		LocalDateTime time = LocalDateTime.now();
		try {
			String outputFileName = String.format("output/%d-%d-%d_%d-%d-%d.txt", time.getDayOfMonth(), time.getMonthValue(), time.getYear(), time.getHour(), time.getMinute(), time.getSecond());
			outputFile = new FileWriter(outputFileName);
			outputFile.write(String.format("%s - %s, %s, %s, %d, %d, %d, Python: %.2f - Javascript: %.2f - Ruby on Rails: %.2f - PHP: %.2f - C#: %.2f - C++: %.2f - C: %.2f, %d, %d, %d, %d",
						file.matricula,
						file.nome,
						file.planetaMaisMorreu,
						file.planetaMaisVida,
						file.quadranteBugsConcentram,
						file.quadranteDevsConcentram,
						file.totalInstantesAnalisados,
						file.mediaVelocidadePython,
						file.mediaVelocidadeJavascript,
						file.mediaVelocidadeRubyOnRails,
						file.mediaVelocidadePHP,
						file.mediaVelocidadeCSharp,
						file.mediaVelocidadeCPlusPlus,
						file.mediaVelocidadeC,
						file.quantidadeTotalDeBugs,
						file.quantidadeTotalDeDevs,
						file.quantidadeTotalDeHoras,
						file.quantidadeDeAnosTotais
			));

			if(outputFile != null) {
				outputFile.close();
			}

			return true;
		}
		catch(IOException err) {
			err.printStackTrace();
			return false;
		}
	}
}

class _user {
	public String name;
	public String matricula;
	public int quantidadeApareceu;
	public _user(String nome, String matricula){
		this.quantidadeApareceu = 0;
		this.name = nome;
		this.matricula = matricula;
	}
}