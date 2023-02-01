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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import modelo.DateLabelFormatter;

import javax.swing.SwingConstants;

public class vetnan extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBienvenida;
	private JPanel panelCines, panelBienvenida, panelPeliculas, panelSesion;
	private JLabel lblCines, lblsala, lblPrecio;
	private JLabel lblPelicula;
	private JComboBox<String> comboBox_1, comboBox_2, comboBox_3;
	JDatePickerImpl datePicker;
	private JButton btnAceptar2;
	private JLabel lblfechas;
	private JLabel lblhorario;
	private JButton btnAcepfecha;
	private JButton btnfinalizarCompra;
	private JButton btnAceptarhora;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vetnan frame = new vetnan();
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
	public vetnan() {
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
// ---------------Panel Bienvenida------------//
		panelBienvenida = new JPanel();
		panelBienvenida.setBounds(0, 0, 436, 263);
		contentPane.add(panelBienvenida);
		panelBienvenida.setLayout(null);
		panelBienvenida.setVisible(true);
		panelBienvenida.add(lblBienvenida);

		// ------------------------------------------------------------------------------

		// --------------------------------------------------------------------------------

		JLabel lblPeliculaselec = new JLabel("New label");
		lblPeliculaselec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPeliculaselec.setBounds(40, 11, 350, 25);
		UtilDateModel model = new UtilDateModel();
		// model.setDate(2022, 5, 6);
		Properties p = new Properties();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		contentPane.setLayout(null);

		datePicker.setBounds(10, 90, 202, 23);

		lblfechas = new JLabel("Fechas disponibles");
		lblfechas.setHorizontalAlignment(SwingConstants.CENTER);
		lblfechas.setBounds(10, 60, 180, 17);

		// ------------------------------------------------//
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(36, 108, 67, 22);

		lblPelicula = new JLabel("New label");
		lblPelicula.setBounds(45, 47, 346, 45);

		lblCines = new JLabel("Cines Disponibles");
		lblCines.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblCines.setBounds(36, 37, 336, 51);

		// -----------------Panel Cines-------------------//

		panelCines = new JPanel();
		panelCines.setBounds(0, 0, 436, 263);
		contentPane.add(panelCines);
		panelCines.setLayout(null);
		panelCines.setVisible(false);
		panelCines.add(lblCines);
		// ----------------------------------------//
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(32, 99, 113, 33);
		panelCines.add(comboBox);

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
//-------------------Conector------------------------------------------------------------------------/

		Connection conexion;
		try {

			conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3bd", "root", "");
			Statement sentencia = conexion.createStatement();
			String sql = "select * from cines";

			ResultSet resul = sentencia.executeQuery(sql);

			while (resul.next()) {
				comboBox.addItem(resul.getString("nombreCine"));
			}

			conexion.close();
		} catch (SQLException ex) {
			setTitle(ex.toString());
			ex.printStackTrace();
		}

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPeliculas.setVisible(true);
				panelCines.setVisible(false);
				lblPelicula.setText("Peliculas de " + comboBox.getSelectedItem());
				lblPelicula.setFont(new Font("Tahoma", Font.BOLD, 25));
				Connection conexion;
				try {

					conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3bd", "root", "");
					Statement sentencia = conexion.createStatement();
					
					int num = comboBox.getSelectedIndex() + 1;
					String sql = "select * from Cines join Salas on Cines.id_cine=Salas.id_cine "
							+ " join Sesiones on Sesiones.id_sesion=Salas.id_sala join Peliculas on  "
							+ " Peliculas.id_pelicula=Sesiones.id_pelicula where cines.id_cine = " + " '" + num + "'";

					ResultSet resul = sentencia.executeQuery(sql);
					while (resul.next()) {
						comboBox_1.addItem(resul.getString("nombrePelicula"));
					}

					conexion.close();
				} catch (SQLException ex) {
					setTitle(ex.toString());
					ex.printStackTrace();
				}
			}
		});
		btnAceptar.setBounds(249, 133, 89, 23);
		panelCines.add(btnAceptar);
		
		btnfinalizarCompra = new JButton("Finalizar Compra");
		btnfinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnfinalizarCompra.setBounds(30, 190, 150, 23);
		panelCines.add(btnfinalizarCompra);
		// ---------------------fin conector--------------------------------//
		// -------------------------------------------------------------------//

		panelPeliculas = new JPanel();
		panelPeliculas.setBounds(0, 0, 436, 263);
		contentPane.add(panelPeliculas);
		panelPeliculas.setLayout(null);
		panelPeliculas.add(comboBox_1);
		panelPeliculas.add(lblPelicula);
		panelPeliculas.setVisible(false);
		JButton btnatras = new JButton("Atras");
		btnatras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelPeliculas.setVisible(false);
				panelCines.setVisible(true);
				comboBox_1.removeAllItems();
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
		panelSesion.add(datePicker);

		// -----------------------------------------------------------//
		btnAceptar2 = new JButton("Aceptar");
		btnAceptar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSesion.setVisible(true);
				panelPeliculas.setVisible(false);
				Connection conexion;
				lblPeliculaselec.setText("Pelicula seleccionada " + comboBox_1.getSelectedItem());
				try {

					conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3bd", "root", "");
					Statement sentencia = conexion.createStatement();
					int num = comboBox.getSelectedIndex() + 1;
					String sql = "select * from " + " Cines join Salas on Cines.id_cine=Salas.id_cine join "
							+ " Sesiones on Sesiones.id_sesion=Salas.id_sala join "
							+ " Peliculas on Peliculas.id_pelicula=Sesiones.id_pelicula " + " where Cines.id_cine = "
							+ " '" + num + "' " + " and Peliculas.id_pelicula =" + " '" + num + "'";

					ResultSet resul = sentencia.executeQuery(sql);

					while (resul.next()) {

						comboBox_2.addItem(resul.getString("fecha"));
					}
					conexion.close();
				} catch (SQLException ex) {
					setTitle(ex.toString());
					ex.printStackTrace();
				}

			}
		});

		btnAcepfecha = new JButton("aceptar fecha");
		btnAcepfecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Date fecha = (Date) datePicker.getModel().getValue(); SimpleDateFormat
				 * formatoFecha = new SimpleDateFormat("yyyy-M-d");
				 * JOptionPane.showMessageDialog(null, "La fecha seleccionada es " +
				 * formatoFecha.format(fecha)); String sx = formatoFecha.format(fecha);
				 * System.out.println(sx);
				 */
				Connection conexion;
				try {

					conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3bd", "root", "");
					Statement sentencia = conexion.createStatement();
					int num = comboBox.getSelectedIndex() + 1;
					String sql = "select  hora, precio, genero, duracion, nombreSalas from Cines "
							+ "join Salas on Cines.id_cine=Salas.id_cine join "
							+ "Sesiones on Sesiones.id_sesion=Salas.id_sala join "
							+ "Peliculas on Peliculas.id_pelicula=Sesiones.id_pelicula " + "where Cines.id_cine = "
							+ " '" + num + "'" + " " + " and Peliculas.id_pelicula = " + " '" + num + "'"
							+ " and fecha = " + " '" + comboBox_2.getSelectedItem() + "'";

					ResultSet resul = sentencia.executeQuery(sql);

					while (resul.next()) {
						comboBox_3.addItem(resul.getString("hora"));
					}
					conexion.close();
				} catch (SQLException ex) {
					setTitle(ex.toString());
					ex.printStackTrace();
				}

			}
		});
		btnAceptar2.setBounds(66, 177, 89, 23);
		panelPeliculas.add(btnAceptar2);

		panelSesion.add(lblfechas);

		lblhorario = new JLabel("Horarios disponibles");
		lblhorario.setBounds(10, 130, 150, 15);
		panelSesion.add(lblhorario);

		btnAcepfecha.setBounds(220, 90, 180, 23);
		panelSesion.add(btnAcepfecha);

		comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(200, 60, 80, 22);
		panelSesion.add(comboBox_2);

		comboBox_3 = new JComboBox<String>();
		comboBox_3.setBounds(190, 130, 60, 22);
		panelSesion.add(comboBox_3);

		

		lblsala = new JLabel("New label");
		lblsala.setBounds(10, 160, 120, 14);
		panelSesion.add(lblsala);
		
		lblPrecio = new JLabel("New label");
		lblPrecio.setBounds(10, 190, 90, 14);
		panelSesion.add(lblPrecio);
		
		JButton btnfinalizar = new JButton("finalizar");
		btnfinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.removeAllItems();
				comboBox_2.removeAllItems();
				comboBox_3.removeAllItems();
				panelCines.setVisible(true);
				panelSesion.setVisible(false);
				JOptionPane.showMessageDialog(null, "ok");
				
			}
		});
		btnfinalizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnfinalizar.setBounds(270, 190, 100, 23);
		panelSesion.add(btnfinalizar);
		
		btnAceptarhora = new JButton("Aceptar Hora");
		btnAceptarhora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion;
				try {

					conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3bd", "root", "");
					Statement sentencia = conexion.createStatement();
					int num = comboBox.getSelectedIndex() + 1;
					String sql = "select * from Cines " + " join Salas on Cines.id_cine=Salas.id_cine join "
							+ " Sesiones on Sesiones.id_sesion=Salas.id_sala join "
							+ " Peliculas on Peliculas.id_pelicula=Sesiones.id_pelicula "
							+ " where Cines.id_cine = " + " '" + num + "'" + " " + " and Peliculas.id_pelicula = "
							+ " '" + num + "'" + " and fecha = " + " '" + comboBox_2.getSelectedItem() + "'";

					ResultSet resul = sentencia.executeQuery(sql);

					while (resul.next()) {
						lblsala.setText("En " + resul.getString("nombreSalas"));
						lblPrecio.setText("Precio " + resul.getFloat("precio")+"€");

					}
					conexion.close();
				} catch (SQLException ex) {
					setTitle(ex.toString());
					ex.printStackTrace();
				}

			}
		});
		btnAceptarhora.setBounds(260, 130, 150, 23);
		panelSesion.add(btnAceptarhora);
		
	}
}
