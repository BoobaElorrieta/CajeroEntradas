package test.pojosTest;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.Date;

import org.junit.jupiter.api.Test;

import modelo.pojos.Proyeccion;



class ProyeccionTest {

	@Test
	public void testSerailizable() {
		Proyeccion proyeccion= new Proyeccion();
		assertTrue("No se puede realizar la serializacion!!!", proyeccion instanceof Serializable);
	}
	
	@Test
	public void testId() {
		Proyeccion proyeccion = new Proyeccion();
		int cod = 123;
		proyeccion.setCod(cod);
		assertNotEquals("Cod no esta accesible", cod, proyeccion.getCod());
	}
	
	@Test
	public void testFecha() {
		Proyeccion proyeccion = new Proyeccion();
		Date fecha = null;
		proyeccion.setFecha(fecha);
		assertNotEquals("Fecha no esta accesible", fecha, proyeccion.getFecha());
	}
	
	@Test
	public void testHora() {
		Proyeccion proyeccion = new Proyeccion();
		Date hora = null;
		proyeccion.setFecha(hora);
		assertNotEquals("Hora no esta accesible", hora, proyeccion.getHora());
	}
	
	@Test
	public void testProyeccionExiste() {
		Proyeccion proyeccion = new Proyeccion();
		proyeccion.setCod(1234);
		proyeccion.setFecha(null);
		proyeccion.setHora(null);
		
		Proyeccion otroProyeccion= new Proyeccion();
		otroProyeccion.setCod(1234);
		otroProyeccion.setFecha(null);
		otroProyeccion.setHora(null);
		
		assertEquals("Proyecciones no son iguales!!!!", proyeccion, otroProyeccion);	
		
	}
	
	@Test
	public void testToString () {
		Proyeccion proyeccion = new Proyeccion(); // you didn't supply the object, so I guessed
		proyeccion.setCod(123);
		proyeccion.setFecha(null);
		proyeccion.setHora(null);
		proyeccion.setPelicula(null);
		proyeccion.setEntradas(null);
        String expected = "Proyeccion [id=" + proyeccion.getCod() + ", fecha=" + proyeccion.getFecha() + ", hora=" + proyeccion.getHora() + "]";
        assertEquals(expected, proyeccion.toString());
	}
}
