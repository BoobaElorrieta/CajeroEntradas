package Test;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Modelo.pojos.Pelicula;
import Modelo.pojos.Sala;

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
	public void testSala() {
		Pelicula pelicula = new Pelicula();
		ArrayList<Sala> sala = null;
		pelicula.setSalas(sala);
		assertNotEquals("Id no está accesible", sala, pelicula.getCod());
	}

	@Test
	public void testPeliculaExiste() {
		Pelicula pelicula = new Pelicula();
		pelicula.setCod(1234);
		pelicula.setTitulo("Zipi");
		Pelicula pelicula2 = new Pelicula();
		pelicula2.setCod(1234);
		pelicula2.setTitulo("Zipi");

		assertEquals("usuarios no son iguales!!!!", pelicula, pelicula2);
	}

	@Test
	public void testPeliculaNoExiste() {
		Pelicula pelicula = new Pelicula();
		pelicula.setCod(1234);
		pelicula.setTitulo("Zipi");

		Pelicula pelicula2 = new Pelicula();
		pelicula2.setCod(1234);
		pelicula2.setTitulo("Zipi");

		assertNotEquals("usuarios son iguales!!!!", pelicula, pelicula2);

	}

	@Test
	public void testToString() {
		Pelicula pelicula = new Pelicula();
		pelicula.setCod(1234);
		pelicula.setTitulo("Hola");
		pelicula.setDuracion(123);
		pelicula.setGenero("Hola");
		pelicula.setCoste(123);
		pelicula.setSalas(null);
		String expected = "Pelicula [cod=" + pelicula.getCod() + ", titulo=" + pelicula.getTitulo() + ", duracion="
				+ pelicula.getDuracion() + ", genero=" + pelicula.getGenero() + ", coste=" + pelicula.getCoste()
				+ ", salas=" + pelicula.getSalas() + "]";
		assertEquals(expected, pelicula.toString());

	}

}
