package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class CajeroEntradas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CajeroEntradas window = new CajeroEntradas();
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
	public CajeroEntradas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 688, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel RegistroPanel = new JPanel();
		RegistroPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(RegistroPanel);
		RegistroPanel.setLayout(null);
		
		JLabel RegistroLbl = new JLabel("Registro De Usuario");
		RegistroLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		RegistroLbl.setBounds(152, 11, 350, 49);
		RegistroPanel.add(RegistroLbl);
		
		JLabel RegistroLblNombre = new JLabel("Nombre:");
		RegistroLblNombre.setBounds(53, 91, 143, 14);
		RegistroPanel.add(RegistroLblNombre);
		
		JLabel RegistroLblApellidos = new JLabel("Apellidos:");
		RegistroLblApellidos.setBounds(53, 128, 143, 14);
		RegistroPanel.add(RegistroLblApellidos);
		
		JLabel RegistroLblContraseña = new JLabel("Contraseña:");
		RegistroLblContraseña.setBounds(53, 169, 143, 14);
		RegistroPanel.add(RegistroLblContraseña);
		
		JLabel RegistroLblDni = new JLabel("DNI:");
		RegistroLblDni.setBounds(53, 216, 143, 14);
		RegistroPanel.add(RegistroLblDni);
		
		JLabel RegistroLblDireccion = new JLabel("Direccion:");
		RegistroLblDireccion.setBounds(371, 91, 143, 14);
		RegistroPanel.add(RegistroLblDireccion);
		
		JLabel RegistroLabel = new JLabel("New label");
		RegistroLabel.setBounds(371, 128, 143, 14);
		RegistroPanel.add(RegistroLabel);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setBounds(371, 169, 143, 14);
		RegistroPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setBounds(371, 216, 143, 14);
		RegistroPanel.add(lblNewLabel_3_1);
		
		JPanel InicioPanel = new JPanel();
		InicioPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(InicioPanel);
		InicioPanel.setLayout(null);
		
		JLabel InicioLbl = new JLabel("BOOBA");
		InicioLbl.setFont(new Font("Tahoma", Font.PLAIN, 50));
		InicioLbl.setBounds(71, 36, 158, 101);
		InicioPanel.add(InicioLbl);
		
		JLabel InicioLblCompra = new JLabel("Compra de Entradas");
		InicioLblCompra.setBounds(71, 229, 120, 36);
		InicioPanel.add(InicioLblCompra);
		
		JButton InicioBtnIniciar = new JButton("Iniciar");
		InicioBtnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 40));
		InicioBtnIniciar.setBounds(327, 218, 296, 99);
		InicioPanel.add(InicioBtnIniciar);
		
		JButton InicioBtnRegistrar = new JButton("Regístrate!");
		InicioBtnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		InicioBtnRegistrar.setBounds(415, 25, 225, 36);
		InicioPanel.add(InicioBtnRegistrar);
	}
}
