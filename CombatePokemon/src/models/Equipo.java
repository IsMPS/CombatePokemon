package models;

import java.util.ArrayList;

public class Equipo {
	private ArrayList<Pokemon> equipo;

	public Equipo() {
		super();
		this.equipo = new ArrayList<Pokemon>(6);
	}
	
	public void meterPok(Pokemon pok) {
		this.equipo.add(pok);
	}
	
	public void mostrarPok() {
		for (Pokemon c : equipo) {
			c.getNombre();
		}
	}
	
	public Pokemon elegirPok() {
		for (Pokemon c : equipo) {
			if (c.getActualHP()>0) {
				return c;
			}
		}
		return equipo.get(0);
	}
	
}
