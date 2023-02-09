package controlador;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import modelo.bbdd.RegistraCliente;
import modelo.pojos.Cliente;
import vista.CajeroEntradas;

public class ControladorEneko {

	public void registrarUsuario(JTextField dni, JTextField nombre, JTextField apellidos, JTextField contrasena,
			JTextField tfno, JTextField direccion, JTextField email, JComboBox sexo) {
		Cliente cliente = new Cliente();
		
		cliente.setDni(dni.getText());
		cliente.setNombre(nombre.getText());
		cliente.setApellidos(apellidos.getText());
		cliente.setSexo(sexo.getSelectedItem().toString());
		cliente.setContrasena(contrasena.getText());
		cliente.setTfno(tfno.getText());
		cliente.setDireccion(direccion.getText());
		cliente.setEmail(email.getText());
		System.out.println(cliente.toString());
		RegistraCliente registraCliente = new RegistraCliente();
		registraCliente.insertCliente(cliente);
	}
}
