package tierra_media4;

import java.util.ArrayList;

public abstract class Promocion extends Atraccion{
	protected ArrayList<Atraccion> atracciones;

	public Promocion(String nombreAtraccion, double costo, double tiempo, int cupo, ArrayList<Atraccion> atracciones) {
		super(nombreAtraccion, costo, tiempo, cupo);
		this.atracciones = atracciones;
	}

	public void decrementarCupos() {
		for (Atraccion atraccion : atracciones) {
			atraccion.usarUnCupo();
		}
		this.cupo--;
	}

	
	public void setCupo() {
		int minimo = 1000;
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getCupo() < minimo) {
				minimo = atraccion.getCupo();
			}
		}
		this.cupo = minimo;
	}

	
	public String getAtracciones() {
		String respuesta = "[";
		for (Atraccion atraccionA : atracciones) {
			respuesta = respuesta + atraccionA.getNombreAtraccion() + ", ";
		}
		respuesta = respuesta.substring(0, respuesta.length() - 2);
		return respuesta + "]";
	}

	protected abstract double getConDescuento();
	
	
}
