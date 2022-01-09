package models;

import java.util.ArrayList;

public class Entrenador {
	private String nombre;
	private Equipo equipo;

	public Entrenador(String nombre, Equipo equipo) {
		super();
		this.nombre = nombre;
		this.equipo = equipo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
