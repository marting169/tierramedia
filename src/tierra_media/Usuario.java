package tierra_media;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempo_disponible;
	private ArrayList<Producto> itinerario;
	private ArrayList<Atraccion> soloAtracciones;

	public Usuario(String nombre, double presupuesto, double tiempo_disponible) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo_disponible = tiempo_disponible;
		this.soloAtracciones=new ArrayList<Atraccion>();
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

	public ArrayList<Producto> getItinerario() {
		return itinerario;
	}
	
	public void listarItinerarios() {
		for (Producto itinerarioA : this.itinerario) {
			System.out.println(itinerarioA.toString());
		}
	}

	public void setItinerario(ArrayList<Producto> itinerarios) {
		this.itinerario = itinerarios;
	}

	public ArrayList<Atraccion> getSoloAtracciones() {
		return soloAtracciones;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempo_disponible=" + tiempo_disponible
				+ ", itinerario=" + itinerario + "]";
	}

	public void setSoloAtracciones(ArrayList<Atraccion> soloAtracciones) {
		this.soloAtracciones=soloAtracciones;
	}

	/*public boolean atraccionIncluida(Atraccion nuevaAtraccion) {
		return this.soloAtracciones.contains(nuevaAtraccion);
	}
	public boolean atraccionIncluidaEnPromocion(ArrayList<Atraccion> soloAtracciones) {
		boolean existe=false;
		int i=0;
		while(i< soloAtracciones.size() && !existe) {
			existe = this.atraccionIncluida(soloAtracciones.get(i));
			i++;
		}
		return existe;
	}*/
}
