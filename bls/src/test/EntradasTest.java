package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Pelicula;
import modelo.Sesion;

class EntradasTest {
	int id_entrada = 0;
	int id_entrada0 = 1;

	int id_cliente = 1;
	int id_cliente0 = 0;
	String dni = "21";
	String nombre = "1";
	String apellido = "21";
	char sexo = 'h';
	String contrasenya = "12";
	Cliente cliente = new Cliente(id_cliente, dni, nombre, apellido, sexo, contrasenya);
	
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

	Entrada entradas = new Entrada(id_entrada,cliente, arraySesiones);
	Entrada entradas1 = new Entrada(id_entrada, cliente, arraySesiones);
	Entrada entradas2 = null;
	Entrada entradas3 = new Entrada(id_entrada0, cliente, arraySesiones);
	@Test
	void test() {
		entradas.setCliente(cliente);
		entradas.setId_entrada(id_entrada);
		entradas.setSesiones(arraySesiones);
		assertEquals(entradas.getId_entrada(), id_entrada);
		assertTrue(entradas.getSesiones().equals(arraySesiones));
		assertTrue(entradas.getCliente().equals(cliente));

		assertTrue(entradas.equals(entradas1));
		assertFalse(entradas.equals(entradas2));
		assertTrue(entradas.equals(entradas));
		assertFalse(entradas.equals(entradas3));
		assertFalse(entradas.equals(entradas.getClass()));
		assertEquals(entradas.toString(), "Entradas [id_entrada=" + id_entrada + ", cliente=" + cliente + ", sesiones=" + Arrays.toString(arraySesiones)
		+ "]");
	}

}
