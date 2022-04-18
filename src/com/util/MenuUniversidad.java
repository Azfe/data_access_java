package com.util;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.model.GestorProfesores;
import com.model.ProfesorDTO;

public class MenuUniversidad {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		GestorProfesores gp = new GestorProfesores();
		
		gp.crearProfesor("Pepe", "Martín", "1234");
		
		// gp.borrarProfesor(1);
		// gp.modificarProfesor("Fer", "Gil", 2);
		
		List<ProfesorDTO> profesores = gp.listarProfesores();
		for (Iterator<ProfesorDTO> iterator = profesores.iterator(); iterator
				.hasNext();) {
			ProfesorDTO profesorDTO = (ProfesorDTO) iterator.next();
			System.out.println("Nombre: " + profesorDTO.getNombre()
					+ " Apellidos: " + profesorDTO.getApellidos() + " Passw: "
					+ profesorDTO.getPass() + " Id: " + profesorDTO.getID());
		}
		
	
		
		System.out.println("----------BUSCAR POR ID 2----------");
		System.out.println(gp.consultarPorID(2));
		/*
		System.out.println(gp.consultaLogin("Pepe", "123456"));
		System.out.println(gp.consultaLogin("Pepe", "lalala"));
		*/
		
		
	}
}
