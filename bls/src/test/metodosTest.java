package test;


import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import Controlador.metodos;
import modelo.Cine;
import modelo.Cliente;
import modelo.Sesion;

public class metodosTest {


	final String server = "jdbc:mysql://localhost/reto3bdbb";
	final String user = "root";
	final String pass = "";
	
	metodos metodos = new metodos();

	@Test
	public void testMostrarCines() {
		Cine[] cine = metodos.cargarDatos();
		
		String[] cines = metodos.mostrarCines(cine);
		String[] cines2 = metodos.mostrarCines(cine);

		for (int i = 0; i < cines.length; i++) {
			assertEquals(cines2[i], cines[i]);
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
	public void testSacarPeliculasOrdenadasPorfecha() {
		String nombreCineSel = "Cines Yelmo";
		Cine[] cines = metodos.cargarDatos();
		metodos.sacarPeliculasOrdenadasPorfecha(cines, nombreCineSel);
		metodos.cargarDatos();

		assertEquals(cines[0].getNombreCine(), nombreCineSel);

	}
	
	
	@Test
	public void testSesionesDeUnaFechaPelicula() {
		String nCineSel = "Cines Yelmo";
		String nomPeliculaSel = "Shrek";
		String fecha = "2023-02-07";
		Cine[] cine = metodos.cargarDatos();
		
		metodos.sesionesDeUnaFechaPelicula(nCineSel, nomPeliculaSel, fecha, cine);
		Sesion[] sesiones = new Sesion[1];
		
		assertEquals(cine[0].getNombreCine(),nCineSel);
		assertNotEquals(sesiones[0],nomPeliculaSel);
	}
	
	@Test
	public void testSalaDeUnaFechaPelicula() {
		String nCineSel = "Cines Yelmo";
		String nomPeliculaSel = "Shrek";
		String fecha = "2023-02-07";
		Cine[] cine = metodos.cargarDatos();
		
		metodos.salaDeUnaFechaPelicula(nCineSel, nomPeliculaSel, fecha, cine);
		Sesion[] sesiones = new Sesion[1];
		
		assertEquals(cine[0].getNombreCine(),nCineSel);
		assertNotEquals(sesiones[0],nomPeliculaSel);
	}
	
	@Test
	public void testPrecioDeUnaPelicula() {
		Cine[] cine = metodos.cargarDatos();
		String nomPeliculaSel = "Shrek";
		metodos.precioDeUnaPelicula(nomPeliculaSel, cine);
		
		
	}
	
	@Test
	public void testSacarFechaPelicula() {
		String nCineSel = "Cines Yelmo";
		String nomPeliculaSel = "Shrek";
		Cine[] cine = metodos.cargarDatos();
		metodos.sacarFechaPelicula(cine, nomPeliculaSel, nCineSel);
		
		
	}
	
	
/*	@Test
	public void testCompra() {
		String precio = "7.5";
		String pelicula = "Shrek";
		String fecha = "2023-02-07";
		String hora = "12:30";
		String sala = "Sala Principal";
		
		metodos.compra(precio, pelicula, fecha, hora, sala);
		String[] [] carritoNew=new String [cont+1][5];
	}
*/
}
