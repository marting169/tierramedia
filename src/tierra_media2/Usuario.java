package tierra_media2;

public class Usuario {
	private String nombre;
	private int presupuesto;
	private double tiempo_disponible;
	public Usuario(String nombre, int presupuesto, double tiempo_disponible) {
		super();
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo_disponible = tiempo_disponible;
	}
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	public double getTiempo_disponible() {
		return tiempo_disponible;
	}
	public void setTiempo_disponible(double tiempo_disponible) {
		this.tiempo_disponible = tiempo_disponible;
	}
	public String getNombre() {
		return nombre;
	}

	
	//devolver datos

	
	
	
}
