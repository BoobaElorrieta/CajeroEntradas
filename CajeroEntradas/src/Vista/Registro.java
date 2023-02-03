package Vista;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Registro extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAceptarRegistro;
	private JTextField textFieldApellidosRegistro;
	private JTextField textFieldContrasenaRegistro;
	private JTextField textFieldDNIRegistro;
	private JTextField textFieldDireccionRegistro;
	private JTextField textFieldTelefonoRegistro;
	private JTextField textFieldEMailRegistro;
	private JLabel lblNombreRegistro;
	private JRadioButton rdbtnHombreRegistro;
	private JRadioButton rdbtnMujerRegistro;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Registro de usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(197, 24, 215, 31);
		contentPane.add(lblNewLabel_1);
		
		lblNombreRegistro = new JLabel("Nombre:");
		lblNombreRegistro.setBounds(37, 103, 75, 14);
		contentPane.add(lblNombreRegistro);
		
		JLabel lblApellidosRegistro = new JLabel("Apellidos:");
		lblApellidosRegistro.setBounds(32, 160, 110, 14);
		contentPane.add(lblApellidosRegistro);
		
		JLabel lblContrasenaRegistro = new JLabel("Contraseña:");
		lblContrasenaRegistro.setBounds(32, 215, 205, 14);
		contentPane.add(lblContrasenaRegistro);
		
		JLabel lblDNIRegistro = new JLabel("DNI:");
		lblDNIRegistro.setBounds(37, 274, 89, 14);
		contentPane.add(lblDNIRegistro);
		
		JTextField textFieldNombreRegistro = new JTextField();
		textFieldNombreRegistro.setColumns(10);
		textFieldNombreRegistro.setBounds(122, 103, 149, 20);
		contentPane.add(textFieldNombreRegistro);
		
		JLabel lblDireccionRegistro = new JLabel("Dirección:");
		lblDireccionRegistro.setBounds(365, 103, 110, 14);
		contentPane.add(lblDireccionRegistro);
		
		JLabel lblSexoRegistro = new JLabel("Sexo:");
		lblSexoRegistro.setBounds(365, 160, 68, 14);
		contentPane.add(lblSexoRegistro);
		
		btnAceptarRegistro = new JButton("Aceptar");
		btnAceptarRegistro.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAceptarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnAceptarRegistro.setBounds(78, 346, 186, 42);
		contentPane.add(btnAceptarRegistro);
		
		textFieldApellidosRegistro = new JTextField();
		textFieldApellidosRegistro.setColumns(10);
		textFieldApellidosRegistro.setBounds(122, 157, 149, 20);
		contentPane.add(textFieldApellidosRegistro);
		
		textFieldContrasenaRegistro = new JTextField();
		textFieldContrasenaRegistro.setColumns(10);
		textFieldContrasenaRegistro.setBounds(122, 212, 149, 20);
		contentPane.add(textFieldContrasenaRegistro);
		
		textFieldDNIRegistro = new JTextField();
		textFieldDNIRegistro.setColumns(10);
		textFieldDNIRegistro.setBounds(122, 271, 149, 20);
		contentPane.add(textFieldDNIRegistro);
		
		JLabel lblTelefonoRegistro = new JLabel("Teléfono:");
		lblTelefonoRegistro.setBounds(365, 215, 129, 14);
		contentPane.add(lblTelefonoRegistro);
		
		JLabel lblEMailRegistro = new JLabel("E-Mail:");
		lblEMailRegistro.setBounds(366, 274, 109, 14);
		contentPane.add(lblEMailRegistro);
		
		textFieldDireccionRegistro = new JTextField();
		textFieldDireccionRegistro.setColumns(10);
		textFieldDireccionRegistro.setBounds(446, 100, 149, 20);
		contentPane.add(textFieldDireccionRegistro);
		
		textFieldTelefonoRegistro = new JTextField();
		textFieldTelefonoRegistro.setColumns(10);
		textFieldTelefonoRegistro.setBounds(446, 212, 149, 20);
		contentPane.add(textFieldTelefonoRegistro);
		
		textFieldEMailRegistro = new JTextField();
		textFieldEMailRegistro.setColumns(10);
		textFieldEMailRegistro.setBounds(446, 271, 149, 20);
		contentPane.add(textFieldEMailRegistro);
		
		rdbtnHombreRegistro = new JRadioButton("Hombre");
		rdbtnHombreRegistro.setBounds(446, 156, 89, 23);
		contentPane.add(rdbtnHombreRegistro);
		
		rdbtnMujerRegistro = new JRadioButton("Mujer");
		rdbtnMujerRegistro.setBounds(540, 156, 89, 23);
		contentPane.add(rdbtnMujerRegistro);
		
		JButton btnCancelarRegistro = new JButton("Cancelar");
		btnCancelarRegistro.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCancelarRegistro.setBounds(388, 346, 186, 42);
		contentPane.add(btnCancelarRegistro);
	}
}
