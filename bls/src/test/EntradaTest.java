package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;


import org.junit.jupiter.api.Test;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Pelicula;
import modelo.Sesion;

class EntradaTest {
	int id_entrada = 0;
	int id_entrada0 = 1;
	float precioTotal;

	String dni = "21";
	String nombre = "1";
	String apellido = "21";
	String sexo = "h";
	String contrasenya = "12";
	Cliente cliente = new Cliente( dni, nombre, apellido, sexo, contrasenya);
	
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
	Sesion [] arraySesiones= {sesiones};

	Entrada entradas = new Entrada(id_entrada,cliente, arraySesiones,precioTotal);
	Entrada entradas1 = new Entrada(id_entrada, cliente, arraySesiones,precioTotal);
	Entrada entradas2 = null;
	Entrada entradas3 = new Entrada(id_entrada0, cliente, arraySesiones,precioTotal);
	@Test
	void test() {
		entradas.setCliente(cliente);
		entradas.setId_entrada(id_entrada);
		entradas.setSesiones(arraySesiones);
		entradas.setPrecioTotal(precioTotal);
		assertEquals(entradas.getId_entrada(), id_entrada);
		assertTrue(entradas.getSesiones().equals(arraySesiones));
		assertTrue(entradas.getCliente().equals(cliente));
		assertEquals(entradas.getPrecioTotal(), precioTotal,1.1f);

		assertTrue(entradas.equals(entradas1));
		assertFalse(entradas.equals(entradas2));
		assertTrue(entradas.equals(entradas));
		assertFalse(entradas.equals(entradas3));
		assertFalse(entradas.equals(entradas.getClass()));
		assertEquals(entradas.toString(),"Entrada [id_entrada=" + id_entrada + ", cliente=" + cliente + ", arraySesiones="
				+ Arrays.toString(arraySesiones) + ", precioTotal=" + precioTotal + "]");
	}
	
}