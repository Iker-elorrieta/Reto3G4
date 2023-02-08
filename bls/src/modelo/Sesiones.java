package modelo;

import java.sql.Date;
import java.util.Arrays;

public class Sesiones {
	private int id_sesion;
	private Date fecha;
	private Date hora;
	private Peliculas[] arrayPelicula;
	private Cines[] arrayCine;


	public Sesiones( int id_sesion,Date fecha,Date hora,Peliculas[] arrayPelicula,Cines[] arrayCine) {
		this.id_sesion=id_sesion;
		this.fecha=fecha;
		this.hora=hora;
		this.arrayPelicula=arrayPelicula;
		this.arrayCine=arrayCine;

	};
	

	public Peliculas[] getPelicula() {
		return arrayPelicula;
	}
	public void setPelicula(Peliculas[] arrayPelicula) {
		this.arrayPelicula = arrayPelicula;
	}

	public int getId_sesion() {
		return id_sesion;
	}
	public void setId_sesion(int id_sesion) {
		this.id_sesion = id_sesion;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sesiones other = (Sesiones) obj;
		return id_sesion == other.id_sesion;
	}


	public Cines[] getArrayCine() {
		return arrayCine;
	}


	public void setArrayCine(Cines[] arrayCine) {
		this.arrayCine = arrayCine;
	}


	@Override
	public String toString() {
		return "Sesiones [id_sesion=" + id_sesion + ", fecha=" + fecha + ", hora=" + hora + ", arrayPelicula="
				+ Arrays.toString(arrayPelicula) + ", arrayCine=" + Arrays.toString(arrayCine) + "]";
	}
	

}
