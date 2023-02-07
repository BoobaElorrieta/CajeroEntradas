package controlador;

import modelo.pojos.Cine;
import vista.CajeroEntradas;

public class Controlador {

	public void asignarCine(Cine cine) {
		CajeroEntradas cajero = new CajeroEntradas ();
		cajero.scCbSeleccionCine.addItem(cine.getNombre());
	}


}
