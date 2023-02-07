package modelo.pojos;

import java.io.Serializable;
import java.util.Objects;
import java.util.Date;


public class Entrada implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2320199558574154732L;

	private int cod = 0;
	
	private Date fechaDeCompra = null;
	
	Cliente cliente = null;
	Proyeccion proyeccion = null;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public Date getFechaDeCompra() {
		return fechaDeCompra;
	}
	public void setFechaDeCompra(Date fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Proyeccion getProyeccion() {
		return proyeccion;
	}
	public void setProyeccion(Proyeccion proyeccion) {
		this.proyeccion = proyeccion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, cod, fechaDeCompra, proyeccion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return Objects.equals(cliente, other.cliente) && cod == other.cod
				&& Objects.equals(fechaDeCompra, other.fechaDeCompra) && Objects.equals(proyeccion, other.proyeccion);
	}
	@Override
	public String toString() {
		return "Entrada [cod=" + cod + ", fechaDeCompra=" + fechaDeCompra + ", cliente=" + cliente + ", proyeccion="
				+ proyeccion + "]";
	}

}
