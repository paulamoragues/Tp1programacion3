package logica;

public class Juego {
	private Grilla grilla;
<<<<<<< HEAD
	private int turnos; // cantidad de turnos
	// record

	public Juego() {
		grilla = new Grilla();
=======
	private int turnos;

	private static int record = Integer.MAX_VALUE; // Static para que no se reinicie
	private static String nombreRecord = ""; // Static para que no se reinicie

	public Juego(int tamaño) {
		grilla = new Grilla(tamaño);
>>>>>>> Felipe
		turnos = 0;
	}

	public void jugarTurno(int fila, int columna) {
		grilla.tocarCelda(fila, columna);
		turnos++;
	}
<<<<<<< HEAD
	
	public boolean estaCompleta() {
		return grilla.estaCompleta();
	}
	
	public int getTurnos() {
		return turnos;
	}
	
	// ???
	public int getColorCelda(int fila, int columna) {
        return grilla.getColorCelda(fila, columna);
    }
	
=======

	public boolean estaCompleta() {
		return grilla.estaCompleta();
	}

	public int getTurnos() {
		return turnos;
	}

	public static int getRecord() {
		return record;
	}

	public static String getNombreRecord() {
		return nombreRecord;
	}

	public void actualizarRecord(String nombreJugador) {
		if (estaCompleta() && turnos < record) {
			record = turnos;
			nombreRecord = nombreJugador;
		}
	}

	public int getColorCelda(int fila, int columna) {
		return grilla.getColorCelda(fila, columna);
	}

>>>>>>> Felipe
}