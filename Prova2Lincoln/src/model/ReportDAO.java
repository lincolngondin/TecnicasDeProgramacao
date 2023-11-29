package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportDAO {
	public ArrayList<Report> getAllData(){
		try {
			Connection conexao = new DBConnection().getConnection();
			if(conexao == null) {
				return null;
			}

			ArrayList<Report> reports = new ArrayList<Report>();
			ResultSet dados = conexao.prepareStatement("select * from javalar").executeQuery();
			while(dados.next()) {
				Report report = new Report();
				report.nome = dados.getString("nome");
				report.matricula = dados.getString("matricula");
				report.nome_arquivo = dados.getString("nome_arquivo");
				report.bug_python = dados.getInt("bug_python");
				report.bug_javascript = dados.getInt("bug_javascript");
				report.bug_ruby = dados.getInt("bug_ruby");
				report.bug_php = dados.getInt("bug_php");
				report.bug_csharp = dados.getInt("bug_csharp");
				report.bug_cmais = dados.getInt("bug_cmais");
				report.bug_c = dados.getInt("bug_c");

				report.dev_python = dados.getInt("dev_python");
				report.dev_javascript = dados.getInt("dev_javascript");
				report.dev_ruby = dados.getInt("dev_ruby");
				report.dev_php = dados.getInt("dev_php");
				report.dev_csharp = dados.getInt("dev_csharp");
				report.dev_cmais = dados.getInt("dev_cmais");
				report.dev_c = dados.getInt("dev_c");

				report.v_python = dados.getInt("v_python");
				report.v_javascript = dados.getInt("v_javascript");
				report.v_ruby = dados.getInt("v_ruby");
				report.v_php = dados.getInt("v_php");
				report.v_csharp = dados.getInt("v_csharp");
				report.v_cmais = dados.getInt("v_cmais");
				report.v_c = dados.getInt("v_c");

				report.d_python = dados.getInt("d_python");
				report.d_javascript = dados.getInt("d_javascript");
				report.d_ruby = dados.getInt("d_ruby");
				report.d_php = dados.getInt("d_php");
				report.d_csharp = dados.getInt("d_csharp");
				report.d_cmais = dados.getInt("d_cmais");
				report.d_c = dados.getInt("d_c");

				report.a_python = dados.getInt("a_python");
				report.a_javascript = dados.getInt("a_javascript");
				report.a_ruby = dados.getInt("a_ruby");
				report.a_php = dados.getInt("a_php");
				report.a_csharp = dados.getInt("a_csharp");
				report.a_cmais = dados.getInt("a_cmais");
				report.a_c = dados.getInt("a_c");
				
				report.bug_q1 = dados.getInt("bug_q1");
				report.bug_q2 = dados.getInt("bug_q2");
				report.bug_q3 = dados.getInt("bug_q3");
				report.bug_q4 = dados.getInt("bug_q4");

				report.dev_q1 = dados.getInt("dev_q1");
				report.dev_q2 = dados.getInt("dev_q2");
				report.dev_q3 = dados.getInt("dev_q3");
				report.dev_q4 = dados.getInt("dev_q4");
				System.out.printf("%s %s %s\n",report.nome, report.matricula,report.nome_arquivo);
				reports.add(report);
			}

			conexao.close();
			return reports;
		}
		catch(SQLException err) {
			err.printStackTrace();
			return null;
		}
	}

	public boolean inserir(Report report) {
		try {
			Connection conexao = new DBConnection().getConnection();
			if(conexao == null) {
				return false;
			}

			String query = "insert into javalar (nome, matricula, nome_arquivo, bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c, dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c, v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, bug_q1, bug_q2, bug_q3, bug_q4, dev_q1, dev_q2, dev_q3, dev_q4) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ins = conexao.prepareStatement(query);
			ins.setString(1, report.nome);
			ins.setString(2, report.matricula);
			ins.setString(3, report.nome_arquivo);
			ins.setInt(4, report.bug_python);
			ins.setInt(5, report.bug_javascript);
			ins.setInt(6, report.bug_ruby);
			ins.setInt(7, report.bug_php);
			ins.setInt(8, report.bug_csharp);
			ins.setInt(9, report.bug_cmais);
			ins.setInt(10, report.bug_c);
			ins.setInt(11, report.dev_python);
			ins.setInt(12, report.dev_javascript);
			ins.setInt(13, report.dev_ruby);
			ins.setInt(14, report.dev_php);
			ins.setInt(15, report.dev_csharp);
			ins.setInt(16, report.dev_cmais);
			ins.setInt(17, report.dev_c);
			ins.setInt(18, report.v_python);
			ins.setInt(19, report.v_javascript);
			ins.setInt(20, report.v_ruby);
			ins.setInt(21, report.v_php);
			ins.setInt(22, report.v_csharp);
			ins.setInt(23, report.v_cmais);
			ins.setInt(24, report.v_c);
			ins.setInt(25, report.d_python);
			ins.setInt(26, report.d_javascript);
			ins.setInt(27, report.d_ruby);
			ins.setInt(28, report.d_php);
			ins.setInt(29, report.d_csharp);
			ins.setInt(30, report.d_cmais);
			ins.setInt(31, report.d_c);
			ins.setInt(32, report.a_python);
			ins.setInt(33, report.a_javascript);
			ins.setInt(34, report.a_ruby);
			ins.setInt(35, report.a_php);
			ins.setInt(36, report.a_csharp);
			ins.setInt(37, report.a_cmais);
			ins.setInt(38, report.a_c);
			ins.setInt(39, report.bug_q1);
			ins.setInt(40, report.bug_q2);
			ins.setInt(41, report.bug_q3);
			ins.setInt(42, report.bug_q4);
			ins.setInt(43, report.dev_q1);
			ins.setInt(44, report.dev_q2);
			ins.setInt(45, report.dev_q3);
			ins.setInt(46, report.dev_q4);
			ins.executeUpdate();

			conexao.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
