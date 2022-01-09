package main;

import java.util.Scanner;

import models.Combate;
import models.Entrenador;
import models.Equipo;
import models.Estado;
import models.Movimiento;
import models.Pokemon;
import models.TipoPoke;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pokemon P1E1 = new Pokemon(4, "Charmander", TipoPoke.Fuego, null, null, 52, 43, 60, 50, 65, null, 39, 6);
		Pokemon P2E1 = new Pokemon(1, "Bulbasur", TipoPoke.Planta, TipoPoke.Veneno, null, 49, 49, 65, 65, 45, null, 45, 6);
		Pokemon P1E2 = new Pokemon(7, "Squirtle", TipoPoke.Agua, null, null, 48, 65, 50, 64, 43, null, 44, 6);
		Pokemon P2E2 = new Pokemon(37, "Vulpix", TipoPoke.Fuego, null, null, 41, 40, 50, 65, 65, null, 38, 6);
		
		Movimiento Placaje = new Movimiento("Placaje", TipoPoke.Normal, 35, 35, 40, 0, 0, 0, 0, 0, null,0);
		Movimiento Ascuas = new Movimiento("Ascuas", TipoPoke.Fuego, 25, 25, 40, 0, 0, 0, 0, 0, Estado.Quemado,10);
		Movimiento Paralizador = new Movimiento("Paralizador", TipoPoke.Planta, 30, 30, 1, 0, 0, 0, 0, 0, Estado.Paralizado, 100);
		Movimiento PistolaAgua = new Movimiento("PistolaAgua", TipoPoke.Agua, 25, 25, 40, 0, 0, 0, 0, 0, null,0);
		
		P1E1.getMov().add(Placaje);
		P1E1.getMov().add(Ascuas);
		P2E1.getMov().add(Placaje);
		P2E1.getMov().add(Paralizador);
		P1E2.getMov().add(Placaje);
		P1E2.getMov().add(PistolaAgua);
		P2E2.getMov().add(Placaje);
		P2E2.getMov().add(Ascuas);
		
		Equipo EE1 = new Equipo();
		Equipo EE2 = new Equipo();
		EE1.meterPok(P1E1);
		EE1.meterPok(P2E1);
		EE2.meterPok(P1E2);
		EE2.meterPok(P2E2);
		
		Entrenador E1 = new Entrenador("Malo", EE1);
		Entrenador E2 = new Entrenador("Isa", EE2);
		
		Combate comb = new Combate(E1, E2, P1E1, P1E2);
		
		// Aquí comienza el juego
		boolean juego = false;
		do {
			//Empieza el más rápido
			System.out.println(comb.quienEmpiezaTurno().getNombre());
			comb.quienEmpiezaTurno().mostrarMov();
			System.out.println("Elige movimiento");
			String movi = sc.nextLine();
			comb.aplicarMov(comb.quienEmpiezaTurno().elegirMov(movi),comb.quienEmpiezaTurno());
			System.out.println();
			if(comb.getP1().getActualHP()==0) {
				comb.setP1(EE1.elegirPok());
			}
			if(comb.getP2().getActualHP()==0) {
				comb.setP2(EE2.elegirPok());
			}
			juego=comb.isFinished();
			//Le sigue el otro
			if(comb.getP1().equals(comb.quienEmpiezaTurno())) {
				System.out.println(comb.getP2().getNombre());
				comb.getP2().mostrarMov();
				System.out.println("Elige movimiento");
				movi = sc.nextLine();
				comb.aplicarMov(comb.getP2().elegirMov(movi),comb.getP2());
			}else if(comb.getP2().equals(comb.quienEmpiezaTurno())) {
				System.out.println(comb.getP1().getNombre());
				comb.getP1().mostrarMov();
				System.out.println("Elige movimiento");
				movi = sc.nextLine();
				comb.aplicarMov(comb.getP1().elegirMov(movi),comb.getP1());
			}
			
			// Para que se cambie el pokemon no se puede elegir
			if(comb.getP1().getActualHP()==0) {
				comb.setP1(EE1.elegirPok());
			}
			if(comb.getP2().getActualHP()==0) {
				comb.setP2(EE2.elegirPok());
			}
			
			// Si tienen todos 0 de vida debería acabar
			juego=comb.isFinished();
		}while(!juego);

		sc.close();
	}
}
