package controlador;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

	// Busca los cines disponibles que hay
	public void asignarCinePrueba(JComboBox<String> scCbSeleccionCine) {
		scCbSeleccionCine.removeAllItems();
		solicitudCine = new SolicitaCines();
		ArrayList<Cine> cines = solicitudCine.getCines();
		for (int i = 0; i < cines.size(); i++) {
			scCbSeleccionCine.addItem(cines.get(i).getNombre());

		}
	}
	// Añade las peliculas al combo box enbase a el cine seleccionado
	public void escogerCine(JComboBox<String> scCbSeleccionCine, JComboBox<String> spCbSeleccionPeli) {
		String cine = null;
		cine = (String) scCbSeleccionCine.getSelectedItem();

		
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
	// Pone los horarios disponible en base a la pelicula seleccionada
	public void escogerHorarios(JComboBox<String> horariosCbHorariosDisponibles, JComboBox<String> spCbSeleccionPeli) {
		String pelicula = null;
		pelicula = (String) spCbSeleccionPeli.getSelectedItem();
		
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
	
	// Ventana Emergente
	
	  public void ventanaDeConfirmacion(JComboBox<String> horariosCbHorariosDisponibles) {
			String cine = null;
			cine = (String) horariosCbHorariosDisponibles.getSelectedItem();
			
			String[] parts = cine.split("/");
			String fecha = parts[0];
			String hora = parts[1]; 
			String precio = parts[2];
			String sala = parts[3];
			
	        JFrame jFrame = new JFrame();
	        JOptionPane.showMessageDialog(jFrame, "Has seleccionado la siguientes opciones: \r\n" + "La pelicula sera el dia " + fecha + "a las " + hora + "en la sala " + sala + " por un precio de " + precio);


	    }
}
