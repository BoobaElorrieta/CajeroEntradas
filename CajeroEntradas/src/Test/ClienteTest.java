package Test;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Modelo.pojos.Cliente;
import Modelo.pojos.Entrada;

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
		assertNotEquals("DNI no está accesible", dni, cliente.getDni());
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
		String apellido = "Gimenez";
		cliente.setApellidos(apellido);
		assertNotEquals("Apellido no está accesible", apellido, cliente.getApellidos());
	}
	
	@Test
	public void testSexo() {
		Cliente cliente = new Cliente();
		String sexo = "Hombre";
		cliente.setSexo(sexo);
		assertNotEquals("Sexo no está accesible", sexo, cliente.getSexo());
	}
	
	@Test
	public void testContraseña() {
		Cliente cliente = new Cliente();
		String contraseña = "abc17384CBA";
		cliente.setContrasena(contraseña);
		assertNotEquals("Contraseña no está accesible", contraseña, cliente.getContrasena());
	}
	
	@Test
	public void testTfno() {
		Cliente cliente = new Cliente();
		int tfno = 99999991;
		cliente.setTfno(tfno);
		assertNotEquals("Tfno no está accesible", tfno, cliente.getTfno());
	}
	
	@Test
	public void testDireccion() {
		Cliente cliente = new Cliente();
		String direccion = "C/Lehendakari Aguirre 179";
		cliente.setDireccion(direccion);
		assertNotEquals("Direccion no está accesible", direccion, cliente.getDireccion());
	}
	
	@Test
	public void testEmail() {
		Cliente cliente = new Cliente();
		String email = "elorritea@gmail.com";
		cliente.setEmail(email);
		assertNotEquals("Email no está accesible", email, cliente.getEmail());
	}
	
	
	@Test
	public void testEntradas() {
		Cliente cliente = new Cliente();
		ArrayList<Entrada> entradas = null;
		cliente.setEntradas(entradas);
		assertNotEquals("Entrada no está accesible", entradas, cliente.getEmail());
	}
	
	@Test
	public void testClienteExiste() {
		Cliente cliente = new Cliente();
		cliente.setTfno(1234);
		cliente.setDni("Zipi");
		Cliente cliente2 = new Cliente();
		cliente2.setTfno(1234);
		cliente2.setDni("Zipi");

		assertEquals("Clientes no son iguales!!!!", cliente, cliente2);
	}

	@Test
	public void testClienteNoExiste() {
		Cliente cliente = new Cliente();
		cliente.setTfno(1234);
		cliente.setDni("Zipi");
		Cliente cliente2 = new Cliente();
		cliente2.setTfno(1234);
		cliente2.setDni("Zipi");

		assertNotEquals("Clientes son iguales!!!!", cliente, cliente2);

	}

	@Test
	public void testToString() {
		Cliente cliente = new Cliente();
		cliente.setDni("Holas");
		cliente.setNombre("Hola");
		cliente.setApellidos("Hola");
		cliente.setSexo("Hola");
		cliente.setContrasena("Hola");
		cliente.setTfno(123);
		cliente.setDireccion("Hola");
		cliente.setEmail("Hola");
		cliente.setEntradas(null);
		String expected = "Cliente [Dni=" + cliente.getDni() + ", Nombre=" + cliente.getNombre() + ", Apellidos="
				+ cliente.getApellidos() + ", Sexo=" + cliente.getSexo() + ", Contraseña=" + cliente.getContrasena()
				+ ", Tlfn=" + cliente.getTfno() + ", Direccion=" + cliente.getDireccion()
				+", Email=" + cliente.getEmail() + ", Entradas=" + cliente.getEntradas() + "]";
		assertEquals(expected, cliente.toString());
	}
}
