package modelo.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Pelicula implements Serializable {
	/**
	 *  Existe una relacion 1:N con Proyeccion
	 */
	private static final long serialVersionUID = -8809226843737235064L;

// 	Clave primaria
	private int cod = 0;
	
//	Atributos
	private String titulo = null;
	private int duracion = 0;
	private String genero = null;
	private int coste = 0;
	
//	Relaciones
	private ArrayList<Proyeccion> proyecciones = null;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	public ArrayList<Proyeccion> getProyeccion() {
		return proyecciones;
	}

	public void setProyeccion(ArrayList<Proyeccion> proyeccion) {
		this.proyecciones = proyeccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod, coste, duracion, genero, proyecciones, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return cod == other.cod && coste == other.coste && duracion == other.duracion
				&& Objects.equals(genero, other.genero) && Objects.equals(proyecciones, other.proyecciones)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Pelicula [cod=" + cod + ", titulo=" + titulo + ", duracion=" + duracion + ", genero=" + genero
				+ ", coste=" + coste + ", proyeccion=" + proyecciones + "]";
	}

}
