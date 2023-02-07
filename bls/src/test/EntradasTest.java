package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import modelo.Cines;
import modelo.Cliente;
import modelo.Entradas;
import modelo.Peliculas;
import modelo.Salas;
import modelo.Sesiones;

class EntradasTest {
	int id_entrada = 0;
	int id_entrada0 = 1;
	Sesiones id_sesion;
	Peliculas peliculas;

	Cines cines;
	int id_cliente = 1;
	int id_cliente0 = 0;
	String dni = "21";
	String nombre = "1";
	String apellido = "21";
	char sexo = 'h';
	String contrasenya = "12";
	Cliente cliente = new Cliente(id_cliente, dni, nombre, apellido, sexo, contrasenya);
	Cliente[] clientes = { cliente };

	int id_sesion0;
	Date fecha;
	Date hora;
	Peliculas id_pelicula;
	Salas id_sala;

	Sesiones Sesiones = new Sesiones(id_sesion0, fecha, hora, id_pelicula, id_sala);
	Sesiones[] sesiones = { Sesiones };

	int id_pelicula0 = 2;

	String nombrePelicula = "12";
	float precio = 1.1f;
	int duracion = 132;
	String genero = "sus";

	Peliculas peliculas0 = new Peliculas(id_pelicula0, nombrePelicula, precio, duracion, genero);
	Peliculas[] peliculass = { peliculas0 };

	int id_sala0 = 9;
	String nombreSalas = "sala1";
	int num_salas = 3;
	Date fecha0;
	Date hora0;
	Peliculas[] id_pelicula00;
	Salas sala = new Salas(id_sala0, nombreSalas, num_salas, fecha0, hora0, id_pelicula00);

	Salas[] FK_id_sala = { sala };
	int id_cine = 1;

	String nombreCine = "elorrieta";
	Cines cine = new Cines(id_cine, nombreCine, FK_id_sala);
	Cines[] cinee = { cines };

	Entradas entradas = new Entradas(id_entrada, sesiones, peliculass, clientes, cinee);
	Entradas entradas1 = new Entradas(id_entrada, sesiones, peliculass, clientes, cinee);
	Entradas entradas2 = null;
	Entradas entradas3 = new Entradas(id_entrada0, sesiones, peliculass, clientes, cinee);

	@Test
	void test() {
		entradas.setCines(cinee);
		entradas.setCliente(clientes);
		entradas.setId_entrada(id_entrada);
		entradas.setId_sesion(sesiones);
		entradas.setPeliculas(peliculass);
		assertEquals(entradas.getId_entrada(), id_entrada);
		assertTrue(entradas.getCines().equals(cinee));
		assertTrue(entradas.getCliente().equals(clientes));
		assertTrue(entradas.getId_sesion().equals(sesiones));
		assertTrue(entradas.getPeliculas().equals(peliculass));

		assertTrue(entradas.equals(entradas1));
		assertFalse(entradas.equals(entradas2));
		assertTrue(entradas.equals(entradas));
		assertFalse(entradas.equals(entradas3));
		assertFalse(entradas.equals(entradas.getClass()));
		assertEquals(entradas.toString(), "Entradas [id_entrada=" + id_entrada + "]");
	}

}
