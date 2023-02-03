package Modelo.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Cine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 565880329585090674L;

	private int cod = 0;
	
	private String nombre = null;
	private String direccion = null;
	
	ArrayList <Sala> salas;

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

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod, direccion, nombre, salas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return cod == other.cod && Objects.equals(direccion, other.direccion) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(salas, other.salas);
	}

	@Override
	public String toString() {
		return "Cine [cod=" + cod + ", nombre=" + nombre + ", direccion=" + direccion + ", salas=" + salas + "]";
	}
	
}
