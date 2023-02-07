package modelo.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;



public class Sala implements Serializable{

	/**
	 *  Existe una relacion N:1 con Cine
	 *  Existe una relacion 1:N con Proyección
	 */
	
	private static final long serialVersionUID = -3596305966431711984L;

//	Clave primaria
	private int cod = 0;
	
//	Atributos
	private String nombre = null;
	
//	Relaciones
	private ArrayList<Proyeccion> proyeccion = null;
	private Cine cine = null;
	
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
		return Objects.hash(nombre, cine, cod, proyeccion);
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
		return Objects.equals(nombre, other.nombre) && Objects.equals(cine, other.cine) && cod == other.cod
				&& Objects.equals(proyeccion, other.proyeccion);
	}
	@Override
	public String toString() {
		return "Sala [cod=" + cod + ", Nombre=" + nombre + ", proyeccion=" + proyeccion + ", cine=" + cine + "]";
	}
	
}