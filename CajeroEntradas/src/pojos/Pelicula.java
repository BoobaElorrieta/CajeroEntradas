package pojos;

import java.io.Serializable;
import java.util.ArrayList;

public class Pelicula implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8809226843737235064L;


	private int cod = 0;
	
	
	private String titulo = null;
	private int duracion = 0;
	private String genero = null;
	private int coste = 0;
	
	ArrayList<Sala> salas;

}
