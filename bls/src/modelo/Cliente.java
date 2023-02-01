package modelo;

import java.util.Objects;

public class Cliente {
	private int id_cliente;
	private String dni;
	private String nombre;
	private String apellido;
	private char sexo;
	private String contraseña;

	public Cliente(int id_cliente, String dni, String nombre, String apellido, char sexo, String contraseña) {
		this.id_cliente = id_cliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.contraseña = contraseña;

	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "id_cliente=" + id_cliente + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo="
				+ sexo + ", contraseña=" + contraseña ;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}
	

}
