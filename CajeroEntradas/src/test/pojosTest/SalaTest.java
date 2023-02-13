package test.pojosTest;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.jupiter.api.Test;

import modelo.pojos.Sala;



class SalaTest {
	@Test
	public void testSerailizable() {
		Sala sala= new Sala();
		assertTrue("No se puede realizar la serializacion!!!", sala instanceof Serializable);
	}

	@Test
	public void testCod() {
		Sala sala = new Sala();
		int cod = 123;
		sala.setCod(cod);
		assertNotEquals("Cod no esta accesible", cod, sala.getCod());
	}
	
	public void testnombre() {
		Sala sala = new Sala();
		String nombre = "Alfredo";
		sala.setNombre(nombre);
		assertNotEquals("Nombre no esta accesible", nombre, sala.getNombre());
	}

	@Test
	public void testSalaExiste() {
		Sala sala = new Sala();
		sala.setCod(1234);
		sala.setNombre(null);
		
		
		Sala otraSala= new Sala();
		otraSala.setCod(1234);
		otraSala.setNombre(null);
		
		assertEquals("Salas no son iguales!!!!", sala, otraSala);	
		
	}
	
	@Test
	public void testToString () {
		Sala sala = new Sala(); // you didn't supply the object, so I guessed
		sala.setCod(0123);
		sala.setNombre(null);
		sala.setCine(null);
		sala.setProyeccion(null);
        String expected = "Proyeccion [cod=" + sala.getCod() + ", nombre=" + sala.getNombre() + "]";
        assertEquals(expected, sala.toString());
	}
}
