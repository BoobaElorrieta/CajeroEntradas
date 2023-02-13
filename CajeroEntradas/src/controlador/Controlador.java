package controlador;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
	SolicitaCines solicitudCine = null;
	SolicitaPeliculas solicitudPeliculas = null;
	SolicitaHorarios solicitudHorarios = null;
	SolicitaCliente solicitudClientes = null;

	// Busca los cines disponibles que hay
	public void buscarCine(JComboBox<String> scCbSeleccionCine) {
		scCbSeleccionCine.removeAllItems();
		solicitudCine = new SolicitaCines();
		ArrayList<Cine> cines = solicitudCine.getCines("SELECT nombre FROM Cines");
		for (int i = 0; i < cines.size(); i++) {
			scCbSeleccionCine.addItem(cines.get(i).getNombre());
		}
	}
	// Añade las peliculas al combo box enbase a el cine seleccionado
	public void escogerCine(JComboBox<String> scCbSeleccionCine, JComboBox<String> spCbSeleccionPeli, JLabel spLbl) {
		String cine = (String) scCbSeleccionCine.getSelectedItem();

		
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
		spLbl.setText("Cine " + cine);

	}
	// Nos Muestra las fecahs disponibles para esa pelicula
	public void escogerFecha(JComboBox<String> scCbSeleccionCine, JComboBox<String> spCbSeleccionPeli,JComboBox<String> spCbDia) {

//		Arreglar
		
		spCbSeleccionPeli.removeAllItems();
		String pelicula = (String) spCbSeleccionPeli.getSelectedItem();
		String cine = (String) scCbSeleccionCine.getSelectedItem();
		try {
		solicitudHorarios = new SolicitaHorarios();
		ArrayList<Proyeccion> proyeccion = solicitudHorarios.getProyecciones( "SELECT fecha, hora, precio, s.nombre "
				+ "FROM proyecciones pr "
				+ "JOIN salas S ON pr.cod_sala=S.cod "
				+ "JOIN peliculas pe ON pr.cod_peli=pe.codigo "
				+ "JOIN cines c ON c.cod = s.cod_cine "
				+ "WHERE c.nombre = '" + cine + "' AND titulo = '" + pelicula + "' "
				+ "GROUP BY fecha");
		System.out.println(proyeccion.toString());
		for (int i = 0; i < proyeccion.size(); i++) {
			spCbDia.addItem(proyeccion.get(i).getFecha().toString());
	}
		}catch (Exception e) {
			JFrame jFrame = new JFrame();
	        JOptionPane.showMessageDialog(jFrame, "ERROR (prueba a elegir una fecha que has elegido una fecha)");
			
		}
		
	}
	
	
	// Pone los horarios disponible en base a la pelicula seleccionada
	public void escogerHorarios(JComboBox<String> scCbSeleccionCine, JComboBox<String> horariosCbHorariosDisponibles, JComboBox<String> spCbSeleccionPeli, JLabel horariosLblHorariosDisponibles, JComboBox<String> spCbDia) {

		spCbDia.removeAllItems();
		String pelicula = (String) spCbSeleccionPeli.getSelectedItem();
		String fecha = (String) spCbDia.getSelectedItem();
		String cine = (String) scCbSeleccionCine.getSelectedItem();
		
		solicitudHorarios = new SolicitaHorarios();
		ArrayList<Proyeccion> proyeccion = solicitudHorarios.getProyecciones( "SELECT fecha, hora, precio, s.nombre\r\n"
				+ "FROM proyecciones pr JOIN salas s ON pr.cod_sala = s.cod\r\n"
				+ "JOIN peliculas pe ON pr.cod_peli = pe.codigo\r\n"
				+ "JOIN cines c ON s.cod_cine = c.cod\r\n"
				+ "WHERE c.nombre = '" + cine + "' and fecha = '" + fecha + "' and titulo = '" + pelicula + "'");
		for (int i = 0; i < proyeccion.size(); i++) {
			horariosCbHorariosDisponibles.addItem(proyeccion.get(i).getHora() + " / " + proyeccion.get(i).getPrecio() + "€  / " + proyeccion.get(i).getSala().getNombre());
			horariosLblHorariosDisponibles.setText(pelicula);
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
	
	  public void ventanaDeConfirmacion(JComboBox<String> horariosCbHorariosDisponibles, JComboBox<String> spCbSeleccionPeli, JComboBox<String> scCbSeleccionCine, JComboBox<String> spCbDia) {
			String horario = (String) horariosCbHorariosDisponibles.getSelectedItem();
			String pelicula = (String) spCbSeleccionPeli.getSelectedItem();
			String cine = (String) scCbSeleccionCine.getSelectedItem();
			String fecha = (String) spCbDia.getSelectedItem();

			
			String[] parts = horario.split("/");
			String hora = parts[0]; 
			String precio = parts[1];
			String sala = parts[2];
			
	        JFrame jFrame = new JFrame();
	        JOptionPane.showMessageDialog(jFrame, "Has seleccionado la siguientes opciones: \r\n" + "La pelicula " + pelicula + " sera el dia " + fecha + " a las " + hora + "en la sala " + sala + " del cine " + cine + " por un precio de " + precio);


	    }
	  
		public boolean comprobarLogin(JTextField loginTfEmail, JTextField loginTfContrasena) {
			String correo = null;
			String contrasenaUsuario = null;
			String contrasenaReal = null;
			boolean ret = false;
			correo = (String) loginTfEmail.getText();
			contrasenaUsuario = (String) loginTfContrasena.getText();
			try {
			
			solicitudClientes = new SolicitaCliente();
			ArrayList<Cliente> cliente = solicitudClientes.getClientes("SELECT email, contrasena FROM Clientes WHERE email = '" + correo + "'");
			contrasenaReal = cliente.get(0).getContrasena();
			if (contrasenaUsuario.equalsIgnoreCase(contrasenaReal)) {
				//Se le deja pasar
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "ACESO PERMITIDO");
				ret = true;
				
			}else {
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "ACESO DENEGADO");
				ret = false;
			}
		}catch (Exception e) {
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
