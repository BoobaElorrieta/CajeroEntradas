package test.controladorTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.junit.jupiter.api.Test;

import controlador.Controlador;
import modelo.bbdd.SolicitaCines;
import modelo.bbdd.SolicitaHorarios;
import modelo.bbdd.SolicitaPeliculas;
import modelo.pojos.Cine;
import modelo.pojos.Pelicula;
import modelo.pojos.Proyeccion;
import vista.CajeroEntradas;

class ControladorTest {
	
	Controlador controlador = null;
	CajeroEntradas cajeroEntradas = null;
	SolicitaCines solicitaCine = null;
	SolicitaPeliculas solicitaPeliculas = null;
	SolicitaHorarios solicitaHorarios = null;
	
	@Test
	public void testBuscarCines() {
		controlador = new Controlador();
		cajeroEntradas = new CajeroEntradas();
		solicitaCine = new SolicitaCines();
		ArrayList<Cine> cines = solicitaCine.getCines();
		for (int i = 0; i < cines.size(); i++) {
			cajeroEntradas.scCbSeleccionCine.addItem(cines.get(i).getNombre());
		}
		assertNotNull(cines);
	}
	
	public void testEscogerCine() {
		cajeroEntradas = new CajeroEntradas();
		solicitaPeliculas = new SolicitaPeliculas();
		String cine = (String) cajeroEntradas.scCbSeleccionCine.getSelectedItem();
		ArrayList<Pelicula> pelis = solicitaPeliculas.getPeliculas(
				"Select Titulo "
				+ "From Peliculas, Proyecciones, Salas, Cines "
				+ "Where cines.Nombre = '" + cine + "'and peliculas.codigo = proyecciones.cod_peli and "
				+ "proyecciones.cod_sala = salas.cod and salas.cod_cine = cines.cod "
				+ "GROUP BY titulo "
				+ "ORDER BY FECHA asc, hora ASC");
		assertNotNull(pelis);
	}
	
	public void testEscogerHorarios(JComboBox<String> horariosCbHorariosDisponibles, JComboBox<String> spCbSeleccionPeli, JLabel horariosLblHorariosDisponibles) {
		cajeroEntradas = new CajeroEntradas();
		solicitaPeliculas = new SolicitaPeliculas();
		solicitaHorarios = new SolicitaHorarios();
		String pelicula = (String) spCbSeleccionPeli.getSelectedItem();
		
		ArrayList<Proyeccion> proyeccion = solicitaHorarios.getProyecciones( "Select fecha, hora, precio, nombre From proyecciones, salas, peliculas WHERE proyecciones.cod_sala = salas.cod and proyecciones.cod_peli = peliculas.codigo and peliculas.titulo = '" + pelicula + "'");
		assertNotNull(proyeccion);
	}
}
