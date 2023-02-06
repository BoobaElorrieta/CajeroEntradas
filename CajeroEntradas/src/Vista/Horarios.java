package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Horarios extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Horarios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreHorario = new JLabel("Pelicula Seleccionada");
		lblNombreHorario.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNombreHorario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreHorario.setBounds(198, 11, 278, 47);
		contentPane.add(lblNombreHorario);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 99, 203, 29);
		contentPane.add(lblNewLabel);
	}

}
