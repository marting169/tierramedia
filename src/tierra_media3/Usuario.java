package tierra_media3;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempo_disponible;
	private ArrayList<Atraccion> itinerario;

	public Usuario(String nombre, double presupuesto, double tiempo_disponible) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo_disponible = tiempo_disponible;
	}

	public double getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getTiempo_disponible() {
		return this.tiempo_disponible;
	}

	public void setTiempo_disponible(double tiempo_disponible) {
		this.tiempo_disponible = tiempo_disponible;
	}

	public String getNombre() {
		return this.nombre;
	}

	public ArrayList<Atraccion> getItinerario() {
		return itinerario;
	}

	public void setItinerario(ArrayList<Atraccion> itinerario) {
		this.itinerario = itinerario;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempo_disponible=" + tiempo_disponible
				+ ", itinerario=" + itinerario + "]";
	}


}
