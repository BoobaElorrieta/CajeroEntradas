package pojos;

import java.util.ArrayList;

public class Cine {
	private int cod = 0;
	
	
	private String nombre = null;
	private String direccion = null;
	private int NoSalas = 0;
	
	ArrayList<Sala> salas;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNoSalas() {
		return NoSalas;
	}

	public void setNoSalas(int noSalas) {
		NoSalas = noSalas;
	}

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
