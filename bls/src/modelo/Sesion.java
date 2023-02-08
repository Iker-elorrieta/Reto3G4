package modelo;

import java.sql.Date;
import java.util.Arrays;

public class Sesion {
	private int id_sesion;
	private Date fecha;
	private Date hora;
	private Pelicula pelicula;


	public Sesion( int id_sesion,Date fecha,Date hora,Pelicula pelicula) {
		this.id_sesion=id_sesion;
		this.fecha=fecha;
		this.hora=hora;
		this.pelicula=pelicula;
	};


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
		Sesion other = (Sesion) obj;
		return id_sesion == other.id_sesion;
	}



	public Pelicula getPelicula() {
		return pelicula;
	}



	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}



	@Override
	public String toString() {
		return "Sesiones [id_sesion=" + id_sesion + ", fecha=" + fecha + ", hora=" + hora + ", pelicula=" + pelicula
				+ "]";
	}
	

}
