package modelo;

import java.util.Objects;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellido;
	private String sexo;
	private String contrasenya;

	public Cliente( String dni, String nombre, String apellido, String sexo, String contrasenya) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.contrasenya = contrasenya;
	}



	public Cliente() {
		// TODO Auto-generated constructor stub
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}





	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", contrasenya=" + contrasenya + "]";
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