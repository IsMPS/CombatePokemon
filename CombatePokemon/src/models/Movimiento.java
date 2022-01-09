package models;

public class Movimiento {
	private String nombre;
	private TipoPoke tipo;
	private int maxPP;
	private int actualPP;
	private int damage;
	private int cambiaAttack;
	private int cambiaDef;
	private int cambiaSpAttack;
	private int cambiaSpDef;
	private int cambiaSpeed;
	private Estado aplicaEstado;
	private int prob;
	
	public Movimiento(String nombre, TipoPoke tipo, int maxPP, int actualPP, int damage, int cambiaAttack,
			int cambiaDef, int cambiaSpAttack, int cambiaSpDef, int cambiaSpeed, Estado aplicaEstado, int prob) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.maxPP = maxPP;
		this.actualPP = actualPP;
		this.damage = damage;
		this.cambiaAttack = cambiaAttack;
		this.cambiaDef = cambiaDef;
		this.cambiaSpAttack = cambiaSpAttack;
		this.cambiaSpDef = cambiaSpDef;
		this.cambiaSpeed = cambiaSpeed;
		this.aplicaEstado = aplicaEstado;
		this.prob = prob;
	}
	
	public String getNombre() {
		return nombre;
	}
	public TipoPoke getTipo() {
		return tipo;
	}
	public int getMaxPP() {
		return maxPP;
	}
	public int getActualPP() {
		return actualPP;
	}
	public int getDamage() {
		return damage;
	}
	public int getCambiaAttack() {
		return cambiaAttack;
	}
	public int getCambiaDef() {
		return cambiaDef;
	}
	public int getCambiaSpAttack() {
		return cambiaSpAttack;
	}
	public int getCambiaSpDef() {
		return cambiaSpDef;
	}
	public int getCambiaSpeed() {
		return cambiaSpeed;
	}
	
	public Estado getAplicaEstado() {
		if(prob>=Math.random()*100) {
			System.out.println("El estado "+aplicaEstado+" ha sido aplicado");
			return aplicaEstado;
		}
		return null;
	}
	
	
}
