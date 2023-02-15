package controlador;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.bbdd.RegistraCliente;
import modelo.bbdd.SolicitaCines;
import modelo.bbdd.SolicitaCliente;
import modelo.bbdd.SolicitaHorarios;
import modelo.bbdd.SolicitaPeliculas;
import modelo.pojos.Cine;
import modelo.pojos.Cliente;
import modelo.pojos.Pelicula;
import modelo.pojos.Proyeccion;
import vista.CajeroEntradas;

public class Controlador {

	CajeroEntradas cajero = null;
	SolicitaCines solicitaCine = null;
	SolicitaPeliculas solicitaPeliculas = null;
	SolicitaHorarios solicitaHorarios = null;
	SolicitaCliente solicitaClientes = null;

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

	// Busca los cines disponibles que hay
	public void buscarCine(JComboBox<String> scCbSeleccionCine) {
		scCbSeleccionCine.removeAllItems();
		solicitaCine = new SolicitaCines();
		ArrayList<Cine> cines = solicitaCine.getCines("SELECT nombre FROM Cines");
		for (int i = 0; i < cines.size(); i++) {
			scCbSeleccionCine.addItem(cines.get(i).getNombre());
		}
	}

	// Añade las peliculas al combo box enbase a el cine seleccionado
	public void escogerCine(JComboBox<String> scCbSeleccionCine, JComboBox<String> spCbSeleccionPeli, JLabel spLbl) {
		String cine = (String) scCbSeleccionCine.getSelectedItem();

		spCbSeleccionPeli.removeAllItems();
		solicitaPeliculas = new SolicitaPeliculas();
		ArrayList<Pelicula> pelis = solicitaPeliculas
				.getPeliculas("Select Titulo " + "From Peliculas, Proyecciones, Salas, Cines "
						+ "Where cines.Nombre = '" + cine + "'and peliculas.codigo = proyecciones.cod_peli and "
						+ "proyecciones.cod_sala = salas.cod and salas.cod_cine = cines.cod " + "GROUP BY titulo "
						+ "ORDER BY FECHA asc, hora ASC");
		for (int i = 0; i < pelis.size(); i++) {
			spCbSeleccionPeli.addItem(pelis.get(i).getTitulo());

		}
		spLbl.setText("Cine " + cine);

	}

	// Nos Muestra las fecahs disponibles para esa pelicula
	public void escogerFecha(JComboBox<String> scCbSeleccionCine, JComboBox<String> spCbSeleccionPeli,
			JComboBox<String> spCbDia) {

//		Arreglar

		// spCbSeleccionPeli.removeAllItems();
		spCbDia.removeAllItems();
		String pelicula = (String) spCbSeleccionPeli.getSelectedItem();
		String cine = (String) scCbSeleccionCine.getSelectedItem();
		try {
			solicitaHorarios = new SolicitaHorarios();
			ArrayList<Proyeccion> proyecciones = solicitaHorarios
					.getProyecciones("SELECT fecha, hora, precio, s.nombre " + "FROM proyecciones pr "
							+ "JOIN salas S ON pr.cod_sala=S.cod " + "JOIN peliculas pe ON pr.cod_peli=pe.codigo "
							+ "JOIN cines c ON c.cod = s.cod_cine " + "WHERE c.nombre = '" + cine + "' AND titulo = '"
							+ pelicula + "' " + "GROUP BY fecha");
			for (int i = 0; i < proyecciones.size(); i++) {
				spCbDia.addItem(proyecciones.get(i).getFecha().toString());
			}
		} catch (Exception e) {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "ERROR (prueba a elegir una fecha que has elegido una fecha)");

		}

	}

	// Pone los horarios disponible en base a la pelicula seleccionada
	public void escogerHorarios(JComboBox<String> scCbSeleccionCine, JComboBox<String> horariosCbHorariosDisponibles,
			JComboBox<String> spCbSeleccionPeli, JLabel horariosLblHorariosDisponibles, JComboBox<String> spCbDia) {

		horariosCbHorariosDisponibles.removeAllItems();
		String pelicula = (String) spCbSeleccionPeli.getSelectedItem();
		String fecha = (String) spCbDia.getSelectedItem();
		String cine = (String) scCbSeleccionCine.getSelectedItem();

		solicitaHorarios = new SolicitaHorarios();
		ArrayList<Proyeccion> proyecciones = solicitaHorarios.getProyecciones("SELECT fecha, hora, precio, s.nombre\r\n"
				+ "FROM proyecciones pr JOIN salas s ON pr.cod_sala = s.cod\r\n"
				+ "JOIN peliculas pe ON pr.cod_peli = pe.codigo\r\n" + "JOIN cines c ON s.cod_cine = c.cod\r\n"
				+ "WHERE c.nombre = '" + cine + "' and fecha = '" + fecha + "' and titulo = '" + pelicula + "'");
		for (int i = 0; i < proyecciones.size(); i++) {
			horariosCbHorariosDisponibles.addItem(
					proyecciones.get(i).getHora().toString()/*
															 * + " / " + proyeccion.get(i).getPrecio() + "€  / " +
															 * proyeccion.get(i).getSala().getNombre()
															 */);
			horariosLblHorariosDisponibles.setText(pelicula);
		}
	}

	public void selecionarHora(JComboBox<String> scCbSeleccionCine, JComboBox<String> horariosCbHorariosDisponibles,
			JComboBox<String> spCbSeleccionPeli, JLabel horariosLblHorariosDisponibles, JComboBox<String> spCbDia,
			JLabel precioSesiontLbl, JLabel horariosLblNombreSala) {
		String pelicula = (String) spCbSeleccionPeli.getSelectedItem();
		String fecha = (String) spCbDia.getSelectedItem();
		String cine = (String) scCbSeleccionCine.getSelectedItem();
		String hora = (String) horariosCbHorariosDisponibles.getSelectedItem();
		solicitaHorarios = new SolicitaHorarios();
		ArrayList<Proyeccion> proyecciones = solicitaHorarios.getProyecciones("SELECT fecha, hora, precio, s.nombre\r\n"
				+ "FROM proyecciones pr JOIN salas s ON pr.cod_sala = s.cod\r\n"
				+ "JOIN peliculas pe ON pr.cod_peli = pe.codigo\r\n" + "JOIN cines c ON s.cod_cine = c.cod\r\n"
				+ "WHERE c.nombre = '" + cine + "' and fecha = '" + fecha + "' and titulo = '" + pelicula
				+ "' and hora = '" + hora + "'");
		for (int i = 0; i < proyecciones.size(); i++) {
			precioSesiontLbl.setText("" + proyecciones.get(i).getPrecio() + " €");
			horariosLblNombreSala.setText("" + proyecciones.get(i).getSala().getNombre() + "");
		}

	}

	public void registrarUsuario(JTextField dni, JTextField nombre, JTextField apellidos, JTextField contrasena,
			JTextField tfno, JTextField direccion, JTextField email, JComboBox<String> sexo) {
		Cliente cliente = new Cliente();

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
		
		modelo.addRow(new String[] {hora, pelicula, cine, fecha, precio, sala});

	}

	public boolean comprobarLogin(JTextField loginTfEmail, JTextField loginTfContrasena) {
		String correo = null;
		String contrasenaUsuario = null;
		String contrasenaReal = null;
		boolean ret = false;
		correo = (String) loginTfEmail.getText();
		contrasenaUsuario = (String) loginTfContrasena.getText();
		try {

			solicitaClientes = new SolicitaCliente();
			ArrayList<Cliente> cliente = solicitaClientes
					.getClientes("SELECT email, contrasena FROM Clientes WHERE email = '" + correo + "'");
			contrasenaReal = cliente.get(0).getContrasena();
			if (contrasenaUsuario.equalsIgnoreCase(contrasenaReal)) {
				// Se le deja pasar
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "ACESO PERMITIDO");
				ret = true;

			} else {
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "ACESO DENEGADO");
				ret = false;
			}
		} catch (Exception e) {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "ERROR, ese email no existe en la base de datos.");
			ret = false;
		}
		return ret;
	}

	public void cerrarPrograma() {
		System.exit(0);
	}
}
