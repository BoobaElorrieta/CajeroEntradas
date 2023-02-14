package test.controladorTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
	Cine cine = null;
	
	@Test
	public void testBuscarCinesNull() {
		controlador = new Controlador();
		cajeroEntradas = new CajeroEntradas();
		solicitaCine = new SolicitaCines();
		ArrayList<Cine> cines = solicitaCine.getCines("SELECT nombre FROM Cines");
		for (int i = 0; i < cines.size(); i++) {
			cajeroEntradas.scCbSeleccionCine.addItem(cines.get(i).getNombre());
		}
		assertNotNull(cines);
	}
	
	@Test
	public void testBuscarCinesSize() {
		controlador = new Controlador();
		cajeroEntradas = new CajeroEntradas();
		solicitaCine = new SolicitaCines();
		ArrayList<Cine> cines = solicitaCine.getCines("SELECT nombre FROM Cines");
		for (int i = 0; i < cines.size(); i++) {
			cajeroEntradas.scCbSeleccionCine.addItem(cines.get(i).getNombre());
		}
		
		assertEquals(cines.size(), 3);
	}	
	
	
	public void testEscogerCineNull() {
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
	
	public void testEscogerCineSize() {
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
		assertEquals(pelis.size(), 2);
	}
	
	public void testEscogerHorariosNull() {
		cajeroEntradas = new CajeroEntradas();
		solicitaPeliculas = new SolicitaPeliculas();
		solicitaHorarios = new SolicitaHorarios();
		
		ArrayList<Proyeccion> proyecciones = solicitaHorarios.getProyecciones( "Select fecha, hora, precio, nombre From proyecciones, salas, peliculas WHERE proyecciones.cod_sala = salas.cod and proyecciones.cod_peli = peliculas.codigo and peliculas.titulo = 'Shrek2'");
		assertNotNull(proyecciones);
	}
	
	public void testEscogerHorariosSize() {
		cajeroEntradas = new CajeroEntradas();
		solicitaPeliculas = new SolicitaPeliculas();
		solicitaHorarios = new SolicitaHorarios();
		
		ArrayList<Proyeccion> proyecciones = solicitaHorarios.getProyecciones( "Select fecha, hora, precio, nombre From proyecciones, salas, peliculas WHERE proyecciones.cod_sala = salas.cod and proyecciones.cod_peli = peliculas.codigo and peliculas.titulo = 'Shrek2'");
		assertEquals(proyecciones, 11);
	}
	
	public void selecionarHoraNull () {
		solicitaHorarios = new SolicitaHorarios();
		ArrayList<Proyeccion> proyecciones = solicitaHorarios.getProyecciones( "SELECT fecha, hora, precio, s.nombre\r\n"
				+ "FROM proyecciones pr JOIN salas s ON pr.cod_sala = s.cod"
				+ "JOIN peliculas pe ON pr.cod_peli = pe.codigo"
				+ "JOIN cines c ON s.cod_cine = c.cod"
				+ "WHERE c.nombre = 'Eneko' and fecha = '2023-02-21' and titulo = 'Shrek 2' and hora = '17:00:00'");
		
		assertNotNull(proyecciones);
	}
	
	public void selecionarHoraSize () {
		solicitaHorarios = new SolicitaHorarios();
		ArrayList<Proyeccion> proyecciones = solicitaHorarios.getProyecciones( "SELECT fecha, hora, precio, s.nombre\r\n"
				+ "FROM proyecciones pr JOIN salas s ON pr.cod_sala = s.cod"
				+ "JOIN peliculas pe ON pr.cod_peli = pe.codigo"
				+ "JOIN cines c ON s.cod_cine = c.cod"
				+ "WHERE c.nombre = 'Eneko' and fecha = '2023-02-21' and titulo = 'Shrek 2' and hora = '17:00:00'");
		
		assertEquals(proyecciones.size(), 1);
	}
	
}
