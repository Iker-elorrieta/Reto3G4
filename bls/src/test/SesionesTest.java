package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import modelo.Cines;
import modelo.Peliculas;
import modelo.Salas;
import modelo.Sesiones;

class SesionesTest {
	int id_pelicula0 = 2;

	String nombrePelicula = "12";
	float precio = 1.1f;
	int duracion = 132;
	String genero = "sus";
	Peliculas peliculas = new Peliculas(id_pelicula0, nombrePelicula, precio, duracion, genero);
	Peliculas [] arrayPeliculas = {peliculas};
	
	
	int id_sala = 9;
	String nombreSalas = "sala1";
	int num_salas = 3;
	Salas sala = new Salas(id_sala, nombreSalas, num_salas, arrayPeliculas);
	int id_cine = 1;
	int id_cine0 = 0;
	String nombreCine = "elorrieta";
	Salas[] FK_id_sala = { sala };
	
	Cines cine = new Cines(id_cine, nombreCine, FK_id_sala);
	Cines[] arrayCines = {cine};
	 
	int id_sesion=0;
	 int id_sesion0=1;
	 Date fecha;
	 Date hora;
	  Sesiones sesiones = new Sesiones (id_sesion,fecha,hora,arrayPeliculas,arrayCines);
	  Sesiones sesiones1 = new Sesiones (id_sesion,fecha,hora,arrayPeliculas,arrayCines);
	  Sesiones sesiones2 = null;
	  Sesiones sesiones3 = new Sesiones (id_sesion0,fecha,hora,arrayPeliculas,arrayCines);
	  
	@Test
	void test() {
		sesiones.setFecha(fecha);
		sesiones.setHora(hora);
		sesiones.setPelicula(arrayPeliculas);
		sesiones.setId_sesion(id_sesion);
		sesiones.setArrayCine(arrayCines);
		assertEquals(sesiones.getFecha(),fecha);
		assertEquals(sesiones.getHora(),hora);
		assertTrue(sesiones.getPelicula().equals(arrayPeliculas));
		assertTrue(sesiones.getArrayCine().equals(arrayCines));
		assertEquals(sesiones.getId_sesion(),id_sesion);
		assertEquals(sesiones.toString(),"Sesiones [id_sesion=" + id_sesion + ", fecha=" + fecha + ", hora=" + hora + ", arrayPelicula="
				+ Arrays.toString(arrayPeliculas) + ", arrayCine=" + Arrays.toString(arrayCines) + "]");
		
		assertTrue(sesiones.equals(sesiones1));
		assertFalse(sesiones.equals(sesiones2));
		assertTrue(sesiones.equals(sesiones));
		assertFalse(sesiones.equals(sesiones3));
		assertFalse(sesiones.equals(sesiones.getClass()));
	}

}
