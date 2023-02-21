package test;


import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Controlador.metodos;
import modelo.Cine;
import modelo.Cliente;
import modelo.Pelicula;

public class metodosTest {


	final String server = "jdbc:mysql://localhost/reto3bdbb";
	final String user = "root";
	final String pass = "";
	
	metodos metodos = new metodos();

	@Test
	public void testSacarPeliculasC() {
		String nombreCineSel = "Cines Yelmo";
		String nombrePeliSel = "Interestelar";
		Cine[] cines = metodos.cargarDatos();
		Pelicula[] pelicula = metodos.sacarPeliculasC(cines, nombreCineSel);
		metodos.sacarPeliculasC(cines, nombreCineSel);
		assertEquals(cines[0].getNombreCine(), nombreCineSel);
		assertNotEquals(pelicula[0].getNombrePelicula(), nombrePeliSel);

	}
	
	
	@Test
	public void testCargarDatos() {

		String nombreCineSel = "Cines Yelmo";
		Cine[] cines = metodos.cargarDatos();
		Cine[] cines2 = metodos.cargarDatos();
		
		Pelicula[] arrayPeliculas = metodos.sacarPeliculasC(cines, nombreCineSel);
		Pelicula[] peliNueva = metodos.sacarPeliculasC(cines, nombreCineSel);
		

		
		
		for (int i = 0; i < arrayPeliculas.length; i++) {
			assertEquals(arrayPeliculas[i].getId_pelicula(),peliNueva[i].getId_pelicula());
			assertEquals(arrayPeliculas[i].getDuracion(),peliNueva[i].getDuracion());
			assertEquals(arrayPeliculas[i].getGenero(),peliNueva[i].getGenero());
			assertEquals(arrayPeliculas[i].getNombrePelicula(),peliNueva[i].getNombrePelicula());
			assertEquals(arrayPeliculas[i].getPrecio(),peliNueva[i].getPrecio());
		}
		
		for (int i = 0; i < cines.length; i++) {
			assertEquals(cines2[i].getId_cine(), cines[i].getId_cine());
			assertEquals(cines2[i].getNombreCine(), cines[i].getNombreCine());
			assertNotEquals(cines2[i].getId_sala(), cines[i].getId_sala());
		}
		



	}


	@Test
	public void testArrayClientes() {
		Cliente[] clientes = metodos.arrayClientes();
		Cliente[] clientes2 = metodos.arrayClientes();

		for (int i = 0; i < clientes.length; i++) {
			assertEquals(clientes[i].getDni(), clientes2[i].getDni());
			assertEquals(clientes[i].getNombre(), clientes2[i].getNombre());
			assertEquals(clientes[i].getApellido(), clientes2[i].getApellido());
			assertEquals(clientes[i].getSexo(), clientes2[i].getSexo());
			assertEquals(clientes[i].getContrasenya(), clientes2[i].getContrasenya());
		}
	}


	
	
	@Test
	public void testSacarFechaPelicula() {
		String nCineSel = "Cines Yelmo";
		String nomPeliculaSel = "Shrek";

		Cine[] cine = metodos.cargarDatos();
		Pelicula[] pelicula = metodos.sacarPeliculasC(cine, nCineSel);
		metodos.sacarFechaPelicula(cine, nomPeliculaSel, nCineSel);	

		assertEquals(cine[0].getNombreCine(),nCineSel);
		assertEquals(pelicula[0].getNombrePelicula(),nomPeliculaSel);

	}
	
	@Test
	public void testsacarHora() {
	String nCineSel = "Cines Yelmo";
	String nomPeliculaSel = "Shrek";
	String fecha = "2023-02-07";

	Cine[] cine = metodos.cargarDatos();
	Pelicula[] pelicula = metodos.sacarPeliculasC(cine, nCineSel);
	metodos.sacarDatosF(nCineSel, fecha, cine);

	assertEquals(cine[0].getNombreCine(),nCineSel);
	assertEquals(pelicula[0].getNombrePelicula(),nomPeliculaSel);

	}
	
}
