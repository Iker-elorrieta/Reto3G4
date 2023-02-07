package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import modelo.Cines;
import modelo.Peliculas;
import modelo.Salas;

class CinesTest {
	int id_sala = 9;
	String nombreSalas = "sala1";
	int num_salas = 3;
	Date fecha;
	Date hora;
	Peliculas[] id_pelicula;
	Salas sala = new Salas(id_sala, nombreSalas, num_salas, fecha, hora, id_pelicula);
	int id_cine = 1;
	int id_cine0 = 0;
	String nombreCine = "elorrieta";
	Salas[] FK_id_sala = { sala };
	
	Cines cine = new Cines(id_cine, nombreCine, FK_id_sala);
	Cines cine1 = new Cines(id_cine, nombreCine, FK_id_sala);
	Cines cine2 = null;
	Cines cine3 = new Cines(id_cine0, nombreCine, FK_id_sala);
	@Test
	void test() {
		cine.setId_cine(id_cine);
		cine.setId_sala(FK_id_sala);
		cine.setNombreCine(nombreCine);
		assertEquals(cine.getId_cine(), id_cine);
		assertTrue(cine.getId_sala().equals(FK_id_sala));
		assertEquals(cine.getNombreCine(), nombreCine);
		assertEquals(cine.toString(),
				"id_cine=" + id_cine + ", nombre del Cine=" + nombreCine + ", id_sala=" + FK_id_sala);
		assertTrue(cine.equals(cine1));
		assertFalse(cine.equals(cine2));
		assertTrue(cine.equals(cine));
		assertFalse(cine.equals(cine3));
		assertFalse(cine.equals(FK_id_sala[0].getClass()));
	}
}
