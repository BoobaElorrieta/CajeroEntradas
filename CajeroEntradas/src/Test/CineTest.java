package Test;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.jupiter.api.Test;

import Modelo.pojos.Cine;

class CineTest {
	
	@Test
	public void testSerailizable() {
		Cine cine= new Cine();
		assertTrue("No se puede realizar la serializacion!!!", cine instanceof Serializable);
	}
	
	@Test
	public void testCod() {
		Cine cine = new Cine();
		int cod = 123;
		cine.setCod(cod);
		assertNotEquals("Id no esta accesible", cod, cine.getCod());
	}

	@Test
	public void testNombre() {
		Cine cine = new Cine();
		String nombre= "un texto";
		cine.setNombre(nombre);
		assertNotEquals("Nombre no esta accesible", nombre, cine.getNombre());
	}
	
	@Test
	public void testDireccion() {
		Cine cine = new Cine();
		String direccion= "Calle zzz";
		cine.setDireccion(direccion);
		assertNotEquals("Nombre no esta accesible", direccion, cine.getDireccion());
	}
	
	@Test
	public void testEquals() {
	Cine cine = new Cine();
	Cine cine2 = new Cine();
	assertNotEquals(cine, cine2);
	}
}
