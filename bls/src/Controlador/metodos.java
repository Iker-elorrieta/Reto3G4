package Controlador;

import java.sql.*;
import modelo.Cine;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Pelicula;
import modelo.Sala;
import modelo.Sesion;

public class metodos {

	final String server = "jdbc:mysql://localhost/reto3bdbb";
	final String user = "root";
	final String pass = "";
	String guardarcine = "";
	int guardarIdCine = 0;

	public Cine[] arrayCines() {

		Cine[] cargaCines = new Cine[0];
		Connection conexion;
		try {
			conexion = DriverManager.getConnection(server, user, pass);
			Statement sacaCine = conexion.createStatement();
			String sql = "select * from cines";
			ResultSet resul = sacaCine.executeQuery(sql);
			while (resul.next()) {
				Cine cine = new Cine();
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

	public Sesion[] arraySesiones() {

		Sesion[] cargaSesiones = new Sesion[0];
		Connection conexion;
		try {
			conexion = DriverManager.getConnection(server, user, pass);
			Statement sentencia = conexion.createStatement();
			String sql = "select * from sesiones" + " order by fecha";

			ResultSet resul = sentencia.executeQuery(sql);
			while (resul.next()) {
				Sesion sesion = new Sesion();
				sesion.setId_sesion(resul.getInt("id_sesion"));
				Sesion[] sesionNueva = new Sesion[cargaSesiones.length + 1];
				sesion.setFecha(resul.getDate("fecha"));
				sesion.setHora(resul.getTime("hora"));
				for (int i = 0; i < cargaSesiones.length; i++) {
					sesionNueva[i] = cargaSesiones[i];
				}
				sesionNueva[cargaSesiones.length] = sesion;
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
			conexion = DriverManager.getConnection(server, user, pass);
			Statement sentencia = conexion.createStatement();
			String sql = "select * from cliente";
			ResultSet resul = sentencia.executeQuery(sql);
			while (resul.next()) {
				cliente = new Cliente();
				cliente.setApellido(resul.getString("Apellidos"));
				cliente.setContrasenya(resul.getString("contrasena"));
				cliente.setDni(resul.getString("dni"));
				cliente.setNombre(resul.getString("nombre"));
				cliente.setSexo(resul.getString("sexo"));
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

	Sala[] guardarCargaSalas;
	Sesion[] guardarCargaSesion;
	Pelicula[] guardarCargaPelicula;

	public Pelicula[] sacarPeliculaDelCine(String nombreCineSel, Cine[] cines) {
		cines = arrayCines();
		Sala[] cargaSalas = new Sala[0];
		Sesion[] cargaSesiones = new Sesion[0];
		Pelicula[] cargaPeliculas = new Pelicula[0];
		Connection conexion;

		for (int i = 0; i < cines.length; i++) {
			if (cines[i].getNombreCine().equals(nombreCineSel)) {
				guardarcine = nombreCineSel;
				try {
					conexion = DriverManager.getConnection(server, user, pass);
					Statement state = conexion.createStatement();
					guardarIdCine = cines[i].getId_cine();
					String sql = "select * from salas where salas.id_cine = " + "'" + cines[i].getId_cine() + "'";
					ResultSet resul = state.executeQuery(sql);
					while (resul.next()) {
						Sala sala = new Sala();
						sala.setId_sala(resul.getInt("id_sala"));
						sala.setNombreSalas(resul.getString("nombreSalas"));
						Sala[] salaNuevo = new Sala[cargaSalas.length + 1];
						for (int j = 0; j < cargaSalas.length; j++) {
							salaNuevo[j] = cargaSalas[j];
						}
						salaNuevo[cargaSalas.length] = sala;
						cargaSalas = salaNuevo;
						guardarCargaSalas = cargaSalas;
					}
					for (int k = 0; k < cargaSalas.length; k++) {
						Statement state1 = conexion.createStatement();
						String sql1 = "select * from sesiones where sesiones.id_sala = " + "'"
								+ cargaSalas[k].getId_sala() + "'";
						ResultSet resul1 = state1.executeQuery(sql1);
						while (resul1.next()) {
							Sesion sesion = new Sesion();
							sesion.setFecha(resul1.getDate("fe" + "cha"));
							sesion.setHora(resul1.getTime("hora"));
							sesion.setId_sesion(resul1.getInt("id_sesion"));
							Sesion[] sesionNueva = new Sesion[cargaSesiones.length + 1];
							for (int l = 0; l < cargaSesiones.length; l++) {
								sesionNueva[l] = cargaSesiones[l];
							}
							sesionNueva[cargaSesiones.length] = sesion;
							cargaSesiones = sesionNueva;
							guardarCargaSesion = cargaSesiones;
						}

					}
					for (int j = 0; j < cargaSesiones.length; j++) {
						Statement state2 = conexion.createStatement();
						String sql2 = "select * from sesiones,peliculas where sesiones.id_pelicula=peliculas.id_pelicula and sesiones.id_sesion = "
								+ "'" + cargaSesiones[j].getId_sesion() + "'";
						ResultSet resul2 = state2.executeQuery(sql2);
						while (resul2.next()) {
							Pelicula pelicula = new Pelicula();
							pelicula.setDuracion(resul2.getInt("duracion"));
							pelicula.setGenero(resul2.getString("genero"));
							pelicula.setId_pelicula(resul2.getInt("id_pelicula"));
							pelicula.setNombrePelicula(resul2.getString("nombrePelicula"));
							pelicula.setPrecio(resul2.getFloat("precio"));
							Pelicula[] peliNueva = new Pelicula[cargaPeliculas.length + 1];
							for (int m = 0; m < cargaPeliculas.length; m++) {
								peliNueva[m] = cargaPeliculas[m];
							}
							peliNueva[cargaPeliculas.length] = pelicula;
							cargaPeliculas = peliNueva;
							guardarCargaPelicula = cargaPeliculas;
						}
					}
				} catch (Exception ex) {
					System.out.println("sacarPeliculaDelCine");
				}
			}
		}
		return cargaPeliculas;

	}

	public String[] sacarFechaPelicula(Cine[] cines, String nomPeliculaSel, String nCineSel) {
		String fechas = "";
		cines = arrayCines();
		String[] fechasA = null;

		for (int i = 0; i < cines.length; i++) {
			if (cines[i].getNombreCine().equals(nCineSel)) {
				for (int j = 0; j < guardarCargaSalas.length; j++) {
					if (guardarCargaPelicula[j].getNombrePelicula().equals(nomPeliculaSel)) {
						for (int k = 0; k < guardarCargaSesion.length; k++) {
							if (guardarCargaPelicula[k].getNombrePelicula().equals(nomPeliculaSel)) {
								fechas = fechas + guardarCargaSesion[k].getFecha().toString() + "//";
								fechasA = fechas.split("//");
								System.out.println(fechasA);
							}

						}
					}
				}
			}
		}

		return fechasA;

	}
	
	public String[] sacarHora(String nCineSel, String nomPeliculaSel, String fecha) {
		
		Cine[]cines = arrayCines();
		String resultado="";
		String[] sesionesA = null;
		int k=0;
		

		for(int i = 0; i < cines.length; i++) {
			if(cines[i].getNombreCine().equals(nCineSel)) {
				for(int j = 0; j < guardarCargaPelicula.length; j++) {
					if(guardarCargaPelicula[j].getNombrePelicula().equals(nomPeliculaSel)) {
						while(k < guardarCargaSesion.length) {
							if(guardarCargaSesion[k].getFecha().toString().equals(fecha)) {
								int ID = guardarCargaSesion[k].getId_sesion();
								for(int y = 0; y < guardarCargaSalas.length; y++) {
									if(guardarCargaSalas[y].getId_sala()==ID) {
										resultado=resultado+guardarCargaSesion[k].getHora().toString()+" ";
										resultado=resultado+"en la: "+guardarCargaSalas[y].getNombreSalas()+" ";
										resultado=resultado+"Precio: "+guardarCargaPelicula[j].getPrecio()+"//";
									}
								}
								
							}
						k++;	
						}
						
					}
				}
			}
		}
		
		sesionesA=resultado.split("//");
		return sesionesA;
	}
}