package modelo;

import java.sql.Date;

public class Sesiones {
	private int id_sesion;
	private Date fecha;
	private Hora hora;
	public Sesiones (int id_sesion,Date fecha,Hora hora) {
		this.id_sesion = id_sesion;
		this.fecha = fecha;
		this.hora = hora;
	}

	public int getId_sesion() {
		return id_sesion;
	}

	public void setId_sesion(int id_sesion) {
		this.id_sesion = id_sesion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "id_sesion=" + id_sesion + ", fecha= " + fecha + ", hora= " + hora ;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sesiones other = (Sesiones) obj;
		return id_sesion == other.id_sesion;
	}

}
