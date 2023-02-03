package Test;

import static org.junit.Assert.*;
import java.io.Serializable;
import java.util.Date;

import org.junit.jupiter.api.Test;
import Modelo.pojos.Entrada;

class EntradaTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testSerailizable() {
		Entrada entrada= new Entrada();
		assertTrue("No se puede realizar la serializacion!!!", entrada instanceof Serializable);
	}
	@Test
	public void testcod() {
		Entrada entrada = new Entrada();
		int cod= 13;
		entrada.setCod(cod);
		assertEquals("Cod no esta accesible", cod, entrada.getCod());
	}
	
	@Test
	public void testfechaDeCompra() {
		Entrada entrada = new Entrada();
		Date fechaDeCompra=  ;
		entrada.setFechaDeCompra(fechaDeCompra);
		assertNotEquals("fechaDeCompra no esta accesible", fechaDeCompra, entrada.getFechaDeCompra());
	}
	
	
}
