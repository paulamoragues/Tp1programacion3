package interfaz;

import javax.swing.*;

import logica.Juego;

import java.awt.*;

public class PantallaFinal {
	private JFrame frame;
	private JLabel labelTurnos;
	private JLabel labelRecord;

	public PantallaFinal(String jugador, int turnos) {// le paso el jugadro y la cantidad de turnos
		frame = new JFrame("Locura Cromática - ¡GANASTE!");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);// aparezca la ventana en el medio
		frame.getContentPane().setLayout(null);

		// GANASTE
		JLabel labelVictoria = new JLabel("¡Felicidades " + jugador + " Ganaste!");
		labelVictoria.setFont(new Font("Arial", Font.BOLD, 20));
		labelVictoria.setBounds(73, 96, 363, 43);
		frame.getContentPane().add(labelVictoria);

		// Turnos
		labelTurnos = new JLabel("Cantidad de Turnos: " + turnos);
		labelTurnos.setBounds(116, 150, 250, 25);
		frame.getContentPane().add(labelTurnos);

		// Record
		labelRecord = new JLabel("El Record es de " + Juego.getNombreRecord() + " con " + Juego.getRecord() + " turnos");
		labelRecord.setBounds(116, 270, 320, 25);
		frame.getContentPane().add(labelRecord);

		// Boton para cerrar
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(186, 366, 100, 30);
		btnCerrar.addActionListener(e -> frame.dispose()); // Cerrar la ventana actual
		frame.getContentPane().add(btnCerrar);

		// Boton para reiniciar
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(186, 325, 100, 30);
		btnReiniciar.addActionListener(e -> reiniciarJuego()); // Llamo al metodo reiniciarJuego
		frame.getContentPane().add(btnReiniciar);

		frame.setVisible(true);
	}

	private void reiniciarJuego() {
		frame.dispose(); // Cierra la ventana actual
		new PantallaInicial();
	}
}
