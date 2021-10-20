package tierra_media3;

public class Atraccion {
	protected String nombre;
	protected double costo;
	protected double tiempo;
	protected int cupo;
	
	public Atraccion(String nombreAtraccion, double costo, double tiempo, int cupo) {
		super();
		this.nombre = nombreAtraccion;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
	}

	public String getNombreAtraccion() {
		return nombre;
	}

	public void setNombreAtraccion(String nombreAtraccion) {
		this.nombre = nombreAtraccion;
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
	
	public void usarUnCupo() {
		this.cupo--;
	}

	@Override
	public String toString() {
		return "Atracción\nNombre [" + nombre + "]\n-Precio: $" + costo + "\n-Duración: " + tiempo + " horas";
	}
	
	public String toString2() {
		return nombre + " ";
	}
	
	
	
}
