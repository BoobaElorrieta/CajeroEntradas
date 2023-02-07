package controlador;

import modelo.pojos.Cine;
import vista.CajeroEntradas;

public class Controlador {

	public void asignarCine(Cine cine) {
		
		vista.CageroEntradas.ScCbSeleccionCine.addItem(cine.getNombre());
	}


}
