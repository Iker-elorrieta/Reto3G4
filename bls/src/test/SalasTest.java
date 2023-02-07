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
	Peliculas[] id_pelicula = { peliculas };
	Salas sala = new Salas(id_sala, nombreSalas, num_salas, fecha, hora, id_pelicula);
	Salas sala1 = new Salas(id_sala, nombreSalas, num_salas, fecha, hora, id_pelicula);
	Salas sala2 = null;
	Salas sala3 = new Salas(id_sala0, nombreSalas, num_salas, fecha, hora, id_pelicula);
	@Test
	
	void test() {
		sala.setFecha(fecha);
		sala.setHora(hora);
		sala.setId_pelicula(id_pelicula);
		sala.setId_sala(id_sala);
		sala.setNombreSalas(nombreSalas);
		sala.setNum_salas(num_salas);
		assertEquals(sala.getFecha(), fecha);
		assertEquals(sala.getHora(), hora);
		assertTrue(sala.getId_pelicula().equals(id_pelicula));
		assertEquals(sala.getId_sala(), id_sala);
		assertEquals(sala.getNombreSalas(), nombreSalas);
		assertEquals(sala.getNum_salas(), num_salas);
		assertEquals(sala.toString(),  "Salas [id_sala=" + id_sala + ", nombreSalas=" + nombreSalas + ", num_salas=" + num_salas + ", fecha="
				+ fecha + ", hora=" + hora + ", id_pelicula=" + Arrays.toString(id_pelicula) + "]");
		assertTrue(sala.equals(sala1));
		assertFalse(sala.equals(sala2));
		assertTrue(sala.equals(sala));
		assertFalse(sala.equals(sala3));
		assertFalse(sala.equals(sala.getClass()));
	}
	

}
