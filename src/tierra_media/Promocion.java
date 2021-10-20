package tierra_media;

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
		int suma3 = 0;
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getCupo() > 1) {
				suma3 += atraccion.getCupo();
			} else {
				throw new RuntimeException("La atracción " + atraccion.getNombreAtraccion() + " no tiene cupo.");
			}
		}
		this.cupo = suma3;
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
