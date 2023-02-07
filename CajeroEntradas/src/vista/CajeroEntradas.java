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

import modelo.bbdd.SolicitaCines;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CajeroEntradas {

	private JFrame frame;
	private JTextField registroTfNombre;
	private JTextField registroTfApellidos;
	private JTextField registroTfDNI;
	private JTextField registroTfEmail;
	private JTextField registroTfContrasena;
	private JTextField registroTfTfno;
	private JTextField registroTfDireccion;
	private JButton scBtnFinalizarSesion;
	private JButton scBtnAceptar;
	public JComboBox scCbSeleccionCine;
	private JButton inicioBtnIniciar;
	private JButton inicioBtnRegistrar;
	private JComboBox registroCbSexo;
	private JButton registroBtnAceptar;
	private JButton registroBtnCancelar;
	private JButton spBtnResumenDeCompra;
	private JComboBox spCbSeleccionPeli;
	private JButton spBtnAceptar;
	private JButton horariosBtnAceptar;
	private JComboBox horariosCbHorariosDisponibles;
	private JButton horariosBtnCancelar;
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
		loginTfEmail.setBounds(235, 87, 263, 37);
		loginPanel.add(loginTfEmail);
		loginTfEmail.setColumns(10);
		
		loginTfContrasena = new JTextField();
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
		loginBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginBtnAceptar.setBounds(235, 259, 263, 58);
		loginPanel.add(loginBtnAceptar);
		
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
		
		JPanel horariosPanel = new JPanel();
		horariosPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(horariosPanel);
		horariosPanel.setLayout(null);
		
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
		
		horariosBtnAceptar = new JButton("Aceptar");
		horariosBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horariosBtnAceptar.setBounds(462, 135, 186, 57);
		horariosPanel.add(horariosBtnAceptar);
		
		horariosBtnCancelar = new JButton("Cancelar");
		horariosBtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horariosBtnCancelar.setBounds(462, 238, 186, 57);
		horariosPanel.add(horariosBtnCancelar);
		
		JPanel seleccionCinePanel = new JPanel();
		seleccionCinePanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(seleccionCinePanel);
		seleccionCinePanel.setLayout(null);
		
		scCbSeleccionCine = new JComboBox();
		scCbSeleccionCine.setToolTipText("Selecciona el Cine");
		scCbSeleccionCine.setBounds(55, 139, 239, 30);
		seleccionCinePanel.add(scCbSeleccionCine);
		
		JLabel scLbl = new JLabel("Selecciona el Cine");
		scLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		scLbl.setBounds(167, 25, 344, 36);
		seleccionCinePanel.add(scLbl);
		
		scBtnAceptar = new JButton("Aceptar");
		scBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scBtnAceptar.setBounds(422, 116, 224, 53);
		seleccionCinePanel.add(scBtnAceptar);
		
		scBtnFinalizarSesion = new JButton("Finalizar Sesion");
		scBtnFinalizarSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scBtnFinalizarSesion.setBounds(422, 225, 224, 53);
		seleccionCinePanel.add(scBtnFinalizarSesion);
		
		JPanel seleccionPeliPanel = new JPanel();
		seleccionPeliPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(seleccionPeliPanel);
		seleccionPeliPanel.setLayout(null);
		
		JLabel spLbl = new JLabel("Cine");
		spLbl.setHorizontalAlignment(SwingConstants.CENTER);
		spLbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		spLbl.setBounds(208, 11, 274, 45);
		seleccionPeliPanel.add(spLbl);
		
		JLabel spLblPelisDisponibles = new JLabel("Películas Disponibles:");
		spLblPelisDisponibles.setBounds(72, 124, 153, 22);
		seleccionPeliPanel.add(spLblPelisDisponibles);
		
		spCbSeleccionPeli = new JComboBox();
		spCbSeleccionPeli.setBounds(72, 157, 222, 22);
		seleccionPeliPanel.add(spCbSeleccionPeli);
		
		spBtnAceptar = new JButton("Aceptar");
		spBtnAceptar.setBounds(404, 126, 258, 53);
		seleccionPeliPanel.add(spBtnAceptar);
		
		spBtnResumenDeCompra = new JButton("Resumen de Compra");
		spBtnResumenDeCompra.setBounds(404, 250, 258, 53);
		seleccionPeliPanel.add(spBtnResumenDeCompra);
		
		JPanel inicioPanel = new JPanel();
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
		
		inicioBtnIniciar = new JButton("Iniciar");
		inicioBtnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SolicitaCines solicitud = new SolicitaCines();
				solicitud.SolicitarCines();
			}
		});
		inicioBtnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 40));
		inicioBtnIniciar.setBounds(327, 218, 296, 99);
		inicioPanel.add(inicioBtnIniciar);
		
		inicioBtnRegistrar = new JButton("Regístrate!");
		inicioBtnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		inicioBtnRegistrar.setBounds(415, 25, 225, 36);
		inicioPanel.add(inicioBtnRegistrar);
		
		JPanel registroPanel = new JPanel();
		registroPanel.setBounds(0, 0, 672, 350);
		frame.getContentPane().add(registroPanel);
		registroPanel.setLayout(null);
		
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
		
		registroCbSexo = new JComboBox();
		registroCbSexo.setToolTipText("Seleccione su Sexo");
		registroCbSexo.setMaximumRowCount(3);
		registroCbSexo.setBounds(141, 208, 136, 18);
		registroPanel.add(registroCbSexo);
		
		registroBtnAceptar = new JButton("Aceptar");
		registroBtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		registroBtnAceptar.setBounds(119, 259, 158, 49);
		registroPanel.add(registroBtnAceptar);
		
		registroBtnCancelar = new JButton("Cancelar");
		registroBtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		registroBtnCancelar.setBounds(422, 259, 158, 49);
		registroPanel.add(registroBtnCancelar);
	}
}