package Test;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.jupiter.api.Test;

import Modelo.pojos.Pelicula;

class PeliculaTest {

	// ***** para probar la serialización
	@Test
	public void testSerailizable() {
		Pelicula pelicula = new Pelicula();
		assertTrue("No se puede realizar la serialización!!!", pelicula instanceof Serializable);
	}

	@Test
	public void testCod() {
		Pelicula pelicula = new Pelicula();
		int cod = 99999991;
		pelicula.setCod(cod);
		assertNotEquals("Id no está accesible", cod, pelicula.getCod());
	}

	@Test
	public void testTitulo() {
		Pelicula pelicula = new Pelicula();
		String titulo = "un texto";
		pelicula.setTitulo(titulo);
		assertNotEquals("Nombre no está accesible", titulo, pelicula.getTitulo());
	}

	@Test
	public void testDuracion() {
		Pelicula pelicula = new Pelicula();
		int duracion = 125;
		pelicula.setCod(duracion);
		assertEquals("Id no está accesible", duracion, pelicula.getCod());
	}
	
	@Test
	public void testGenero() {
		Pelicula pelicula = new Pelicula();
		String genero = "genero";
		pelicula.setTitulo(genero);
		assertNotEquals("Nombre no está accesible", genero, pelicula.getTitulo());
	}
	
	@Test
	public void testCoste() {
		Pelicula pelicula = new Pelicula();
		int coste = 125;
		pelicula.setCod(coste);
		assertNotEquals("Id no está accesible", coste, pelicula.getCod());
	}
	
	@Test
	public void testEquals() {
		
	}
	
}
