package controlador;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.bbdd.SolicitaCines;
import modelo.bbdd.SolicitaCliente;
import modelo.bbdd.SolicitaHorarios;
import modelo.bbdd.SolicitaPeliculas;
import modelo.pojos.Cliente;
import vista.CajeroEntradas;

public class ControladorIbai {

	CajeroEntradas cajero = null;
	SolicitaCines solicitaCine = null;
	SolicitaPeliculas solicitaPeliculas = null;
	SolicitaHorarios solicitaHorarios = null;
	SolicitaCliente solicitaClientes = null;

	public void comprobarLogin(JTextField loginTfEmail, JTextField loginTfContrasena) {
		String correo = null;
		String contrasenaUsuario = null;
		String contrasenaReal = null;
		int ret;
		correo = (String) loginTfEmail.getText();
		contrasenaUsuario = (String) loginTfContrasena.getText();
		try {

			solicitaClientes = new SolicitaCliente();
			ArrayList<Cliente> cliente = solicitaClientes
					.getClientes("SELECT email, contrasena FROM Clientes WHERE email = '" + correo + "'");
			contrasenaReal = cliente.get(0).getContrasena();
			if (contrasenaUsuario.equalsIgnoreCase(contrasenaReal)) {
				// Se le deja pasar
				JFrame jFrame = new JFrame();
				ret = JOptionPane.showConfirmDialog(null, "ACESO PERMITIDO \r\n" + "Desea imprimir el ticket?",
						"YES_NO_OPTION", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

				switch (ret) {
				case 0:
					System.out.println("Has pulsado Sí");
					break;
				case 1:
					System.out.println("Has pulsado No");
					break;

				}
			} else {
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "ACESO DENEGADO");
			}
		} catch (Exception e) {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "ERROR, ese email no existe en la base de datos.");
		}

	}
}
