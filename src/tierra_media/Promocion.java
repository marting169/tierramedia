package tierra_media;

import java.util.ArrayList;

public class Promocion extends Atraccion{
	/*private String nombre;
	private double costo;
	private double tiempo;
	private int cupo;*/
	
	private double conDescuento;
	private ArrayList<Atraccion> atracciones;
	private TipoDescuento tipoDescuento;

	public Promocion(ArrayList<Atraccion> atracciones, String nombre, TipoDescuento tipo, double costo,
			double tiempo, double aDescontar, int cupo) {
		super(nombre,costo, tiempo, cupo);
		this.atracciones = atracciones;
		this.setTipoDescuento(tipo);
		this.conDescuento = this.obtenerDescuento(aDescontar);
	}

	public Promocion(ArrayList<Atraccion> atracciones, String nombre, TipoDescuento tipo, double costo,
			double tiempo,int cupo) {
		super(nombre,costo, tiempo, cupo);
		this.atracciones = atracciones;
		this.setTipoDescuento(tipo);
		this.conDescuento = this.obtenerDescuento(atracciones.get(2).getCosto());
	}

	public void setNombrePromocion(String nombre) {
		this.nombre = nombre;
	}

	public void setTipoDescuento(TipoDescuento tipo) {
		tipoDescuento = tipo;
	}

	public String getNombrePromocion() {
		return nombre;
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
	
	public void decrementarCupos() {
		int suma = 0;
		for (Atraccion atraccion : atracciones) {
			atraccion.usarUnCupo();
			
		}
		this.cupo = suma;
	}


	public double obtenerDescuento(double valor) {
		if (tipoDescuento == TipoDescuento.PORCENTUAL) {
			return costo - costo * (valor / 100);
		} else {
			return costo - valor;
		}
	}

	public String getAtracciones() {
		String respuesta="[";
		for(Atraccion atraccionA:atracciones) {
			respuesta= respuesta + atraccionA.getNombreAtraccion() + ", ";
		}
		respuesta = respuesta.substring(0, respuesta.length()-2);
		return respuesta+"]";
	}

	public double getConDescuento() {
		return conDescuento;
	}

	@Override
	public String toString() {
		return nombre + "\n-Atracciones incluidas: " + this.getAtracciones() + "\n-Duración :" + tiempo +" horas \n-Precio original: " + costo
				+ "\n-Precio con descuento:" + conDescuento;
	}

}
