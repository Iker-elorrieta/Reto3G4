package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import modelo.Cine;
import modelo.Pelicula;
import modelo.Sala;
import modelo.Sesion;

class SesionesTest {
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
	Date hora;
	Sesion sesiones = new Sesion(id_sesion, fecha, hora, peliculas);
	Sesion sesiones1 = new Sesion(id_sesion, fecha, hora, peliculas);
	Sesion sesiones2 = null;
	Sesion sesiones3 = new Sesion(id_sesion0, fecha, hora, peliculas);
	
	@Test
	void test() {
		sesiones.setFecha(fecha);
		sesiones.setHora(hora);
		sesiones.setPelicula(peliculas);
		sesiones.setId_sesion(id_sesion);
		assertEquals(sesiones.getFecha(), fecha);
		assertEquals(sesiones.getHora(), hora);
		assertEquals(sesiones.getId_sesion(), id_sesion);
		assertEquals(sesiones.getPelicula(),peliculas);
		assertEquals(sesiones.toString(), "Sesiones [id_sesion=" + id_sesion + ", fecha=" + fecha + ", hora=" + hora
				+ ", pelicula=" + peliculas + "]");

		assertTrue(sesiones.equals(sesiones1));
		assertFalse(sesiones.equals(sesiones2));
		assertTrue(sesiones.equals(sesiones));
		assertFalse(sesiones.equals(sesiones3));
		assertFalse(sesiones.equals(sesiones.getClass()));
	}

}
