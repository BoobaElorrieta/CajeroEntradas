package controlador;

import modelo.bbdd.RegistraCliente;
import modelo.pojos.Cliente;
import vista.CajeroEntradas;

public class ControladorEneko {

	public void registrarUsuario(Cliente cliente) {
		RegistraCliente registraCliente = new RegistraCliente();
		CajeroEntradas cajero = new CajeroEntradas();
		
		cliente.setDni(cajero.registroTfDNI.getText());
		cliente.setNombre(cajero.registroTfNombre.getText());
		cliente.setApellidos(cajero.registroTfApellidos.getText());
		cliente.setSexo(cajero.registroCbSexo.getSelectedItem().toString());
		cliente.setContrasena(cajero.registroTfContrasena.getText());
		cliente.setTfno(Integer. parseInt(cajero.registroTfTfno.getText()));
		cliente.setDireccion(cajero.registroTfDireccion.getText());
		cliente.setEmail(cajero.registroTfEmail.getText());
		
		registraCliente.insertCliente(cliente);
	}
}
