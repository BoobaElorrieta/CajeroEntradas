package Test;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.jupiter.api.Test;

import Modelo.pojos.Cliente;
import Modelo.pojos.Pelicula;

class ClienteTest {

	@Test
	public void testSerailizable() {
		Cliente cliente = new Cliente();
		assertTrue("No se puede realizar la serialización!!!", cliente instanceof Serializable);
	}
	
	@Test
	public void testDni() {
		Cliente cliente = new Cliente();
		String dni = "12345789D";
		cliente.setDni(dni);
		assertNotEquals("Id no está accesible", dni, cliente.getDni());
	}

	@Test
	public void testNombre() {
		Cliente cliente = new Cliente();
		String nombre = "Maria";
		cliente.setNombre(nombre);
		assertNotEquals("Nombre no está accesible", nombre, cliente.getNombre());
	}
	

	@Test
	public void testApellidos() {
		Cliente cliente = new Cliente();
		String nombre = "Maria";
		cliente.setNombre(nombre);
		assertNotEquals("Nombre no está accesible", nombre, cliente.getNombre());
	
}
