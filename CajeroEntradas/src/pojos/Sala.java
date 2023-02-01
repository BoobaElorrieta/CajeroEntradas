package pojos;

import java.io.Serializable;
import java.util.ArrayList;



public class Sala implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3596305966431711984L;

	private int cod = 0;
	
	private String Nombre = null;
	private String Pelicula = null;
	
	ArrayList<Pelicula> peliculas;
	Cine cine =null;
	
	
	
}
