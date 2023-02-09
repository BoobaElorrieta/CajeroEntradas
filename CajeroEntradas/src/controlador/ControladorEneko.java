package controlador;

import modelo.bbdd.RegistraCliente;
import modelo.pojos.Cliente;
import vista.CajeroEntradas;

public class ControladorEneko {

	public void registrarUsuario() {
		CajeroEntradas cajero = new CajeroEntradas();
		Cliente cliente = new Cliente();
		
		cliente.setDni(cajero.registroTfDNI.getText());
		cliente.setNombre(cajero.registroTfNombre.getText());
		cliente.setApellidos(cajero.registroTfApellidos.getText());
		cliente.setSexo(cajero.registroCbSexo.getSelectedItem().toString());
		cliente.setContrasena(cajero.registroTfContrasena.getText());
		cliente.setTfno(cajero.registroTfTfno.getText());
		cliente.setDireccion(cajero.registroTfDireccion.getText());
		cliente.setEmail(cajero.registroTfEmail.getText());

		RegistraCliente registraCliente = new RegistraCliente();
		registraCliente.insertCliente(cliente);
	}
}
