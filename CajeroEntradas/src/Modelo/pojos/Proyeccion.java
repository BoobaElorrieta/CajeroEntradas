package Modelo.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class Proyeccion implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 5154322425865131472L;
	
	private int id = 0;
	
	private Date Fecha = null;
	private Date Hora = null;
	private int Precio = 0;
	
	Sala sala = null;
	Pelicula pelicula = null;
	ArrayList <Entrada> entradas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public Date getHora() {
		return Hora;
	}
	public void setHora(Date hora) {
		Hora = hora;
	}
	public int getPrecio() {
		return Precio;
	}
	public void setPrecio(int precio) {
		Precio = precio;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public ArrayList<Entrada> getEntradas() {
		return entradas;
	}
	public void setEntradas(ArrayList<Entrada> entradas) {
		this.entradas = entradas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Fecha, Hora, Precio, entradas, id, pelicula, sala);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyeccion other = (Proyeccion) obj;
		return Objects.equals(Fecha, other.Fecha) && Objects.equals(Hora, other.Hora) && Precio == other.Precio
				&& Objects.equals(entradas, other.entradas) && id == other.id
				&& Objects.equals(pelicula, other.pelicula) && Objects.equals(sala, other.sala);
	}
	@Override
	public String toString() {
		return "Proyeccion [id=" + id + ", Fecha=" + Fecha + ", Hora=" + Hora + ", Precio=" + Precio + ", sala=" + sala
				+ ", pelicula=" + pelicula + ", entradas=" + entradas + "]";
	}
	
	
}
