package modelo;


public class Entradas {
	private int id_entrada;
	private int id_sesion;
	public Entradas( int id_entrada ,int id_sesion) {
		this.id_entrada = id_entrada;
		this.id_sesion = id_sesion;
	}

	public int getId_entrada() {
		return id_entrada;
	}

	public void setId_entrada(int id_entrada) {
		this.id_entrada = id_entrada;
	}

	public int getId_sesion() {
		return id_sesion;
	}

	public void setId_sesion(int id_sesion) {
		this.id_sesion = id_sesion;
	}

	@Override
	public String toString() {
		return "id_entrada=" + id_entrada + ", id_sesion=" + id_sesion ;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entradas other = (Entradas) obj;
		return id_entrada == other.id_entrada;
	}
	
}
