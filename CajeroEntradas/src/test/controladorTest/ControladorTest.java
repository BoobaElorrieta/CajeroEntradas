package test.controladorTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JComboBox;

import org.junit.jupiter.api.Test;

import controlador.Controlador;
import modelo.bbdd.SolicitaCines;
import modelo.bbdd.SolicitaPeliculas;
import modelo.pojos.Cine;
import modelo.pojos.Cliente;
import modelo.pojos.Pelicula;
import vista.CajeroEntradas;

class ControladorTest {
	
	Controlador controlador = null;
	CajeroEntradas cajeroEntradas = null;
	SolicitaCines solicitaCine = null;
	SolicitaPeliculas solicitaPeliculas = null;

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testBuscarCines() {
		controlador = new Controlador();
		cajeroEntradas = new CajeroEntradas();
		solicitaCine = new SolicitaCines();
		ArrayList<Cine> cines = solicitaCine.getCines();
		for (int i = 0; i < cines.size(); i++) {
			cajeroEntradas.scCbSeleccionCine.addItem(cines.get(i).getNombre());
		}
		assertNotNull(cines);
	}
	
	public void testEscogerCine() {
		cajeroEntradas = new CajeroEntradas();
		solicitaPeliculas = new SolicitaPeliculas();
		String cine = null;
		ArrayList<Pelicula> pelis = solicitaPeliculas.getPeliculas(
				"Select Titulo "
				+ "From Peliculas, Proyecciones, Salas, Cines "
				+ "Where cines.Nombre = '" + cine + "'and peliculas.codigo = proyecciones.cod_peli and "
				+ "proyecciones.cod_sala = salas.cod and salas.cod_cine = cines.cod "
				+ "GROUP BY titulo "
				+ "ORDER BY FECHA asc, hora ASC");
		ArrayList<Pelicula> peliculas = solicitaPeliculas.getPeliculas(cine);
		for (int i = 0; i < pelis.size(); i++) {
			cajeroEntradas.spCbSeleccionPeli.addItem(pelis.get(i).getTitulo());
		}
		
	}

}
