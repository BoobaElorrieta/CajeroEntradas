package controlador;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.bbdd.RegistraCliente;
import modelo.pojos.Cliente;
import vista.CajeroEntradas;

public class ControladorEneko {

//	Ir al panel Inicio
	public void mostrarPanelInicio(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel, 
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(true);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);		
	}
	
//	Ir al panel Registro
	public void mostrarPanelRegistro(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel, 
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(true);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);		
	}
	
//	Ir al panel Seleccion Cine
	public void mostrarPanelSeleccionCine(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel, 
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(true);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);		
	}
	
//	Ir al panel Seleccion Peli
	public void mostrarPanelSeleccionPeli(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel, 
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(true);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);		
	}
	
//	Ir al panel Horarios
	public void mostrarPanelHorarios(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel, 
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(true);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(false);		
	}
	
//	Ir al panel Resumen Compra
	public void mostrarPanelResumenCompra(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel, 
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(true);
		loginPanel.setVisible(false);		
	}
//	Ir al panle Login
	public void mostrarPanelLogin(JPanel inicioPanel, JPanel registroPanel, JPanel seleccionCinePanel, 
			JPanel seleccionPeliPanel, JPanel horariosPanel, JPanel resumenCompraPanel, JPanel loginPanel) {
		inicioPanel.setVisible(false);
		registroPanel.setVisible(false);
		seleccionCinePanel.setVisible(false);
		seleccionPeliPanel.setVisible(false);
		horariosPanel.setVisible(false);
		resumenCompraPanel.setVisible(false);
		loginPanel.setVisible(true);		
	}
	
	
}
