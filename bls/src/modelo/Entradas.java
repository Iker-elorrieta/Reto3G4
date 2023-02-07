package modelo;


public class Entradas {
	private int id_entrada;
	private Sesiones []id_sesion;
	private Peliculas []peliculas;
	private Cliente []cliente;
	private Cines []cines;
	


	public Entradas(int id_entrada,Sesiones[] id_sesion,Peliculas[] peliculas,Cliente[] cliente,Cines []cines) {
		this.id_entrada=id_entrada;
		this.id_sesion=id_sesion;
		this.peliculas = peliculas;
		this.cliente = cliente;
		this.cines = cines;
	}


	public int getId_entrada() {
		return id_entrada;
	}

	public void setId_entrada(int id_entrada) {
		this.id_entrada = id_entrada;
	}
	
	public Sesiones[] getId_sesion() {
		return id_sesion;
	}

	public void setId_sesion(Sesiones[] id_sesion) {
		this.id_sesion = id_sesion;
	}
	public Peliculas []getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Peliculas []peliculas) {
		this.peliculas = peliculas;
	}

	public Cliente[] getCliente() {
		return cliente;
	}

	public void setCliente(Cliente[] cliente) {
		this.cliente = cliente;
	}

	public Cines[] getCines() {
		return cines;
	}

	public void setCines(Cines[] cines) {
		this.cines = cines;
	}



	
	@Override
	public String toString() {
		return "Entradas [id_entrada=" + id_entrada + "]";
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
