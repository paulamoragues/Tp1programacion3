package logica;
//esta clase es para probar el funcionamiento de la logica sin la interfaz
//provisorio 

import java.util.Scanner;

public class Juego {
	private Grilla grilla;
	private int turnos; // cantidad de turnos
	// record

	public Juego() {
		grilla = new Grilla();
		turnos = 0;
	}

	public void jugarTurno(int fila, int columna) {
		grilla.tocarCelda(fila, columna);
		turnos++;
	}

	// no va
	public void mostrarEstado() {
		grilla.mostrarGrilla();
	}
	
	public boolean estaCompleta() {
		return grilla.estaCompleta();
	}
	
	public int getTurnos() {
		return turnos;
	}

	// por ejemplo
	public static void main(String[] args) {
		Juego juego = new Juego();
		Scanner scanner = new Scanner(System.in);

		while (!juego.estaCompleta()) {
			juego.mostrarEstado();
			System.out.println("ingresa fila y columna entre 0 y 4: ");
			System.out.println("cantidad de turnos: " + juego.getTurnos());
			
			int fila = scanner.nextInt();
			int columna = scanner.nextInt();

			juego.jugarTurno(fila, columna);
		}

		System.out.println("felitaciones, ganaste");
	}
}