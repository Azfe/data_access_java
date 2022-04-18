package com.model;

public class ProfesorDTO {

	private int ID;
	private String nombre;
	private String apellidos;
	private String pass;
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public ProfesorDTO (){
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	@Override
	public String toString() {
		return "ProfesorDTO [ID=" + ID + ", nombre=" + nombre + ", apellidos=" + apellidos + ", pass=" + pass + "]";
	}
	
	
	
}
