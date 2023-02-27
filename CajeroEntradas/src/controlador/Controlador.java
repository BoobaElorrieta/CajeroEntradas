package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.ControladorBBDD;
import modelo.bbdd.CompraEntradas;
import modelo.bbdd.RegistraCliente;
import modelo.bbdd.SolicitaCines;
import modelo.bbdd.SolicitaCliente;
import modelo.bbdd.SolicitaHorarios;
import modelo.bbdd.SolicitaPeliculas;
import modelo.pojos.Cliente;
import modelo.pojos.Entrada;
import modelo.pojos.Proyeccion;
import vista.CajeroEntradas;

public class Controlador {

	Proyeccion proyeccion = null;
	Cliente cliente = null;
	Entrada entrada = null;
	Date date = null;
	CajeroEntradas cajero = null;
	SolicitaCines solicitaCine = null;
	SolicitaPeliculas solicitaPeliculas = null;
	SolicitaHorarios solicitaHorarios = null;
	SolicitaCliente solicitaClientes = null;
	CompraEntradas compraEntradas = null;
	ControladorBBDD bbdd = null;

//	Ir al panel Inicio

	public void mostrarPanelInicio(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel,
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(true);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);
	}

//	Ir al panel Registro
	public void mostrarPanelRegistro(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel,
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(true);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);
	}

//	Ir al panel Seleccion Cine

	public void mostrarPanelSeleccionCine(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel,
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(true);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);
	}

//	Ir al panel Seleccion Peli

	public void mostrarPanelSeleccionPeli(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel,
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(true);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);
	}

//	Ir al panel Horarios

	public void mostrarPanelHorarios(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel,
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(true);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);
	}

//	Ir al panel Resumen Compra

	public void mostrarPanelResumenCompra(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel,
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(true);
		loginPanel.setVisible(false);
	}

//	Ir al panel Login

	public void mostrarPanelLogin(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel,
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(true);
	}

//	Registrar el Usuario

	public void registrarUsuario(JTextField dni, JTextField nombre, JTextField apellidos, JTextField contrasena,
			JTextField tfno, JTextField direccion, JTextField email, JComboBox<String> sexo) {
		cliente = new Cliente();

		cliente.setDni(dni.getText());
		cliente.setNombre(nombre.getText());
		cliente.setApellidos(apellidos.getText());
		cliente.setSexo(sexo.getSelectedItem().toString());
		cliente.setContrasena(contrasena.getText());
		cliente.setTfno(Integer.parseInt(tfno.getText()));
		cliente.setDireccion(direccion.getText());
		cliente.setEmail(email.getText());
		RegistraCliente registraCliente = new RegistraCliente();
		registraCliente.insertCliente(cliente);
	}

//	Registrar la entrada

	public void registrarEntrada(Cliente cliente/* , Proyeccion proyeccion */) {
		entrada = new Entrada();
		compraEntradas = new CompraEntradas();
		Date date = new Date();

//		Hacer un metodo q devuelva el usuario logueado y otro para la proyeccion seleccionada

		long timeInMilliSeconds = date.getTime();
		java.sql.Date dateSQL = new java.sql.Date(timeInMilliSeconds);

		entrada.setFechaDeCompra(dateSQL);
		entrada.setCliente(cliente);
		entrada.setProyeccion(proyeccion);

		compraEntradas.insertEntrada(entrada);
	}

	// Ventana Emergente

	public void ventanaDeConfirmacion(JComboBox<String> horariosCbHorariosDisponibles,
			JComboBox<String> spCbSeleccionPeli, JComboBox<String> scCbSeleccionCine, JComboBox<String> spCbDia,
			JLabel precioSesiontLbl, JLabel horariosLblNombreSala, DefaultTableModel modelo, JButton horariosBtnAceptar,
			ArrayList<String> datosPeliculas) {
		String hora = (String) horariosCbHorariosDisponibles.getSelectedItem();
		String pelicula = (String) spCbSeleccionPeli.getSelectedItem();
		String cine = (String) scCbSeleccionCine.getSelectedItem();
		String fecha = (String) spCbDia.getSelectedItem();
		String precio = (String) precioSesiontLbl.getText();
		String sala = (String) horariosLblNombreSala.getText();

		JFrame jFrame = new JFrame();
		JOptionPane.showMessageDialog(jFrame,
				"Has seleccionado la siguientes opciones: \r\n" + "La pelicula " + pelicula + " sera el dia " + fecha
						+ " a las " + hora + "en la sala " + sala + " del cine " + cine + " por un precio de "
						+ precio);
		modelo.addRow(new String[] { hora, pelicula, cine, fecha, precio, sala });
		String datos = pelicula + "," + hora + "," + cine + "," + fecha + "," + sala + "," + precio;
		datosPeliculas.add(datos);
		horariosBtnAceptar.setEnabled(false);
	}

//	Calcular el Precio Total

	public void calcularPrecioTotal(DefaultTableModel modelo, JTextArea rcTaPrecioTotal) {

		double precioTotal = 0;
		ArrayList<String> precios = new ArrayList<String>();
		int filasDeLaTabla = modelo.getRowCount();

		for (int i = 0; i < modelo.getRowCount(); i++) {
			precios.add(modelo.getValueAt(i, 4).toString());
		}

		for (int i = 0; i < precios.size(); i++) {
			precioTotal = precioTotal + Integer.parseInt(precios.get(i));
		}

		if (filasDeLaTabla == 2) {
			precioTotal = precioTotal * 0.8;
		} else if (filasDeLaTabla == 3) {
			precioTotal = precioTotal * 0.7;
		} else if (filasDeLaTabla == 4) {
			precioTotal = precioTotal * 0.6;
		}
		if (filasDeLaTabla >= 5) {
			precioTotal = precioTotal * 0.5;
		}

		precioTotal = Math.round(precioTotal * 100) / 100d;

		rcTaPrecioTotal.setText("" + precioTotal + " €");

	}

	public void crearFichero(ArrayList<String> datosPeliculas) throws IOException {
		for (int i = 0; i < datosPeliculas.size(); i++) {
			bbdd = new ControladorBBDD();
			DateFormat dateFormat = new SimpleDateFormat("MMM yyyy HH_mm_ss");
			String date = dateFormat.format(new Date());
			
			String datosPelicula = datosPeliculas.get(i);
			String[] infoPeli = datosPelicula.split(",");
			String pelicula = infoPeli[0];
			String hora = infoPeli[1];
			String cine = infoPeli[2];
			String fecha = infoPeli[3];
			String sala = infoPeli[4];
			String precio = infoPeli[5];

			
			File entrada = new File("src//tickets//" + date + ".txt");
			FileWriter fichero = null;
			PrintWriter pw = null;
			fichero = new FileWriter(entrada, true);
			pw = new PrintWriter(fichero);
			pw.println("---Ticket---");
			pw.println("Cine: " + cine);
			pw.println("Pelicula: " + pelicula);
			pw.println("Fecha: " + fecha);
			pw.println("Hora: " + hora);
			pw.println("Sala: " + sala);
			pw.println("Precio: " + precio + "€");
			pw.println("Fecha impresion: " + date);
			pw.println("------------------------");
			pw.println("");
			fichero.close();
		}
		datosPeliculas.clear();
	}

	public void cerrarPrograma() {
		System.exit(0);
	}

}
