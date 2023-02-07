package modelo;

public class Cines {
	private int id_cine;
	private String nombreCine;
	private Salas[] id_sala;

	public Cines(int id_cine,String nombreCine,Salas[] id_sala) {
		this.id_cine = id_cine;
		this.nombreCine = nombreCine;
		this.id_sala = id_sala;
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

	public Salas[] getId_sala() {
		return id_sala;
	}

	public void setId_sala(Salas[] id_sala) {
		this.id_sala = id_sala;
	}

	@Override
	public String toString() {
		return "id_cine=" + id_cine + ", nombre del Cine=" + nombreCine + ", id_sala=" + id_sala ;
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
