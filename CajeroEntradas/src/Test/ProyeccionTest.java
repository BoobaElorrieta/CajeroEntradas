package Test;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.pojos.Proyeccion;

class ProyeccionTest {

	@Test
	public void testSerailizable() {
		Proyeccion proyeccion= new Proyeccion();
		assertTrue("No se puede realizar la serializacion!!!", proyeccion instanceof Serializable);
	}
	
	@Test
	public void testId() {
		Proyeccion proyeccion = new Proyeccion();
		int id = 123;
		proyeccion.setId(id);
		assertNotEquals("Id no esta accesible", id, proyeccion.getId());
	}
	
	@Test
	public void testFecha() {
		Proyeccion proyeccion = new Proyeccion();
		Date fecha = null;
		proyeccion.setFecha(fecha);
		assertNotEquals("Id no esta accesible", fecha, proyeccion.getFecha());
	}
	
	@Test
	public void testHora() {
		Proyeccion proyeccion = new Proyeccion();
		Date hora = null;
		proyeccion.setFecha(hora);
		assertNotEquals("Id no esta accesible", hora, proyeccion.getHora());
	}
	
	@Test
	public void testProyeccionExiste() {
		Proyeccion proyeccion = new Proyeccion();
		proyeccion.setId(1234);
		proyeccion.setFecha(null);
		proyeccion.setHora(null);
		
		Proyeccion otroProyeccion= new Proyeccion();
		otroProyeccion.setId(1234);
		otroProyeccion.setFecha(null);
		otroProyeccion.setHora(null);
		
		assertEquals("usuarios no son iguales!!!!", proyeccion, otroProyeccion);	
		
	}
	
	@Test
	public void testToString () {
		Proyeccion proyeccion = new Proyeccion(); // you didn't supply the object, so I guessed
		proyeccion.setId(123);
		proyeccion.setFecha(null);
		proyeccion.setHora(null);
		proyeccion.setPelicula(null);
		proyeccion.setEntradas(null);
        String expected = "Proyeccion [id=" + proyeccion.getId() + ", fecha=" + proyeccion.getFecha() + ", hora=" + proyeccion.getHora() + "]";
        assertEquals(expected, proyeccion.toString());
	}
}
