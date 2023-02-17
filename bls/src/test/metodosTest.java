package test;


import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import Controlador.metodos;
import modelo.Cine;
import modelo.Cliente;
import modelo.Pelicula;
import modelo.Sesion;

public class metodosTest {


	final String server = "jdbc:mysql://localhost/reto3bd";
	final String user = "root";
	final String pass = "";
	
	metodos metodos = new metodos();

	@Test
	public void testArrayCines() {
		Cine[] cines = metodos.arrayCines();
		Cine[] cines2 = metodos.arrayCines();

		for (int i = 0; i < cines.length; i++) {
			assertEquals(cines2[i].getId_cine(), cines[i].getId_cine());
			assertEquals(cines2[i].getNombreCine(), cines[i].getNombreCine());
			assertEquals(cines2[i].getId_sala(), cines[i].getId_sala());
		}

	}

	@Test
	public void testArraySesiones() {
		Sesion[] sesiones = metodos.arraySesiones();
		Sesion[] sesiones2 = metodos.arraySesiones();

		for (int i = 0; i < sesiones.length; i++) {
			assertEquals(sesiones[i].getId_sesion(), sesiones2[i].getId_sesion());
			assertEquals(sesiones[i].getFecha(), sesiones2[i].getFecha());
			assertEquals(sesiones[i].getHora(), sesiones2[i].getHora());
			assertEquals(sesiones[i].getPelicula(), sesiones2[i].getPelicula());
		}
	}

	@Test
	public void testArrayClientes() {
		Cliente cliente = new Cliente();
		Cliente[] clientes = metodos.arrayClientes(cliente);
		Cliente[] clientes2 = metodos.arrayClientes(cliente);

		for (int i = 0; i < clientes.length; i++) {
			assertEquals(clientes[i].getDni(), clientes2[i].getDni());
			assertEquals(clientes[i].getNombre(), clientes2[i].getNombre());
			assertEquals(clientes[i].getApellido(), clientes2[i].getApellido());
			assertEquals(clientes[i].getSexo(), clientes2[i].getSexo());
			assertEquals(clientes[i].getContrasenya(), clientes2[i].getContrasenya());
		}
	}

	@Test
	public void testSacarPeliculaDelCine() {
		String nombreCineSel = "Cines Yelmo";
		Cine[] cines = metodos.arrayCines();
		metodos.sacarPeliculaDelCine(nombreCineSel, cines);
		metodos.arrayCines();



		assertEquals(cines[0].getNombreCine(), nombreCineSel);

	}
	
	
	@Test
	public void testFechaPelicula() {
		String nCineSel = "Cines Yelmo";
		String nomPeliculaSel = "Shrek";

		Cine[] cine = metodos.arrayCines();
		Pelicula[] pelicula = metodos.sacarPeliculaDelCine(nCineSel, cine);
		metodos.sacarFechaPelicula(cine, nomPeliculaSel, nCineSel);	

		assertEquals(cine[0].getNombreCine(),nCineSel);
		assertEquals(pelicula[0].getNombrePelicula(),nomPeliculaSel);

	}
	
	@Test
	public void testsacarHora() {
	String nCineSel = "Cines Yelmo";
	String nomPeliculaSel = "Shrek";
	String fecha = "2023-02-07";

	Cine[] cine = metodos.arrayCines();
	Pelicula[] pelicula = metodos.sacarPeliculaDelCine(nCineSel, cine);
	Sesion[] sesion = metodos.arraySesiones();
	metodos.sacarHora(nCineSel,  nomPeliculaSel, fecha);

	assertEquals(cine[0].getNombreCine(),nCineSel);
	assertEquals(pelicula[0].getNombrePelicula(),nomPeliculaSel);
	assertNotEquals(sesion[0].getFecha(),fecha);

	}

}
