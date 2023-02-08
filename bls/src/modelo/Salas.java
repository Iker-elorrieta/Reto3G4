package modelo;

import java.util.Arrays;

public class Salas {
	private int id_sala;
	private String nombreSalas;
	private int num_salas;
	private Peliculas [] arrayPeliculas;
	
	public Salas(int id_sala,String nombreSalas,int num_salas,Peliculas []arrayPeliculas) {
		this.id_sala = id_sala;
		this.nombreSalas = nombreSalas;
		this.num_salas=num_salas;
		this.arrayPeliculas=arrayPeliculas;
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
	public String toString() {
		return "Salas [id_sala=" + id_sala + ", nombreSalas=" + nombreSalas + ", num_salas=" + num_salas + ", id_pelicula=" + Arrays.toString(arrayPeliculas) + "]";
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

	public int getNum_salas() {
		return num_salas;
	}

	public void setNum_salas(int num_salas) {
		this.num_salas = num_salas;
	}

	public Peliculas[] getId_pelicula() {
		return arrayPeliculas;
	}

	public void setId_pelicula(Peliculas[] arrayPeliculas) {
		this.arrayPeliculas = arrayPeliculas;
	}

}
