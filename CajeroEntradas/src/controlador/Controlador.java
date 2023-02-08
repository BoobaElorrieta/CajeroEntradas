package controlador;

import java.util.ArrayList;

import javax.swing.JComboBox;

import modelo.bbdd.SolicitaCines;
import modelo.pojos.Cine;
import vista.CajeroEntradas;

public class Controlador {

	public void asignarCinePrueba(JComboBox<String> scCbSeleccionCine) {
		SolicitaCines solicitud = new SolicitaCines();
		ArrayList<Cine> cines = solicitud.getCines();
		for (int i = 0; i < cines.size(); i++) {
			scCbSeleccionCine.addItem(cines.get(i).getNombre());

		}
	}
	
	public void esogerCine(JComboBox<String> scCbSeleccionCine) {
		String pelicula = null;
		SolicitaCines solicitud = new SolicitaCines();
		pelicula = (String) scCbSeleccionCine.getSelectedItem();
		System.out.println(pelicula);

		}
	
}
