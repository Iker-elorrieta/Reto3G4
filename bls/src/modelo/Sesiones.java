package modelo;

import java.sql.Date;


public class Sesiones {
	private int id_sesion;
	private Date fecha;
	private Date hora;
	private Peliculas pelicula;
	private Salas salas;
	public Sesiones( int id_sesion,Date fecha,Date hora,Peliculas pelicula,Salas salas) {
		this.id_sesion=id_sesion;
		this.fecha=fecha;
		this.hora=hora;
		this.pelicula=pelicula;
		this.salas=salas;
	};
	



	@Override
	public String toString() {
		return "Sesiones [id_sesion=" + id_sesion + "]";
	}




	public Peliculas getPelicula() {
		return pelicula;
	}
	public void setPelicula(Peliculas pelicula) {
		this.pelicula = pelicula;
	}
	public Salas getSalas() {
		return salas;
	}
	public void setSalas(Salas salas) {
		this.salas = salas;
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
	

}
