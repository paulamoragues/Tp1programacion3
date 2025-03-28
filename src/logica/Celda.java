package logica;

import java.util.Random;

public class Celda {
	private int color;
	private static final int coloresPosibles = 6;

	private static final Random rand = new Random();

	public Celda() {
		this.color = -1; // -1 significa sin color
	}

	public void cambiarColor() {
		Random rand = new Random();
		this.color = rand.nextInt(coloresPosibles);
	}

	public void apagar() {
		this.color = -1;
	}

	public int getColor(){
		return color;
	}

}