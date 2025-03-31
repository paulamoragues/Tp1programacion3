package logica;

public class Celda {
	private ColorCelda color;

	public Celda() {
		this.color = ColorCelda.GRIS; 
	}

	public void cambiarColor() {
		this.color = ColorCelda.obtenerColorAleatorio();
	}

	public void apagar() {
		this.color = ColorCelda.GRIS;
	}

	public ColorCelda getColor() {
		return color;
	}

}