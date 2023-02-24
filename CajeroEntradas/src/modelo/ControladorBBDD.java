package modelo;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Controlador;
import modelo.bbdd.SolicitaCines;
import modelo.bbdd.SolicitaCliente;
import modelo.bbdd.SolicitaHorarios;
import modelo.bbdd.SolicitaPeliculas;
import modelo.pojos.Cine;
import modelo.pojos.Cliente;
import modelo.pojos.Pelicula;
import modelo.pojos.Proyeccion;
import vista.CajeroEntradas;

public class ControladorBBDD {

	Controlador controlador = null;
	CajeroEntradas cajero = null;
	SolicitaCines solicitaCine = null;
	SolicitaPeliculas solicitaPeliculas = null;
	SolicitaHorarios solicitaHorarios = null;
	SolicitaCliente solicitaClientes = null;

	// Busca los cines disponibles que hay
		public void buscarCine(JComboBox<String> scCbSeleccionCine) {
			scCbSeleccionCine.removeAllItems();
			solicitaCine = new SolicitaCines();
			ArrayList<Cine> cines = solicitaCine.getCines("SELECT nombre FROM cines");
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
					.getPeliculas("SELECT titulo "
							+ "FROM peliculas pe JOIN proyecciones pr ON pe.cod = pr.cod_peli "
							+ "JOIN salas s ON pr.cod_sala = s.cod "
							+ "JOIN cines c ON s.cod_cine = c.cod	"
							+ "WHERE c.nombre = '" + cine +"' "
							+ "GROUP BY titulo "
							+ "ORDER BY fecha asc, hora ASC;");
			for (int i = 0; i < pelis.size(); i++) {
				spCbSeleccionPeli.addItem(pelis.get(i).getTitulo());

			}
			spLbl.setText("Cine " + cine);

		}

		// Nos Muestra las fecahs disponibles para esa pelicula
		public void escogerFecha(JComboBox<String> scCbSeleccionCine, JComboBox<String> spCbSeleccionPeli,
				JComboBox<String> spCbDia) {

//				Arreglar

			// spCbSeleccionPeli.removeAllItems();
			spCbDia.removeAllItems();
			String pelicula = (String) spCbSeleccionPeli.getSelectedItem();
			String cine = (String) scCbSeleccionCine.getSelectedItem();
//			try {
				solicitaHorarios = new SolicitaHorarios();
				ArrayList<Proyeccion> proyecciones = solicitaHorarios
						.getProyecciones("SELECT fecha, hora, precio, s.nombre " 
								+ "FROM proyecciones pr "
								+ "JOIN salas s ON pr.cod_sala=s.cod " 
								+ "JOIN peliculas pe ON pr.cod_peli=pe.cod "
								+ "JOIN cines c ON c.cod = s.cod_cine " 
								+ "WHERE c.nombre = '" + cine + "' AND titulo = '"
								+ pelicula + "' " 
								+ "GROUP BY fecha "
								+ "ORDER BY fecha");
				for (int i = 0; i < proyecciones.size(); i++) {
					spCbDia.addItem(proyecciones.get(i).getFecha().toString());
//				}
//			} catch (Exception e) {
//				JFrame jFrame = new JFrame();
//				JOptionPane.showMessageDialog(jFrame, "ERROR (prueba a elegir una fecha que has elegido una fecha)");

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
					+ "JOIN peliculas pe ON pr.cod_peli = pe.cod\r\n" 
					+ "JOIN cines c ON s.cod_cine = c.cod\r\n"
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
			JLabel precioSesiontLbl, JLabel horariosLblNombreSala, JButton horariosBtnAceptar) {
		String pelicula = (String) spCbSeleccionPeli.getSelectedItem();
		String fecha = (String) spCbDia.getSelectedItem();
		String cine = (String) scCbSeleccionCine.getSelectedItem();
		String hora = (String) horariosCbHorariosDisponibles.getSelectedItem();
		solicitaHorarios = new SolicitaHorarios();
		ArrayList<Proyeccion> proyecciones = solicitaHorarios.getProyecciones("SELECT fecha, hora, precio, s.nombre\r\n"
				+ "FROM proyecciones pr JOIN salas s ON pr.cod_sala = s.cod\r\n"
				+ "JOIN peliculas pe ON pr.cod_peli = pe.cod\r\n" + "JOIN cines c ON s.cod_cine = c.cod\r\n"
				+ "WHERE c.nombre = '" + cine + "' and fecha = '" + fecha + "' and titulo = '" + pelicula
				+ "' and hora = '" + hora + "'"
				+ "ORDER BY hora asc;");
		for (int i = 0; i < proyecciones.size(); i++) {
			precioSesiontLbl.setText("" + proyecciones.get(i).getPrecio() + "");
			horariosLblNombreSala.setText("" + proyecciones.get(i).getSala().getNombre() + "");
		}
		horariosBtnAceptar.setEnabled(true);

	}
	
	public boolean comprobarLogin(JTextField loginTfEmail, JTextField loginTfContrasena) throws IOException {
		controlador = new Controlador();
		String correo = null;
		String contrasenaUsuario = null;
		String contrasenaReal = null;
		boolean loging = false;
		int ret;
		correo = (String) loginTfEmail.getText();
		contrasenaUsuario = (String) loginTfContrasena.getText();
		try {

			solicitaClientes = new SolicitaCliente();
			ArrayList<Cliente> cliente = solicitaClientes
					.getClientes("SELECT email, contrasena FROM clientes WHERE email = '" + correo + "'");
			contrasenaReal = cliente.get(0).getContrasena();
			if (contrasenaUsuario.equalsIgnoreCase(contrasenaReal)) {
				// Se le deja pasar
				
//				Añadir funcion de añadir a la BDD
				
				
				JFrame jFrame = new JFrame();
				ret = JOptionPane.showConfirmDialog(null, "ACESO PERMITIDO \r\n" + "Desea imprimir el ticket?",
						"YES_NO_OPTION", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

				switch (ret) {
				case 0:
					String directorio = JOptionPane.showInputDialog("Donde quiere guardar su ticket?");
					JOptionPane.showMessageDialog(jFrame, "Su ticket " + directorio
							+ " ha sido guardado en DESCARGAS \r\n" + "Gracias por su compra:)");
					controlador.crearFichero();
					break;
				case 1:
					JOptionPane.showMessageDialog(jFrame, "Gracias Por su compra:)");
					break;

				}
			loging = false;
			} else {
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "ACESO DENEGADO");
			}

		} catch (Exception e) {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "ERROR, ese email no existe en la base de datos.");
		}
		return loging;

	}	
}
