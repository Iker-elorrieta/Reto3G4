package metodos;

import java.sql.*;
import modelo.Cine;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Pelicula;
import modelo.Sala;
import modelo.Sesion;

public class metodosObjetos {
	int id_pelicula;
	String nombrePelicula;
	float precio;
	int duracion;
	String genero;

	Pelicula peliculas = new Pelicula(id_pelicula, nombrePelicula, precio, duracion, genero);

	String dni;
	String nombre;
	String apellido;
	char sexo;
	String contrasenya;
	Cliente cliente = new Cliente(dni, nombre, apellido, sexo, contrasenya);

	int id_sesion;
	int id_sesion0;
	Date fecha;
	Sesion sesiones = new Sesion(id_sesion, fecha, peliculas);
	Sesion[] arraySesiones = { sesiones };

	int id_entrada;
	float precioTotal;
	Entrada entradas = new Entrada(id_entrada, cliente, arraySesiones, precioTotal);

	int id_sala;
	String nombreSalas;
	Sala sala = new Sala(id_sala, nombreSalas, arraySesiones);
	Sala[] arraySalas = { sala };

	int id_cine;
	String nombreCine;

	public Cine[] arrayCines(Cine cine) {

		Cine[] cargaCines = new Cine[0];
		Connection conexion;

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3bd", "root", "");
			Statement sentencia = conexion.createStatement();
			String sql = "select * from cines";
			ResultSet resul = sentencia.executeQuery(sql);
			while (resul.next()) {
				cine = new Cine(id_cine, nombreCine, arraySalas);
				cine.setId_cine(resul.getInt("id_cine"));
				cine.setNombreCine(resul.getString("nombreCine"));

				Cine[] cineNuevo = new Cine[cargaCines.length + 1];
				for (int i = 0; i < cargaCines.length; i++) {
					cineNuevo[i] = cargaCines[i];
				}
				cineNuevo[cargaCines.length] = cine;
				cargaCines = cineNuevo;

			}

		} catch (Exception e) {
			System.out.println("error");
		}
		return cargaCines;
	}

	public Sala[] arraySalas(Sala sala) {

		Sala[] cargaSalas = new Sala[0];
		Connection conexion;

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3bd", "root", "");
			Statement sentencia = conexion.createStatement();
			String sql = "select * from salas";
			ResultSet resul = sentencia.executeQuery(sql);
			while (resul.next()) {
				sala = new Sala(id_sala, nombreSalas, arraySesiones);
				sala.setId_sala(resul.getInt("id_sala"));
				sala.setNombreSalas(resul.getString("nombreSalas"));

				Sala[] salaNuevo = new Sala[cargaSalas.length + 1];
				for (int i = 0; i < cargaSalas.length; i++) {
					salaNuevo[i] = cargaSalas[i];
				}
				salaNuevo[cargaSalas.length] = sala;
				cargaSalas = salaNuevo;

			}

		} catch (Exception e) {
			System.out.println("error");
		}
		return cargaSalas;
	}

	public Pelicula[] arrayPeliculas(Pelicula peliculas) {

		Pelicula[] cargaPeliculas = new Pelicula[0];
		Connection conexion;

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3bd", "root", "");
			Statement sentencia = conexion.createStatement();
			String sql = "select * from peliculas";
			ResultSet resul = sentencia.executeQuery(sql);
			while (resul.next()) {
				peliculas = new Pelicula(id_pelicula, nombrePelicula, precio, duracion, genero);
				peliculas.setNombrePelicula(resul.getString("nombrePelicula"));
				peliculas.setDuracion(resul.getInt("duracion"));
				peliculas.setGenero(resul.getString("genero"));
				peliculas.setId_pelicula(resul.getInt("id_pelicula"));
				
				Pelicula[] peliculaNueva = new Pelicula[cargaPeliculas.length + 1];
				for (int i = 0; i < cargaPeliculas.length; i++) {
					peliculaNueva[i] = cargaPeliculas[i];
				}
				peliculaNueva[cargaPeliculas.length] = peliculas;
				cargaPeliculas = peliculaNueva;
			}

		} catch (Exception e) {
			System.out.println("error");
		}
		return cargaPeliculas;
	}

	public Sesion[] arraySesiones(Sesion sesiones) {

		Sesion[] cargaSesiones = new Sesion[0];
		Connection conexion;

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3bd", "root", "");
			Statement sentencia = conexion.createStatement();
			String sql = "select * from Sesiones";
			ResultSet resul = sentencia.executeQuery(sql);
			while (resul.next()) {
				sesiones = new Sesion(id_sesion, fecha, peliculas);

				sesiones.setId_sesion(resul.getInt("id_sesion"));
				Sesion[] sesionNueva = new Sesion[cargaSesiones.length + 1];
				for (int i = 0; i < cargaSesiones.length; i++) {
					sesionNueva[i] = cargaSesiones[i];
				}
				sesionNueva[cargaSesiones.length] = sesiones;
				cargaSesiones = sesionNueva;
			}

		} catch (Exception e) {
			System.out.println("error");
		}
		return cargaSesiones;
	}
	public Cliente[] arrayClientes(Cliente cliente) {

		Cliente[] cargaClientes = new Cliente[0];
		Connection conexion;

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3bd", "root", "");
			Statement sentencia = conexion.createStatement();
			String sql = "select * from clientes";
			ResultSet resul = sentencia.executeQuery(sql);
			while (resul.next()) {
				cliente = new Cliente(dni, nombre, apellido, sexo, contrasenya);
				cliente.setApellido(resul.getString("apellido"));
				cliente.setContrasenya(resul.getString("contraseña"));
				cliente.setDni(resul.getString("dni"));
				cliente.setNombre(resul.getString("nombre"));
				//cliente.setSexo(resul.getShort("sexo"));
				Cliente[] clienteNueva = new Cliente[cargaClientes.length + 1];
				for (int i = 0; i < cargaClientes.length; i++) {
					clienteNueva[i] = cargaClientes[i];
				}
				clienteNueva[cargaClientes.length] = cliente;
				cargaClientes = clienteNueva;
			}
			
		} catch (Exception e) {
			System.out.println("error");
		}
		return cargaClientes;
	}

}
