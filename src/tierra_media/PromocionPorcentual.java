package tierra_media;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {

	private double conDescuento;
	
	public PromocionPorcentual(String nombreAtraccion, double costo, double tiempo, int cupo,
			ArrayList<Atraccion> atracciones, double conDescuento) {
		super(nombreAtraccion, costo, tiempo, cupo, atracciones);
		setDescuento(conDescuento);
	}
	//OK
	public void setDescuento(double descuento) {
		this.conDescuento= this.getCosto()-this.getCosto()*descuento/100;
	}

	public double getConDescuento() {
		return conDescuento;
	}
	/*@Override
	public String toString() {
		return "PromocionPorcentual [conDescuento=" + conDescuento + ", atracciones=" + this.getAtracciones() + ", nombre="
				+ nombre + ", costo=" + costo + ", tiempo=" + tiempo + ", cupo=" + cupo + "]";
	}*/


	
	@Override
	public String toString() {
		return nombre + "\n-Atracciones incluidas: " + this.getAtracciones() + "\n-Duración :" + tiempo
				+ " horas \n-Precio original: " + costo + "\n-Precio con descuento:" + conDescuento+ ", cupo=" + cupo;
	}

}
