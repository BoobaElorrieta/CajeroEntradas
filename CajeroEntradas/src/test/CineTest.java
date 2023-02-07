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
		assertNotEquals("Cod no esta accesible", cod, cine.getCod());
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
		assertNotEquals("Direccion no esta accesible", direccion, cine.getDireccion());
	}
	
	@Test
	public void testCineExiste() {
		Cine cine = new Cine();
		cine.setCod(1234);
		cine.setNombre("Zipi");
		Cine otroCine= new Cine();
		otroCine.setCod(1234);
		otroCine.setNombre("Zipi");
		
		assertEquals("usuarios no son iguales!!!!", cine, otroCine);	
		
	}

	@Test
	public void testCineNoExiste() {
		Cine cine= new Cine();
		cine.setCod(1234);
		cine.setNombre("Zipi");
		
		Cine otroUsuario= new Cine();
		otroUsuario.setCod(1234);
		otroUsuario.setNombre("Zipi");
		
		assertNotEquals("usuarios son iguales!!!!", cine, otroUsuario);			
	}
	
	@Test
	public void testToString () {
		Cine cine = new Cine(); // you didn't supply the object, so I guessed
		cine.setCod(123);
		cine.setNombre("asd");
		cine.setDireccion("Calle tus muelas");
		cine.setSalas(null);
        String expected = "Cine [cod=" + cine.getCod() + ", nombre=" + cine.getNombre() + ", direccion=" + cine.getDireccion() + ", salas=" + cine.getSalas() +  "]"; // put the expected value here
        assertEquals(expected, cine.toString());
	}
}
