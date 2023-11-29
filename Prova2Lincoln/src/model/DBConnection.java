package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private String host;
	private String banco;
	private String usuario;
	private String senha;
	public DBConnection() {
		/*
		this.host = "localhost";
		this.banco = "banco_teste";
		this.usuario = "root";
		this.senha = "";
		*/
		
		this.host = "da_java.mysql.dbaas.com.br";
		this.banco = "da_java";
		this.usuario = "da_java";
		this.senha = "Tecnicas*2023@";
		
		
	}
	public Connection getConnection() {
		//String url="jdbc:mysql://" + this.host + "/" + this.banco+"?verifyServerCertificate=false&useSSL=true";
		String url="jdbc:mysql://" + this.host + "/" + this.banco+"?verifyServerCertificate=false&useSSL=false";
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException err) {
			System.out.println("Conexão com MYSQL não realizada");
			err.printStackTrace();
		}
		return null;
	}
}
