package models;

public class Combate {
	private Entrenador e1;
	private Entrenador e2;
	private Pokemon p1;
	private Pokemon p2;
	
	public Pokemon getP1() {
		return p1;
	}

	public void setP1(Pokemon p1) {
		this.p1 = p1;
	}

	public Pokemon getP2() {
		return p2;
	}

	public void setP2(Pokemon p2) {
		this.p2 = p2;
	}

	public Entrenador getE1() {
		return e1;
	}

	public Entrenador getE2() {
		return e2;
	}

	public Pokemon quienEmpiezaTurno() {
		if(p1.getSpeed()>=p2.getSpeed()) {
			return p1;
		} else if(p2.getSpeed()>=p1.getSpeed()) {
			return p2;
		} else {
			return null;
		}
	
	}
	
	public Combate(Entrenador e1, Entrenador e2, Pokemon p1, Pokemon p2) {
		super();
		this.e1 = e1;
		this.e2 = e2;
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/**
	 * Se aplica el movimiento del pokemon que sea
	 * @param Movimiento
	 * @param Pokemon
	 */
	public void aplicarMov(Movimiento c,Pokemon p) {
		if(p.elegirMov(c).getActualPP()>0 && p.equals(p1)) {
			p2.setEstado(c.getAplicaEstado());
			p2.setActualHP((int) (p2.getActualHP()-(c.getDamage())*getEfectividad(c,p)));
			if(p2.getActualHP()<0) {
				p2.setActualHP(0);
			}
			System.out.println("Vida del "+p2.getNombre()+" "+p2.getActualHP());
			
		}else if(p.elegirMov(c).getActualPP()>0 && p.equals(p2)) {
			p1.setEstado(c.getAplicaEstado());
			p1.setActualHP((int) (p1.getActualHP()-(c.getDamage()*getEfectividad(c,p))));
			if(p1.getActualHP()<0) {
				p1.setActualHP(0);
			}
			System.out.println("Vida del "+p1.getNombre()+" "+p1.getActualHP());
		}
	}
	
	/**
	 * Si acaba o no
	 * @return true - Acabado  false - Sigue
	 */
	public boolean isFinished() {
		if(p1.getActualHP()==0 || p2.getActualHP()==0) {
			return true;
		} else {
			return false;
		}
	}
	
	// Solo coge el primer tipo 
	/**
	 * Para ataques más efectivos
	 * @param Movimiento
	 * @param Pokemon
	 * @return 
	 */
	public double getEfectividad(Movimiento c,Pokemon p) {
			if(c.getTipo().equals(TipoPoke.Agua) && p.getTipo1().equals(TipoPoke.Fuego)) {
				return 1.5;
			}else if(c.getTipo().equals(TipoPoke.Fuego) && p.getTipo1().equals(TipoPoke.Planta)) {
				return 1.5;
			} else if (c.getTipo().equals(TipoPoke.Fuego) && p.getTipo1().equals(TipoPoke.Agua)) {
				return 0.7;
			} else if (c.getTipo().equals(TipoPoke.Agua) && p.getTipo1().equals(TipoPoke.Planta)) {
				return 0.7;
			}else {
				return 1;
			}
		}
}

