package tierra_media;

import java.util.ArrayList;

public class PromocionAXB extends Promocion{
	
	private double conDescuento;
	
	public PromocionAXB(String nombreAtraccion, double costo, double tiempo, int cupo, ArrayList<Atraccion> atracciones) {
		super(nombreAtraccion, costo, tiempo, cupo, atracciones);
		setDescuento();
	}

	public void setDescuento() {
		double suma=0;
		for(int i=0;i < 2;i++) {
			suma+=atracciones.get(i).getCosto();
		}
		conDescuento=suma;
	}

	public double getConDescuento() {
		return conDescuento;
	}

	/*@Override
	public String toString() {
		return "PromocionAXB [conDescuento=" + conDescuento + ", atracciones=" + atracciones + ", nombre=" + nombre
				+ ", costo=" + costo + ", tiempo=" + tiempo + ", cupo=" + cupo + "]";
	}*/
	
	@Override
	public String toString() {
		return nombre + "\n-Atracciones incluidas: " + this.getAtracciones() + "\n-Duración :" + tiempo
				+ " horas \n-Precio original: " + costo + "\n-Precio con descuento:" + conDescuento+ ", cupo=" + cupo;
	}

}
