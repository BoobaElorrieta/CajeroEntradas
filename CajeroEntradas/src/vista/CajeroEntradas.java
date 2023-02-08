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

import controlador.Controlador;
import modelo.bbdd.SolicitaCines;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CajeroEntradas {
	
	Controlador controlador = new Controlador();

	private JFrame frame;
	public JComboBox<String> scCbSeleccionCine;
	public JPanel inicioPanel;
	public JPanel loginPanel;
	public JPanel resumenCompraPanel;
	public JPanel horariosPanel;
	public JPanel seleccionPeliPanel;
	public JPanel registroPanel;
	public JPanel seleccionCinePanel;
	private JComboBox horariosCbHorariosDisponibles;

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
		
//		INICIO
		
		inicioPanel = new JPanel();
		inicioPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(inicioPanel);
		inicioPanel.setLayout(null);
		
		JLabel inicioLbl = new JLabel("BOOBA");
		inicioLbl.setFont(new Font("Tahoma", Font.PLAIN, 50));
		inicioLbl.setBounds(71, 36, 158, 101);
		inicioPanel.add(inicioLbl);
		
		JLabel inicioLblCompra = new JLabel("Compra de Entradas");
		inicioLblCompra.setBounds(71, 229, 120, 36);
		inicioPanel.add(inicioLblCompra);
		
		JButton inicioBtnIniciar = new JButton("Iniciar");
		inicioBtnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanelSeleccionCine();
				Controlador solicitud = new Controlador();
				solicitud.asignarCinePrueba(scCbSeleccionCine);
			}
		});
		inicioBtnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 40));
		inicioBtnIniciar.setBounds(327, 218, 296, 99);
		inicioPanel.add(inicioBtnIniciar);
		
		JButton inicioBtnRegistrar = new JButton("Regístrate!");
		inicioBtnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanelRegistro();
			}
		});
		inicioBtnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		inicioBtnRegistrar.setBounds(415, 25, 225, 36);
		inicioPanel.add(inicioBtnRegistrar);
		
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
		
		horariosCbHorariosDisponibles = new JComboBox();
		horariosCbHorariosDisponibles.setToolTipText("Horarios");
		horariosCbHorariosDisponibles.setBounds(47, 166, 284, 26);
		horariosPanel.add(horariosCbHorariosDisponibles);
		
		JButton horariosBtnAceptar = new JButton("Aceptar");
		horariosBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanelInicio();
			}
		});
		horariosBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horariosBtnAceptar.setBounds(462, 135, 186, 57);
		horariosPanel.add(horariosBtnAceptar);
		
		JButton horariosBtnCancelar = new JButton("Cancelar");
		horariosBtnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanelInicio();
			}
		});
		horariosBtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horariosBtnCancelar.setBounds(462, 238, 186, 57);
		horariosPanel.add(horariosBtnCancelar);
		
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
				mostrarPanelInicio();
			}
		});
		loginBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginBtnAceptar.setBounds(235, 259, 263, 58);
		loginPanel.add(loginBtnAceptar);
		
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
		
		JTextArea rcTaEntradasSeleccionadas = new JTextArea();
		rcTaEntradasSeleccionadas.setEditable(false);
		rcTaEntradasSeleccionadas.setBounds(31, 101, 333, 223);
		resumenCompraPanel.add(rcTaEntradasSeleccionadas);
		
		JLabel rcLblPrecioTotal = new JLabel("Precio Total:");
		rcLblPrecioTotal.setBounds(391, 73, 114, 14);
		resumenCompraPanel.add(rcLblPrecioTotal);
		
		JTextArea rcTaPrecioTotal = new JTextArea();
		rcTaPrecioTotal.setBounds(401, 101, 243, 28);
		resumenCompraPanel.add(rcTaPrecioTotal);
		
		JButton rcBtnAceptar = new JButton("Aceptar");
		rcBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanelInicio();
			}
		});
		rcBtnAceptar.setBounds(401, 189, 243, 51);
		resumenCompraPanel.add(rcBtnAceptar);
		
		JButton rcBtnCancelar = new JButton("Cancelar");
		rcBtnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanelInicio();
			}
		});
		rcBtnCancelar.setBounds(401, 273, 243, 51);
		resumenCompraPanel.add(rcBtnCancelar);
		
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
		
		JComboBox spCbSeleccionPeli = new JComboBox();
		spCbSeleccionPeli.setBounds(72, 157, 222, 22);
		seleccionPeliPanel.add(spCbSeleccionPeli);
		
		JButton spBtnAceptar = new JButton("Aceptar");
		spBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanelHorarios();
			}
		});
		spBtnAceptar.setBounds(404, 126, 258, 53);
		seleccionPeliPanel.add(spBtnAceptar);
		
		JButton spBtnResumenDeCompra = new JButton("Resumen de Compra");
		spBtnResumenDeCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanelResumenCompra();
			}
		});
		spBtnResumenDeCompra.setBounds(404, 250, 258, 53);
		seleccionPeliPanel.add(spBtnResumenDeCompra);
		
//		SELECCION DE CINE
		
		seleccionCinePanel = new JPanel();
		seleccionCinePanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(seleccionCinePanel);
		seleccionCinePanel.setLayout(null);
		seleccionCinePanel.setVisible(false);
		
		scCbSeleccionCine = new JComboBox<String>();
		scCbSeleccionCine.setToolTipText("Selecciona el Cine");
		scCbSeleccionCine.setBounds(55, 139, 239, 30);
		seleccionCinePanel.add(scCbSeleccionCine);
		
		JLabel scLbl = new JLabel("Selecciona el Cine");
		scLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		scLbl.setBounds(167, 25, 344, 36);
		seleccionCinePanel.add(scLbl);
		
		JButton scBtnAceptar = new JButton("Aceptar");
		scBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador solicitud = new Controlador();
				solicitud.esogerCine(scCbSeleccionCine);
				mostrarPanelSeleccionPeli();
			}
		});
		scBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scBtnAceptar.setBounds(422, 116, 224, 53);
		seleccionCinePanel.add(scBtnAceptar);
		
		JButton scBtnFinalizarSesion = new JButton("Finalizar Sesion");
		scBtnFinalizarSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scBtnFinalizarSesion.setBounds(422, 225, 224, 53);
		seleccionCinePanel.add(scBtnFinalizarSesion);
		
//		REGISTRO
		
		registroPanel = new JPanel();
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
		
		JTextField registroTfNombre = new JTextField();
		registroTfNombre.setBounds(141, 89, 136, 17);
		registroPanel.add(registroTfNombre);
		registroTfNombre.setColumns(10);
		
		JTextField registroTfApellidos = new JTextField();
		registroTfApellidos.setColumns(10);
		registroTfApellidos.setBounds(141, 125, 136, 17);
		registroPanel.add(registroTfApellidos);
		
		JTextField registroTfDNI = new JTextField();
		registroTfDNI.setColumns(10);
		registroTfDNI.setBounds(141, 166, 136, 17);
		registroPanel.add(registroTfDNI);
		
		JTextField registroTfEmail = new JTextField();
		registroTfEmail.setColumns(10);
		registroTfEmail.setBounds(444, 88, 136, 17);
		registroPanel.add(registroTfEmail);
		
		JTextField registroTfContrasena = new JTextField();
		registroTfContrasena.setColumns(10);
		registroTfContrasena.setBounds(444, 125, 136, 17);
		registroPanel.add(registroTfContrasena);
		
		JTextField registroTfTfno = new JTextField();
		registroTfTfno.setColumns(10);
		registroTfTfno.setBounds(444, 166, 136, 17);
		registroPanel.add(registroTfTfno);
		
		JTextField registroTfDireccion = new JTextField();
		registroTfDireccion.setColumns(10);
		registroTfDireccion.setBounds(444, 209, 136, 17);
		registroPanel.add(registroTfDireccion);
		
		JComboBox registroCbSexo = new JComboBox();
		registroCbSexo.setToolTipText("Seleccione su Sexo");
		registroCbSexo.setMaximumRowCount(3);
		registroCbSexo.setBounds(141, 208, 136, 18);
		registroPanel.add(registroCbSexo);
		
		JButton registroBtnAceptar = new JButton("Aceptar");
		registroBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanelInicio();
			}
		});
		registroBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		registroBtnAceptar.setBounds(119, 259, 158, 49);
		registroPanel.add(registroBtnAceptar);
		
		JButton registroBtnCancelar = new JButton("Cancelar");
		registroBtnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanelInicio();
			}
		});
		registroBtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		registroBtnCancelar.setBounds(422, 259, 158, 49);
		registroPanel.add(registroBtnCancelar);
	}
	
//	METODOS
	
	//	Ir al panel Inicio
	private void mostrarPanelInicio() {
		inicioPanel.setVisible(true);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);		
	}
	
//	Ir al panel Registro
	private void mostrarPanelRegistro() {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(true);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);		
	}
	
//	Ir al panel Seleccion Cine
	private void mostrarPanelSeleccionCine() {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(true);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);		
	}
	
//	Ir al panel Seleccion Peli
	private void mostrarPanelSeleccionPeli() {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(true);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);		
	}
	
//	Ir al panel Horarios
	private void mostrarPanelHorarios() {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(true);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);		
	}
	
//	Ir al panel Resumen Compra
	private void mostrarPanelResumenCompra() {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(true);
		loginPanel.setVisible(false);		
	}
//	Ir al panle Login
	private void mostrarPanelLogin() {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(true);		
	}
}
