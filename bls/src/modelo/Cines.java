package modelo;

public class Cines {
	private int id_cine;
	private String nombreCine;
	private int num_salas;
	
	public Cines(int id_cine,String nombreCine,int num_salas) {
		this.id_cine = id_cine;
		this.nombreCine = nombreCine;
		this.num_salas = num_salas;
	}

	public int getId_cine() {
		return id_cine;
	}

	public void setId_cine(int id_cine) {
		this.id_cine = id_cine;
	}

	public String getNombreCine() {
		return nombreCine;
	}

	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	public int getNum_salas() {
		return num_salas;
	}

	public void setNum_salas(int num_salas) {
		this.num_salas = num_salas;
	}

	@Override
	public String toString() {
		return "id_cine=" + id_cine + ", nombre del Cine=" + nombreCine + ", numero de salas=" + num_salas ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cines other = (Cines) obj;
		return id_cine == other.id_cine;
	}
	
}
