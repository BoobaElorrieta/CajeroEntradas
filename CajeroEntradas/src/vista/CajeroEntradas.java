package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.ControladorBBDD;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextPane;

public class CajeroEntradas {

	Controlador controlador = new Controlador();
	ControladorBBDD controladorBBDD = new ControladorBBDD();

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
	private JButton registroBtnAtras;
	private JButton scBtnAtras;
	private JButton spBtnAtras;
	private JButton horariosBtnAtras;
	private JTable table;
	public JComboBox<String> spCbSeleccionPeli;
	private JButton rcBtnAtras;
	private JButton loginBtnAtras;
	private JButton rcBtnAceptar;
	private JComboBox<String> spCbDia;
	private JLabel horariosLblHorariosDisponibles;
	private JLabel horariosLblNombreSala;
	private JLabel horariosLblPrecio;
	private JButton loginBtnRegistrate;
	private JButton spBtnResumenDeCompra;

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

		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CajeroEntradas.class.getResource("/imagenes/hdg_preview_rev_1.png")));

		// RESUMEN DE COMPRA

		resumenCompraPanel = new JPanel();
		resumenCompraPanel.setBackground(Color.WHITE);
		resumenCompraPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(resumenCompraPanel);
		resumenCompraPanel.setLayout(null);
		resumenCompraPanel.setVisible(false);

		JLabel rcLbl = new JLabel("Resumen De Compra");
		rcLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		rcLbl.setBounds(158, 11, 383, 51);
		resumenCompraPanel.add(rcLbl);

		JLabel rcLblEntradasSeleccionadas = new JLabel("Entradas Seleccionadas:");
		rcLblEntradasSeleccionadas.setBounds(10, 71, 177, 28);
		resumenCompraPanel.add(rcLblEntradasSeleccionadas);

		JLabel rcLblPrecio = new JLabel("Precio Total:");
		rcLblPrecio.setBounds(551, 41, 114, 14);
		resumenCompraPanel.add(rcLblPrecio);

		JTextArea rcTaPrecioTotal = new JTextArea();
		rcTaPrecioTotal.setEditable(false);
		rcTaPrecioTotal.setBounds(551, 73, 94, 28);
		resumenCompraPanel.add(rcTaPrecioTotal);

		rcBtnAceptar = new JButton("Aceptar");
		rcBtnAceptar.setBackground(Color.DARK_GRAY);
		rcBtnAceptar.setForeground(Color.WHITE);
		rcBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarPanelLogin(inicioPanel, registroPanel, seleccionCinePanel, seleccionPeliPanel,
						horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		rcBtnAceptar.setBounds(550, 189, 94, 51);
		resumenCompraPanel.add(rcBtnAceptar);

		JButton rcBtnCancelar = new JButton("Cancelar");
		rcBtnCancelar.setBackground(Color.DARK_GRAY);
		rcBtnCancelar.setForeground(Color.WHITE);
		rcBtnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, seleccionPeliPanel,
						horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		rcBtnCancelar.setBounds(550, 273, 94, 51);
		resumenCompraPanel.add(rcBtnCancelar);

		rcBtnAtras = new JButton("🡠 Atras");
		rcBtnAtras.setForeground(Color.WHITE);
		rcBtnAtras.setBackground(Color.DARK_GRAY);
		rcBtnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarPanelSeleccionPeli(inicioPanel, registroPanel, seleccionCinePanel,
						seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		rcBtnAtras.setBounds(10, 11, 105, 30);
		resumenCompraPanel.add(rcBtnAtras);

		JScrollPane rcSpResumenCompra = new JScrollPane();
		rcSpResumenCompra.setBounds(10, 111, 516, 213);
		resumenCompraPanel.add(rcSpResumenCompra);

		

		JLabel rcLblImagen = new JLabel("");
		rcLblImagen.setIcon(new ImageIcon(CajeroEntradas.class.getResource("/Imagenes/5f54a46fcce59c0004901ce0.png")));
		rcLblImagen.setBounds(187, 73, 485, 325);
		resumenCompraPanel.add(rcLblImagen);

		// LOGIN

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
		loginTfContrasena.setBounds(235, 146, 263, 37);
		loginPanel.add(loginTfContrasena);

		JLabel loginLblEmail = new JLabel("Email:");
		loginLblEmail.setBounds(159, 89, 66, 32);
		loginPanel.add(loginLblEmail);

		JLabel loginLblContrasena = new JLabel("Contraseña:");
		loginLblContrasena.setBounds(123, 148, 113, 32);
		loginPanel.add(loginLblContrasena);

		JButton loginBtnAceptar = new JButton("Aceptar y guardar ticket");
		loginBtnAceptar.setBackground(Color.DARK_GRAY);
		loginBtnAceptar.setForeground(Color.WHITE);
		loginBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean solucion = false;
				controlador = new Controlador();
				try {
					controladorBBDD.comprobarLogin(loginTfEmail, loginTfContrasena);
					controlador.registrarEntrada();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (solucion = true) {
					controlador.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, seleccionPeliPanel,
							horariosPanel, resumenCompraPanel, loginPanel);
				}
			}
		});
		loginBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginBtnAceptar.setBounds(235, 260, 263, 58);
		loginPanel.add(loginBtnAceptar);

		loginBtnAtras = new JButton("🡠 Atras");
		loginBtnAtras.setForeground(Color.WHITE);
		loginBtnAtras.setBackground(Color.DARK_GRAY);
		loginBtnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarPanelResumenCompra(inicioPanel, registroPanel, seleccionCinePanel,
						seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		loginBtnAtras.setBounds(10, 11, 105, 30);
		loginPanel.add(loginBtnAtras);

		loginBtnRegistrate = new JButton("Si no estas registrado hazlo aqui!");
		loginBtnRegistrate.setBackground(Color.DARK_GRAY);
		loginBtnRegistrate.setForeground(Color.WHITE);
		loginBtnRegistrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarPanelRegistro(inicioPanel, registroPanel, seleccionCinePanel, seleccionPeliPanel,
						horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		loginBtnRegistrate.setBounds(171, 213, 383, 23);
		loginPanel.add(loginBtnRegistrate);

		
		
		final DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		table = new JTable();
		table.setEnabled(false);
		rcSpResumenCompra.setViewportView(table);
		table.setModel(modelo);
		
		// Columnas de la tabla
		modelo.addColumn("Hora");
		modelo.addColumn("Pelicula");
		modelo.addColumn("Cine");
		modelo.addColumn("Fecha");
		modelo.addColumn("Precio");
		modelo.addColumn("Sala");

//		HORARIOS

		horariosPanel = new JPanel();
		horariosPanel.setBackground(Color.WHITE);
		horariosPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(horariosPanel);
		horariosPanel.setLayout(null);
		horariosPanel.setVisible(false);

		JLabel horariosLbl = new JLabel("Horarios");
		horariosLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		horariosLbl.setHorizontalAlignment(SwingConstants.CENTER);
		horariosLbl.setBounds(195, 11, 279, 57);
		horariosPanel.add(horariosLbl);

		horariosLblHorariosDisponibles = new JLabel("Horarios Disponibles \r\n Para Esta Pelicula");
		horariosLblHorariosDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 18));
		horariosLblHorariosDisponibles.setBounds(20, 121, 385, 26);
		horariosPanel.add(horariosLblHorariosDisponibles);

		horariosCbHorariosDisponibles = new JComboBox<String>();
		horariosCbHorariosDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorBBDD.selecionarHora(scCbSeleccionCine, horariosCbHorariosDisponibles, spCbSeleccionPeli,
						horariosLblHorariosDisponibles, spCbDia, horariosLblPrecio, horariosLblNombreSala);
			}
		});
		horariosCbHorariosDisponibles.setBackground(Color.DARK_GRAY);
		horariosCbHorariosDisponibles.setForeground(Color.WHITE);
		horariosCbHorariosDisponibles.setToolTipText("Horarios");
		horariosCbHorariosDisponibles.setBounds(20, 169, 140, 26);
		horariosPanel.add(horariosCbHorariosDisponibles);

		JButton horariosBtnAceptar = new JButton("Aceptar");
		horariosBtnAceptar.setBackground(Color.DARK_GRAY);
		horariosBtnAceptar.setForeground(Color.WHITE);
		horariosBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador solicitud = new Controlador();
				solicitud.ventanaDeConfirmacion(horariosCbHorariosDisponibles, spCbSeleccionPeli, scCbSeleccionCine,
						spCbDia, horariosLblPrecio, horariosLblNombreSala, modelo);
				controlador.mostrarPanelSeleccionCine(inicioPanel, registroPanel, seleccionCinePanel,
						seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		horariosBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horariosBtnAceptar.setBounds(462, 135, 186, 57);
		horariosPanel.add(horariosBtnAceptar);

		JButton horariosBtnCancelar = new JButton("Cancelar");
		horariosBtnCancelar.setBackground(Color.DARK_GRAY);
		horariosBtnCancelar.setForeground(Color.WHITE);
		horariosBtnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, seleccionPeliPanel,
						horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		horariosBtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horariosBtnCancelar.setBounds(462, 238, 186, 57);
		horariosPanel.add(horariosBtnCancelar);

		horariosBtnAtras = new JButton("🡠 Atras");
		horariosBtnAtras.setBackground(Color.DARK_GRAY);
		horariosBtnAtras.setForeground(Color.WHITE);
		horariosBtnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarPanelSeleccionPeli(inicioPanel, registroPanel, seleccionCinePanel,
						seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);

			}
		});
		horariosBtnAtras.setBounds(10, 11, 105, 30);
		horariosPanel.add(horariosBtnAtras);

		JLabel horariosLblImagen = new JLabel("");
		horariosLblImagen
				.setIcon(new ImageIcon(CajeroEntradas.class.getResource("/Imagenes/5f54a46fcce59c0004901ce0.png")));
		horariosLblImagen.setBounds(187, 41, 485, 325);
		horariosPanel.add(horariosLblImagen);

		JLabel horarioSelectLbl = new JLabel("Precio:");
		horarioSelectLbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		horarioSelectLbl.setBounds(20, 230, 90, 30);
		horariosPanel.add(horarioSelectLbl);

		JLabel horariosLblSala = new JLabel("Sala:");
		horariosLblSala.setFont(new Font("Tahoma", Font.PLAIN, 22));
		horariosLblSala.setBounds(36, 280, 90, 30);
		horariosPanel.add(horariosLblSala);

		horariosLblPrecio = new JLabel("------");
		horariosLblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		horariosLblPrecio.setBounds(98, 230, 90, 30);
		horariosPanel.add(horariosLblPrecio);

		horariosLblNombreSala = new JLabel("------");
		horariosLblNombreSala.setFont(new Font("Tahoma", Font.PLAIN, 22));
		horariosLblNombreSala.setBounds(98, 280, 90, 30);
		horariosPanel.add(horariosLblNombreSala);

//		SELECCION DE PELICULAS

		seleccionPeliPanel = new JPanel();
		seleccionPeliPanel.setBackground(Color.WHITE);
		seleccionPeliPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(seleccionPeliPanel);
		seleccionPeliPanel.setLayout(null);
		seleccionPeliPanel.setVisible(false);

//		JButton movido

		JLabel spLbl = new JLabel("Cine");
		spLbl.setHorizontalAlignment(SwingConstants.CENTER);
		spLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		spLbl.setBounds(208, 11, 274, 45);
		seleccionPeliPanel.add(spLbl);

		JLabel spLblPelisDisponibles = new JLabel("Películas Disponibles:");
		spLblPelisDisponibles.setBounds(72, 124, 153, 22);
		seleccionPeliPanel.add(spLblPelisDisponibles);

		spCbSeleccionPeli = new JComboBox<String>();
		spCbSeleccionPeli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorBBDD.escogerFecha(scCbSeleccionCine, spCbSeleccionPeli, spCbDia);
			}
		});
		spCbSeleccionPeli.setForeground(Color.WHITE);
		spCbSeleccionPeli.setBackground(Color.DARK_GRAY);
		spCbSeleccionPeli.setBounds(72, 157, 222, 22);
		seleccionPeliPanel.add(spCbSeleccionPeli);

		spBtnResumenDeCompra = new JButton("Resumen de Compra");
		spBtnResumenDeCompra.setForeground(Color.WHITE);
		spBtnResumenDeCompra.setBackground(Color.DARK_GRAY);
		spBtnResumenDeCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarPanelResumenCompra(inicioPanel, registroPanel, seleccionCinePanel,
						seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
				controlador.calcularPrecioTotal(modelo, rcTaPrecioTotal);
			}
		});
		spBtnResumenDeCompra.setBounds(404, 250, 258, 53);
		seleccionPeliPanel.add(spBtnResumenDeCompra);

		spBtnAtras = new JButton("🡠 Atras");
		spBtnAtras.setForeground(Color.WHITE);
		spBtnAtras.setBackground(Color.DARK_GRAY);
		spBtnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarPanelSeleccionCine(inicioPanel, registroPanel, seleccionCinePanel,
						seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		spBtnAtras.setBounds(10, 11, 105, 30);
		seleccionPeliPanel.add(spBtnAtras);

		spCbDia = new JComboBox<String>();
		spCbDia.setBounds(72, 249, 222, 30);
		seleccionPeliPanel.add(spCbDia);

//		JButton movido

		JButton spBtnAceptar = new JButton("Aceptar");
		spBtnAceptar.setForeground(Color.WHITE);
		spBtnAceptar.setBackground(Color.DARK_GRAY);
		spBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorBBDD.escogerHorarios(scCbSeleccionCine, horariosCbHorariosDisponibles, spCbSeleccionPeli,
						horariosLblHorariosDisponibles, spCbDia);
				controlador.mostrarPanelHorarios(inicioPanel, registroPanel, seleccionCinePanel, seleccionPeliPanel,
						horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		spBtnAceptar.setBounds(404, 126, 258, 53);
		seleccionPeliPanel.add(spBtnAceptar);

		JLabel spImagen = new JLabel("");
		spImagen.setIcon(new ImageIcon(CajeroEntradas.class.getResource("/Imagenes/5f54a46fcce59c0004901ce0.png")));
		spImagen.setBounds(187, 41, 485, 325);
		seleccionPeliPanel.add(spImagen);

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
				controladorBBDD.escogerCine(scCbSeleccionCine, spCbSeleccionPeli, spLbl);
				controlador.mostrarPanelSeleccionPeli(inicioPanel, registroPanel, seleccionCinePanel,
						seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		scBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scBtnAceptar.setBounds(422, 116, 224, 53);
		seleccionCinePanel.add(scBtnAceptar);

		JButton scBtnFinalizarSesion = new JButton("Finalizar Sesion");
		scBtnFinalizarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador controlador = new Controlador();
				controlador.cerrarPrograma();
			}
		});
		scBtnFinalizarSesion.setForeground(Color.WHITE);
		scBtnFinalizarSesion.setBackground(Color.DARK_GRAY);
		scBtnFinalizarSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scBtnFinalizarSesion.setBounds(422, 225, 224, 53);
		seleccionCinePanel.add(scBtnFinalizarSesion);

		scBtnAtras = new JButton("🡠 Atras");
		scBtnAtras.setBackground(Color.DARK_GRAY);
		scBtnAtras.setForeground(Color.WHITE);
		scBtnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, seleccionPeliPanel,
						horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		scBtnAtras.setBounds(10, 11, 105, 30);
		seleccionCinePanel.add(scBtnAtras);

		JLabel scLblImagen = new JLabel("");
		scLblImagen.setIcon(new ImageIcon(CajeroEntradas.class.getResource("/Imagenes/5f54a46fcce59c0004901ce0.png")));
		scLblImagen.setBounds(187, 41, 485, 325);
		seleccionCinePanel.add(scLblImagen);

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
		registroTfNombre.setBounds(141, 89, 136, 20);
		registroPanel.add(registroTfNombre);
		registroTfNombre.setColumns(10);

		registroTfApellidos = new JTextField();
		registroTfApellidos.setColumns(10);
		registroTfApellidos.setBounds(141, 125, 136, 20);
		registroPanel.add(registroTfApellidos);

		registroTfDNI = new JTextField();
		registroTfDNI.setColumns(10);
		registroTfDNI.setBounds(141, 166, 136, 20);
		registroPanel.add(registroTfDNI);

		registroTfEmail = new JTextField();
		registroTfEmail.setColumns(10);
		registroTfEmail.setBounds(444, 88, 136, 20);
		registroPanel.add(registroTfEmail);

		registroTfContrasena = new JTextField();
		registroTfContrasena.setColumns(10);
		registroTfContrasena.setBounds(444, 125, 136, 20);
		registroPanel.add(registroTfContrasena);

		registroTfTfno = new JTextField();
		registroTfTfno.setColumns(10);
		registroTfTfno.setBounds(444, 166, 136, 20);
		registroPanel.add(registroTfTfno);

		registroTfDireccion = new JTextField();
		registroTfDireccion.setColumns(10);
		registroTfDireccion.setBounds(444, 209, 136, 20);
		registroPanel.add(registroTfDireccion);

		registroCbSexo = new JComboBox<String>();
		registroCbSexo.setToolTipText("Seleccione su Sexo");
		registroCbSexo.addItem("Hombre");
		registroCbSexo.addItem("Mujer");
		registroCbSexo.addItem("Otro");
		registroCbSexo.setMaximumRowCount(3);
		registroCbSexo.setBounds(141, 208, 136, 20);
		registroPanel.add(registroCbSexo);

		JButton registroBtnAceptar = new JButton("Aceptar");
		registroBtnAceptar.setForeground(Color.WHITE);
		registroBtnAceptar.setBackground(Color.DARK_GRAY);
		registroBtnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.registrarUsuario(registroTfDNI, registroTfNombre, registroTfApellidos, registroTfContrasena,
						registroTfTfno, registroTfDireccion, registroTfEmail, registroCbSexo);
				controlador.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, seleccionPeliPanel,
						horariosPanel, resumenCompraPanel, loginPanel);

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
				controlador.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, seleccionPeliPanel,
						horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		registroBtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		registroBtnCancelar.setBounds(422, 259, 158, 49);
		registroPanel.add(registroBtnCancelar);

		registroBtnAtras = new JButton("🡠 Atras");
		registroBtnAtras.setForeground(Color.WHITE);
		registroBtnAtras.setBackground(Color.DARK_GRAY);
		registroBtnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarPanelInicio(inicioPanel, registroPanel, seleccionCinePanel, seleccionPeliPanel,
						horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		registroBtnAtras.setBounds(10, 11, 105, 30);
		registroPanel.add(registroBtnAtras);

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
				controlador.mostrarPanelSeleccionCine(inicioPanel, registroPanel, seleccionCinePanel,
						seleccionPeliPanel, horariosPanel, resumenCompraPanel, loginPanel);
				controladorBBDD.buscarCine(scCbSeleccionCine);
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
				controlador.mostrarPanelRegistro(inicioPanel, registroPanel, seleccionCinePanel, seleccionPeliPanel,
						horariosPanel, resumenCompraPanel, loginPanel);
			}
		});
		inicioBtnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		inicioBtnRegistrar.setBounds(415, 25, 225, 36);
		inicioPanel.add(inicioBtnRegistrar);

		JLabel inicioLblImagen = new JLabel("");
		inicioLblImagen.setIcon(new ImageIcon(CajeroEntradas.class.getResource("/Imagenes/hdg.png")));
		inicioLblImagen.setBounds(0, 97, 239, 253);
		inicioPanel.add(inicioLblImagen);

		JTextPane inicioTpBienvenidosAlCajero = new JTextPane();
		inicioTpBienvenidosAlCajero.setEditable(false);
		inicioTpBienvenidosAlCajero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inicioTpBienvenidosAlCajero
				.setText("Bienvenidos al cajero de entradas de Cines Elorrieta porgramado por la empresa BOOBA");
		inicioTpBienvenidosAlCajero.setBounds(355, 108, 245, 99);
		inicioPanel.add(inicioTpBienvenidosAlCajero);
	}
}
