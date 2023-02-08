package controlador;

import java.util.ArrayList;

import javax.swing.JComboBox;

import modelo.bbdd.SolicitaCines;
import modelo.pojos.Cine;
import vista.CajeroEntradas;

public class Controlador {

	
	public void asignarCinePrueba(JComboBox scCbSeleccionCine) {
		SolicitaCines solicitud = new SolicitaCines();
		ArrayList<Cine> cines = solicitud.getCines();
		CajeroEntradas cajero = new CajeroEntradas ();
		for (int i = 0; i < cines.size(); i++) {
			System.out.println(cines.get(i).getNombre());
			cajero.scCbSeleccionCine.addItem (cines.get(i).getNombre());
			
		}	
		}
}