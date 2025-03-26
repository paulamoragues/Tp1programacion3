package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import logica.Juego;

public class InterfazGrafica {
	private JFrame frame;
	
	private JButton[][] botones;
	private static final int tamaño = 5;
	private Juego juego;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica window = new InterfazGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazGrafica() {
		juego = new Juego();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// creo la matriz con los botones correspondientes
		frame.setLayout(new GridLayout(tamaño, tamaño));
		botones = new JButton[tamaño][tamaño];
		
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setBackground(Color.LIGHT_GRAY);
				final int fila = i;
				final int columna = j;

				// le agrego la accion a los botones
				botones[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						juego.jugarTurno(fila, columna);
						actualizarGrilla();
					}
				});

				frame.add(botones[i][j]);
			}
		}
	}

	// necesario para mostrar los colores de las celdas
	private void actualizarGrilla() {
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				int color = juego.getColorCelda(i, j);
				botones[i][j].setBackground(obtenerColor(color));
			}
		}
	}

	// dado el num de la celda obtenes el color que le corresponde
	private Color obtenerColor(int valor) {
		Color[] colores = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.PINK };
		return valor == -1 ? Color.LIGHT_GRAY : colores[valor];
	}

}
