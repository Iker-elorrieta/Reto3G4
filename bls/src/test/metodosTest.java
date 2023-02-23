package test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Controlador.metodos;
import modelo.Cine;
import modelo.Cliente;
import modelo.Sala;
import modelo.Sesion;

public class metodosTest {

	final String server = "jdbc:mysql://localhost/reto3bdbb";
	final String user = "root";
	final String pass = "";

	metodos metodos = new metodos();

	@Test
	public void testCargarDatos() {
		Cine[] arrayCines = metodos.cargarDatos();
		String resultado = arrayCines[0].toString();
		assertEquals(resultado,
				"Cine [id_cine=1, nombreCine=Cines Yelmo, arraySalas=[Salas [id_sala=1, nombreSalas=Sala Principal, arraySesiones=[Sesiones [id_sesion=1, fecha=2023-02-07, pelicula=id_pelicula=1, nombre de la pelicula=Shrek, precio=7.5, duracion=90, genero=Comedia], Sesiones [id_sesion=9, fecha=2023-02-17, pelicula=id_pelicula=2, nombre de la pelicula=Interestelar, precio=7.5, duracion=169, genero=Drama], Sesiones [id_sesion=10, fecha=2023-02-07, pelicula=id_pelicula=1, nombre de la pelicula=Shrek, precio=7.5, duracion=90, genero=Comedia], Sesiones [id_sesion=14, fecha=2023-02-10, pelicula=id_pelicula=5, nombre de la pelicula=Zatura, precio=7.5, duracion=101, genero=Ciencia Ficción], Sesiones [id_sesion=17, fecha=2023-03-01, pelicula=id_pelicula=6, nombre de la pelicula=Top Gun, precio=7.5, duracion=140, genero=Ciencia Ficción], Sesiones [id_sesion=19, fecha=2023-03-10, pelicula=id_pelicula=7, nombre de la pelicula=Fast and Furious, precio=7.5, duracion=120, genero=Ciencia Ficción], Sesiones [id_sesion=33, fecha=2023-03-04, pelicula=id_pelicula=10, nombre de la pelicula=Torrente 3, precio=7.5, duracion=90, genero=Comedia]]], Salas [id_sala=2, nombreSalas=Sala Secundaria, arraySesiones=[Sesiones [id_sesion=2, fecha=2023-02-17, pelicula=id_pelicula=5, nombre de la pelicula=Zatura, precio=7.5, duracion=101, genero=Ciencia Ficción], Sesiones [id_sesion=12, fecha=2023-02-10, pelicula=id_pelicula=5, nombre de la pelicula=Zatura, precio=7.5, duracion=101, genero=Ciencia Ficción], Sesiones [id_sesion=26, fecha=2023-03-01, pelicula=id_pelicula=8, nombre de la pelicula=Dinosaurios, precio=7.5, duracion=90, genero=Ciencia Ficción], Sesiones [id_sesion=34, fecha=2023-03-04, pelicula=id_pelicula=10, nombre de la pelicula=Torrente 3, precio=7.5, duracion=90, genero=Comedia]]], Salas [id_sala=3, nombreSalas=Sala Tercera, arraySesiones=[Sesiones [id_sesion=3, fecha=2023-02-09, pelicula=id_pelicula=1, nombre de la pelicula=Shrek, precio=7.5, duracion=90, genero=Comedia], Sesiones [id_sesion=20, fecha=2023-03-10, pelicula=id_pelicula=7, nombre de la pelicula=Fast and Furious, precio=7.5, duracion=120, genero=Ciencia Ficción], Sesiones [id_sesion=23, fecha=2023-03-01, pelicula=id_pelicula=8, nombre de la pelicula=Dinosaurios, precio=7.5, duracion=90, genero=Ciencia Ficción], Sesiones [id_sesion=28, fecha=2023-03-02, pelicula=id_pelicula=9, nombre de la pelicula=Padre no hay mas que uno, precio=7.5, duracion=105, genero=Comedia]]]]]");

	}

	@Test
	public void testMostrarCines() {
		Cine[] arrayCines = metodos.cargarDatos();
		String[] cines = metodos.mostrarCines(arrayCines);
		String resultado = cines[0].toString();

		assertEquals(resultado, "Cines Yelmo");

	}

	@Test
	public void testSalaDeUnaFechaPelicula() {
		Cine[] arrayCines = metodos.cargarDatos();
		String nCineSel = "Cines Yelmo";
		String nPeliSel = "Shrek";
		String fecha = "2023-02-07";

		Sala[] arraySala = metodos.salaDeUnaFechaPelicula(nCineSel, nPeliSel, fecha, arrayCines);

		String resultado = arraySala[0].toString();

		assertEquals(resultado,
				"Salas [id_sala=1, nombreSalas=Sala Principal, arraySesiones=[Sesiones [id_sesion=1, fecha=2023-02-07, pelicula=id_pelicula=1, nombre de la pelicula=Shrek, precio=7.5, duracion=90, genero=Comedia], Sesiones [id_sesion=9, fecha=2023-02-17, pelicula=id_pelicula=2, nombre de la pelicula=Interestelar, precio=7.5, duracion=169, genero=Drama], Sesiones [id_sesion=10, fecha=2023-02-07, pelicula=id_pelicula=1, nombre de la pelicula=Shrek, precio=7.5, duracion=90, genero=Comedia], Sesiones [id_sesion=14, fecha=2023-02-10, pelicula=id_pelicula=5, nombre de la pelicula=Zatura, precio=7.5, duracion=101, genero=Ciencia Ficción], Sesiones [id_sesion=17, fecha=2023-03-01, pelicula=id_pelicula=6, nombre de la pelicula=Top Gun, precio=7.5, duracion=140, genero=Ciencia Ficción], Sesiones [id_sesion=19, fecha=2023-03-10, pelicula=id_pelicula=7, nombre de la pelicula=Fast and Furious, precio=7.5, duracion=120, genero=Ciencia Ficción], Sesiones [id_sesion=33, fecha=2023-03-04, pelicula=id_pelicula=10, nombre de la pelicula=Torrente 3, precio=7.5, duracion=90, genero=Comedia]]]");

	}

	@Test
	public void testsSesionesDeUnaFechaPelicula() {
		Cine[] arrayCines = metodos.cargarDatos();
		String nCineSel = "Cines Yelmo";
		String nPeliSel = "Shrek";
		String fecha = "2023-02-07";

		Sesion[] arraySesion = metodos.sesionesDeUnaFechaPelicula(nCineSel, nPeliSel, fecha, arrayCines);

		String resultado = arraySesion[0].toString();

		assertEquals(resultado,
				"Sesiones [id_sesion=1, fecha=2023-02-07, pelicula=id_pelicula=1, nombre de la pelicula=Shrek, precio=7.5, duracion=90, genero=Comedia]");

	}

	@Test
	public void testSacarPeliculasOrdenadasPorfecha() {
		Cine[] arrayCines = metodos.cargarDatos();
		String nCineSel = "Cines Yelmo";

		String[] arrayPelicula = metodos.sacarPeliculasOrdenadasPorfecha(arrayCines, nCineSel);

		String resultado = arrayPelicula[0].toString();

		assertEquals(resultado, "Shrek");

	}

	@Test
	public void testSacarFechaPelicula() {
		Cine[] arrayCines = metodos.cargarDatos();
		String nCineSel = "Cines Yelmo";
		String nPeliSel = "Shrek";

		String[] arrayFecha = metodos.sacarFechaPelicula(arrayCines, nPeliSel, nCineSel);

		String resultado = arrayFecha[0].toString();

		assertEquals(resultado, "2023-02-07");

	}

	@Test
	public void testPrecioDeUnaPelicula() {
		Cine[] arrayCines = metodos.cargarDatos();
		String nPeliSel = "Shrek";

		float precio = metodos.precioDeUnaPelicula(nPeliSel, arrayCines);

		float resultado = precio;

		assertEquals(resultado, 7.5);

	}

	@Test
	public void testArrayClientes() {

		Cliente[] arrayclientes = metodos.arrayClientes();

		String resultado = arrayclientes[0].toString();
		assertEquals(resultado, "Cliente [dni=12345678, nombre=Juan, apellido=Mano Calva, sexo=H, contrasenya=12345]");

	}
	/*
	 * @Test public void testTablaResumen() { String precio = "7.5"; String pelicula
	 * = "Shrek"; String fecha = "2023-02-07"; String hora = "16:30:00"; String sala
	 * = "Sala Principal"; String nCineSel = "Cines Yelmo";
	 * 
	 * String[][] arrayTablaResumen = metodos.tablaResumen(precio, pelicula, fecha,
	 * hora, sala, nCineSel); String resultado = arrayTablaResumen[0][0].toString();
	 * assertEquals(resultado, "Cines Yelmo");
	 * 
	 * String resultado2 = arrayTablaResumen[0][1].toString();
	 * assertEquals(resultado2, "Sala Principal");
	 * 
	 * String resultado3 = arrayTablaResumen[0][2].toString();
	 * System.out.println(resultado3); assertEquals(resultado3, "Shrek"); }
	 */

}
