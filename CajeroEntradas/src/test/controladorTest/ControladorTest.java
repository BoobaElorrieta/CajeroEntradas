package test.controladorTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		ArrayList<Cine> cines = solicitaCine.getCines("SELECT nombre FROM cines");
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
		ArrayList<Cine> cines = solicitaCine.getCines("SELECT nombre FROM cines");
		for (int i = 0; i < cines.size(); i++) {
			cajeroEntradas.scCbSeleccionCine.addItem(cines.get(i).getNombre());
		}
		
		assertEquals(cines.size(), 3);
	}	
	
	@Test
	public void testEscogerCineNull() {
		cajeroEntradas = new CajeroEntradas();
		solicitaPeliculas = new SolicitaPeliculas();
		ArrayList<Pelicula> pelis = solicitaPeliculas.getPeliculas(
				"SELECT titulo "
					+ "FROM peliculas pe JOIN proyecciones pr ON pe.cod = pr.cod_peli "
					+ "JOIN salas s ON pr.cod_sala = s.cod "
					+ "JOIN cines c ON s.cod_cine = c.cod	"
					+ "WHERE c.nombre = 'Eneko' "
					+ "GROUP BY titulo "
					+ "ORDER BY fecha asc, hora ASC;");
		assertNotNull(pelis);
	}
	
	@Test
	public void testEscogerCineSize() {
		cajeroEntradas = new CajeroEntradas();
		solicitaPeliculas = new SolicitaPeliculas();
		ArrayList<Pelicula> pelis = solicitaPeliculas.getPeliculas(
				"SELECT titulo "
					+ "FROM peliculas pe JOIN proyecciones pr ON pe.cod = pr.cod_peli "
					+ "JOIN salas s ON pr.cod_sala = s.cod "
					+ "JOIN cines c ON s.cod_cine = c.cod	"
					+ "WHERE c.nombre = 'Eneko' "
					+ "GROUP BY titulo "
					+ "ORDER BY fecha asc, hora ASC;");
		assertEquals(pelis.size(), 2);
	}
	
	@Test
	public void testEscogerCineOrden() {
		cajeroEntradas = new CajeroEntradas();
		solicitaHorarios = new SolicitaHorarios();
		ArrayList<Proyeccion> fechas = solicitaHorarios.getProyecciones(
				"SELECT * "
					+ "FROM peliculas pe JOIN proyecciones pr ON pe.cod = pr.cod_peli "
					+ "JOIN salas s ON pr.cod_sala = s.cod "
					+ "JOIN cines c ON s.cod_cine = c.cod	"
					+ "WHERE c.nombre = 'Eneko' "
					+ "ORDER BY fecha;");
		assertEquals(25, fechas.size());
		
		java.util.Date fechaAnterior = null;
		
		for (Proyeccion fecha : fechas) {
			if (fechaAnterior != null) {
				assertTrue(fecha.getFecha().compareTo(fechaAnterior) >= 0);
			}
			fechaAnterior = fecha.getFecha();
		}
		
	} 
	
	
	@Test
	public void testEscogerHorariosNull() {
		cajeroEntradas = new CajeroEntradas();
		solicitaPeliculas = new SolicitaPeliculas();
		solicitaHorarios = new SolicitaHorarios();
		
		ArrayList<Proyeccion> proyecciones = solicitaHorarios.getProyecciones("SELECT fecha, hora, precio, s.nombre "
				+ "FROM proyecciones pr JOIN salas s ON pr.cod_sala = s.cod "
				+ "JOIN peliculas pe ON pr.cod_peli = pe.cod " 
				+ "JOIN cines c ON s.cod_cine = c.cod "
				+ "WHERE c.nombre = 'Eneko' and fecha = '2023-02-22' and titulo = 'Shrek 2'");
		assertNotNull(proyecciones);
	}
	
	@Test
	public void testEscogerHorariosSize() {
		cajeroEntradas = new CajeroEntradas();
		solicitaPeliculas = new SolicitaPeliculas();
		solicitaHorarios = new SolicitaHorarios();
		
		ArrayList<Proyeccion> proyecciones = solicitaHorarios.getProyecciones( "SELECT fecha, hora, precio, s.nombre "
				+ "FROM proyecciones pr JOIN salas s ON pr.cod_sala = s.cod "
				+ "JOIN peliculas pe ON pr.cod_peli = pe.cod " 
				+ "JOIN cines c ON s.cod_cine = c.cod "
				+ "WHERE c.nombre = 'Eneko' and fecha = '2023-02-22' and titulo = 'Shrek 2'");
		assertEquals(proyecciones.size(), 2);
	}
	
	@Test	
	public void selecionarHoraNull () {
		solicitaHorarios = new SolicitaHorarios();
		ArrayList<Proyeccion> proyecciones = solicitaHorarios.getProyecciones( "SELECT fecha, hora, precio, s.nombre "
				+ "FROM proyecciones pr JOIN salas s ON pr.cod_sala = s.cod "
				+ "JOIN peliculas pe ON pr.cod_peli = pe.cod "
				+ "JOIN cines c ON s.cod_cine = c.cod "
				+ "WHERE c.nombre = 'Eneko' and fecha = '2023-02-21' and titulo = 'Shrek 2' and hora = '17:00:00'");
		
		assertNotNull(proyecciones);
	}
	
	@Test
	public void selecionarHoraSize () {
		solicitaHorarios = new SolicitaHorarios();
		ArrayList<Proyeccion> proyecciones = solicitaHorarios.getProyecciones("SELECT fecha, hora, precio, s.nombre\r\n"
				+ "FROM proyecciones pr JOIN salas s ON pr.cod_sala = s.cod\r\n"
				+ "JOIN peliculas pe ON pr.cod_peli = pe.cod\r\n" + "JOIN cines c ON s.cod_cine = c.cod\r\n"
				+ "WHERE c.nombre = 'Eneko' and fecha = '2023-02-21' "
				+ "and titulo = 'Shrek 2' and hora = '17:00:00'"
				+ "ORDER BY hora asc;");
		
		assertEquals(proyecciones.size(), 1);
	}

	
}
