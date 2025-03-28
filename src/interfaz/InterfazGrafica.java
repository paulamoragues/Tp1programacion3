package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.Juego;

public class InterfazGrafica {
	private JFrame frame;
	private JButton[][] botones;
	private JLabel labelTurnos;
	private JLabel labelRecord;
	private int tamaño;
	private Juego juego;
	private String jugador;


	// Create the application.
	public InterfazGrafica(String jugador, int tamaño) {
		this.jugador = jugador;
		this.tamaño = tamaño;
		this.juego = new Juego(tamaño);
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame("Locura Cromática - Jugador: " + jugador);
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);// aparezca la ventana en el medio
		frame.setLayout(new BorderLayout());

		// Creo la matriz con los botones correspondientes
		JPanel panelGrilla = new JPanel(new GridLayout(tamaño, tamaño));
		botones = new JButton[tamaño][tamaño];

		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setBackground(Color.LIGHT_GRAY);
				final int fila = i;
				final int columna = j;

				// Le agrego la accion a los botones
				botones[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						juego.jugarTurno(fila, columna);
						actualizarGrilla();
						actualizarLabels();

						if (juego.estaCompleta()) {
							juego.actualizarRecord(jugador);
							new PantallaFinal(jugador, juego.getTurnos());
							frame.dispose(); // Cerrar la ventana actual
						}

					}
				});

				panelGrilla.add(botones[i][j]);
			}
		}

		JPanel panelInfo = new JPanel();
		labelTurnos = new JLabel("Turnos: 0");
		labelRecord = new JLabel("Récord: " + (juego.getRecord() == Integer.MAX_VALUE ? "-" : juego.getRecord()));
		panelInfo.add(labelTurnos);
		panelInfo.add(labelRecord);

		frame.add(panelGrilla, BorderLayout.CENTER);
		frame.add(panelInfo, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	// Necesario para mostrar los colores de las celdas
	private void actualizarGrilla() {
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				int color = juego.getColorCelda(i, j);
				botones[i][j].setBackground(obtenerColor(color));
			}
		}
	}

	private void actualizarLabels() {
		labelTurnos.setText("Turnos: " + juego.getTurnos());
		int record = juego.getRecord();
		labelRecord.setText("Récord: " + (record == Integer.MAX_VALUE ? "-" : record));
	}

	private Color obtenerColor(int valor) {
		Color[] colores = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.PINK };
		return valor == -1 ? Color.LIGHT_GRAY : colores[valor];
	}

}
