package Controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import java.util.Date;

import modelo.Cine;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Pelicula;
import modelo.Sala;
import modelo.Sesion;

public class metodos {
	final String server = "jdbc:mysql://localhost/reto35";
	final String user = "root";
	final String pass = "";
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
	final String sesiones_id_sala = "sesiones.id_sala";
	final String sesiones_id_pelicula = "sesiones.id_pelicula";
	final String peliculas_id_pelicula = "peliculas.id_pelicula";
	final String sesiones_id_sesion = "sesiones.id_sesion";
	final String entrada = "entrada";
	final String id_entrada = "id_entrada";
	final String id_pedido = "id_pedido";
	final String pedido = "pedido";
	final String precioTotal = "precioTotal";
// ---------------------------------------------//
	String[][] carrito = null;
	int cont = 0;

	public String[] mostrarCines(Cine[] arrayCines) {
		String[] nCines = null;
		String gCines = "";
		for (int i = 0; i < arrayCines.length; i++) {
			gCines = gCines + arrayCines[i].getNombreCine() + ",";
		}
		nCines = gCines.split(",");
		return nCines;
	}

	public String[] sacarPeliculasOrdenadasPorfecha(Cine[] arrayCines, String nCineSel) {
		String[] nPeliculas = null;
		Map<String, Date> peliculasFechas = new HashMap<>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < arrayCines.length; i++) {
			if (arrayCines[i].getNombreCine().equals(nCineSel)) {
				for (int j = 0; j < arrayCines[i].getId_sala().length; j++) {
					for (int k = 0; k < arrayCines[i].getId_sala()[j].getArraySesiones().length; k++) {
						String nombrePelicula = arrayCines[i].getId_sala()[j].getArraySesiones()[k].getPelicula()
								.getNombrePelicula();
						Date fechaSesion;
						try {
							fechaSesion = dateFormat
									.parse(arrayCines[i].getId_sala()[j].getArraySesiones()[k].getFecha().toString());
							peliculasFechas.put(nombrePelicula, fechaSesion);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		nPeliculas = peliculasFechas.keySet().toArray(new String[peliculasFechas.size()]);
		Arrays.sort(nPeliculas, new Comparator<String>() {
			@Override
			public int compare(String p1, String p2) {
				return peliculasFechas.get(p1).compareTo(peliculasFechas.get(p2));
			}
		});
		return nPeliculas;
	}

	public Cine[] cargarDatos() {

		Cine[] arrayCine = new Cine[0];
		Cine cine;
		Sala sala;
		Sesion sesion;
		Pelicula pelicula;
		Connection conexion;
// boolean repetido = false;
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

					String sql2 = "select * from " + sesiones + " where " + sesiones_id_sala + "=" + "'"
							+ sala.getId_sala() + "'";
					ResultSet cargaSesiones = sacaSalau.executeQuery(sql2);
					Sesion[] arraySesion = new Sesion[0];

					while (cargaSesiones.next()) {
						sesion = new Sesion();
						sesion.setFecha(cargaSesiones.getDate(fecha));
						sesion.setHora(cargaSesiones.getTime(hora));
						sesion.setId_sesion(cargaSesiones.getInt(id_sesion));

						Statement sacaSesionu = conexion.createStatement();

						String sql3 = "select * from " + peliculas + "," + sesiones + " where " + sesiones_id_pelicula
								+ " = " + peliculas_id_pelicula + " and " + sesiones_id_sesion + " = " + "'"
								+ sesion.getId_sesion() + "'" + " order by " + fecha;
						ResultSet cargaPeliculas = sacaSesionu.executeQuery(sql3);
						Pelicula[] arrayPeliculas = new Pelicula[0];
						while (cargaPeliculas.next()) {
							pelicula = new Pelicula();
							pelicula.setDuracion(cargaPeliculas.getInt(duracion));
							pelicula.setGenero(cargaPeliculas.getString(genero));
							pelicula.setId_pelicula(cargaPeliculas.getInt(id_pelicula));
							pelicula.setNombrePelicula(cargaPeliculas.getString(nombrePelicula));
							pelicula.setPrecio(cargaPeliculas.getFloat(precio));

							/*
							 * for (int m = 0; m < arrayPeliculas.length; m++) { if
							 * (arrayPeliculas[m].getId_pelicula() == pelicula.getId_pelicula()) {
							 *
							 * repetido = true; break; } }
							 */
							// if (!repetido) {
							Pelicula[] peliNueva = new Pelicula[arrayPeliculas.length + 1];
							peliNueva[arrayPeliculas.length] = pelicula;
							arrayPeliculas = peliNueva;
							sesion.setPelicula(pelicula);

							// }
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
			String sql = "select * from " + "" + cliente;
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

	public Sesion[] sesionesDeUnaFechaPelicula(String nCineSel, String nPeliSel, String fecha, Cine[] arrayCines) {

		Sesion[] gSesion = new Sesion[0];
		for (int i = 0; i < arrayCines.length; i++) {
			if (nCineSel.equals(arrayCines[i].getNombreCine())) {
				for (int j = 0; j < arrayCines[i].getId_sala().length; j++) {
					for (int k = 0; k < arrayCines[i].getId_sala()[j].getArraySesiones().length; k++) {
						if (arrayCines[i].getId_sala()[j].getArraySesiones()[k].getPelicula().getNombrePelicula()
								.equals(nPeliSel)
								&& arrayCines[i].getId_sala()[j].getArraySesiones()[k].getFecha().toString()
										.equals(fecha)) {
							Sesion[] arraySesion = new Sesion[gSesion.length + 1];
							for (int p = 0; p < gSesion.length; p++) {
								arraySesion[p] = gSesion[p];
							}
							arraySesion[gSesion.length] = arrayCines[i].getId_sala()[j].getArraySesiones()[k];
							gSesion = arraySesion;
						}
					}
				}
			}

		}

		return gSesion;
	}

	public Sala[] salaDeUnaFechaPelicula(String nCineSel, String nPeliSel, String fecha, Cine[] arrayCines) {
		Sala[] gSala = new Sala[0];
		for (int i = 0; i < arrayCines.length; i++) {
			if (nCineSel.equals(arrayCines[i].getNombreCine())) {
				for (int j = 0; j < arrayCines[i].getId_sala().length; j++) {
					for (int k = 0; k < arrayCines[i].getId_sala()[j].getArraySesiones().length; k++) {
						if (arrayCines[i].getId_sala()[j].getArraySesiones()[k].getPelicula().getNombrePelicula()
								.equals(nPeliSel)
								&& arrayCines[i].getId_sala()[j].getArraySesiones()[k].getFecha().toString()
										.equals(fecha)) {
							Sala[] arraySala = new Sala[gSala.length + 1];
							for (int p = 0; p < gSala.length; p++) {
								arraySala[p] = gSala[p];
							}
							arraySala[gSala.length] = arrayCines[i].getId_sala()[j];
							gSala = arraySala;
						}
					}
				}
			}

		}
		return gSala;
	}

	public float precioDeUnaPelicula(String nPeliSel, Cine[] arrayCines) {
		float precio = 0;
		for (int i = 0; i < arrayCines.length; i++) {
			for (int j = 0; j < arrayCines[i].getId_sala().length; j++) {
				for (int k = 0; k < arrayCines[i].getId_sala()[j].getArraySesiones().length; k++) {
					if (arrayCines[i].getId_sala()[j].getArraySesiones()[k].getPelicula().getNombrePelicula()
							.equals(nPeliSel)) {
						precio = arrayCines[i].getId_sala()[j].getArraySesiones()[k].getPelicula().getPrecio();
					}
				}
			}
		}
		return precio;
	}

	public String[][] tablaResumen(String precio, String pelicula, String fecha, String hora, String sala,
			String cine) {

		String[][] carritoNew = new String[cont + 1][6];

		int i = 0;

		while (i < cont) {
			carritoNew[i][0] = carrito[i][0];
			carritoNew[i][1] = carrito[i][1];
			carritoNew[i][2] = carrito[i][2];
			carritoNew[i][3] = carrito[i][3];
			carritoNew[i][4] = carrito[i][4];
			carritoNew[i][5] = carrito[i][5];
			i++;
		}
		carritoNew[i][0] = cine;
		carritoNew[i][1] = sala;
		carritoNew[i][2] = pelicula;
		carritoNew[i][3] = precio;
		carritoNew[i][4] = fecha;
		carritoNew[i][5] = hora;

		carrito = carritoNew;

		cont++;

		return carritoNew;
	}

	public Sesion sesionRealizada(Cine[] datos, String nCineSel, String nSala, String nPeliSel, String fechaSel,
			String horaSel) {

		Sesion sesionHecha = new Sesion();
		Sesion[] gSesion = new Sesion[0];
		for (int i = 0; i < datos.length; i++) {
			if (nCineSel.equals(datos[i].getNombreCine())) {
				for (int j = 0; j < datos[i].getId_sala().length; j++) {
					for (int k = 0; k < datos[i].getId_sala()[j].getArraySesiones().length; k++) {
						if (datos[i].getId_sala()[j].getArraySesiones()[k].getPelicula().getNombrePelicula()
								.equals(nPeliSel)) {
							Sesion[] arraySesion = new Sesion[gSesion.length + 1];
							for (int p = 0; p < gSesion.length; p++) {
								arraySesion[p] = gSesion[p];
							}
							arraySesion[gSesion.length] = datos[i].getId_sala()[j].getArraySesiones()[k];
							gSesion = arraySesion;
						}
					}
				}
			}

		}
		Sesion[] gSesion2 = new Sesion[0];
		for (int i = 0; i < gSesion.length; i++) {
			if (gSesion[i].getFecha().toString().equals(fechaSel)) {
				Sesion[] arraySesion = new Sesion[gSesion2.length + 1];
				for (int p = 0; p < gSesion2.length; p++) {
					arraySesion[p] = gSesion2[p];
				}
				arraySesion[gSesion2.length] = gSesion[i];
				gSesion2 = arraySesion;
			}
		}
		for (int i = 0; i < gSesion2.length; i++) {
			if (gSesion2[i].getHora().toString().equals(horaSel)) {
				sesionHecha = gSesion2[i];
			}
		}
		return sesionHecha;
	}

	public Entrada añadirEntradas(Sesion sesionHecha, Entrada entrada) {

		entrada.setEntradaSesion(sesionHecha);
		return entrada;
	}

	public boolean validarDNI(String dni) {
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

	public boolean usuarioRegistrado(String dni) {
		Cliente[] usuarios = arrayClientes();
		boolean exist = false;
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i].getDni().equals(dni)) {
				exist = true;
			}
		}
		return exist;
	}

	public void añadirCliente(String nombre, String apellido, String dni, String contra, String sexo) {
		// TODO Auto-generated method stub
		try {
			Connection conexion;
			conexion = DriverManager.getConnection(server, user, pass);
			Statement st = conexion.createStatement();
			st.executeUpdate("INSERT INTO " + cliente + "(" + this.dni + "," + this.nombre + "," + this.Apellidos + ","
					+ this.sexo + "," + this.contrasena + ")" + " VALUES (" + "'" + dni + "', '" + nombre + "', '"
					+ apellido + "','" + sexo + "','" + contra + "')");

		} catch (Exception e) {
			System.out.println("error");
			System.err.println(e.getMessage());
		}
	}

	/*public void añadirPedidoBD(Entrada[] array, String dni3, float precioTotal1) {

		try {
			Connection conexion;
			conexion = DriverManager.getConnection(server, user, pass);
			Statement st = conexion.createStatement();
			for (int i = 0; i < array.length; i++) {
				st.executeUpdate("INSERT INTO " + pedido + "(" + null + "," + dni + "," + precioTotal + ")"
						+ " VALUES (" + "'" + null + "', '" + dni3 + "', '" + precioTotal1 + "')");
				st.executeUpdate("INSERT INTO " + entrada + "(" + null + "," + dni + "," + precioTotal + ")"
						+ " VALUES (" + "'" + null + "', '" + dni3 + "', '" + precioTotal1 + "')");

			}
		} catch (Exception e) {
			System.out.println("error");
			System.err.println(e.getMessage());
		}
	}*/

	public float hacerDescuento(Entrada[] gEntrada, float precioTotal) {
		int cont = 0;
		for (int i = 0; i < gEntrada.length; i++) {
			cont++;
		}
		float precioTotalConDescuento;
		if (cont == 2) {
			precioTotalConDescuento = precioTotal * 0.8f;
		} else if (cont == 1) {
			precioTotalConDescuento = precioTotal * 1;
		} else if (cont == 3) {
			precioTotalConDescuento = precioTotal * 0.7f;
		} else if (cont == 4) {
			precioTotalConDescuento = precioTotal * 0.6f;
		} else { // cantidad >= 5
			precioTotalConDescuento = precioTotal * 0.5f;
		}

		return precioTotalConDescuento;
	}

	public void AnadirFactura(Entrada[] entrada, String sala, String fecha, String hora, String cineSel,
			float precioTotal, String dni) {
		File file = new File("factura.txt");
		BufferedWriter fichero;
		String nomPeli = "";
		try {
			file.delete();
			fichero = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < entrada.length; i++) {
				nomPeli = entrada[i].getEntradaSesion().getPelicula().getNombrePelicula();
			}

			fichero.write("Datos Ticket :> Cine: " + cineSel + ", Sala :" + sala + " pelicula: " + nomPeli + " ,DNI : "
					+ dni + ", " + " ,fecha: " + fecha + " ,hora:" + hora + ",precio total = " + precioTotal + "\n");

			fichero.close();
			JOptionPane.showMessageDialog(null, "La factura ha sido guardada correctamente");

		} catch (

		IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
