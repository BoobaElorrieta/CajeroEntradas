package controlador;

import java.util.ArrayList;

import javax.swing.JComboBox;

import modelo.bbdd.SolicitaCines;
import modelo.pojos.Cine;
import vista.CajeroEntradas;

public class Controlador {
	
	CajeroEntradas cajero = null;
	SolicitaCines solicitud = null;

	public void asignarCinePrueba(JComboBox<String> scCbSeleccionCine) {
		solicitud = new SolicitaCines();
		ArrayList<Cine> cines = solicitud.getCines();
		for (int i = 0; i < cines.size(); i++) {
			scCbSeleccionCine.addItem(cines.get(i).getNombre());

		}
	}
	
	public void esogerCine(JComboBox<String> scCbSeleccionCine) {
		String pelicula = null;
		solicitud = new SolicitaCines();
		pelicula = (String) scCbSeleccionCine.getSelectedItem();
		System.out.println(pelicula);

		}
	
//	//	Ir al panel Inicio
//	public void mostrarPanelInicio() {
//		cajero = new CajeroEntradas();
//		cajero.inicioPanel.setVisible(true);
//		cajero.registroPanel.setVisible(false);
//		cajero.seleccionCinePanel.setVisible(false);
//		cajero.seleccionPeliPanel.setVisible(false);
//		cajero.horariosPanel.setVisible(false);
//		cajero.resumenCompraPanel.setVisible(false);
//		cajero.loginPanel.setVisible(false);		
//	}
//	
////	Ir al panel Registro
//	public void mostrarPanelRegistro() {
//		cajero = new CajeroEntradas();
//		cajero.inicioPanel.setVisible(false);
//		cajero.registroPanel.setVisible(true);
//		cajero.seleccionCinePanel.setVisible(false);
//		cajero.seleccionPeliPanel.setVisible(false);
//		cajero.horariosPanel.setVisible(false);
//		cajero.resumenCompraPanel.setVisible(false);
//		cajero.loginPanel.setVisible(false);		
//	}
//	
////	Ir al panel Seleccion Cine
//	public void mostrarPanelSeleccionCine() {
//		cajero = new CajeroEntradas();
//		cajero.inicioPanel.setVisible(false);
//		cajero.registroPanel.setVisible(false);
//		cajero.seleccionCinePanel.setVisible(true);
//		cajero.seleccionPeliPanel.setVisible(false);
//		cajero.horariosPanel.setVisible(false);
//		cajero.resumenCompraPanel.setVisible(false);
//		cajero.loginPanel.setVisible(false);
//	}
//	
////	Ir al panel Seleccion Peli
//	public void mostrarPanelSeleccionPeli() {
//		cajero = new CajeroEntradas();
//		cajero.inicioPanel.setVisible(false);
//		cajero.registroPanel.setVisible(false);
//		cajero.seleccionCinePanel.setVisible(false);
//		cajero.seleccionPeliPanel.setVisible(true);
//		cajero.horariosPanel.setVisible(false);
//		cajero.resumenCompraPanel.setVisible(false);
//		cajero.loginPanel.setVisible(false);	
//	}
//	
////	Ir al panel Horarios
//	public void mostrarPanelHorarios() {
//		cajero = new CajeroEntradas();
//		cajero.inicioPanel.setVisible(false);
//		cajero.registroPanel.setVisible(false);
//		cajero.seleccionCinePanel.setVisible(false);
//		cajero.seleccionPeliPanel.setVisible(false);
//		cajero.horariosPanel.setVisible(true);
//		cajero.resumenCompraPanel.setVisible(false);
//		cajero.loginPanel.setVisible(false);		
//	}
//	
////	Ir al panel Resumen Compra
//	public void mostrarPanelResumenCompra() {
//		cajero = new CajeroEntradas();
//		cajero.inicioPanel.setVisible(false);
//		cajero.registroPanel.setVisible(false);
//		cajero.seleccionCinePanel.setVisible(false);
//		cajero.seleccionPeliPanel.setVisible(false);
//		cajero.horariosPanel.setVisible(false);
//		cajero.resumenCompraPanel.setVisible(true);
//		cajero.loginPanel.setVisible(false);			
//	}
////	Ir al panle Login
//	public void mostrarPanelLogin() {
//		cajero = new CajeroEntradas();
//		cajero.inicioPanel.setVisible(false);
//		cajero.registroPanel.setVisible(false);
//		cajero.seleccionCinePanel.setVisible(false);
//		cajero.seleccionPeliPanel.setVisible(false);
//		cajero.horariosPanel.setVisible(false);
//		cajero.resumenCompraPanel.setVisible(false);
//		cajero.loginPanel.setVisible(true);	
//	}

	
}
