package vista;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.metodos;
import modelo.Cine;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Pelicula;
import modelo.Sala;
import modelo.Sesion;

public class VistaCine extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBienvenida;
	private JPanel panelCines, panelBienvenida, panelPeliculas, panelSesion;
	private JLabel lblCines, lblsala, lblPrecio, lblduracion, lblGenero;
	private JLabel lblPelicula;
	private JComboBox<String> comboBoxNombrePelicula, comboBoxAceptarFecha, comboBoxAceptarHora, comboBoxNombreCine;

	private JButton btnAceptarPelicula;
	private JLabel lblfechas;
	private JLabel lblhorario;
	private JButton btnAceptarFecha, btnAceptarCine, btnfinalizarSesion, btnAtrasSesion;
	private JButton btnfinalizarCompra;
	private JButton btnAceptarhora;
	private JPanel panelTablaConDatos, panelLog;
	private JScrollPane scrollPane;
	private JTable tableDatos;
	private JButton btnatrasborrar;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	int id_cine;
	String nombreCine;
	int id_pelicula;
	String nombrePelicula;
	float precio;
	int duracion;
	String genero;



	String dni;
	String nombre;
	String apellido;
	char sexo;
	String contrasenya;
	Cliente cliente = new Cliente(dni, nombre, apellido, sexo, contrasenya);

	int id_sesion;
	Date fecha;
	Time hora;
	Sesion sesiones = null;
	Sesion[] arraySesiones = { sesiones };

	int id_entrada;
	float precioTotal;
	Entrada entradas = new Entrada(id_entrada, cliente, arraySesiones, precioTotal);

	int id_sala;
	String nombreSalas;
	Sala sala = new Sala(id_sala, nombreSalas, arraySesiones);
	Sala[] arraySalas = { sala };
	Cine cine = new Cine(id_cine, nombreCine, arraySalas);
	String[] guardarNombrePeliculas = new String[0];
	private Cine[] guardarCine = new Cine[1];
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCine frame = new VistaCine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaCine() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		lblBienvenida = new JLabel("Bienvenido");
		lblBienvenida.setForeground(Color.BLUE);
		lblBienvenida.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblBienvenida.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 29));
		lblBienvenida.setBounds(82, 43, 278, 45);

		panelBienvenida = new JPanel();
		panelBienvenida.setBounds(0, 0, 436, 263);
		contentPane.add(panelBienvenida);
		panelBienvenida.setLayout(null);
		panelBienvenida.setVisible(true);
		panelBienvenida.add(lblBienvenida);

	
		JLabel lblPeliculaselec = new JLabel("New label");
		lblPeliculaselec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPeliculaselec.setBounds(40, 11, 350, 25);

		lblfechas = new JLabel("Fechas disponibles");
		lblfechas.setHorizontalAlignment(SwingConstants.CENTER);
		lblfechas.setBounds(10, 60, 130, 17);

		comboBoxNombrePelicula = new JComboBox<String>();
		comboBoxNombrePelicula.setBounds(36, 108, 140, 22);

		lblPelicula = new JLabel("New label");
		lblPelicula.setBounds(45, 47, 346, 45);

		lblCines = new JLabel("Cines Disponibles");
		lblCines.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblCines.setBounds(36, 37, 336, 51);
		panelCines = new JPanel();
		panelCines.setBounds(0, 0, 436, 263);
		contentPane.add(panelCines);
		panelCines.setLayout(null);
		panelCines.setVisible(false);
		panelCines.add(lblCines);
		comboBoxNombreCine = new JComboBox<String>();
		comboBoxNombreCine.setBounds(32, 99, 113, 33);
		panelCines.add(comboBoxNombreCine);

		panelBienvenida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				panelBienvenida.setVisible(false);
				panelCines.setVisible(true);

			}
		});
		metodos metodos = new metodos();
		guardarCine = metodos.arrayCines(cine);
		for (int i = 0; i < guardarCine.length; i++) {
			comboBoxNombreCine.addItem(guardarCine[i].getNombreCine());
		}
		btnAceptarCine = new JButton("Aceptar");

		btnAceptarCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCines.setVisible(false);
				panelPeliculas.setVisible(true);
				String nCineSel = String.valueOf(comboBoxNombreCine.getSelectedItem());
			
				Pelicula[] dsna = new Pelicula[1];
				dsna= metodos.sacarPeliculaDelCine(nCineSel, guardarCine);
					;
					lblPelicula.setText("" + comboBoxNombreCine.getSelectedItem());
				
			}
		});
		btnAceptarCine.setBounds(249, 133, 89, 23);
		panelCines.add(btnAceptarCine);

		btnfinalizarCompra = new JButton("Finalizar Compra");
		btnfinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel tablaPane = new JPanel();
				tablaPane.setBounds(10, 10, 100, 100);
				tablaPane.setLayout(null);
				contentPane.add(scrollPane);

				tableDatos = new JTable();
				model = new DefaultTableModel();
				tableDatos.setModel(model);

				model.addColumn("Cine");
				model.addColumn("Pelicula");
				model.addColumn("Fecha");
				model.addColumn("Hora");
				model.addColumn("Sala");
				model.addColumn("Duración");
				model.addColumn("Genero");
				model.addColumn("Precio");

				tableDatos.getColumnModel().getColumn(5).setPreferredWidth(350);
				scrollPane.setViewportView(tableDatos);
				tablaPane.add(scrollPane);

			}
		});
		btnfinalizarCompra.setBounds(30, 190, 150, 23);
		panelCines.add(btnfinalizarCompra);

		JButton btnLog = new JButton("Logearse");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCines.setVisible(false);
				panelLog.setVisible(true);

			}
		});
		btnLog.setBounds(300, 190, 89, 23);
		panelCines.add(btnLog);
		
		panelPeliculas = new JPanel();
		panelPeliculas.setBounds(0, 0, 436, 263);
		contentPane.add(panelPeliculas);
		panelPeliculas.setLayout(null);
		panelPeliculas.add(comboBoxNombrePelicula);
		panelPeliculas.add(lblPelicula);
		panelPeliculas.setVisible(false);
		JButton btnatras = new JButton("Atras");
		btnatras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelPeliculas.setVisible(false);
				panelCines.setVisible(true);
				comboBoxNombrePelicula.removeAllItems();
			}

		});
		btnatras.setBounds(271, 171, 89, 23);
		panelPeliculas.add(btnatras);

		panelSesion = new JPanel();
		panelSesion.setBounds(0, 0, 436, 263);
		contentPane.add(panelSesion);
		panelSesion.setVisible(false);
		panelSesion.setLayout(null);
		panelSesion.add(lblPeliculaselec);

		// -----------------------------------------------------------//
		btnAceptarPelicula = new JButton("Aceptar");
		btnAceptarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSesion.setVisible(true);
				panelPeliculas.setVisible(false);

			}
		});
		btnAceptarFecha = new JButton("aceptar fecha");
		btnAceptarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAceptarPelicula.setBounds(66, 177, 89, 23);
		panelPeliculas.add(btnAceptarPelicula);

		panelSesion.add(lblfechas);

		lblhorario = new JLabel("Horarios disponibles");
		lblhorario.setBounds(10, 100, 150, 15);
		panelSesion.add(lblhorario);

		lblduracion = new JLabel("");
		lblduracion.setBounds(10, 180, 150, 15);
		panelSesion.add(lblduracion);

		lblGenero = new JLabel("");
		lblGenero.setBounds(10, 200, 150, 15);
		panelSesion.add(lblGenero);

		btnAceptarFecha.setBounds(240, 60, 160, 23);
		panelSesion.add(btnAceptarFecha);

		comboBoxAceptarFecha = new JComboBox<String>();
		comboBoxAceptarFecha.setBounds(150, 60, 190, 22);
		panelSesion.add(comboBoxAceptarFecha);

		comboBoxAceptarHora = new JComboBox<String>();
		comboBoxAceptarHora.setBounds(170, 100, 60, 22);
		panelSesion.add(comboBoxAceptarHora);

		lblsala = new JLabel("");
		lblsala.setBounds(10, 130, 120, 14);
		panelSesion.add(lblsala);

		lblPrecio = new JLabel("");
		lblPrecio.setBounds(10, 160, 90, 14);
		panelSesion.add(lblPrecio);

		btnfinalizarSesion = new JButton("finalizar");
		btnfinalizarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxNombrePelicula.removeAllItems();
				comboBoxAceptarFecha.removeAllItems();
				comboBoxAceptarHora.removeAllItems();
				panelCines.setVisible(true);
				panelSesion.setVisible(false);
			}
		});
		btnfinalizarSesion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnfinalizarSesion.setBounds(270, 190, 100, 23);
		panelSesion.add(btnfinalizarSesion);

		btnAceptarhora = new JButton("Aceptar Hora");
		btnAceptarhora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion;
				try {

					conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3bd", "root", "");
					Statement sentencia = conexion.createStatement();
					int num = comboBoxNombreCine.getSelectedIndex() + 1;
					String sql = "select * from Cines " + " join Salas on Cines.id_cine=Salas.id_cine join "
							+ " Sesiones on Sesiones.id_sesion=Salas.id_sala join "
							+ " Peliculas on Peliculas.id_pelicula=Sesiones.id_pelicula " + " where Cines.id_cine = "
							+ " '" + num + "'" + " " + " and Peliculas.id_pelicula = " + " '" + num + "'"
							+ " and fecha = " + " '" + comboBoxAceptarFecha.getSelectedItem() + "'";

					ResultSet resul = sentencia.executeQuery(sql);

					while (resul.next()) {
						lblsala.setText("En " + resul.getString("nombreSalas"));
						lblPrecio.setText("Precio: " + resul.getFloat("precio") + "€");
						lblduracion.setText("Duración: " + resul.getInt("duracion") + " minutos");
						lblduracion.setText("Genero: " + resul.getString("genero"));

						precio = resul.getFloat("precio");

						duracion = resul.getInt("duracion");
						genero = resul.getString("genero");

						comboBoxAceptarFecha.getSelectedItem();

						nombreCine = ((String) comboBoxNombreCine.getSelectedItem());
					}
					comboBoxAceptarHora.getSelectedItem();
					conexion.close();
				} catch (SQLException ex) {
					setTitle(ex.toString());
					ex.printStackTrace();
				}

			}
		});
		btnAceptarhora.setBounds(260, 100, 150, 23);
		panelSesion.add(btnAceptarhora);

		btnAtrasSesion = new JButton("Atras");
		btnAtrasSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSesion.setVisible(false);
				panelPeliculas.setVisible(true);
				comboBoxAceptarFecha.removeAllItems();
				lblsala.setText("");
				lblPrecio.setText("");

			}
		});
		btnAtrasSesion.setBounds(80, 190, 89, 23);
		panelSesion.add(btnAtrasSesion);

		panelTablaConDatos = new JPanel();
		panelTablaConDatos.setBounds(0, 0, 436, 263);
		contentPane.add(panelTablaConDatos);
		panelTablaConDatos.setLayout(null);

		btnatrasborrar = new JButton("New button");
		btnatrasborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnatrasborrar.setBounds(0, 0, 89, 23);
		panelTablaConDatos.add(btnatrasborrar);

		panelLog = new JPanel();
		panelLog.setBounds(0, 0, 436, 263);
		contentPane.add(panelLog);
		panelLog.setLayout(null);
		panelTablaConDatos.setVisible(false);
	
	}

}
