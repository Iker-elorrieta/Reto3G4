package modelo;

public class Entrada {
	private int id_entrada;
	private Sesion entradaSesion;
	private float precioSD;
	
	public Sesion getEntradaSesion() {
		return entradaSesion;
	}

	public void setEntradaSesion(Sesion entradaSesion) {
		this.entradaSesion = entradaSesion;
	}

	public Entrada() {
	}

	public int getId_entrada() {
		return id_entrada;
	}

	public void setId_entrada(int id_entrada) {
		this.id_entrada = id_entrada;
	}


	@Override
	public String toString() {
		return "Entrada [id_entrada=" + id_entrada + ", entradaSesion=" + entradaSesion + ", precioSD=" + precioSD
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return id_entrada == other.id_entrada;
	}



	public float getPrecioSD() {
		return precioSD;
	}

	public void setPrecioSD(float precioSD) {
		this.precioSD = precioSD;
	}


}
