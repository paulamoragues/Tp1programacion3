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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import logica.ColorCelda;
import logica.Juego;
import java.awt.Font;

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
		frame.getContentPane().setBackground(new Color(45, 45, 47));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);// aparezca la ventana en el medio
		frame.getContentPane().setLayout(new BorderLayout());

		// Creo la matriz con los botones correspondientes
		JPanel panelGrilla = new JPanel(new GridLayout(tamaño, tamaño));
		
		//Esto es simplemente para poder usar el Design no le den bola
		if (tamaño <= 0) {	
		    throw new IllegalArgumentException("El tamaño de la grilla debe ser mayor que 0");
		}else {
			
			botones = new JButton[tamaño][tamaño];

		}
		
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
		panelInfo.setBackground(new Color(45, 45, 47));
		labelTurnos = new JLabel("Turnos: 0");
		labelTurnos.setFont(new Font("Arial", Font.BOLD, 13));
		labelTurnos.setForeground(new Color(255, 255, 255));
		labelRecord = new JLabel("Récord: " + (juego.getRecord() == Integer.MAX_VALUE ? "-" : juego.getRecord()));
		labelRecord.setFont(new Font("Arial", Font.BOLD, 13));
		labelRecord.setForeground(new Color(255, 255, 255));
		panelInfo.add(labelTurnos);
		panelInfo.add(labelRecord);

		frame.getContentPane().add(panelGrilla, BorderLayout.CENTER);
		frame.getContentPane().add(panelInfo, BorderLayout.SOUTH);
		
		
		// sugerir celda
		JButton btnSugerir = new JButton("Sugerir");
		btnSugerir.setFont(new Font("Arial", Font.BOLD, 13));
		btnSugerir.setBackground(new Color(255, 200, 0));
		btnSugerir.addActionListener(e -> sugerirJugada());

		panelInfo.add(btnSugerir);

		frame.setVisible(true);
	}

	// Actualizar la interfaz
	private void actualizarGrilla() {
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				ColorCelda color = juego.getColorCelda(i, j);
				botones[i][j].setBackground(obtenerColor(color));
			}
		}
	}

	private void actualizarLabels() {
		labelTurnos.setText("Turnos: " + juego.getTurnos());
		int record = juego.getRecord();
		labelRecord.setText("Récord: " + (record == Integer.MAX_VALUE ? "-" : record));
	}

	private Color obtenerColor(ColorCelda colorCelda) {
	    switch (colorCelda) {
	        case ROJO:
	            return Color.RED;
	        case AZUL:
	            return Color.BLUE;
	        case VERDE:
	            return Color.GREEN;
	        case AMARILLO:
	            return Color.YELLOW;
	        case NARANJA:
	            return Color.ORANGE;
	        case ROSA:
	            return Color.PINK;
	        default:
	            return Color.LIGHT_GRAY;
	    }
	}
	
	// sugerir celda
	private void sugerirJugada() {
	    int[] sugerencia = juego.sugerirCelda();
	    if (sugerencia != null) {
	        int fila = sugerencia[0];
	        int columna = sugerencia[1];
	        botones[fila][columna].setBackground(Color.DARK_GRAY); // color de la celda sugerida
	    } else {
	        JOptionPane.showMessageDialog(frame, "No hay jugadas recomendadas.");
	    }
	}

}