package modelo;

import java.util.Arrays;

public class Pedido {
	private Entrada []arrayEntradas;
	private Cliente cliente;
	private float precioTotal;
	private int id_pedido;
	
	@Override
	public String toString() {
		return "Pedido [arrayEntradas=" + Arrays.toString(arrayEntradas) + ", cliente=" + cliente + ", precioTotal="
				+ precioTotal + ", id_pedido=" + id_pedido + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return id_pedido == other.id_pedido;
	}

	public Pedido() {
		
	}

	public Entrada[] getArrayEntradas() {
		return arrayEntradas;
	}
	public void setArrayEntradas(Entrada[] arrayEntradas) {
		this.arrayEntradas = arrayEntradas;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	

}
