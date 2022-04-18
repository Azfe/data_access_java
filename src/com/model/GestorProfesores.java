package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorProfesores {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/universidad";
	private Connection con;

	public GestorProfesores() {
		super();
	}

	public int crearProfesor(String nombre, String apellido, String pass)
			throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		con = DriverManager.getConnection(url, "root", "");

		String sentenciaSQL = "INSERT INTO profesores(nombre,apellidos,password) VALUES (?, ?,?);";
		PreparedStatement ps = con.prepareStatement(sentenciaSQL);
		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ps.setString(3, pass);
		return (ps.executeUpdate());
	}
	
	public List<ProfesorDTO> listarProfesores() throws ClassNotFoundException,
			SQLException {
		List<ProfesorDTO> profesores = new ArrayList<ProfesorDTO>();
		Class.forName(driver);
		con = DriverManager.getConnection(url, "root", "");

		String sentenciaSQL = "Select * from profesores";
		Statement ins = con.createStatement();
		ResultSet rs = ins.executeQuery(sentenciaSQL);
		while (rs.next()) { // si hay resultados crea instancias de ProfesorDTO y añadiéndola a la lista auxiliar
			ProfesorDTO p = new ProfesorDTO();
			p.setNombre(rs.getString("nombre"));
			p.setApellidos(rs.getString("apellidos"));
			p.setID(rs.getInt("id"));
			profesores.add(p);
		}
		return profesores;
	}

	public ProfesorDTO consultarPorID(int id) throws ClassNotFoundException,
			SQLException {
		ProfesorDTO p = new ProfesorDTO();
		Class.forName(driver);
		con = DriverManager.getConnection(url, "root", "");
		String sentenciaSQL = "Select * from profesores where id = ?";
		PreparedStatement ps = con.prepareStatement(sentenciaSQL);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			p.setNombre(rs.getString("nombre"));
			p.setApellidos(rs.getString("apellidos"));
			p.setID(rs.getInt("id"));
		}
		return p;
	}

	public int modificarProfesor(String nombre, String ape, int id)
			throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		con = DriverManager.getConnection(url, "root", "");
		String sentenciaSQL = "Update profesores set nombre=?, apellidos=? where id=?";
		PreparedStatement ps = con.prepareStatement(sentenciaSQL);
		ps.setString(1, nombre);
		ps.setString(2, ape);
		ps.setInt(3, id);
		return (ps.executeUpdate());
	}

	public int borrarProfesor(int id) throws ClassNotFoundException,
			SQLException {

		Class.forName(driver);
		con = DriverManager.getConnection(url, "root", "");
		String sentenciaSQL = "Delete from profesores where id=?";
		PreparedStatement ps = con.prepareStatement(sentenciaSQL);
		ps.setInt(1, id);
		return (ps.executeUpdate());
	}

	public ProfesorDTO consultaLogin(String nombre, String pass)
			throws ClassNotFoundException, SQLException {
		ProfesorDTO p = new ProfesorDTO();
		Class.forName(driver);
		con = DriverManager.getConnection(url, "root", "");
		String sentenciaSQL = "Select * from profesores where nombre= ? and password=?";
		PreparedStatement ps = con.prepareStatement(sentenciaSQL);
		ps.setString(1, nombre);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			p.setNombre(rs.getString("nombre"));
			p.setApellidos(rs.getString("apellidos"));
		}
		return p;
	}
}
