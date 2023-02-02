package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;



public class Sala implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3596305966431711984L;

	private int cod = 0;
	
	private String Nombre = null;
	
	ArrayList<Proyeccion> proyeccion;
	Cine cine = null;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public ArrayList<Proyeccion> getProyeccion() {
		return proyeccion;
	}
	public void setProyeccion(ArrayList<Proyeccion> proyeccion) {
		this.proyeccion = proyeccion;
	}
	public Cine getCine() {
		return cine;
	}
	public void setCine(Cine cine) {
		this.cine = cine;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Nombre, cine, cod, proyeccion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(Nombre, other.Nombre) && Objects.equals(cine, other.cine) && cod == other.cod
				&& Objects.equals(proyeccion, other.proyeccion);
	}
	@Override
	public String toString() {
		return "Sala [cod=" + cod + ", Nombre=" + Nombre + ", proyeccion=" + proyeccion + ", cine=" + cine + "]";
	}
	
}