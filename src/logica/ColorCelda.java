package logica;
import java.util.Random;

public enum ColorCelda {
    ROJO,
    AZUL,
    VERDE,
    AMARILLO,
    NARANJA,
    ROSA,
    GRIS; 
	
	private static final Random RANDOM = new Random();
	
    public static ColorCelda obtenerColorAleatorio() {
        ColorCelda[] colores = {ROJO, AZUL, VERDE, AMARILLO, NARANJA, ROSA};
        return colores[RANDOM.nextInt(colores.length)];
    }
}