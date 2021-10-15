package tierra_media2;

public class Atraccion {
	private String nombreAtraccion;
	private double costo;
	private double tiempo;
	private int cupo;
	
	public Atraccion(String nombreAtraccion, double costo, double tiempo, int cupo) {
		super();
		this.nombreAtraccion = nombreAtraccion;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
	}

	public String getNombreAtraccion() {
		return nombreAtraccion;
	}

	public void setNombreAtraccion(String nombreAtraccion) {
		this.nombreAtraccion = nombreAtraccion;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	@Override
	public String toString() {
		return "Atraccion [nombreAtraccion=" + nombreAtraccion + ", costo=" + costo + ", tiempo=" + tiempo + ", cupo="
				+ cupo + "]";
	}
	
	
	
}
