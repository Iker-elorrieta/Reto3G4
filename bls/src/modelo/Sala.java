package modelo;

import java.util.Arrays;

public class Sala {
	private int id_sala;
	private String nombreSalas;
	private Sesion[] arraySesiones;
	
	public Sala(int id_sala,String nombreSalas, Sesion[] arraySesiones) {
		this.id_sala = id_sala;
		this.nombreSalas = nombreSalas;
		this.arraySesiones=arraySesiones;
	}
	
	public Sala() {
		// TODO Auto-generated constructor stub
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return id_sala == other.id_sala;
	}
	public Sesion[] getArraySesiones() {
		return arraySesiones;
	}

	public void setArraySesiones(Sesion[] arraySesiones) {
		this.arraySesiones = arraySesiones;
	}

	@Override
	public String toString() {
		return "Salas [id_sala=" + id_sala + ", nombreSalas=" + nombreSalas +  ", arraySesiones=" + Arrays.toString(arraySesiones) + "]";
	}

}