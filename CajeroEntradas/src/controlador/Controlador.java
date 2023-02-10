package controlador;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;

import modelo.bbdd.SolicitaCines;
import modelo.bbdd.SolicitaHorarios;
import modelo.bbdd.SolicitaPeliculas;
import modelo.pojos.Cine;
import modelo.pojos.Pelicula;
import modelo.pojos.Proyeccion;
import modelo.pojos.Sala;
import vista.CajeroEntradas;

public class Controlador {

	CajeroEntradas cajero = null;
	SolicitaCines solicitudCine = null;
	SolicitaPeliculas solicitudPeliculas = null;
	SolicitaHorarios solicitudHorarios = null;

	public void asignarCinePrueba(JComboBox<String> scCbSeleccionCine) {
		scCbSeleccionCine.removeAllItems();
		solicitudCine = new SolicitaCines();
		ArrayList<Cine> cines = solicitudCine.getCines();
		for (int i = 0; i < cines.size(); i++) {
			scCbSeleccionCine.addItem(cines.get(i).getNombre());

		}
	}

	public void esogerCine(JComboBox<String> scCbSeleccionCine, JComboBox<String> spCbSeleccionPeli) {
		String cine = null;
		cine = (String) scCbSeleccionCine.getSelectedItem();

		// busca las peliculas y las añade al combobox
		spCbSeleccionPeli.removeAllItems();
		solicitudPeliculas = new SolicitaPeliculas();
		ArrayList<Pelicula> pelis = solicitudPeliculas.getPeliculas( "Select Titulo From Peliculas, Proyecciones, Salas, Cines Where cines.Nombre = '" + cine + "' and peliculas.codigo = proyecciones.cod_peli and proyecciones.cod_sala = salas.cod and salas.cod_cine = cines.cod");
		for (int i = 0; i < pelis.size(); i++) {
			spCbSeleccionPeli.addItem(pelis.get(i).getTitulo());

		}

	}
	
	public void escogerHorarios(JComboBox<String> horariosCbHorariosDisponibles, JComboBox<String> spCbSeleccionPeli) {
		String pelicula = null;
		pelicula = (String) spCbSeleccionPeli.getSelectedItem();
		
		// busca las peliculas y las añade al combobox
		solicitudHorarios = new SolicitaHorarios();
		ArrayList<Proyeccion> proyeccion = solicitudHorarios.getProyecciones( "Select fecha, hora, precio, sala.nombre From proyecciones, salas, peliculas WHERE proyecciones.cod_sala = salas.cod and proyecciones.cod_peli = peliculas.codigo and peliculas.titulo = '" + pelicula + "'");
		for (int i = 0; i < proyeccion.size(); i++) {
			horariosCbHorariosDisponibles.addItem(proyeccion.get(i).getFecha() + " / " + proyeccion.get(i).getHora().getTime() + " / " + proyeccion.get(i).getPrecio() + "€  / " + Sala.get(i).getNombre());

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
