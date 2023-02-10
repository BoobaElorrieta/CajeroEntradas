package controlador;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import modelo.bbdd.RegistraCliente;
import modelo.bbdd.SolicitaCines;
import modelo.bbdd.SolicitaHorarios;
import modelo.bbdd.SolicitaPeliculas;
import modelo.pojos.Cine;
import modelo.pojos.Cliente;
import modelo.pojos.Pelicula;
import modelo.pojos.Proyeccion;
import vista.CajeroEntradas;

public class Controlador {

	CajeroEntradas cajero = null;
	SolicitaCines solicitudCine = null;
	SolicitaPeliculas solicitudPeliculas = null;
	SolicitaHorarios solicitudHorarios = null;

	public void asignarCinePrueba(JComboBox<String> scCbSeleccionCine) {
		scCbSeleccionCine.removeAllItems();
		solicitudCine = new SolicitaCines();
		ArrayList<Cine> cines = solicitudCine.getCines();
		for (int i = 0; i < cines.size(); i++) {
			scCbSeleccionCine.addItem(cines.get(i).getNombre());

		}
	}

	public void esogerCine(JComboBox<String> scCbSeleccionCine, JComboBox<String> spCbSeleccionPeli) {
		String cine = null;
		cine = (String) scCbSeleccionCine.getSelectedItem();

		// busca las peliculas y las añade al combobox
		spCbSeleccionPeli.removeAllItems();
		solicitudPeliculas = new SolicitaPeliculas();
		ArrayList<Pelicula> pelis = solicitudPeliculas.getPeliculas(
				"Select Titulo "
				+ "From Peliculas, Proyecciones, Salas, Cines "
				+ "Where cines.Nombre = '" + cine + "'and peliculas.codigo = proyecciones.cod_peli and "
					+ "proyecciones.cod_sala = salas.cod and salas.cod_cine = cines.cod "
				+ "GROUP BY titulo "
				+ "ORDER BY FECHA asc, hora ASC");
		for (int i = 0; i < pelis.size(); i++) {
			spCbSeleccionPeli.addItem(pelis.get(i).getTitulo());

		}

	}
	
	public void escogerHorarios(JComboBox<String> horariosCbHorariosDisponibles, JComboBox<String> spCbSeleccionPeli) {
		String pelicula = null;
		pelicula = (String) spCbSeleccionPeli.getSelectedItem();
		

		
		// busca las peliculas y las añade al combobox
		solicitudHorarios = new SolicitaHorarios();
		ArrayList<Proyeccion> proyeccion = solicitudHorarios.getProyecciones( "Select fecha, hora, precio, nombre From proyecciones, salas, peliculas WHERE proyecciones.cod_sala = salas.cod and proyecciones.cod_peli = peliculas.codigo and peliculas.titulo = '" + pelicula + "'");
		for (int i = 0; i < proyeccion.size(); i++) {
			horariosCbHorariosDisponibles.addItem(proyeccion.get(i).getFecha() + " / " + proyeccion.get(i).getHora() + " / " + proyeccion.get(i).getPrecio() + "€  / " + proyeccion.get(i).getSala().getNombre());

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
		cliente.setTfno(tfno.getText());
		cliente.setDireccion(direccion.getText());
		cliente.setEmail(email.getText());
		System.out.println(cliente.toString());
		RegistraCliente registraCliente = new RegistraCliente();
		registraCliente.insertCliente(cliente);
	}
}
