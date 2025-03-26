package logica;

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
	
}