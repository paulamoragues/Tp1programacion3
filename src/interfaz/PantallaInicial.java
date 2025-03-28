package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicial {
	private JFrame frame;
	private JTextField nombreField;
	private JComboBox<String> dificultadComboBox;
	private JButton btnConfirmar;

	public PantallaInicial() {
		frame = new JFrame("Locura Cromática - Pantalla Inicial");
		frame.getContentPane().setBackground(new Color(45, 45, 47));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);// aparezca la ventana en el medio
		frame.getContentPane().setLayout(null);

		// Texto Bienvenida
		JLabel labelBienvenida = new JLabel("LOCURA CROMATICA");
		labelBienvenida.setForeground(new Color(255, 255, 255));
		labelBienvenida.setFont(new Font("Arial", Font.BOLD, 26));
		labelBienvenida.setBounds(89, 88, 299, 41);
		frame.getContentPane().add(labelBienvenida);

		// Label y campo de nombre
		JLabel labelNombre = new JLabel("Ingrese un nombre:");
		labelNombre.setForeground(new Color(255, 255, 255));
		labelNombre.setFont(new Font("Arial", Font.PLAIN, 18));
		labelNombre.setBounds(30, 154, 192, 25);
		frame.getContentPane().add(labelNombre);

		nombreField = new JTextField();
		nombreField.setBounds(206, 154, 200, 25);
		frame.getContentPane().add(nombreField);

		
		// Label y ComboBox para dificultad
		JLabel dificultadLabel = new JLabel("Elija la dificultad:");
		dificultadLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		dificultadLabel.setForeground(new Color(255, 255, 255));
		dificultadLabel.setBounds(30, 207, 144, 25);
		frame.getContentPane().add(dificultadLabel);

		String[] opciones = { "3x3", "5x5", "8x8" };
		dificultadComboBox = new JComboBox<>(opciones);
		dificultadComboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		dificultadComboBox.setBounds(206, 207, 100, 25);
		frame.getContentPane().add(dificultadComboBox);

		// Botón "Iniciar Juego"
		btnConfirmar = new JButton("Iniciar Juego");
		btnConfirmar.setForeground(new Color(0, 0, 0));
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConfirmar.setBackground(new Color(46, 239, 24));
		btnConfirmar.setBounds(142, 314, 200, 77);
		btnConfirmar.addActionListener(e -> iniciarJuego());
		frame.getContentPane().add(btnConfirmar);
		

		frame.setVisible(true);
	}

	private void iniciarJuego() {
		// Obtengo el nombre del jugador, si esta vacio le pido que ingrese un nombre
		String jugador = nombreField.getText().trim();
		if (jugador.isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Por favor, ingrese un nombre");
			return;
		}

		// Obtengo la dificultad seleccionada
		int tamaño = 0;
		String seleccion = (String) dificultadComboBox.getSelectedItem();
		if (seleccion.equals("3x3")) {
			tamaño = 3;
		} else if (seleccion.equals("5x5")) {
			tamaño = 5;
		} else if (seleccion.equals("8x8")) {
			tamaño = 8;
		}

		frame.dispose(); // Cerrar la ventana actual
		InterfazGrafica juego = new InterfazGrafica(jugador, tamaño); // Creo la interfazGrafica del juego y despues la											
	}
}