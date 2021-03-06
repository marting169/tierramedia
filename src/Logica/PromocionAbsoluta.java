package Logica;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion{
	
	private double conDescuento;
	

	public PromocionAbsoluta(String nombreAtraccion, double costo, double tiempo,
			ArrayList<Atraccion> atracciones, double conDescuento) {
		super(nombreAtraccion, costo, tiempo, atracciones);
		setDescuento(conDescuento);
	}

	public void setDescuento(double precioAbsoluto) {
		this.conDescuento=precioAbsoluto;
	}
	
	public double getConDescuento() {
		return conDescuento;
	}

	/*@Override
	public String toString() {
		return "PromocionAbsoluta [conDescuento=" + conDescuento + ", atracciones=" + atracciones + ", nombre=" + nombre
				+ ", costo=" + costo + ", tiempo=" + tiempo + ", cupo=" + cupo + "]";
	}*/
	
	@Override
	public String toString() {
		return nombre + "\n-Atracciones incluidas: " + this.getAtracciones() + "\n-Duracion :" + tiempo
				+ " horas \n-Precio original: " + costo + "\n-Precio con descuento:" + conDescuento;
	}

}
