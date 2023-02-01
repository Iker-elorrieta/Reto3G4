package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import modelo.Cines;
import modelo.Cliente;
import modelo.Entradas;
import modelo.Hora;
import modelo.Peliculas;
import modelo.Salas;
import modelo.Sesiones;

class testModelo {
	int hora = 10;
	int minuto = 20;
	Hora hr = new Hora(hora, minuto);
	// ------------------------------------------------------------------------------
	int id_cine = 1;
	int id_cine2 = 2;
	String nombreCine = "elorrieta";
	int num_salas = 2;
	Cines cn = new Cines(id_cine, nombreCine, num_salas);
	Cines cn1 = new Cines(id_cine, nombreCine, num_salas);
	Cines cn3 = new Cines(id_cine2, nombreCine, num_salas);
	Cines cn2 = null;
	// -------------------------------------------------------------------------------
	int id_cliente = 1;
	int id_cliente2 = 1;
	int id_cliente3 = 3;
	String dni = "12345678A";
	String nombre = "Juan";
	String apellido = "Cas";
	char sexo = 'H';
	String contraseña = "1234";
	Cliente cliente = new Cliente(id_cliente, dni, nombre, apellido, sexo, contraseña);
	Cliente cliente2 = new Cliente(id_cliente2, dni, nombre, apellido, sexo, contraseña);
	Cliente cliente3 = new Cliente(id_cliente3, dni, nombre, apellido, sexo, contraseña);
	Cliente cliente4 = null;
	// ------------------------------------------------------------------------------------
	int id_entrada = 1;
	int id_entrada2 = 2;
	int id_sesion = 2;
	Entradas entradas = new Entradas(id_entrada, id_sesion);
	Entradas entradas1 = new Entradas(id_entrada, id_sesion);
	Entradas entradas2 = new Entradas(id_entrada2, id_sesion);
	Entradas entradas3 = null;
	// ----------------------------------------------------------------------------------
	int id_pelicula = 1;
	int id_pelicula2 = 2;
	String nombrePelicula = "o";
	float precio = (float) 1.2;
	int duracion = 100;
	String genero = "sus";
	Peliculas peli = new Peliculas(id_pelicula, nombrePelicula, precio, duracion, genero);
	Peliculas peli2 = new Peliculas(id_pelicula, nombrePelicula, precio, duracion, genero);
	Peliculas peli3 = new Peliculas(id_pelicula2, nombrePelicula, precio, duracion, genero);
	Peliculas peli4 = null;

	// ----------------------------------------------------------------------------------
	int id_sesion0=1;
	int id_sesion01=2;
	Date fecha = new Date(1234567890123L);;
	Hora hora0 =hr;;
	Sesiones sn = new Sesiones (id_sesion0,fecha,hora0);
	Sesiones sn1 = new Sesiones (id_sesion0,fecha,hora0);
	Sesiones sn2 = new Sesiones (id_sesion01,fecha,hora0);
	Sesiones sn3 = null;
	
	// ----------------------------------------------------------------------------------
	int id_sala=1;
	int id_sala1=2;
	String nombreSalas="main";
	int id_cine0=1;
	Salas sl = new Salas (id_sala,nombreSalas,id_cine0);
	Salas sl1 = new Salas (id_sala,nombreSalas,id_cine0);
	Salas sl2 = new Salas (id_sala1,nombreSalas,id_cine0);
	Salas sl3 = null;

	// ----------------------------------------------------------------------------------

	@Test
	void testHora() {
		hr.setHora(hora);
		hr.setMinuto(minuto);
		assertEquals(hr.getHora(), hora);
		assertEquals(hr.getMinuto(), minuto);
		assertEquals(hr.toString(), 10 + ":" + 20);
	}

	@Test
	void testCines() {
		cn.setId_cine(id_cine);
		cn.setNombreCine(nombreCine);
		cn.setNum_salas(num_salas);
		assertEquals(cn.getId_cine(), id_cine);
		assertEquals(cn.getNombreCine(), nombreCine);
		assertEquals(cn.getNum_salas(), num_salas);
		assertEquals(cn.toString(),
				"id_cine=" + id_cine + ", nombre del Cine=" + nombreCine + ", numero de salas=" + num_salas);
		assertEquals(cn.equals(cn1), cn1.equals(cn));
		assertEquals(cn.equals(cn3), cn3.equals(cn));
		assertFalse(cn.equals(cn2));
		assertTrue(cn.equals(cn));
		assertEquals(false, cn1.equals(cn2));

	}

	@Test
	void testCliente() {
		cliente.setApellido(apellido);
		cliente.setContraseña(contraseña);
		cliente.setDni(dni);
		cliente.setId_cliente(id_cliente);
		cliente.setNombre(nombre);
		cliente.setSexo(sexo);
		assertEquals(cliente.getApellido(), apellido);
		assertEquals(cliente.getContraseña(), contraseña);
		assertEquals(cliente.getDni(), dni);
		assertEquals(cliente.getId_cliente(), id_cliente);
		assertEquals(cliente.getNombre(), nombre);
		assertEquals(cliente.getSexo(), sexo);
		assertEquals(cliente.toString(), "id_cliente=" + id_cliente + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", sexo=" + sexo + ", contraseña=" + contraseña);
		assertEquals(cliente.equals(cliente2), cliente2.equals(cliente));
		assertEquals(cliente.equals(cliente3), cliente3.equals(cliente));
		assertFalse(cliente.equals(cliente4));
		assertTrue(cliente.equals(cliente));

	}

	@Test
	void testEntrada() {
		entradas.setId_entrada(id_entrada);
		entradas.setId_sesion(id_sesion);
		assertEquals(entradas.getId_entrada(), id_entrada);
		assertEquals(entradas.getId_sesion(), id_sesion);
		assertEquals(entradas.toString(), "id_entrada=" + id_entrada + ", id_sesion=" + id_sesion);
		assertEquals(entradas.equals(entradas1), entradas1.equals(entradas));
		assertEquals(entradas.equals(entradas2), entradas2.equals(entradas));
		assertFalse(entradas.equals(entradas3));
		assertTrue(entradas.equals(entradas));

	}

	@Test
	void testPeliculas() {
		peli.setDuracion(duracion);
		peli.setGenero(genero);
		peli.setId_pelicula(id_pelicula);
		peli.setNombrePelicula(nombrePelicula);
		peli.setPrecio(precio);
		assertEquals(peli.getDuracion(), duracion);
		assertEquals(peli.getGenero(), genero);
		assertEquals(peli.getNombrePelicula(), nombrePelicula);

		assertEquals(peli.getId_pelicula(),id_pelicula);
		assertEquals(peli.toString(),"id_pelicula=" + id_pelicula + ", nombre de la pelicula=" + nombrePelicula + ", precio=" + precio
				+ ", duracion=" + duracion + ", genero=" + genero);
		assertEquals(peli.equals(peli2), peli2.equals(peli));
		assertEquals(peli.equals(peli3), peli3.equals(peli));
		assertFalse(peli.equals(peli4));
		assertTrue(peli.equals(peli));

	}
	@Test
	void testSesiones() {
		sn.setFecha(fecha);
		sn.setHora(hora0);
		sn.setId_sesion(id_sesion0);
		
		assertEquals(sn.getFecha(), fecha);
		assertEquals(sn.getHora(), hora0);
		assertEquals(sn.getId_sesion(), id_sesion0);
		
		assertEquals(sn.toString(),"id_sesion=" + id_sesion0 + ", fecha= " + fecha + ", hora= " + hora0);
		assertEquals(sn.equals(sn1), sn1.equals(sn));
		assertEquals(sn.equals(sn2), sn2.equals(sn));
		assertFalse(sn.equals(sn3));
		assertTrue(sn.equals(sn));

	}
	@Test
	void testSalas() {
		sl.setId_cine(id_cine0);
		sl.setId_sala(id_sala);
		sl.setNombreSalas(nombreSalas);
		
		assertEquals(sl.getId_cine(), id_cine0);
		assertEquals(sl.getId_sala(), id_sala);
		assertEquals(sl.getNombreSalas(), nombreSalas);
		
		assertEquals(sl.toString(),"id_sala=" + id_sala + ", nombre de la Sala = " + nombreSalas);
		assertEquals(sl.equals(sl1), sl1.equals(sl));
		assertEquals(sl.equals(sl2), sl2.equals(sl));
		assertFalse(sl.equals(sl3));
		assertTrue(sl.equals(sl));
	}


}
