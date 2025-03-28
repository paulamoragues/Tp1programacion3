package logica;
<<<<<<< HEAD
=======

>>>>>>> Felipe
import java.util.Random;

public class Celda {
	private int color;
	private static final int coloresPosibles = 6;
<<<<<<< HEAD
=======
	private static final Random rand = new Random();
>>>>>>> Felipe

	public Celda() {
		this.color = -1; // -1 significa sin color
	}

	public void cambiarColor() {
<<<<<<< HEAD
		Random rand = new Random();
=======
>>>>>>> Felipe
		this.color = rand.nextInt(coloresPosibles);
	}

	public void apagar() {
		this.color = -1;
	}
<<<<<<< HEAD
	
	public int getColor() {
		return color;
	}
	
=======

	public int getColor() {
		return color;
	}

>>>>>>> Felipe
}