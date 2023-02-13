package test.controladorTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JComboBox;

import org.junit.jupiter.api.Test;

import controlador.Controlador;
import modelo.bbdd.SolicitaCines;
import modelo.pojos.Cine;
import modelo.pojos.Cliente;
import vista.CajeroEntradas;

class ControladorTest {
	
	Controlador controlador = null;
	CajeroEntradas cajeroEntradas = null;
	SolicitaCines solicitaCine = null;

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testBuscarCines() {
		controlador = new Controlador();
		cajeroEntradas = new CajeroEntradas();
		solicitaCine = new SolicitaCines();
//		controlador.asignarCinePrueba(cajeroEntradas.scCbSeleccionCine);
		ArrayList<Cine> cines = solicitaCine.getCines();
		for (int i = 0; i < cines.size(); i++) {
			cajeroEntradas.scCbSeleccionCine.addItem(cines.get(i).getNombre());
		}
		assertNotNull(cines);
	}

}
