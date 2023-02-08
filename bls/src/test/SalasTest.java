package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import modelo.Peliculas;
import modelo.Salas;

class SalasTest {
	int id_sala = 1;
	int id_sala0 = 0;
	String nombreSalas = "main";
	int num_salas = 3;
	Date fecha = null;
	Date hora = null;
	
	int id_pelicula0;
	String nombrePelicula;
	float precio;
	int duracion;
	String genero;
	Peliculas peliculas = new Peliculas(id_pelicula0, nombrePelicula, precio, duracion, genero);
	Peliculas[] arrayPeliculas = { peliculas };
	Salas sala = new Salas(id_sala, nombreSalas, num_salas, arrayPeliculas);
	Salas sala1 = new Salas(id_sala, nombreSalas, num_salas, arrayPeliculas);
	Salas sala2 = null;
	Salas sala3 = new Salas(id_sala0, nombreSalas, num_salas, arrayPeliculas);
	@Test
	
	void test() {

		sala.setId_pelicula(arrayPeliculas);
		sala.setId_sala(id_sala);
		sala.setNombreSalas(nombreSalas);
		sala.setNum_salas(num_salas);

		assertTrue(sala.getId_pelicula().equals(arrayPeliculas));
		assertEquals(sala.getId_sala(), id_sala);
		assertEquals(sala.getNombreSalas(), nombreSalas);
		assertEquals(sala.getNum_salas(), num_salas);
		assertEquals(sala.toString(),  "Salas [id_sala=" + id_sala + ", nombreSalas=" + nombreSalas + ", num_salas=" + num_salas + ", id_pelicula=" + Arrays.toString(arrayPeliculas) + "]");
		assertTrue(sala.equals(sala1));
		assertFalse(sala.equals(sala2));
		assertTrue(sala.equals(sala));
		assertFalse(sala.equals(sala3));
		assertFalse(sala.equals(sala.getClass()));
	}
	

}
