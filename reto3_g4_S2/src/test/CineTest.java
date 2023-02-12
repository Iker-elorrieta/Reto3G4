package test;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import modelo.Cine;
import modelo.Pelicula;
import modelo.Sala;
import modelo.Sesion;

class CineTest {
	int id_pelicula = 2;
	int id_pelicula0 = 1;
	String nombrePelicula = "12";
	float precio = 1.1f;
	int duracion = 132;
	String genero = "sus";

	Pelicula peliculas = new Pelicula(id_pelicula, nombrePelicula, precio, duracion, genero);

	int id_sesion = 0;
	int id_sesion0 = 1;
	Date fecha;
	Time hora;
	Sesion sesiones = new Sesion(id_sesion, fecha,hora, peliculas);

	int id_sala = 9;
	String nombreSalas = "sala1";

	Sesion[] arraySesiones = {sesiones};

	Sala sala = new Sala(id_sala, nombreSalas, arraySesiones);
	int id_cine = 1;
	int id_cine0 = 0;
	String nombreCine = "elorrieta";
	Sala[] arraySalas = { sala };

	Cine cine = new Cine(id_cine, nombreCine, arraySalas);
	Cine cine1 = new Cine(id_cine, nombreCine, arraySalas);
	Cine cine2 = null;
	Cine cine3 = new Cine(id_cine0, nombreCine, arraySalas);
	@Test
	
	void test() {
		cine.setId_cine(id_cine);
		cine.setId_sala(arraySalas);
		cine.setNombreCine(nombreCine);
		assertEquals(cine.getId_cine(), id_cine);
		assertTrue(cine.getId_sala().equals(arraySalas));
		assertEquals(cine.getNombreCine(), nombreCine);
		assertEquals(cine.toString(),
				"Cine [id_cine=" + id_cine + ", nombreCine=" + nombreCine + ", arraySalas=" + Arrays.toString(arraySalas)
				+ "]");
		assertTrue(cine.equals(cine1));
		assertFalse(cine.equals(cine2));
		assertTrue(cine.equals(cine));
		assertFalse(cine.equals(cine3));
		assertFalse(cine.equals(arraySalas[0].getClass()));
	}
}