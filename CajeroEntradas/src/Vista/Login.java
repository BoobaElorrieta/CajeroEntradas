package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private static final long SerialVersionUID = 1L;
	private JTextField textField_1;
	private JTextField textField;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLogin.setBounds(291, 11, 56, 41);
		contentPane.add(lblLogin);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(180, 107, 56, 30);
		contentPane.add(lblEmail);
		
		JLabel lblContrasena = new JLabel("Contraseña: ");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblContrasena.setBounds(141, 183, 95, 30);
		contentPane.add(lblContrasena);
		
		textField = new JTextField();
		textField.setBounds(246, 108, 203, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(246, 184, 203, 29);
		contentPane.add(textField_1);
		
		btnAceptar = new JButton("Aceptar y guardar ticket");
		btnAceptar.setBounds(98, 280, 203, 67);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(364, 280, 203, 67);
		contentPane.add(btnCancelar);
	}
}
