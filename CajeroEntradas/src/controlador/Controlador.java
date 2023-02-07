package controlador;

import java.util.ArrayList;

import modelo.pojos.Cine;
import vista.CajeroEntradas;

public class Controlador {

	public void asignarCine(Cine cine) {

		ArrayList<String> cines = new ArrayList<String>();
		cines.add(cine.getNombre());
		System.out.print(cines);
		CajeroEntradas cajero = new CajeroEntradas();
		cajero.scCbSeleccionCine.addItem(cines.toString());
	}

}
