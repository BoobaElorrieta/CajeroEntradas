package controlador;

import java.util.ArrayList;

import javax.swing.JComboBox;

import modelo.bbdd.SolicitaCines;
import modelo.bbdd.SolicitaPeliculas;
import modelo.pojos.Cine;
import modelo.pojos.Pelicula;
import vista.CajeroEntradas;

public class Controlador {

	CajeroEntradas cajero = null;
	SolicitaCines solicitudCine = null;
	SolicitaPeliculas solicitudPeliculas = null;

	public void asignarCinePrueba(JComboBox<String> scCbSeleccionCine) {
		solicitudCine = new SolicitaCines();
		ArrayList<Cine> cines = solicitudCine.getCines();
		for (int i = 0; i < cines.size(); i++) {
			scCbSeleccionCine.addItem(cines.get(i).getNombre());

		}
	}

	public void esogerCine(JComboBox<String> scCbSeleccionCine, JComboBox<String> spCbSeleccionPeli) {
		String pelicula = null;
		pelicula = (String) scCbSeleccionCine.getSelectedItem();
		System.out.println(pelicula);

		// busca las peliculas y las añade al combobox
		solicitudPeliculas = new SolicitaPeliculas();
	//	ArrayList<Pelicula> pelis = solicitudPeliculas.getPeliculas( "Select Titulo From Peliculas Pe join Proyecciones Pr on Pe.cod = Pr.codPeli join Salas S on Pr.codSala = S.cod join Cines C on S.codCine = C.cod Where C.Nombre = " + pelicula + " Order by Fecha, Horas ASC");
		ArrayList<Pelicula> pelis = solicitudPeliculas.getPeliculas("Select Titulo From Peliculas");
		for (int i = 0; i < pelis.size(); i++) {
			spCbSeleccionPeli.addItem(pelis.get(i).getTitulo());

		}

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
