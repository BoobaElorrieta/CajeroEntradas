package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Horarios extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JLabel lblNombreHorario;
	private JLabel lblHorasDisponiblesHorario;
	private JComboBox comboBoxHorasHorario;
	private JButton btnAceptarHorario;
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
		
		lblNombreHorario = new JLabel("Pelicula Seleccionada");
		lblNombreHorario.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNombreHorario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreHorario.setBounds(198, 11, 278, 47);
		contentPane.add(lblNombreHorario);
		
		lblHorasDisponiblesHorario = new JLabel("Horarios Diponibles de la Pelicula:");
		lblHorasDisponiblesHorario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHorasDisponiblesHorario.setBounds(36, 106, 254, 29);
		contentPane.add(lblHorasDisponiblesHorario);
		
		comboBoxHorasHorario = new JComboBox();
		comboBoxHorasHorario.setBounds(36, 169, 247, 29);
		contentPane.add(comboBoxHorasHorario);
		
		btnAceptarHorario = new JButton("Aceptar");
		btnAceptarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  JOptionPane.showMessageDialog(null, "Mensaje de Comfirmacion", "Has seleccionado la película … el día … a las … en la sala … por el precio de …", 1);
				  contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnAceptarHorario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAceptarHorario.setBounds(407, 311, 219, 84);
		contentPane.add(btnAceptarHorario);
	}

}
