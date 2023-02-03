package modelo;

import java.util.Date;

public class Entradas {
	private int id_entrada;
	private int id_sesion;
	private String nombreCines;
	private String nombreSalas;
	private Hora hora;
	private Date fecha;
	private String nombrePelicula;
	private int duracion;
	private float precio;
	private String genero;
	
	public Entradas( int id_entrada ,int id_sesion ) {
		this.id_entrada = id_entrada;
		this.id_sesion = id_sesion;
	/*	this.nombreCines = nombreCines;
		this.nombreSalas = nombreSalas;
		this.hora = hora;
		this.fecha = fecha;
		this.nombrePelicula = nombrePelicula;
		this.duracion = duracion;
		this.precio = precio;
		this.genero = genero;*/
	}
/*	
	public String getNombreCines() {
		return nombreCines;
	}

	public void setNombreCines(String nombreCines) {
		this.nombreCines = nombreCines;
	}

	public String getNombreSalas() {
		return nombreSalas;
	}

	public void setNombreSalas(String nombreSalas) {
		this.nombreSalas = nombreSalas;
	}

	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

*/


	


	public int getId_entrada() {
		return id_entrada;
	}

	public void setId_entrada(int id_entrada) {
		this.id_entrada = id_entrada;
	}

	public int getId_sesion() {
		return id_sesion;
	}

	public void setId_sesion(int id_sesion) {
		this.id_sesion = id_sesion;
	}

	@Override
	public String toString() {
		return "id_entrada=" + id_entrada + ", id_sesion=" + id_sesion ;
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
