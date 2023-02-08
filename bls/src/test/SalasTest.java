package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import modelo.Pelicula;
import modelo.Sala;
import modelo.Sesion;

class SalasTest {
	int id_sala = 1;
	int id_sala0 = 0;
	String nombreSalas = "main";
	int num_salas = 3;
	
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
	Sesion [] arraySesiones= {sesiones};

	

	Sala sala = new Sala(id_sala, nombreSalas, num_salas, arraySesiones);
	Sala sala1 = new Sala(id_sala, nombreSalas, num_salas, arraySesiones);
	Sala sala2 = null;
	Sala sala3 = new Sala(id_sala0, nombreSalas, num_salas, arraySesiones);
	@Test
	
	void test() {
		sala.setId_sala(id_sala);
		sala.setNombreSalas(nombreSalas);
		sala.setNum_salas(num_salas);
		sala.setArraySesiones(arraySesiones);

		assertTrue(sala.getArraySesiones().equals(arraySesiones));
		assertEquals(sala.getId_sala(), id_sala);
		assertEquals(sala.getNombreSalas(), nombreSalas);
		assertEquals(sala.getNum_salas(), num_salas);
		assertEquals(sala.toString(), 
				"Salas [id_sala=" + id_sala + ", nombreSalas=" + nombreSalas + ", num_salas=" + num_salas
				+ ", arraySesiones=" + Arrays.toString(arraySesiones) + "]"	);
		assertTrue(sala.equals(sala1));
		assertFalse(sala.equals(sala2));
		assertTrue(sala.equals(sala));
		assertFalse(sala.equals(sala3));
		assertFalse(sala.equals(sala.getClass()));
	}

}
