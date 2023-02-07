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
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class CajeroEntradas {

	private JFrame frame;
	private JTextField RegistroTfNombre;
	private JTextField RegistroTfApellidos;
	private JTextField RegistroTfDNI;
	private JTextField RegistroTfEmail;
	private JTextField RegistroTfContrasena;
	private JTextField RegistroTfTfno;
	private JTextField RegistroTfDireccion;
	private JButton ScBtnFinalizarSesion;
	private JButton ScBtnAceptar;
	public JComboBox ScCbSeleccionCine;
	private JButton InicioBtnIniciar;
	private JButton InicioBtnRegistrar;
	private JComboBox RegistroCbSexo;
	private JButton RegistroBtnAceptar;
	private JButton RegistroBtnCancelar;
	private JButton SpBtnResumenDeCompra;
	private JComboBox SpCbSeleccionPeli;
	private JButton SpBtnAceptar;
	private JButton HorariosBtnAceptar;
	private JComboBox HorariosCbHorariosDisponibles;
	private JButton HorariosBtnCancelar;
	private JTextArea rcTaEntradasSeleccionadas;
	private JTextArea rcTaPrecioTotal;
	private JButton rcBtnAceptar;
	private JButton rcBtnCancelar;
	private JTextField loginTfEmail;
	private JTextField loginTfContrasena;

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
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel loginLbl = new JLabel("Login");
		loginLbl.setHorizontalAlignment(SwingConstants.CENTER);
		loginLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		loginLbl.setBounds(220, 11, 263, 49);
		loginPanel.add(loginLbl);
		
		loginTfEmail = new JTextField();
		loginTfEmail.setBounds(270, 86, 263, 37);
		loginPanel.add(loginTfEmail);
		loginTfEmail.setColumns(10);
		
		loginTfContrasena = new JTextField();
		loginTfContrasena.setColumns(10);
		loginTfContrasena.setBounds(270, 181, 263, 37);
		loginPanel.add(loginTfContrasena);
		
		JLabel loginLblEmail = new JLabel("Email:");
		loginLblEmail.setBounds(232, 88, 28, 32);
		loginPanel.add(loginLblEmail);
		
		JLabel loginLblContrasena = new JLabel("Contraseña:");
		loginLblContrasena.setBounds(200, 183, 66, 32);
		loginPanel.add(loginLblContrasena);
		
		JPanel resumenCompraPanel = new JPanel();
		resumenCompraPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(resumenCompraPanel);
		resumenCompraPanel.setLayout(null);
		
		JLabel rcLbl = new JLabel("Resumen De Compra");
		rcLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		rcLbl.setBounds(158, 11, 383, 51);
		resumenCompraPanel.add(rcLbl);
		
		JLabel rcLblEntradasSeleccionadas = new JLabel("Entradas Seleccionadas:");
		rcLblEntradasSeleccionadas.setBounds(31, 62, 177, 28);
		resumenCompraPanel.add(rcLblEntradasSeleccionadas);
		
		rcTaEntradasSeleccionadas = new JTextArea();
		rcTaEntradasSeleccionadas.setEditable(false);
		rcTaEntradasSeleccionadas.setBounds(31, 101, 333, 223);
		resumenCompraPanel.add(rcTaEntradasSeleccionadas);
		
		JLabel rcLblPrecioTotal = new JLabel("Precio Total:");
		rcLblPrecioTotal.setBounds(391, 73, 114, 14);
		resumenCompraPanel.add(rcLblPrecioTotal);
		
		rcTaPrecioTotal = new JTextArea();
		rcTaPrecioTotal.setBounds(401, 101, 243, 28);
		resumenCompraPanel.add(rcTaPrecioTotal);
		
		rcBtnAceptar = new JButton("Aceptar");
		rcBtnAceptar.setBounds(401, 189, 243, 51);
		resumenCompraPanel.add(rcBtnAceptar);
		
		rcBtnCancelar = new JButton("Cancelar");
		rcBtnCancelar.setBounds(401, 273, 243, 51);
		resumenCompraPanel.add(rcBtnCancelar);
		
		JPanel HorariosPanel = new JPanel();
		HorariosPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(HorariosPanel);
		HorariosPanel.setLayout(null);
		
		JLabel horariosLbl = new JLabel("Horarios");
		horariosLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		horariosLbl.setHorizontalAlignment(SwingConstants.CENTER);
		horariosLbl.setBounds(195, 11, 279, 57);
		HorariosPanel.add(horariosLbl);
		
		JLabel HorariosLblHorariosDisponibles = new JLabel("Horarios Disponibles Para Esta Pelicula");
		HorariosLblHorariosDisponibles.setBounds(47, 118, 186, 26);
		HorariosPanel.add(HorariosLblHorariosDisponibles);
		
		HorariosCbHorariosDisponibles = new JComboBox();
		HorariosCbHorariosDisponibles.setToolTipText("Horarios");
		HorariosCbHorariosDisponibles.setBounds(47, 166, 284, 26);
		HorariosPanel.add(HorariosCbHorariosDisponibles);
		
		HorariosBtnAceptar = new JButton("Aceptar");
		HorariosBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HorariosBtnAceptar.setBounds(462, 135, 186, 57);
		HorariosPanel.add(HorariosBtnAceptar);
		
		HorariosBtnCancelar = new JButton("Cancelar");
		HorariosBtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HorariosBtnCancelar.setBounds(462, 238, 186, 57);
		HorariosPanel.add(HorariosBtnCancelar);
		
		JPanel SeleccionCinePanel = new JPanel();
		SeleccionCinePanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(SeleccionCinePanel);
		SeleccionCinePanel.setLayout(null);
		
		ScCbSeleccionCine = new JComboBox();
		ScCbSeleccionCine.setToolTipText("Selecciona el Cine");
		ScCbSeleccionCine.setBounds(55, 139, 239, 30);
		SeleccionCinePanel.add(ScCbSeleccionCine);
		
		JLabel ScLbl = new JLabel("Selecciona el Cine");
		ScLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		ScLbl.setBounds(167, 25, 344, 36);
		SeleccionCinePanel.add(ScLbl);
		
		ScBtnAceptar = new JButton("Aceptar");
		ScBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ScBtnAceptar.setBounds(422, 116, 224, 53);
		SeleccionCinePanel.add(ScBtnAceptar);
		
		ScBtnFinalizarSesion = new JButton("Finalizar Sesion");
		ScBtnFinalizarSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ScBtnFinalizarSesion.setBounds(422, 225, 224, 53);
		SeleccionCinePanel.add(ScBtnFinalizarSesion);
		
		JPanel SeleccionPeliPanel = new JPanel();
		SeleccionPeliPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(SeleccionPeliPanel);
		SeleccionPeliPanel.setLayout(null);
		
		JLabel SpLbl = new JLabel("Cine");
		SpLbl.setHorizontalAlignment(SwingConstants.CENTER);
		SpLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		SpLbl.setBounds(208, 11, 274, 45);
		SeleccionPeliPanel.add(SpLbl);
		
		JLabel SpLblPelisDisponibles = new JLabel("Películas Disponibles:");
		SpLblPelisDisponibles.setBounds(72, 124, 153, 22);
		SeleccionPeliPanel.add(SpLblPelisDisponibles);
		
		SpCbSeleccionPeli = new JComboBox();
		SpCbSeleccionPeli.setBounds(72, 157, 222, 22);
		SeleccionPeliPanel.add(SpCbSeleccionPeli);
		
		SpBtnAceptar = new JButton("Aceptar");
		SpBtnAceptar.setBounds(404, 126, 258, 53);
		SeleccionPeliPanel.add(SpBtnAceptar);
		
		SpBtnResumenDeCompra = new JButton("Resumen de Compra");
		SpBtnResumenDeCompra.setBounds(404, 250, 258, 53);
		SeleccionPeliPanel.add(SpBtnResumenDeCompra);
		
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
		
		InicioBtnIniciar = new JButton("Iniciar");
		InicioBtnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 40));
		InicioBtnIniciar.setBounds(327, 218, 296, 99);
		InicioPanel.add(InicioBtnIniciar);
		
		InicioBtnRegistrar = new JButton("Regístrate!");
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
		
		RegistroCbSexo = new JComboBox();
		RegistroCbSexo.setToolTipText("Seleccione su Sexo");
		RegistroCbSexo.setMaximumRowCount(3);
		RegistroCbSexo.setBounds(141, 208, 136, 18);
		RegistroPanel.add(RegistroCbSexo);
		
		RegistroBtnAceptar = new JButton("Aceptar");
		RegistroBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		RegistroBtnAceptar.setBounds(119, 259, 158, 49);
		RegistroPanel.add(RegistroBtnAceptar);
		
		RegistroBtnCancelar = new JButton("Cancelar");
		RegistroBtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		RegistroBtnCancelar.setBounds(422, 259, 158, 49);
		RegistroPanel.add(RegistroBtnCancelar);
	}
}
