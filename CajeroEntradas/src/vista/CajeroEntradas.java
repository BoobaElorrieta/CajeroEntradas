package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class CajeroEntradas {

	private JFrame frame;
	private JTextField RegistroTfNombre;
	private JTextField RegistroTfApellidos;
	private JTextField RegistroTfDNI;
	private JTextField RegistroTfEmail;
	private JTextField RegistroTfContrasena;
	private JTextField RegistroTfTfno;
	private JTextField RegistroTfDireccion;

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
		
		JPanel SeleccionCinePanel = new JPanel();
		SeleccionCinePanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(SeleccionCinePanel);
		SeleccionCinePanel.setLayout(null);
		
		JComboBox ScCbSeleccionCine = new JComboBox();
		ScCbSeleccionCine.setBounds(54, 110, 239, 30);
		SeleccionCinePanel.add(ScCbSeleccionCine);
		
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
		
		JPanel RegistroPanel = new JPanel();
		RegistroPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(RegistroPanel);
		RegistroPanel.setLayout(null);
		
		JLabel RegistroLbl = new JLabel("Registro De Usuario");
		RegistroLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		RegistroLbl.setBounds(152, 11, 350, 49);
		RegistroPanel.add(RegistroLbl);
		
		JLabel RegistroLblNombre = new JLabel("Nombre:");
		RegistroLblNombre.setBounds(61, 91, 50, 14);
		RegistroPanel.add(RegistroLblNombre);
		
		JLabel RegistroLblApellidos = new JLabel("Apellidos:");
		RegistroLblApellidos.setBounds(61, 128, 78, 14);
		RegistroPanel.add(RegistroLblApellidos);
		
		JLabel RegistroLblContraseña = new JLabel("Contraseña:");
		RegistroLblContraseña.setBounds(371, 128, 71, 14);
		RegistroPanel.add(RegistroLblContraseña);
		
		JLabel RegistroLblDni = new JLabel("DNI:");
		RegistroLblDni.setBounds(61, 169, 65, 14);
		RegistroPanel.add(RegistroLblDni);
		
		JLabel RegistroLblDireccion = new JLabel("Dirección:");
		RegistroLblDireccion.setBounds(371, 212, 71, 14);
		RegistroPanel.add(RegistroLblDireccion);
		
		JLabel RegistroLblSexo = new JLabel("Sexo:");
		RegistroLblSexo.setBounds(61, 212, 59, 14);
		RegistroPanel.add(RegistroLblSexo);
		
		JLabel RegistroLblTfno = new JLabel("Teléfono:");
		RegistroLblTfno.setBounds(371, 169, 65, 14);
		RegistroPanel.add(RegistroLblTfno);
		
		JLabel RegistroLblEmail = new JLabel("E-Mail:");
		RegistroLblEmail.setBounds(371, 91, 65, 14);
		RegistroPanel.add(RegistroLblEmail);
		
		RegistroTfNombre = new JTextField();
		RegistroTfNombre.setBounds(141, 89, 136, 17);
		RegistroPanel.add(RegistroTfNombre);
		RegistroTfNombre.setColumns(10);
		
		RegistroTfApellidos = new JTextField();
		RegistroTfApellidos.setColumns(10);
		RegistroTfApellidos.setBounds(141, 125, 136, 17);
		RegistroPanel.add(RegistroTfApellidos);
		
		RegistroTfDNI = new JTextField();
		RegistroTfDNI.setColumns(10);
		RegistroTfDNI.setBounds(141, 166, 136, 17);
		RegistroPanel.add(RegistroTfDNI);
		
		RegistroTfEmail = new JTextField();
		RegistroTfEmail.setColumns(10);
		RegistroTfEmail.setBounds(444, 88, 136, 17);
		RegistroPanel.add(RegistroTfEmail);
		
		RegistroTfContrasena = new JTextField();
		RegistroTfContrasena.setColumns(10);
		RegistroTfContrasena.setBounds(444, 125, 136, 17);
		RegistroPanel.add(RegistroTfContrasena);
		
		RegistroTfTfno = new JTextField();
		RegistroTfTfno.setColumns(10);
		RegistroTfTfno.setBounds(444, 166, 136, 17);
		RegistroPanel.add(RegistroTfTfno);
		
		RegistroTfDireccion = new JTextField();
		RegistroTfDireccion.setColumns(10);
		RegistroTfDireccion.setBounds(444, 209, 136, 17);
		RegistroPanel.add(RegistroTfDireccion);
		
		JComboBox RegistroCBSexo = new JComboBox();
		RegistroCBSexo.setToolTipText("Seleccione su Sexo");
		RegistroCBSexo.setMaximumRowCount(3);
		RegistroCBSexo.setBounds(141, 208, 136, 18);
		RegistroPanel.add(RegistroCBSexo);
		
		JButton RegistroBtnAceptar = new JButton("Aceptar");
		RegistroBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		RegistroBtnAceptar.setBounds(119, 259, 158, 49);
		RegistroPanel.add(RegistroBtnAceptar);
		
		JButton RegistroBtnCancelar = new JButton("Cancelar");
		RegistroBtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		RegistroBtnCancelar.setBounds(422, 259, 158, 49);
		RegistroPanel.add(RegistroBtnCancelar);
	}
}
