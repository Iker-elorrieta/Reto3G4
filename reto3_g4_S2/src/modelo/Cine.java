package modelo;

import java.util.Arrays;

public class Cine {
	private int id_cine;
	private String nombreCine;
	private Sala[] arraySalas;

	public Cine(int id_cine,String nombreCine,Sala[] arraySalas) {
		this.id_cine = id_cine;
		this.nombreCine = nombreCine;
		this.arraySalas = arraySalas;
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

	public Sala[] getId_sala() {
		return arraySalas;
	}

	public void setId_sala(Sala[] arraySalas) {
		this.arraySalas = arraySalas;
	}
	
	@Override
	public String toString() {
		return "Cine [id_cine=" + id_cine + ", nombreCine=" + nombreCine + ", arraySalas=" + Arrays.toString(arraySalas)
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return id_cine == other.id_cine;
	}	
}