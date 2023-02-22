package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.bbdd.CompraEntradas;
import modelo.bbdd.RegistraCliente;
import modelo.bbdd.SolicitaCines;
import modelo.bbdd.SolicitaCliente;
import modelo.bbdd.SolicitaHorarios;
import modelo.bbdd.SolicitaPeliculas;
import modelo.pojos.Cine;
import modelo.pojos.Cliente;
import modelo.pojos.Entrada;
import modelo.pojos.Pelicula;
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
	ArrayList<String> datosPelicula = new ArrayList<String>();

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
		System.out.println(cliente.toString());
		RegistraCliente registraCliente = new RegistraCliente();
		registraCliente.insertCliente(cliente);
	}
	

	public void registrarEntrada() {
		entrada = new Entrada();
		proyeccion = new Proyeccion();
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
			JLabel precioSesiontLbl, JLabel horariosLblNombreSala, DefaultTableModel modelo) {
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

		String datos = pelicula + "," + hora + "," + cine + "," + fecha;

		datosPelicula.add(datos);
		for (int i = 0; i < datosPelicula.size(); i++) {
		System.out.print(datosPelicula.get(i));
//		System.out.print(datosPelicula.size());

		}

	}

	

	public void crearFichero() throws IOException {
		System.out.println("ha comezado1");
		for (int i = 0; i < datosPelicula.size(); i++) {
			String[] parts = datosPelicula.get(i).split(",");
			String pelicula = parts[0];
			String hora = parts[1];
			String cine = parts[2];
			String fecha = parts[3];
			
			
			System.out.println(pelicula);
			System.out.println(hora);
			System.out.println(cine);
			System.out.println(fecha);
			

			System.out.println("ha comezado2");
			File entrada = new File("src\tickets\ticket.txt");
			FileWriter fichero = null;
			PrintWriter pw = null;
			fichero = new FileWriter(entrada);
			pw = new PrintWriter(fichero);
			pw.println("---Ticket---");
			pw.println("Cine: " + cine);
			pw.println("Pelicula: " + pelicula);
			pw.println("Fecha: " + fecha);
			pw.println("Hora: " + hora);
			pw.println("Sala: ");
			pw.println("Precio: ");
			fichero.close();
			System.out.println("ha terminado");
		}
	}
	
	public void calcularEntrada() {
		System.exit(0);
	}
	
	public void cerrarPrograma() {
		System.exit(0);
	}
	

}
