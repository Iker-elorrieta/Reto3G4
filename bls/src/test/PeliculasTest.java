package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import modelo.Peliculas;

class PeliculasTest {
	 int id_pelicula=2;
	 int id_pelicula0=1;
	 String nombrePelicula="12";
	 float precio= 1.1f;
	 int duracion=132;
	 String genero="sus";
	 
	 Peliculas peliculas = new Peliculas(id_pelicula,nombrePelicula,precio,duracion,genero);
	 Peliculas peliculas1 = new Peliculas(id_pelicula,nombrePelicula,precio,duracion,genero);
	 Peliculas peliculas3 = new Peliculas(id_pelicula0,nombrePelicula,precio,duracion,genero);
	 Peliculas peliculas2 = null;
	 

	@Test
	void test() {
		peliculas.setDuracion(duracion);
		peliculas.setGenero(genero);
		peliculas.setId_pelicula(id_pelicula);
		peliculas.setNombrePelicula(nombrePelicula);
		peliculas.setPrecio(precio);
		assertEquals(peliculas.getDuracion(),duracion);
		assertEquals(peliculas.getGenero(),genero);
		assertEquals(peliculas.getId_pelicula(),id_pelicula);
		assertEquals(peliculas.getNombrePelicula(),nombrePelicula);
		assertEquals(peliculas.getPrecio(),precio,1.1f);
		assertEquals(peliculas.toString(),"id_pelicula=" + id_pelicula + ", nombre de la pelicula=" + nombrePelicula + ", precio=" + precio
				+ ", duracion=" + duracion + ", genero=" + genero);
		assertTrue(peliculas.equals(peliculas1));
		assertFalse(peliculas.equals(peliculas2));
		assertTrue(peliculas.equals(peliculas));
		assertFalse(peliculas.equals(peliculas3));
		assertFalse(peliculas.equals(peliculas.getClass()));
	
	}

}
