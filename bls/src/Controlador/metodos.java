package Controlador;

import java.sql.*;
import modelo.Cine;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Pelicula;
import modelo.Sala;
import modelo.Sesion;

public class metodos {

	final String server = "jdbc:mysql://localhost/reto3bd";
	final String user = "root";
	final String pass = "";
	String guardarcine = "";
	int guardarIdCine = 0;
	String [][] carrito;
	int cont=0;
	// -----------finals de bd--------------//
	final String cines = "cines";
	final String id_cine = "id_cine";
	final String nombreCine = "nombreCine";
	final String cliente = "cliente";
	final String Apellidos = "Apellidos";
	final String contrasena = "contrasena";
	final String dni = "dni";
	final String nombre = "nombre";
	final String sexo = "sexo";
	final String id_sala = "id_sala";
	final String nombreSalas = "nombreSalas";
	final String sesiones = "sesiones";
	final String fecha = "fecha";
	final String hora = "hora";
	final String id_sesion = "id_sesion";
	final String salas = "salas";
	final String peliculas = "peliculas";
	final String duracion = "duracion";
	final String genero = "genero";
	final String id_pelicula = "id_pelicula";
	final String nombrePelicula = "nombrePelicula";
	final String precio = "precio";
	// ---------------------------------------------//

	public Pelicula[] sacarPeliculasC(Cine[] arrayCines, String nCineSel) {

		Pelicula[] arrayPeliculas = new Pelicula[0];
		for (int i = 0; i < arrayCines.length; i++) {
			if (arrayCines[i].getNombreCine().equals(nCineSel)) {
				for (int j = 0; j < arrayCines[i].getId_sala().length; j++) {
					for (int k = 0; k < arrayCines[i].getId_sala()[j].getArraySesiones().length; k++) {
						Pelicula[] peliNueva = new Pelicula[arrayPeliculas.length + 1];
						for (int l = 0; l < arrayPeliculas.length; l++) {
							peliNueva[l] = arrayPeliculas[l];
						}
						peliNueva[arrayPeliculas.length] = arrayCines[i].getId_sala()[j].getArraySesiones()[k]
								.getPelicula();
						arrayPeliculas = peliNueva;
					}
				}
			}

		}
		return arrayPeliculas;
	}

	public Cine[] cargarDatos() {

		Cine[] arrayCine = new Cine[0];
		Cine cine;
		Sala sala;
		Sesion sesion;
		Pelicula pelicula;
		Connection conexion;
//		boolean repetido = false;
		try {

			conexion = DriverManager.getConnection(server, user, pass);
			Statement sacaCine = conexion.createStatement();
			String sql = "select * from " + cines;
			ResultSet cargaCines = sacaCine.executeQuery(sql);

			while (cargaCines.next()) {

				cine = new Cine();
				cine.setNombreCine(cargaCines.getString(nombreCine));
				cine.setId_cine(cargaCines.getInt(id_cine));

				Statement sacaCineu = conexion.createStatement();
				String sql1 = "select * from " + salas + " where " + id_cine + " = " + "'" + cine.getId_cine() + "'";
				ResultSet cargaSala = sacaCineu.executeQuery(sql1);

				Sala[] arraySalas = new Sala[0];
				while (cargaSala.next()) {
					sala = new Sala();
					sala.setId_sala(cargaSala.getInt(id_sala));
					sala.setNombreSalas(cargaSala.getString(nombreSalas));

					Statement sacaSalau = conexion.createStatement();
					String sql2 = "select * from " + sesiones + " where sesiones.id_sala= " + "'" + sala.getId_sala()
							+ "'";
					ResultSet cargaSesiones = sacaSalau.executeQuery(sql2);
					Sesion[] arraySesion = new Sesion[0];

					while (cargaSesiones.next()) {
						sesion = new Sesion();
						sesion.setFecha(cargaSesiones.getDate(fecha));
						sesion.setHora(cargaSesiones.getTime(hora));
						sesion.setId_sesion(cargaSesiones.getInt(id_sesion));

						Statement sacaSesionu = conexion.createStatement();
						String sql3 = "select * from " + peliculas + "," + sesiones
								+ " where sesiones.id_pelicula=peliculas.id_pelicula and sesiones.id_sesion = " + "'"
								+ sesion.getId_sesion() + "'";
						ResultSet cargaPeliculas = sacaSesionu.executeQuery(sql3);
						Pelicula[] arrayPeliculas = new Pelicula[0];
						while (cargaPeliculas.next()) {
							pelicula = new Pelicula();
							pelicula.setDuracion(cargaPeliculas.getInt(duracion));
							pelicula.setGenero(cargaPeliculas.getString(genero));
							pelicula.setId_pelicula(cargaPeliculas.getInt(id_pelicula));
							pelicula.setNombrePelicula(cargaPeliculas.getString(nombrePelicula));
							pelicula.setPrecio(cargaPeliculas.getFloat(precio));

				/*			for (int m = 0; m < arrayPeliculas.length; m++) {
								if (arrayPeliculas[m].getId_pelicula() == pelicula.getId_pelicula()) {
			
									repetido = true;
									break;
								}
							}*/
						//	if (!repetido) {
								Pelicula[] peliNueva = new Pelicula[arrayPeliculas.length + 1];
								peliNueva[arrayPeliculas.length] = pelicula;
								arrayPeliculas = peliNueva;
								sesion.setPelicula(pelicula);

					//		}
						}

						Sesion[] sesionNueva = new Sesion[arraySesion.length + 1];
						for (int l = 0; l < arraySesion.length; l++) {
							sesionNueva[l] = arraySesion[l];
						}
						sesionNueva[arraySesion.length] = sesion;
						arraySesion = sesionNueva;
						sala.setArraySesiones(arraySesion);

					}

					Sala[] salaNuevo = new Sala[arraySalas.length + 1];
					for (int j = 0; j < arraySalas.length; j++) {
						salaNuevo[j] = arraySalas[j];
					}
					salaNuevo[arraySalas.length] = sala;
					arraySalas = salaNuevo;
					cine.setId_sala(arraySalas);

				}
				Cine[] cineNuevo = new Cine[arrayCine.length + 1];
				for (int i = 0; i < arrayCine.length; i++) {
					cineNuevo[i] = arrayCine[i];
				}
				cineNuevo[arrayCine.length] = cine;
				arrayCine = cineNuevo;
			}

		} catch (Exception e) {
			System.out.println("lol");
		}
		return arrayCine;
	}

	public Cliente[] arrayClientes() {

		Cliente[] cargaClientes = new Cliente[0];
		Connection conexion;

		try {
			conexion = DriverManager.getConnection(server, user, pass);
			Statement sentencia = conexion.createStatement();
			String sql = "select * from " + "" +cliente;
			ResultSet resul = sentencia.executeQuery(sql);
			while (resul.next()) {
				Cliente clientes = new Cliente();
				clientes.setApellido(resul.getString(Apellidos));
				clientes.setContrasenya(resul.getString(contrasena));
				clientes.setDni(resul.getString(dni));
				clientes.setNombre(resul.getString(nombre));
				clientes.setSexo(resul.getString(sexo));
				Cliente[] clienteNueva = new Cliente[cargaClientes.length + 1];
				for (int i = 0; i < cargaClientes.length; i++) {
					clienteNueva[i] = cargaClientes[i];
				}
				clienteNueva[cargaClientes.length] = clientes;
				cargaClientes = clienteNueva;
			}

		} catch (Exception e) {
			System.out.println("error");
		}
		return cargaClientes;
	}

	public String[] sacarFechaPelicula(Cine[] arrayCines, String nomPeliculaSel, String nCineSel) {
		String fechas = "";
		String[] fechasA = null;
		for (int i = 0; i < arrayCines.length; i++) {
			if (arrayCines[i].getNombreCine().equals(nCineSel)) {
				for (int j = 0; j < arrayCines[i].getId_sala().length; j++) {
					for (int k = 0; k < arrayCines[i].getId_sala()[j].getArraySesiones().length; k++) {
						if (arrayCines[i].getId_sala()[j].getArraySesiones()[k].getPelicula().getNombrePelicula()
								.equals(nomPeliculaSel)) {
							fechas = fechas + arrayCines[i].getId_sala()[j].getArraySesiones()[k].getFecha() + "//";
							fechasA = fechas.split("//");
						}
					}
				}
			}
		}
		return fechasA;
	}

	public String[] sacarDatosF(String nCineSel, String fecha, Cine[] arrayCines) {
		String resultado = "";
		String[] sesionesA = null;
		for (int i = 0; i < arrayCines.length; i++) {
			if (arrayCines[i].getNombreCine().equals(nCineSel)) {
				for (int j = 0; j < arrayCines[i].getId_sala().length; j++) {
					for (int k = 0; k < arrayCines[i].getId_sala()[j].getArraySesiones().length; k++) {
						if (arrayCines[i].getId_sala()[j].getArraySesiones()[k].getFecha().toString().equals(fecha)) {
							resultado = resultado + arrayCines[i].getId_sala()[j].getArraySesiones()[k].getHora() + " ";
							resultado = resultado + "en la: " + arrayCines[i].getId_sala()[j].getNombreSalas() + " ";
							resultado = resultado + "Precio: "
									+ arrayCines[i].getId_sala()[j].getArraySesiones()[k].getPelicula().getPrecio()
									+ "//";
						}
					}
				}
			}
		}
		sesionesA = resultado.split("//");
		
		return sesionesA;
	}

/*	public static boolean validarDNI(String dni) {
		boolean valido = false;
		final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

		if (dni.length() == 9) {
			int numeroDNI = Integer.parseInt(dni.substring(0, 8));
			char letraDNI = dni.charAt(8);
			int resto = numeroDNI % 23;
			char letraCorrecta = letras.charAt(resto);

			if (letraDNI == letraCorrecta) {
				valido = true;
			}
		}
		return valido;
	}
*/
	
public String [][] compra(String precio, String pelicula, String fecha, String hora, String sala) {
		
		String [][] carritoNew=new String [cont+1][5];
		
		int i=0;
		
		while(i<cont) {
			carritoNew[i][0]=carrito[i][0];
			carritoNew[i][1]=carrito[i][1];
			carritoNew[i][2]=carrito[i][2];
			carritoNew[i][3]=carrito[i][3];
			carritoNew[i][4]=carrito[i][4];
			i++;
		}
		carritoNew[i][0]=precio;
		carritoNew[i][1]=pelicula;
		carritoNew[i][2]=fecha;
		carritoNew[i][3]=hora;
		carritoNew[i][4]=sala;
		
		
		
		carrito=carritoNew;
		
		cont++;
		
		return carritoNew;
	}
}