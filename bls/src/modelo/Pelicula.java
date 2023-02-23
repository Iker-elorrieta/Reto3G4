package modelo;


public class Pelicula {
	private int id_pelicula;
	private String nombrePelicula;
	private float precio;
	private int duracion;
	private String genero;

	public Pelicula(int id_pelicula, String nombrePelicula, float precio, int duracion, String genero) {
		this.id_pelicula = id_pelicula;
		this.nombrePelicula = nombrePelicula;
		this.precio = precio;
		this.duracion = duracion;
		this.genero = genero;
	}

	public Pelicula() {
		// TODO Auto-generated constructor stub
	}

	public int getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "id_pelicula=" + id_pelicula + ", nombre de la pelicula=" + nombrePelicula + ", precio=" + precio
				+ ", duracion=" + duracion + ", genero=" + genero;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return id_pelicula == other.id_pelicula;
	}

}