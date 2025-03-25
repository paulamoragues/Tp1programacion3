package interfaz;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;

import logica.Juego;

public class InterfazGrafica {

	private JFrame frame;
	private Juego juego;
	
	private JButton[][] botones;
	private static final int tamaño = 5; // tamaño de la grilla

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}