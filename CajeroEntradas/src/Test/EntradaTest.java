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
		int cod= 163;
		entrada.setCod(cod);
		assertEquals("Cod no esta accesible", cod, entrada.getCod());
	}
	
	@Test
	public void testfechaDeCompra() {
		Entrada entrada = new Entrada();
		Date fechaDeCompra= null  ;
		entrada.setFechaDeCompra(fechaDeCompra);
		assertNotEquals("fechaDeCompra no esta accesible", fechaDeCompra, entrada.getFechaDeCompra());
	}
	
	@Test
	public void testEntradaExiste() {
		Entrada entrada= new Entrada();
		entrada.setCod(123);
		entrada.setFechaDeCompra(null);
		
		Entrada otraEntrada= new Entrada();
		otraEntrada.setCod(123);
		otraEntrada.setFechaDeCompra(null);
		
		assertEquals("usuarios no son iguales!!!!", entrada, otraEntrada);
		
	}
	
	@Test
	public void testEntradaNoExiste() {
		Entrada entrada= new Entrada();
		entrada.setCod(123);
		entrada.setFechaDeCompra(null);
		
		Entrada otraEntrada= new Entrada();
		otraEntrada.setCod(1234);
		otraEntrada.setFechaDeCompra(null);;
		
		assertNotEquals("usuarios son iguales!!!!", entrada, otraEntrada);
}
	@Test
	public void testToString () {
		Entrada entrada = new Entrada();
		entrada.setCod(123);
		entrada.setFechaDeCompra(null);
		String expected = "Entrada [cod=" + entrada.getCod() + ", fechaDeCompra=" + entrada.getFechaDeCompra() + ", cliente=" + entrada.getCliente() + "]";
		assertEquals(expected, entrada.toString());
	}
}
