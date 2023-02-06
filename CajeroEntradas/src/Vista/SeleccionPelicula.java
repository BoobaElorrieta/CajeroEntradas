package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionPelicula extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPeliculasDisponiblesSeleccionPeliculas;
	private JButton btnAceptarSeleccionPeli;
	private JButton btnResumenDeCompraSeleccionPelicula;
	private JComboBox comboBoxSeleccionPeliculas;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SeleccionPelicula() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreSeleccionPeli = new JLabel("Cine Pepito");
		lblNombreSeleccionPeli.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNombreSeleccionPeli.setBounds(221, 26, 187, 50);
		contentPane.add(lblNombreSeleccionPeli);
		
		lblPeliculasDisponiblesSeleccionPeliculas = new JLabel("Peliculas Disponibles:");
		lblPeliculasDisponiblesSeleccionPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPeliculasDisponiblesSeleccionPeliculas.setBounds(27, 129, 221, 26);
		contentPane.add(lblPeliculasDisponiblesSeleccionPeliculas);
		
		comboBoxSeleccionPeliculas = new JComboBox();
		comboBoxSeleccionPeliculas.setBounds(27, 166, 221, 30);
		contentPane.add(comboBoxSeleccionPeliculas);
		
		btnAceptarSeleccionPeli = new JButton("Aceptar");
		btnAceptarSeleccionPeli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Horarios horario = new Horarios();
				horario.setVisible(true);
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnAceptarSeleccionPeli.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAceptarSeleccionPeli.setBounds(394, 127, 207, 82);
		contentPane.add(btnAceptarSeleccionPeli);
		
		btnResumenDeCompraSeleccionPelicula = new JButton("Resumen de Compra");
		btnResumenDeCompraSeleccionPelicula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnResumenDeCompraSeleccionPelicula.setBounds(394, 269, 207, 87);
		contentPane.add(btnResumenDeCompraSeleccionPelicula);
	}

}
