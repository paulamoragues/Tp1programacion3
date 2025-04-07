package logica;

import java.util.Random;

public enum ColorCelda {
	ROJO, AZUL, VERDE, AMARILLO, NARANJA, ROSA, GRIS;

	public static ColorCelda obtenerColorAleatorio() {
		Random random = new Random();
		
		ColorCelda[] colores = { ROJO, AZUL, VERDE, AMARILLO, NARANJA, ROSA };
		return colores[random.nextInt(colores.length)];
	}
}