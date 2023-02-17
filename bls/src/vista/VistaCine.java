package vista;
import java.awt.Color;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import Controlador.metodos;
import modelo.Cine;
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
	private JLabel lblCines;
	private JLabel lblPelicula;
	private JComboBox<String> comboBoxNombrePelicula, comboBoxAceptarFecha, comboBoxAceptarSesion, comboBoxNombreCine;
	String nCineSel ;
	private JButton btnAceptarPelicula;
	private JLabel lblfechas;
	private JLabel lblhorario;
	private JButton btnAceptarFecha, btnAceptarCine, btnfinalizarSesion, btnAtrasSesion;
	private JButton btnfinalizarCompra;
	private JPanel panelTablaConDatos, panelLog;
	private JScrollPane scrollPane;
	private JTable tableDatos;
	private JButton btnatrasborrar;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	

	int id_sala;
	String nombreSalas;
	Sala sala = new Sala();
	Sesion sesion = new Sesion();
	Pelicula pelicula = new Pelicula();
	Sala[] arraySalas = { sala };
	String[] guardarNombrePeliculas = new String[0];
	private Cine[] guardarCine = new Cine[1];
	Pelicula[] peliculas;

	
	String nPeliSel = "";
	
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

	
		JLabel lblPeliculaselec = new JLabel();
		lblPeliculaselec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPeliculaselec.setBounds(40, 11, 350, 25);

		lblfechas = new JLabel("Fechas disponibles");
		lblfechas.setHorizontalAlignment(SwingConstants.CENTER);
		lblfechas.setBounds(10, 60, 130, 17);

		comboBoxNombrePelicula = new JComboBox<String>();
		comboBoxNombrePelicula.setBounds(36, 108, 140, 22);

		lblPelicula = new JLabel("");
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
		guardarCine = metodos.arrayCines();
		for (int i = 0; i < guardarCine.length; i++) {
			comboBoxNombreCine.addItem(guardarCine[i].getNombreCine());
		}
		btnAceptarCine = new JButton("Aceptar");

		btnAceptarCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCines.setVisible(false);
				panelPeliculas.setVisible(true);
				nCineSel = String.valueOf(comboBoxNombreCine.getSelectedItem());
				lblPelicula.setText(nCineSel);
				 peliculas = new Pelicula[1];
				peliculas= metodos.sacarPeliculaDelCine(nCineSel, guardarCine);
					for(int i=0;i<peliculas.length;i++) {
						comboBoxNombrePelicula.addItem(peliculas[i].getNombrePelicula());
					}
				
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
				nPeliSel = String.valueOf(comboBoxNombrePelicula.getSelectedItem());
				lblPeliculaselec.setText(nPeliSel);
				String [] guardarSesion =metodos.sacarFechaPelicula(guardarCine, nPeliSel, nCineSel);
				for(int i=0;i<guardarSesion.length;i++) {
					comboBoxAceptarFecha.addItem(guardarSesion[i].toString());
				}
				

			}
		});
		btnAceptarFecha = new JButton("aceptar fecha");
		btnAceptarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnfinalizarSesion.setVisible(true);
				comboBoxAceptarSesion.removeAllItems();
				String fecha = comboBoxAceptarFecha.getSelectedItem().toString();
				String [] guardarHoras =metodos.sacarHora(nCineSel, nPeliSel, fecha);
				for(int i=0;i<guardarHoras.length;i++) {
					comboBoxAceptarSesion.addItem(guardarHoras[i].toString());
				}
				
			}
		});
		btnAceptarPelicula.setBounds(66, 177, 89, 23);
		panelPeliculas.add(btnAceptarPelicula);

		panelSesion.add(lblfechas);

		lblhorario = new JLabel("Horarios disponibles");
		lblhorario.setBounds(10, 100, 150, 15);
		panelSesion.add(lblhorario);

		btnAceptarFecha.setBounds(260, 60, 160, 23);
		panelSesion.add(btnAceptarFecha);

		comboBoxAceptarFecha = new JComboBox<String>();
		comboBoxAceptarFecha.setBounds(150, 60, 100, 22);
		panelSesion.add(comboBoxAceptarFecha);

		comboBoxAceptarSesion = new JComboBox<String>();
		comboBoxAceptarSesion.setBounds(170, 100, 270, 22);
		panelSesion.add(comboBoxAceptarSesion);

		btnfinalizarSesion = new JButton("finalizar");
		btnfinalizarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				comboBoxNombrePelicula.removeAllItems();
				comboBoxAceptarFecha.removeAllItems();
				comboBoxAceptarSesion.removeAllItems();
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "La pelicula ha sido guarda en pedidos correctamente.");
				panelCines.setVisible(true);
				panelSesion.setVisible(false);
				}
			
		});
		btnfinalizarSesion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnfinalizarSesion.setBounds(270, 190, 100, 23);
		panelSesion.add(btnfinalizarSesion);
		btnfinalizarSesion.setVisible(false);


		btnAtrasSesion = new JButton("Atras");
		btnAtrasSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSesion.setVisible(false);
				panelPeliculas.setVisible(true);
				comboBoxAceptarFecha.removeAllItems();
				comboBoxAceptarSesion.removeAllItems();
				btnfinalizarSesion.setVisible(false);

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
