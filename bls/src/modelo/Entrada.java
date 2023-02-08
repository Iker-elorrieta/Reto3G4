package modelo;

import java.util.Arrays;

public class Entrada {
	private int id_entrada;
	private Cliente cliente;
	private Sesion [] arraySesiones;
	private float precioTotal;
	
	public Entrada(int id_entrada,Cliente cliente,Sesion [] arraySesiones,float precioTotal) {
		this.id_entrada=id_entrada;
		this.cliente = cliente;
		this.arraySesiones=arraySesiones;
		this.precioTotal=precioTotal;
	}

	public int getId_entrada() {
		return id_entrada;
	}

	public void setId_entrada(int id_entrada) {
		this.id_entrada = id_entrada;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	@Override
	public String toString() {
		return "Entrada [id_entrada=" + id_entrada + ", cliente=" + cliente + ", arraySesiones="
				+ Arrays.toString(arraySesiones) + ", precioTotal=" + precioTotal + "]";
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
		return id_entrada == other.id_entrada;
	}

	public Sesion [] getSesiones() {
		return arraySesiones;
	}

	public void setSesiones(Sesion [] arraySesiones) {
		this.arraySesiones = arraySesiones;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

}
