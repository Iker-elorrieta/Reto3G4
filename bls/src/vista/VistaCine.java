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
import javax.swing.table.DefaultTableModel;

import Controlador.metodos;
import modelo.Cine;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Sala;
import modelo.Sesion;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VistaCine extends JFrame {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelRegistro;
	private JLabel lblBienvenida;
	private JPanel panelCines, panelBienvenida, panelPeliculas, panelSesion;
	private JLabel lblCines;
	private JLabel lblPelicula, lblInicio, lblUser, lblPass;
	JScrollPane scrollPane;
	private JComboBox<String> comboBoxNombrePelicula, comboBoxAceptarFecha, comboBoxAceptarSesion, comboBoxNombreCine,
			comboBoxSexo;
	String nCineSel;
	private JButton btnAceptarPelicula;
	private JLabel lblfechas;
	private JLabel lblhorario, lblPT, lblRegistro1;
	private JButton btnAceptarCine, btnfinalizarSesion, btnAtrasSesion, btnARegistro;
	private JButton btnfinalizarCompra, btnComprar;
	private JPanel panelFinalizarSesion, panelLog;

	private JButton btnatrasborrar;

	/**
	 * Launch the application.
	 */

	Sesion sesion = new Sesion();
	String[] fechas;
	String[] nombrePeliculas;
	metodos metodos = new metodos();
	String nPeliSel = "";
	private JTable table;
	String precio = "";
// ---------------
	Entrada entradaA = new Entrada();
	Cine[] cargado = metodos.cargarDatos();
	Cliente[] gClientes;
	Sesion sesionHecha;
	String[] nombreCines;
	String[] sesionHoraDeFechaPelicula;
	String[] salaDeFechaPelicula;
	String gHora = "";
	Sala[] guardarSalaFechaPelicula;
	String gSala = "";
	Sesion[] guardarSesionFechaPelicula;
	Entrada[] gEntrada = new Entrada[0];
	String fecha;
	String salaSel = "";
	String fechaSel = "";
	String horaSel = "";
	String[][] tablaArray;
	char[] contra;
	String pass = "";
	String dni="";
	String horaSel2="";
	float descuento = 0;
	private JTextField textUser;
	private JPasswordField passwordField;
	private JButton btnInicioRealizado;
	private JButton btnRegistro;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDNI;
	private JLabel lblContra;
	private JLabel lblSexo;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JPasswordField passwordField_1;
	private JButton btnReset;
	private JLabel lblTabla;
	private JPanel panelCompra;
	private JLabel lblCompraRealizada;
	private JButton btnVolver2;
	private JLabel lblImprimir;
	private JButton btnImprimir;
	private JLabel lblError;
	private JLabel lblvacio;
	private JLabel lblErrorDNI;
	private JLabel lblYaRegistrado;
	private JButton btnAtras3;
	private JLabel lblNewLabel;

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
		comboBoxNombrePelicula.setBounds(36, 108, 200, 22);

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
// ------------------muestra los cines-------------//
		nombreCines = metodos.mostrarCines(cargado);

		for (int i = 0; i < nombreCines.length; i++) {
			comboBoxNombreCine.addItem(nombreCines[i]);
		}
// -------------------------------------------------//
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
				nombrePeliculas = metodos.sacarPeliculasOrdenadasPorfecha(cargado, nCineSel);
				for (int i = 0; i < nombrePeliculas.length; i++) {
					comboBoxNombrePelicula.addItem(nombrePeliculas[i]);
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
				btnComprar.setVisible(true);
				float precioTotal = 0;
				int i = 0;
				if (tablaArray != null) {
					while (i < tablaArray.length) {
						precioTotal = precioTotal + Float.parseFloat(tablaArray[i][3]);
						i++;
					}
				}
				table = new JTable();

				table.setModel(new DefaultTableModel(tablaArray,
						new String[] { "Cine", "sala", "Pelicula", "precio", "fecha", "hora" }));

				table.setBounds(0, 0, 1, 1);
				scrollPane.setViewportView(table);
				descuento = metodos.hacerDescuento(gEntrada, precioTotal);
				panelFinalizarSesion.remove(lblPT);
				lblPT = new JLabel();
				lblPT.setText("Precio total: " + precioTotal + "€");
				lblNewLabel.setVisible(true);
				lblNewLabel.setText("Con descuento " + descuento);
				lblPT.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblPT.setBounds(36, 200, 336, 51);
				panelFinalizarSesion.add(lblPT);
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
				fechas = metodos.sacarFechaPelicula(cargado, nPeliSel, nCineSel);
				for (int i = 0; i < fechas.length; i++) {
					comboBoxAceptarFecha.addItem(fechas[i]);
				}

				HashSet<String> set = new HashSet<String>();
				for (int i = 0; i < comboBoxAceptarFecha.getItemCount(); i++) {
					set.add(comboBoxAceptarFecha.getItemAt(i).toString());
				}
				comboBoxAceptarFecha.removeAllItems();
				for (String item : set) {
					comboBoxAceptarFecha.addItem(item);
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

				if (comboBoxAceptarFecha.getSelectedItem() != null) {
					gHora = "";
					gSala = "";

					btnfinalizarSesion.setVisible(true);
					comboBoxAceptarSesion.removeAllItems();
					fecha = comboBoxAceptarFecha.getSelectedItem().toString();
					guardarSesionFechaPelicula = metodos.sesionesDeUnaFechaPelicula(nCineSel, nPeliSel, fecha, cargado);
					guardarSalaFechaPelicula = metodos.salaDeUnaFechaPelicula(nCineSel, nPeliSel, fecha, cargado);

					float precio = metodos.precioDeUnaPelicula(nPeliSel, cargado);
					for (int i = 0; i < guardarSesionFechaPelicula.length; i++) {
						gHora = gHora + guardarSesionFechaPelicula[i].getHora().toString() + ",";

					}
					for (int j = 0; j < guardarSalaFechaPelicula.length; j++) {
						gSala = gSala + guardarSalaFechaPelicula[j].getNombreSalas() + ",";
					}

					salaDeFechaPelicula = gSala.split(",");
					sesionHoraDeFechaPelicula = gHora.split(",");
					for (int i = 0; i < sesionHoraDeFechaPelicula.length; i++) {

						String hora = sesionHoraDeFechaPelicula[i].substring(0,
								sesionHoraDeFechaPelicula[i].length() - 3);
						for (int j = 0; j < salaDeFechaPelicula.length; j++) {
							comboBoxAceptarSesion.addItem(hora + "-" + salaDeFechaPelicula[j] + "-" + precio);
						}
					}

					HashSet<String> set = new HashSet<String>();
					for (int i = 0; i < comboBoxAceptarSesion.getItemCount(); i++) {
						set.add(comboBoxAceptarSesion.getItemAt(i).toString());
					}
					comboBoxAceptarSesion.removeAllItems();
					for (String item : set) {
						comboBoxAceptarSesion.addItem(item);
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

				lblTabla.setVisible(false);
				horaSel = comboBoxAceptarSesion.getSelectedItem().toString().substring(0, 5) + ":00";
				String[] rSala = comboBoxAceptarSesion.getSelectedItem().toString().split("-");
				salaSel = rSala[1];
				sesionHecha = metodos.sesionRealizada(cargado, nCineSel, salaSel, nPeliSel, fecha, horaSel);
				Entrada[] newEntrada = new Entrada[gEntrada.length + 1];
				for (int i = 0; i < gEntrada.length; i++) {
					newEntrada[i] = gEntrada[i];
				}
				newEntrada[gEntrada.length] = metodos.añadirEntradas(sesionHecha, entradaA);
				gEntrada = newEntrada;
				horaSel2=comboBoxAceptarSesion.getSelectedItem().toString().substring(0, 5);
				precio = String.valueOf(gEntrada[0].getEntradaSesion().getPelicula().getPrecio());
				tablaArray = metodos.tablaResumen(precio,
						gEntrada[0].getEntradaSesion().getPelicula().getNombrePelicula(), fecha,
						comboBoxAceptarSesion.getSelectedItem().toString().substring(0, 5), salaSel, nCineSel);

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

		lblPT = new JLabel();

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

		lblInicio = new JLabel("Iniciar Sesion");
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInicio.setBounds(20, 20, 140, 30);
		panelLog.add(lblInicio);

		lblUser = new JLabel("Usuario(DNI):");
		lblUser.setBounds(20, 90, 120, 14);
		panelLog.add(lblUser);

		lblPass = new JLabel("Contraseña");
		lblPass.setBounds(20, 140, 120, 14);
		panelLog.add(lblPass);

		textUser = new JTextField();
		textUser.setBounds(170, 90, 140, 20);
		panelLog.add(textUser);
		textUser.setColumns(10);
		textUser.setVisible(false);

		passwordField = new JPasswordField();
		passwordField.setBounds(170, 140, 140, 20);
		passwordField.setVisible(false);
		panelLog.add(passwordField);

		btnInicioRealizado = new JButton("Aceptar");
		btnInicioRealizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gClientes = metodos.arrayClientes();
				contra = passwordField.getPassword();
				pass = String.valueOf(contra);
				for (int i = 0; i < gClientes.length; i++) {
					if (textUser.getText().equals(gClientes[i].getDni())
							&& pass.equals(gClientes[i].getContrasenya())) {
						dni=textUser.getText();
						panelLog.setVisible(false);
						panelCompra.setVisible(true);
						btnImprimir.setVisible(true);
						btnVolver2.setVisible(true);
						// metodos.añadirEntradaBD(gEntrada, dni, precio);
					} else {
						lblError.setVisible(true);
						textUser.setText("");
						passwordField.setText("");
					}
				}
			}
		});
		btnInicioRealizado.setBounds(290, 190, 120, 23);
		btnInicioRealizado.setVisible(false);

		panelLog.add(btnInicioRealizado);

		btnRegistro = new JButton("Registrarse");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLog.setVisible(false);
				panelRegistro.setVisible(true);
				textField1.setVisible(true);
				textField2.setVisible(true);
				textField3.setVisible(true);
				comboBoxSexo.setVisible(true);
				passwordField_1.setVisible(true);
				btnARegistro.setVisible(true);
				lblRegistro1.setVisible(true);
				lblNombre.setVisible(true);
				lblApellido.setVisible(true);
				lblDNI.setVisible(true);
				lblSexo.setVisible(true);
				lblContra.setVisible(true);
			}
		});
		btnRegistro.setBounds(40, 190, 130, 23);
		btnRegistro.setVisible(false);
		panelLog.add(btnRegistro);

		btnReset = new JButton("Volver");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VistaCine frame = new VistaCine();
				frame.setVisible(true);
			}
		});
		btnReset.setBounds(290, 20, 120, 23);
		btnReset.setVisible(false);
		panelLog.add(btnReset);

		lblError = new JLabel("Usuario o contraseña incorrecto");
		lblError.setForeground(Color.RED);
		lblError.setBounds(20, 160, 200, 14);
		lblError.setVisible(false);
		panelLog.add(lblError);
		panelFinalizarSesion.setVisible(false);

		table = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 50, 400, 130);
		scrollPane.setViewportView(table);
		panelFinalizarSesion.add(scrollPane);

		btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tablaArray != null) {
					panelFinalizarSesion.setVisible(false);
					panelLog.setVisible(true);
					btnInicioRealizado.setVisible(true);
					btnRegistro.setVisible(true);
					btnReset.setVisible(true);
					textUser.setVisible(true);
					passwordField.setVisible(true);
				} else {
					lblTabla.setVisible(true);
				}

			}
		});
		btnComprar.setBounds(300, 20, 89, 23);
		btnComprar.setVisible(false);
		panelFinalizarSesion.add(btnComprar);

		lblTabla = new JLabel("Realiza una sesión por lo menos");
		lblTabla.setBounds(29, 190, 290, 14);
		lblTabla.setVisible(false);
		panelFinalizarSesion.add(lblTabla);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(210, 210, 150, 14);
		lblNewLabel.setVisible(false);
		panelFinalizarSesion.add(lblNewLabel);

		panelRegistro = new JPanel();
		panelRegistro.setBounds(0, 0, 436, 263);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);
		panelRegistro.setVisible(false);

		lblRegistro1 = new JLabel("Registrarse");
		lblRegistro1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRegistro1.setBounds(20, 20, 140, 30);
		panelRegistro.add(lblRegistro1);
		lblRegistro1.setVisible(false);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 70, 90, 14);
		panelRegistro.add(lblNombre);
		lblNombre.setVisible(false);

		lblApellido = new JLabel("Apellidos:");
		lblApellido.setBounds(20, 110, 90, 14);
		lblApellido.setVisible(false);
		panelRegistro.add(lblApellido);

		lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(20, 150, 90, 14);
		lblDNI.setVisible(false);
		panelRegistro.add(lblDNI);

		lblContra = new JLabel("Contraseña:");
		lblContra.setBounds(20, 190, 90, 14);
		lblContra.setVisible(false);
		panelRegistro.add(lblContra);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(230, 150, 90, 14);
		lblSexo.setVisible(false);
		panelRegistro.add(lblSexo);

		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setBounds(270, 150, 60, 22);
		comboBoxSexo.addItem("M");
		comboBoxSexo.addItem("F");

		comboBoxSexo.setVisible(false);
		panelRegistro.add(comboBoxSexo);

		textField1 = new JTextField();
		textField1.setBounds(130, 70, 100, 20);
		panelRegistro.add(textField1);
		textField1.setColumns(10);
		textField1.setVisible(false);

		textField2 = new JTextField();
		textField2.setBounds(130, 110, 96, 20);
		panelRegistro.add(textField2);
		textField2.setColumns(10);
		textField2.setVisible(false);

		textField3 = new JTextField();
		textField3.setBounds(130, 150, 96, 20);
		panelRegistro.add(textField3);
		textField3.setColumns(10);
		textField3.setVisible(false);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(130, 190, 90, 20);
		passwordField_1.setVisible(false);
		panelRegistro.add(passwordField_1);

		btnARegistro = new JButton("Aceptar");
		btnARegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean validarDNI = metodos.validarDNI(textField3.getText());
				boolean DNIexiste = metodos.usuarioRegistrado(textField3.getText());
				textField1.getText();
				contra = passwordField_1.getPassword();
				pass = String.valueOf(contra);
				if (textField1.getText().equals("") || textField2.getText().equals("")
						|| textField3.getText().equals("") || pass.equals("")) {
					lblvacio.setVisible(true);
				} else if (DNIexiste) {
					lblYaRegistrado.setVisible(true);
				} else if (validarDNI && textField1.getText().length() > 1 && textField2.getText().length() > 1
						&& pass.length() > 1) {
					panelRegistro.setVisible(false);
					panelLog.setVisible(true);
					metodos.añadirCliente(textField1.getText(), textField2.getText(),
							textField3.getText().toUpperCase(), pass, comboBoxSexo.getSelectedItem().toString());
				} else {
					lblErrorDNI.setVisible(true);
					lblvacio.setVisible(false);
				}

			}
		});
		btnARegistro.setBounds(290, 190, 89, 23);
		btnARegistro.setVisible(false);
		panelRegistro.add(btnARegistro);

		lblvacio = new JLabel("Rellena todos los campos");
		lblvacio.setBounds(30, 220, 180, 14);
		lblvacio.setVisible(false);
		panelRegistro.add(lblvacio);

		lblErrorDNI = new JLabel("DNI incorrecto");
		lblErrorDNI.setForeground(Color.RED);
		lblErrorDNI.setBounds(20, 170, 90, 14);
		lblErrorDNI.setVisible(false);
		panelRegistro.add(lblErrorDNI);

		lblYaRegistrado = new JLabel("El dni ya existe, inicia sesion ");
		lblYaRegistrado.setBounds(240, 30, 190, 14);
		lblYaRegistrado.setVisible(false);
		panelRegistro.add(lblYaRegistrado);

		btnAtras3 = new JButton("Atras");
		btnAtras3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistro.setVisible(false);
				panelLog.setVisible(true);
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				passwordField_1.setText("");

			}
		});
		btnAtras3.setBounds(310, 50, 89, 23);
		panelRegistro.add(btnAtras3);

		panelCompra = new JPanel();
		panelCompra.setBounds(0, 0, 436, 263);
		contentPane.add(panelCompra);
		panelCompra.setLayout(null);
		panelCompra.setVisible(false);

		lblCompraRealizada = new JLabel("New label");
		lblCompraRealizada.setBounds(10, 15, 304, 52);
		panelCompra.add(lblCompraRealizada);

		btnVolver2 = new JButton("Volver");
		btnVolver2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VistaCine frame = new VistaCine();
				frame.setVisible(true);
			}
		});
		btnVolver2.setBounds(30, 190, 89, 23);
		btnVolver2.setVisible(false);
		panelCompra.add(btnVolver2);

		lblImprimir = new JLabel("Pulsa Imprimir para guarda la factura ");
		lblImprimir.setBounds(30, 90, 300, 14);
		panelCompra.add(lblImprimir);

		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	

				metodos.AnadirFactura(gEntrada, salaSel, fecha, horaSel2, nCineSel, descuento, dni);
			}
		});
		btnImprimir.setBounds(250, 120, 99, 23);
		btnImprimir.setVisible(false);
		panelCompra.add(btnImprimir);
	}
}