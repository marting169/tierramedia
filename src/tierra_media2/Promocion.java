package tierra_media2;

import java.util.ArrayList;

public class Promocion {
	private String nombrePromocion;
	private ArrayList<Atraccion> atracciones;
	private double costo;
	private double tiempo;
	private double conDescuento;
	private int cupo;
	private TipoDescuento tipoDescuento;

	public Promocion(ArrayList<Atraccion> atracciones, String nombrePromocion, TipoDescuento tipo, double costo,
			double tiempo, double aDescontar) {
		this.atracciones = atracciones;
		this.setNombrePromocion(nombrePromocion);
		this.setTipoDescuento(tipo);
		this.setCosto(costo);
		this.setTiempo(tiempo);
		// this.setCostoTiempoyCupo();
		this.conDescuento = this.obtenerDescuento(aDescontar);
	}

	private void setCosto(double costo2) {
		this.costo = costo2;
	}
	private void setTiempo(double tiempo2) {
		this.tiempo = tiempo2;
	}

	public Promocion(ArrayList<Atraccion> atracciones, String nombrePromocion, TipoDescuento tipo, double costo,
			double tiempo) {
		this.atracciones = atracciones;
		this.setNombrePromocion(nombrePromocion);
		this.setTipoDescuento(tipo);
		this.setCosto(costo);
		this.setTiempo(tiempo);
		//this.setCostoTiempoyCupo();
		this.conDescuento = this.obtenerDescuento(atracciones.get(2).getCosto());
	}

	public void setNombrePromocion(String nombre) {
		nombrePromocion = nombre;
	}

	public void setTipoDescuento(TipoDescuento tipo) {
		tipoDescuento = tipo;
	}

	public String getNombrePromocion() {
		return nombrePromocion;
	}

	public void setCostoTiempoyCupo() {
		double suma1 = 0;
		int suma2 = 0;
		int suma3 = 0;
		for (Atraccion atraccion : atracciones) {
			suma1 += atraccion.getCosto();
			suma2 += atraccion.getTiempo();
			if (atraccion.getCupo() > 1) {
				suma3 += atraccion.getCupo();
			} else {
				throw new RuntimeException("La atracción " + atraccion.getNombreAtraccion() + " no tiene cupo.");
			}
		}
		this.costo = suma1;
		this.tiempo = suma2;
		this.cupo = suma3;
	}

	public double getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public int getCupo() {
		return cupo;
	}

	public double obtenerDescuento(double valor) {
		if (tipoDescuento == TipoDescuento.PORCENTUAL) {
			return costo - costo * (valor / 100);
		} else {
			return costo - valor;
		}
	}

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}

	public double getDescuento() {
		return conDescuento;
	}

	@Override
	public String toString() {
		return "Promocion [nombrePromocion=" + nombrePromocion + ", atracciones=" + atracciones + ", costo=" + costo
				+ ", tiempo=" + tiempo + ", conDescuento=" + conDescuento + ", cupo=" + cupo + ", tipoDescuento="
				+ tipoDescuento + "]";
	}

	// calcular monto con descuento de cada tipod de promoción (generar interfaces
	// de cada tipo de promoción)

}
