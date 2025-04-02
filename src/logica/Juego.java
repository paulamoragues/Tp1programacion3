package logica;

public class Juego {
	private Grilla grilla;
	private int turnos;

	private static int record = Integer.MAX_VALUE; // Static para que no se reinicie
	private static String nombreRecord = ""; // Static para que no se reinicie

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

	public ColorCelda getColorCelda(int fila, int columna) {
		return grilla.getColorCelda(fila, columna);
	}
	
	// te devuelve la mejor celda, osea, la que tiene menos vecinos pintados
	public int[] sugerirCelda() {
	    int minVecinosColoreados = Integer.MAX_VALUE;
	    int[] mejorCelda = null;

	    for (int i = 0; i < grilla.getTamaño(); i++) {
	        for (int j = 0; j < grilla.getTamaño(); j++) {
	            if (grilla.getColorCelda(i, j) == ColorCelda.GRIS) {
	                int vecinosColoreados = grilla.contarVecinosColoreados(i, j);

	                if (vecinosColoreados < minVecinosColoreados) {
	                    minVecinosColoreados = vecinosColoreados;
	                    mejorCelda = new int[]{i, j};
	                }
	            }
	        }
	    }

	    return mejorCelda; 
	}


}