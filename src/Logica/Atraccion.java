package Logica;

public class Atraccion extends Producto{
	
	protected int cupo;
	
	public Atraccion(String nombreAtraccion, double costo, double tiempo, int cupo) {
		super(nombreAtraccion, costo, tiempo);
		this.cupo = cupo;
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
		return "\nAtraccion"
				+ "\n-Nombre [" + nombre + "]"
						+ "\n-Precio: $" + costo + 
						"\n-Duracion: " + tiempo + " horas";
	}
	
	public String toString2() {
		return nombre + " ";
	}
}
