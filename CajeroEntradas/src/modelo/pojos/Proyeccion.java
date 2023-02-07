package modelo.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class Proyeccion implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 5154322425865131472L;
	
	private int cod = 0;
	
	private Date fecha = null;
	private Date hora = null;
	private int precio = 0;
	
	private Sala sala = null;
	private Pelicula pelicula = null;
	private ArrayList <Entrada> entradas = null;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
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
		return Objects.hash(cod, entradas, fecha, hora, pelicula, precio, sala);
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
		return cod == other.cod && Objects.equals(entradas, other.entradas) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(hora, other.hora) && Objects.equals(pelicula, other.pelicula)
				&& precio == other.precio && Objects.equals(sala, other.sala);
	}
	
	@Override
	public String toString() {
		return "Proyeccion [cod=" + cod + ", fecha=" + fecha + ", hora=" + hora + ", precio=" + precio + ", sala="
				+ sala + ", pelicula=" + pelicula + ", entradas=" + entradas + "]";
	}
	
}
