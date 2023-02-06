package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionCine extends JFrame {

	private JPanel contentPaneSeleccionCine;
	private static final long serialVersionUID = 1L;
	private JComboBox comboBoxSeleccionSeleccionCine;
	private JButton btnAceptarSeleccionCine;
	private JButton btnFinalizarSesionSeleccionCine;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public SeleccionCine() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 460);
		contentPaneSeleccionCine = new JPanel();
		contentPaneSeleccionCine.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneSeleccionCine);
		contentPaneSeleccionCine.setLayout(null);
		
		comboBoxSeleccionSeleccionCine = new JComboBox<String>();
		comboBoxSeleccionSeleccionCine.setToolTipText("Selecciona el cine");
		comboBoxSeleccionSeleccionCine.setBounds(52, 77, 216, 34);
		contentPaneSeleccionCine.add(comboBoxSeleccionSeleccionCine);
		
		btnAceptarSeleccionCine = new JButton("Aceptar");
		btnAceptarSeleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeleccionPelicula seleccionPelicula = new SeleccionPelicula();
				seleccionPelicula.setVisible(true);
				contentPaneSeleccionCine.getParent().getParent().getParent().setVisible(false);
				
			}
		});
		btnAceptarSeleccionCine.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAceptarSeleccionCine.setBounds(52, 293, 216, 88);
		contentPaneSeleccionCine.add(btnAceptarSeleccionCine);
		
		btnFinalizarSesionSeleccionCine = new JButton("Finalizar Sesion");
		btnFinalizarSesionSeleccionCine.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnFinalizarSesionSeleccionCine.setBounds(396, 293, 216, 88);
		contentPaneSeleccionCine.add(btnFinalizarSesionSeleccionCine);
	}
}
