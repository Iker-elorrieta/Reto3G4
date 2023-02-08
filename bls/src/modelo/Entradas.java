package modelo;

import java.util.Arrays;

public class Entradas {
	private int id_entrada;
	private Peliculas []peliculas;
	private Cliente cliente;
	
	
	public Entradas(int id_entrada,Peliculas[] peliculas,Cliente cliente) {
		this.id_entrada=id_entrada;
		this.peliculas = peliculas;
		this.cliente = cliente;
	}


	public int getId_entrada() {
		return id_entrada;
	}

	public void setId_entrada(int id_entrada) {
		this.id_entrada = id_entrada;
	}
	

	public Peliculas []getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Peliculas []peliculas) {
		this.peliculas = peliculas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	@Override
	public String toString() {
		return "Entradas [id_entrada=" + id_entrada + ", peliculas=" + Arrays.toString(peliculas) + ", cliente="
				+ cliente + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entradas other = (Entradas) obj;
		return id_entrada == other.id_entrada;
	}

}
