package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import modelo.Peliculas;
import modelo.Salas;
import modelo.Sesiones;

class SesionesTest {
	int id_pelicula0 = 2;

	String nombrePelicula = "12";
	float precio = 1.1f;
	int duracion = 132;
	String genero = "sus";
	Peliculas peliculas0 = new Peliculas(id_pelicula0, nombrePelicula, precio, duracion, genero);
	Peliculas [] peli = {peliculas0};
	
	int id_sala0 = 9;
	String nombreSalas = "sala1";
	int num_salas = 3;
	Date fecha0;
	Date hora0;

	Salas sala = new Salas(id_sala0, nombreSalas, num_salas, fecha0, hora0, peli);

	 
	int id_sesion=0;
	 int id_sesion0=1;
	 Date fecha;
	 Date hora;
	  Sesiones sesiones = new Sesiones (id_sesion,fecha,hora,peliculas0,sala);
	  Sesiones sesiones1 = new Sesiones (id_sesion,fecha,hora,peliculas0,sala);
	  Sesiones sesiones2 = null;
	  Sesiones sesiones3 = new Sesiones (id_sesion0,fecha,hora,peliculas0,sala);
	  
	@Test
	void test() {
		sesiones.setFecha(fecha);
		sesiones.setHora(hora);
		sesiones.setPelicula(peliculas0);
		sesiones.setSalas(sala);
		sesiones.setId_sesion(id_sesion);
		assertEquals(sesiones.getFecha(),fecha);
		assertEquals(sesiones.getHora(),hora);
		assertTrue(sesiones.getPelicula().equals(peliculas0));
		assertEquals(sesiones.getId_sesion(),id_sesion);
		assertTrue(sesiones.getSalas().equals(sala));
		assertEquals(sesiones.toString(),"Sesiones [id_sesion=" + id_sesion + "]");
		
		
		assertTrue(sesiones.equals(sesiones1));
		assertFalse(sesiones.equals(sesiones2));
		assertTrue(sesiones.equals(sesiones));
		assertFalse(sesiones.equals(sesiones3));
		assertFalse(sesiones.equals(sesiones.getClass()));
	}

}
