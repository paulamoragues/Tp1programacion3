package logica;

public class Juego {
	private Grilla grilla;
	private int turnos;
	private int record = Integer.MAX_VALUE;
	

	public Juego(int tamaño) {
        grilla = new Grilla(tamaño);
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
	
	public int getRecord() {
	    return record;
	}
	
	public void actualizarRecord() {
	    if (estaCompleta() && turnos < record) {
	        record = turnos;
	    }
	}
	
	// ???
	public int getColorCelda(int fila, int columna) {
        return grilla.getColorCelda(fila, columna);
    }
	
}