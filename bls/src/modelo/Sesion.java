package modelo;

import java.util.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Sesion {
	private int id_sesion;
	private Date fecha;
	private Time hora;
	private Pelicula pelicula;

	public Sesion(int id_sesion, Date fecha, Time hora, Pelicula pelicula) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		formatoFecha.format(cal.getTime());
		fecha = cal.getTime();
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat formatoFecha1 = new SimpleDateFormat("hh:mm");
		formatoFecha1.format(cal1.getTime());
		java.util.Date date = cal1.getTime();
		hora = new java.sql.Time(date.getTime());
		this.id_sesion = id_sesion;
		this.fecha = fecha;
		this.pelicula = pelicula;
		this.hora = hora;
	};

	public Sesion() {
		// TODO Auto-generated constructor stub
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sesion other = (Sesion) obj;
		return id_sesion == other.id_sesion;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Sesiones [id_sesion=" + id_sesion + ", fecha=" + fecha + ", pelicula=" + pelicula + "]";
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}
}