package vista;

import java.awt.Color;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controlador.metodos;
import modelo.Cine;
import modelo.Pelicula;
import modelo.Sala;
import modelo.Sesion;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
	JScrollPane scrollPane;
	private JComboBox<String> comboBoxNombrePelicula, comboBoxAceptarFecha, comboBoxAceptarSesion, comboBoxNombreCine;
	String nCineSel;
	private JButton btnAceptarPelicula;
	private JLabel lblfechas;
	private JLabel lblhorario;
	private JButton btnAceptarCine, btnfinalizarSesion, btnAtrasSesion;
	private JButton btnfinalizarCompra;
	private JPanel panelFinalizarSesion, panelLog;

	private JButton btnatrasborrar;

	/**
	 * Launch the application.
	 */

	int id_sala;
	String nombreSalas;
	Sala sala = new Sala();
	Sesion sesion = new Sesion();
	Pelicula pelicula = new Pelicula();
	Sala[] arraySalas = { sala };
	String[] fechas;
	String[] guardarNombrePeliculas = new String[0];
	Pelicula[] peliculas;
	Cine[] cargaDatos;
	metodos metodos = new metodos();
	String[] nombresC;
	String nPeliSel = "";
	String[][]tablaArray;
	JTable table;

	
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
		Cine[] cargado = metodos.cargarDatos();

		

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
		for (int i = 0; i < cargado.length; i++) {
			comboBoxNombreCine.addItem(cargado[i].getNombreCine());
		}

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

		btnAceptarCine = new JButton("Aceptar");

		btnAceptarCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCines.setVisible(false);
				panelPeliculas.setVisible(true);
				nCineSel = String.valueOf(comboBoxNombreCine.getSelectedItem());
				lblPelicula.setText(nCineSel);
				peliculas = metodos.sacarPeliculasC(cargado, nCineSel);
				for (int i = 0; i < peliculas.length; i++) {
					comboBoxNombrePelicula.addItem(peliculas[i].getNombrePelicula());
				}
				
				HashSet<String> set = new HashSet<String>();
				for (int i = 0; i < comboBoxNombrePelicula.getItemCount(); i++) {
				set.add(comboBoxNombrePelicula.getItemAt(i).toString());
				}
				comboBoxNombrePelicula.removeAllItems();
				for (String item : set) {
				comboBoxNombrePelicula.addItem(item);
				}
			}
		});
		btnAceptarCine.setBounds(249, 133, 89, 23);
		panelCines.add(btnAceptarCine);

		btnfinalizarCompra = new JButton("Finalizar Compra");
		btnfinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFinalizarSesion.setVisible(true);
				panelCines.setVisible(false);
				
				table = new JTable();
				
					table.setModel(new DefaultTableModel(
							tablaArray,
							new String[] { "Precio", "Pelicula", "Fecha", "Hora", "Sala" }));
				
				table.setBounds(0, 0, 1, 1);
				scrollPane.setViewportView(table);
			
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
		btnLog.setBounds(300, 20, 89, 23);

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
				fechas = metodos.sacarFechaPelicula(cargado,nPeliSel, nCineSel);
				for (int i = 0; i < fechas.length; i++) {
					comboBoxAceptarFecha.addItem(fechas[i]);
				}

			}
		});
		btnAceptarPelicula.setBounds(66, 177, 89, 23);
		panelPeliculas.add(btnAceptarPelicula);

		panelSesion.add(lblfechas);

		lblhorario = new JLabel("Horarios disponibles");
		lblhorario.setBounds(10, 100, 150, 15);
		panelSesion.add(lblhorario);

		comboBoxAceptarFecha = new JComboBox<String>();
		comboBoxAceptarFecha.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBoxAceptarFecha.getSelectedItem() != null) {
					btnfinalizarSesion.setVisible(true);
					comboBoxAceptarSesion.removeAllItems();
					String fecha = comboBoxAceptarFecha.getSelectedItem().toString();
					String[] guardarHoras = metodos.sacarDatosF(nCineSel, fecha, cargado);
					for (int i = 0; i < guardarHoras.length; i++) {
						comboBoxAceptarSesion.addItem(guardarHoras[i].toString());
				}
				}
			}
		});
		comboBoxAceptarFecha.setBounds(150, 60, 100, 22);
		panelSesion.add(comboBoxAceptarFecha);

		comboBoxAceptarSesion = new JComboBox<String>();
		comboBoxAceptarSesion.setBounds(170, 100, 270, 22);
		panelSesion.add(comboBoxAceptarSesion);

		btnfinalizarSesion = new JButton("finalizar");
		btnfinalizarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[]split=comboBoxAceptarSesion.getSelectedItem().toString().split(" ");
				String precio=split[6];
				String pelicula=comboBoxNombrePelicula.getSelectedItem().toString();
				String fecha=comboBoxAceptarFecha.getSelectedItem().toString();
				String hora=split[0];
				String sala=split[3]+" "+split[4];
				tablaArray = metodos.compra(precio,pelicula,fecha,hora,sala);
				
				comboBoxNombrePelicula.removeAllItems();
				comboBoxAceptarFecha.removeAllItems();
				comboBoxAceptarSesion.removeAllItems();
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "La pelicula ha sido guarda en entradas correctamente.");
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

		panelFinalizarSesion = new JPanel();
		panelFinalizarSesion.setBounds(0, 0, 436, 263);
		contentPane.add(panelFinalizarSesion);
		panelFinalizarSesion.setLayout(null);

		btnatrasborrar = new JButton("Atras");
		btnatrasborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCines.setVisible(true);
				panelFinalizarSesion.setVisible(false);
			}
		});
		btnatrasborrar.setBounds(20, 20, 89, 23);
		panelFinalizarSesion.add(btnatrasborrar);

		panelLog = new JPanel();
		panelLog.setBounds(0, 0, 436, 263);
		contentPane.add(panelLog);
		panelLog.setLayout(null);
		panelFinalizarSesion.setVisible(false);
		panelFinalizarSesion.add(btnLog);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 50, 300, 130);
		panelFinalizarSesion.add(scrollPane);

	
	

	}
}
