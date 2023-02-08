package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import modelo.Cliente;
import modelo.Entradas;
import modelo.Peliculas;

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
	
	int id_pelicula0 = 2;
	String nombrePelicula = "12";
	float precio = 1.1f;
	int duracion = 132;
	String genero = "sus";
	
	Peliculas peliculas = new Peliculas(id_pelicula0, nombrePelicula, precio, duracion, genero);
	Peliculas[] arrayPeliculas = { peliculas };

	Entradas entradas = new Entradas(id_entrada, arrayPeliculas, cliente);
	Entradas entradas1 = new Entradas(id_entrada, arrayPeliculas, cliente);
	Entradas entradas2 = null;
	Entradas entradas3 = new Entradas(id_entrada0, arrayPeliculas, cliente);

	@Test
	void test() {
		entradas.setCliente(cliente);
		entradas.setId_entrada(id_entrada);
		entradas.setPeliculas(arrayPeliculas);
		assertEquals(entradas.getId_entrada(), id_entrada);
		assertTrue(entradas.getPeliculas().equals(arrayPeliculas));
		assertTrue(entradas.getCliente().equals(cliente));

		assertTrue(entradas.equals(entradas1));
		assertFalse(entradas.equals(entradas2));
		assertTrue(entradas.equals(entradas));
		assertFalse(entradas.equals(entradas3));
		assertFalse(entradas.equals(entradas.getClass()));
		assertEquals(entradas.toString(),  "Entradas [id_entrada=" + id_entrada + ", peliculas=" + Arrays.toString(arrayPeliculas) + ", cliente="
				+ cliente + "]");
	}

}
