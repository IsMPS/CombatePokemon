package models;

import java.util.ArrayList;

public class Pokemon {
	private int numero;
	private String nombre;
	private TipoPoke tipo1;
	private TipoPoke tipo2;
	private Estado estado;
	private int attack;
	private int def;
	private int specialAttack;
	private int specialDef;
	private int speed;
	private ArrayList<Movimiento> Mov;
	private int maxHP;
	private int actualHP;
	private int lvl;
	
	public Pokemon(int numero, String nombre, TipoPoke tipo1, TipoPoke tipo2, Estado estado, int attack, int def,
			int specialAttack, int specialDef, int speed, ArrayList<Movimiento> mov, int maxHP, int lvl) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.estado = estado;
		this.attack =5+((attack*2));
		this.def = 5+((def*2));
		this.specialAttack = 5+((specialAttack*2));
		this.specialDef = 5+((specialDef*2));
		this.speed = 5+((speed*2));
		this.Mov = new ArrayList<Movimiento>(4);
		this.lvl = lvl;
		// Paso de añadirle los PE y los IV
		this.maxHP = 10+((maxHP*2)+lvl); 
		this.actualHP= 10+((maxHP*2)+lvl);	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public ArrayList<Movimiento> getMov() {
		return Mov;
	}

	public void setMov(ArrayList<Movimiento> mov) {
		Mov = mov;
	}

	public int getNumero() {
		return numero;
	}

	public TipoPoke getTipo1() {
		return tipo1;
	}

	public TipoPoke getTipo2() {
		return tipo2;
	}

	public int getAttack() {
		return attack;
	}

	public int getDef() {
		return def;
	}

	public int getSpecialAttack() {
		return specialAttack;
	}

	public int getSpecialDef() {
		return specialDef;
	}

	public int getSpeed() {
		return speed;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getActualHP() {
		return actualHP;
	}

	public void setActualHP(int actualHP) {
		this.actualHP = actualHP;
	}

	public int getLvl() {
		return lvl;
	}

	public Movimiento elegirMov(String nm) {
		for (Movimiento c : Mov) {
			if (c.getNombre().equals(nm)) {
				return c;
			}
		}
		return null;
	}
	
	public Movimiento elegirMov(Movimiento m) {
		for (Movimiento c : Mov) {
			if (c.equals(m)) {
				return c;
			}
		}
		return null;
	}
	
	public void mostrarMov() {
		for (Movimiento c : Mov) {
			System.out.println(c.getNombre());
		}
	}
	
}
