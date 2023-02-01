package modelo;



public class Salas {
	private int id_sala;
	private String nombreSalas;
	private int id_cine;
	
	public Salas(int id_sala,String nombreSalas,int id_cine) {
		this.id_sala = id_sala;
		this.nombreSalas = nombreSalas;
		this.id_cine = id_cine;
	}

	public int getId_sala() {
		return id_sala;
	}

	public void setId_sala(int id_sala) {
		this.id_sala = id_sala;
	}

	public String getNombreSalas() {
		return nombreSalas;
	}

	public void setNombreSalas(String nombreSalas) {
		this.nombreSalas = nombreSalas;
	}

	public int getId_cine() {
		return id_cine;
	}

	public void setId_cine(int id_cine) {
		this.id_cine = id_cine;
	}

	@Override
	public String toString() {
		return "id_sala=" + id_sala + ", nombre de la Sala = " + nombreSalas;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salas other = (Salas) obj;
		return id_sala == other.id_sala;
	}

}
