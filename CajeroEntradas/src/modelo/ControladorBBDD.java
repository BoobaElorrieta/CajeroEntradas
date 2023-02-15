package modelo;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import modelo.bbdd.SolicitaCines;
import modelo.bbdd.SolicitaCliente;
import modelo.bbdd.SolicitaHorarios;
import modelo.bbdd.SolicitaPeliculas;
import modelo.pojos.Cine;
import modelo.pojos.Pelicula;
import modelo.pojos.Proyeccion;
import vista.CajeroEntradas;

public class ControladorBBDD {

	CajeroEntradas cajero = null;
	SolicitaCines solicitaCine = null;
	SolicitaPeliculas solicitaPeliculas = null;
	SolicitaHorarios solicitaHorarios = null;
	SolicitaCliente solicitaClientes = null;

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

//				Arreglar

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
				+ "' and hora = '" + hora + "'"
				+ "ORDER BY hora asc;");
		for (int i = 0; i < proyecciones.size(); i++) {
			precioSesiontLbl.setText("" + proyecciones.get(i).getPrecio() + " €");
			horariosLblNombreSala.setText("" + proyecciones.get(i).getSala().getNombre() + "");
		}

	}
		
}
