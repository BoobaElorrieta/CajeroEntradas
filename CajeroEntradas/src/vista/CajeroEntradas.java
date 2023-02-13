package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import controlador.Controlador;
import controlador.ControladorEneko;
import modelo.bbdd.RegistraCliente;
import modelo.pojos.Cliente;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JTextPane;

public class CajeroEntradas {
	
	Controlador controlador = new Controlador();
	ControladorEneko controladorEneko = new ControladorEneko();

	private JFrame frame;
	public JComboBox<String> scCbSeleccionCine;
	public JPanel inicioPanel;
	public JPanel loginPanel;
	public JPanel resumenCompraPanel;
	public JPanel horariosPanel;
	public JPanel seleccionPeliPanel;
	public JPanel registroPanel;
	public JPanel seleccionCinePanel;
	private JComboBox<String> horariosCbHorariosDisponibles;
	public JTextField registroTfNombre;
	public JTextField registroTfApellidos;
	public JTextField registroTfDNI;
	public JComboBox<String> registroCbSexo;
	public JTextField registroTfEmail;
	public JTextField registroTfContrasena;
	public JTextField registroTfTfno;
	public JTextField registroTfDireccion;
	private JButton btnAtras_3;
	private JButton btnAtras;
	private JButton btnAtras_2;
	private JButton btnAtras_1;
	private JTable table;
	private JComboBox<String> spCbSeleccionPeli;
	private JButton btnAtras_4;
	private JButton btnAtras_5;
	private JButton rcBtnAceptar;

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
		
//		REGISTRO
		
		registroPanel = new JPanel();
		registroPanel.setBackground(Color.WHITE);
		registroPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(registroPanel);
		registroPanel.setLayout(null);
		registroPanel.setVisible(false);
		
		JLabel registroLbl = new JLabel("Registro De Usuario");
		registroLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		registroLbl.setBounds(152, 11, 350, 49);
		registroPanel.add(registroLbl);
		
		JLabel registroLblNombre = new JLabel("Nombre:");
		registroLblNombre.setBounds(61, 91, 50, 14);
		registroPanel.add(registroLblNombre);
		
		JLabel registroLblApellidos = new JLabel("Apellidos:");
		registroLblApellidos.setBounds(61, 128, 78, 14);
		registroPanel.add(registroLblApellidos);
		
		JLabel registroLblContraseña = new JLabel("Contraseña:");
		registroLblContraseña.setBounds(371, 128, 71, 14);
		registroPanel.add(registroLblContraseña);
		
		JLabel registroLblDni = new JLabel("DNI:");
		registroLblDni.setBounds(61, 169, 65, 14);
		registroPanel.add(registroLblDni);
		
		JLabel registroLblDireccion = new JLabel("Dirección:");
		registroLblDireccion.setBounds(371, 212, 71, 14);
		registroPanel.add(registroLblDireccion);
		
		JLabel registroLblSexo = new JLabel("Sexo:");
		registroLblSexo.setBounds(61, 212, 59, 14);
		registroPanel.add(registroLblSexo);
		
		JLabel registroLblTfno = new JLabel("Teléfono:");
		registroLblTfno.setBounds(371, 169, 65, 14);
		registroPanel.add(registroLblTfno);
		
		JLabel registroLblEmail = new JLabel("E-Mail:");
		registroLblEmail.setBounds(371, 91, 65, 14);
		registroPanel.add(registroLblEmail);
		
		registroTfNombre = new JTextField();
		registroTfNombre.setBounds(141, 89, 136, 17);
		registroPanel.add(registroTfNombre);
		registroTfNombre.setColumns(10);
		
		registroTfApellidos = new JTextField();
		registroTfApellidos.setColumns(10);
		registroTfApellidos.setBounds(141, 125, 136, 17);
		registroPanel.add(registroTfApellidos);
		
		registroTfDNI = new JTextField();
		registroTfDNI.setColumns(10);
		registroTfDNI.setBounds(141, 166, 136, 17);
		registroPanel.add(registroTfDNI);
		
		registroTfEmail = new JTextField();
		registroTfEmail.setColumns(10);
		registroTfEmail.setBounds(444, 88, 136, 17);
		registroPanel.add(registroTfEmail);
		
		registroTfContrasena = new JTextField();
		registroTfContrasena.setColumns(10);
		registroTfContrasena.setBounds(444, 125, 136, 17);
		registroPanel.add(registroTfContrasena);
		
		registroTfTfno = new JTextField();
		registroTfTfno.setColumns(10);
		registroTfTfno.setBounds(444, 166, 136, 17);
		registroPanel.add(registroTfTfno);
		
		registroTfDireccion = new JTextField();
		registroTfDireccion.setColumns(10);
		registroTfDireccion.setBounds(444, 209, 136, 17);
		registroPanel.add(registroTfDireccion);
		
		registroCbSexo = new JComboBox<String>();
		registroCbSexo.setToolTipText("Seleccione su Sexo");
		registroCbSexo.addItem("Hombre");
		registroCbSexo.addItem("Mujer");
		registroCbSexo.addItem("Otro");
		registroCbSexo.setMaximumRowCount(3);
		registroCbSexo.setBounds(141, 208, 136, 18);
		registroPanel.add(registroCbSexo);
		
		JButton registroBtnAceptar = new JButton("Aceptar");
		registroBtnAceptar.setForeground(Color.WHITE);
		registroBtnAceptar.setBackground(Color.DARK_GRAY);
		registroBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.registrarUsuario(registroTfDNI, registroTfNombre, registroTfApellidos, registroTfContrasena,
				registroTfTfno, registroTfDireccion, registroTfEmail, registroCbSexo);
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
				
			}
		});
		registroBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		registroBtnAceptar.setBounds(119, 259, 158, 49);
		registroPanel.add(registroBtnAceptar);
		
		JButton registroBtnCancelar = new JButton("Cancelar");
		registroBtnCancelar.setForeground(Color.WHITE);
		registroBtnCancelar.setBackground(Color.DARK_GRAY);
		registroBtnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		registroBtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		registroBtnCancelar.setBounds(422, 259, 158, 49);
		registroPanel.add(registroBtnCancelar);
		
		btnAtras_3 = new JButton("🡠 Atras");
		btnAtras_3.setForeground(Color.WHITE);
		btnAtras_3.setBackground(Color.DARK_GRAY);
		btnAtras_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		btnAtras_3.setBounds(10, 11, 105, 30);
		registroPanel.add(btnAtras_3);
		
//		INICIO
		
		inicioPanel = new JPanel();
		inicioPanel.setBackground(Color.WHITE);
		inicioPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(inicioPanel);
		inicioPanel.setLayout(null);
		
		JLabel inicioLbl = new JLabel("Cines elorrieta");
		inicioLbl.setFont(new Font("Tahoma", Font.PLAIN, 50));
		inicioLbl.setBounds(10, 11, 424, 101);
		inicioPanel.add(inicioLbl);
		
		JButton inicioBtnIniciar = new JButton("Iniciar");
		inicioBtnIniciar.setForeground(Color.WHITE);
		inicioBtnIniciar.setBackground(Color.DARK_GRAY);
		inicioBtnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelSeleccionCine(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
				Controlador solicitud = new Controlador();
				solicitud.asignarCinePrueba(scCbSeleccionCine);
			}
		});
		inicioBtnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 40));
		inicioBtnIniciar.setBounds(327, 218, 296, 99);
		inicioPanel.add(inicioBtnIniciar);
		
		JButton inicioBtnRegistrar = new JButton("Regístrate!");
		inicioBtnRegistrar.setForeground(Color.WHITE);
		inicioBtnRegistrar.setBackground(Color.DARK_GRAY);
		inicioBtnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelRegistro(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		inicioBtnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		inicioBtnRegistrar.setBounds(415, 25, 225, 36);
		inicioPanel.add(inicioBtnRegistrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CajeroEntradas.class.getResource("/Imagenes/hdg.png")));
		lblNewLabel.setBounds(0, 97, 239, 253);
		inicioPanel.add(lblNewLabel);
		
		JTextPane txtpnBienvenidosAlCajero = new JTextPane();
		txtpnBienvenidosAlCajero.setEditable(false);
		txtpnBienvenidosAlCajero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnBienvenidosAlCajero.setText("Bienvenidos al cajero de entradas de Cines Elorrieta porgramado por la empresa BOOBA");
		txtpnBienvenidosAlCajero.setBounds(355, 108, 245, 99);
		inicioPanel.add(txtpnBienvenidosAlCajero);
		
//		HORARIOS
		
		horariosPanel = new JPanel();
		horariosPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(horariosPanel);
		horariosPanel.setLayout(null);
		horariosPanel.setVisible(false);
		
		JLabel horariosLbl = new JLabel("Horarios");
		horariosLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		horariosLbl.setHorizontalAlignment(SwingConstants.CENTER);
		horariosLbl.setBounds(195, 11, 279, 57);
		horariosPanel.add(horariosLbl);
		
		JLabel horariosLblHorariosDisponibles = new JLabel("Horarios Disponibles Para Esta Pelicula");
		horariosLblHorariosDisponibles.setBounds(47, 118, 186, 26);
		horariosPanel.add(horariosLblHorariosDisponibles);
		
		horariosCbHorariosDisponibles = new JComboBox<String>();
		horariosCbHorariosDisponibles.setToolTipText("Horarios");
		horariosCbHorariosDisponibles.setBounds(47, 166, 284, 26);
		horariosPanel.add(horariosCbHorariosDisponibles);
		
		JButton horariosBtnAceptar = new JButton("Aceptar");
		horariosBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador solicitud = new Controlador();
				solicitud.ventanaDeConfirmacion(horariosCbHorariosDisponibles);
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		horariosBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horariosBtnAceptar.setBounds(462, 135, 186, 57);
		horariosPanel.add(horariosBtnAceptar);
		
		JButton horariosBtnCancelar = new JButton("Cancelar");
		horariosBtnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		horariosBtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horariosBtnCancelar.setBounds(462, 238, 186, 57);
		horariosPanel.add(horariosBtnCancelar);
		
		btnAtras_1 = new JButton("🡠 Atras");
		btnAtras_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelSeleccionPeli(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		btnAtras_1.setBounds(10, 11, 105, 30);
		horariosPanel.add(btnAtras_1);
		
//		SELECCION DE CINE
		
		seleccionCinePanel = new JPanel();
		seleccionCinePanel.setBackground(Color.WHITE);
		seleccionCinePanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(seleccionCinePanel);
		seleccionCinePanel.setLayout(null);
		seleccionCinePanel.setVisible(false);
		
		scCbSeleccionCine = new JComboBox<String>();
		scCbSeleccionCine.setForeground(Color.WHITE);
		scCbSeleccionCine.setBackground(Color.DARK_GRAY);
		scCbSeleccionCine.setToolTipText("Selecciona el Cine");
		scCbSeleccionCine.setBounds(55, 139, 239, 30);
		seleccionCinePanel.add(scCbSeleccionCine);
		
		JLabel scLbl = new JLabel("Selecciona el Cine");
		scLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		scLbl.setBounds(167, 25, 344, 36);
		seleccionCinePanel.add(scLbl);
		
		JButton scBtnAceptar = new JButton("Aceptar");
		scBtnAceptar.setForeground(Color.WHITE);
		scBtnAceptar.setBackground(Color.DARK_GRAY);
		scBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador solicitud = new Controlador();
				solicitud.escogerCine(scCbSeleccionCine, spCbSeleccionPeli);
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelSeleccionPeli(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		scBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scBtnAceptar.setBounds(422, 116, 224, 53);
		seleccionCinePanel.add(scBtnAceptar);
		
		JButton scBtnFinalizarSesion = new JButton("Finalizar Sesion");
		scBtnFinalizarSesion.setForeground(Color.WHITE);
		scBtnFinalizarSesion.setBackground(Color.DARK_GRAY);
		scBtnFinalizarSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scBtnFinalizarSesion.setBounds(422, 225, 224, 53);
		seleccionCinePanel.add(scBtnFinalizarSesion);
		
		btnAtras = new JButton("🡠 Atras");
		btnAtras.setBackground(Color.DARK_GRAY);
		btnAtras.setForeground(Color.WHITE);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		btnAtras.setBounds(10, 11, 105, 30);
		seleccionCinePanel.add(btnAtras);
		
		JLabel label = new JLabel("New label");
		label.setBounds(317, 264, -23, -70);
		seleccionCinePanel.add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(329, 225, -324, -222);
		seleccionCinePanel.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CajeroEntradas.class.getResource("/Imagenes/5f54a46fcce59c0004901ce0.png")));
		lblNewLabel_1.setBounds(187, 41, 485, 325);
		seleccionCinePanel.add(lblNewLabel_1);
		
//		LOGIN
		
		loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		loginPanel.setVisible(false);
		
		JLabel loginLbl = new JLabel("Login");
		loginLbl.setHorizontalAlignment(SwingConstants.CENTER);
		loginLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		loginLbl.setBounds(220, 11, 263, 49);
		loginPanel.add(loginLbl);
		
		JTextField loginTfEmail = new JTextField();
		loginTfEmail.setBounds(235, 87, 263, 37);
		loginPanel.add(loginTfEmail);
		loginTfEmail.setColumns(10);
		
		JTextField loginTfContrasena = new JTextField();
		loginTfContrasena.setColumns(10);
		loginTfContrasena.setBounds(235, 182, 263, 37);
		loginPanel.add(loginTfContrasena);
		
		JLabel loginLblEmail = new JLabel("Email:");
		loginLblEmail.setBounds(197, 89, 28, 32);
		loginPanel.add(loginLblEmail);
		
		JLabel loginLblContrasena = new JLabel("Contraseña:");
		loginLblContrasena.setBounds(165, 184, 66, 32);
		loginPanel.add(loginLblContrasena);
		
		JButton loginBtnAceptar = new JButton("Aceptar y guardar ticket");
		loginBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean solucion = false;
				controlador = new Controlador();
				solucion = controlador.comprobarLogin(loginTfEmail, loginTfContrasena);
				
				if (solucion = true) {	
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
				}else {
					controladorEneko = new ControladorEneko();
					controladorEneko.mostrarPanelResumenCompra(inicioPanel, registroPanel, seleccionCinePanel, 
							seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
				}
			}
		});
		loginBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginBtnAceptar.setBounds(235, 259, 263, 58);
		loginPanel.add(loginBtnAceptar);
		
		btnAtras_5 = new JButton("🡠 Atras");
		btnAtras_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
				controladorEneko.mostrarPanelResumenCompra(inicioPanel, registroPanel, seleccionCinePanel, 
						seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		btnAtras_5.setBounds(10, 11, 105, 30);
		loginPanel.add(btnAtras_5);
		
//		RESUMEN DE COMPRA
		
		resumenCompraPanel = new JPanel();
		resumenCompraPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(resumenCompraPanel);
		resumenCompraPanel.setLayout(null);
		resumenCompraPanel.setVisible(false);
		
		JLabel rcLbl = new JLabel("Resumen De Compra");
		rcLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		rcLbl.setBounds(158, 11, 383, 51);
		resumenCompraPanel.add(rcLbl);
		
		JLabel rcLblEntradasSeleccionadas = new JLabel("Entradas Seleccionadas:");
		rcLblEntradasSeleccionadas.setBounds(31, 62, 177, 28);
		resumenCompraPanel.add(rcLblEntradasSeleccionadas);
		
		JLabel rcLblPrecioTotal = new JLabel("Precio Total:");
		rcLblPrecioTotal.setBounds(391, 73, 114, 14);
		resumenCompraPanel.add(rcLblPrecioTotal);
		
		JTextArea rcTaPrecioTotal = new JTextArea();
		rcTaPrecioTotal.setBounds(401, 101, 243, 28);
		resumenCompraPanel.add(rcTaPrecioTotal);
		
		rcBtnAceptar = new JButton("Aceptar");
		rcBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelLogin(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		rcBtnAceptar.setBounds(401, 189, 243, 51);
		resumenCompraPanel.add(rcBtnAceptar);
		
		JButton rcBtnCancelar = new JButton("Cancelar");
		rcBtnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		rcBtnCancelar.setBounds(401, 273, 243, 51);
		resumenCompraPanel.add(rcBtnCancelar);
		
		btnAtras_4 = new JButton("🡠 Atras");
		btnAtras_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
				controladorEneko.mostrarPanelSeleccionPeli(inicioPanel, registroPanel, seleccionCinePanel, 
						seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		btnAtras_4.setBounds(10, 11, 105, 30);
		resumenCompraPanel.add(btnAtras_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 119, 272, 197);
		resumenCompraPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
//		SELECCION DE PELICULAS
		
		seleccionPeliPanel = new JPanel();
		seleccionPeliPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(seleccionPeliPanel);
		seleccionPeliPanel.setLayout(null);
		seleccionPeliPanel.setVisible(false);
		
		JLabel spLbl = new JLabel("Cine");
		spLbl.setHorizontalAlignment(SwingConstants.CENTER);
		spLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		spLbl.setBounds(208, 11, 274, 45);
		seleccionPeliPanel.add(spLbl);
		
		JLabel spLblPelisDisponibles = new JLabel("Películas Disponibles:");
		spLblPelisDisponibles.setBounds(72, 124, 153, 22);
		seleccionPeliPanel.add(spLblPelisDisponibles);
		
		spCbSeleccionPeli = new JComboBox<String>();
		spCbSeleccionPeli.setBounds(72, 157, 222, 22);
		seleccionPeliPanel.add(spCbSeleccionPeli);
		
//		Va mal
		
		JButton spBtnAceptar = new JButton("Aceptar");
		spBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador = new Controlador();
				controlador.escogerHorarios(horariosCbHorariosDisponibles, spCbSeleccionPeli);
				controladorEneko = new ControladorEneko();
				controladorEneko.mostrarPanelHorarios(inicioPanel, registroPanel, seleccionCinePanel, 
						seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		spBtnAceptar.setBounds(404, 126, 258, 53);
		seleccionPeliPanel.add(spBtnAceptar);
		
		JButton spBtnResumenDeCompra = new JButton("Resumen de Compra");
		spBtnResumenDeCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelResumenCompra(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		spBtnResumenDeCompra.setBounds(404, 250, 258, 53);
		seleccionPeliPanel.add(spBtnResumenDeCompra);
		
		btnAtras_2 = new JButton("🡠 Atras");
		btnAtras_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorEneko = new ControladorEneko();
			controladorEneko.mostrarPanelSeleccionCine(inicioPanel, registroPanel, seleccionCinePanel, 
					seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		btnAtras_2.setBounds(10, 11, 105, 30);
		seleccionPeliPanel.add(btnAtras_2);
	}
}
