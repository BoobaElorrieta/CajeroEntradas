package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Proyeccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5154322425865131472L;
	
	private int id = 0;
	
	private Date Fecha = null;
	private Date Hora = null;
	
	Sala sala = null;
	Pelicula pelicula = null;
	ArrayList <Entrada> entradas;
}
