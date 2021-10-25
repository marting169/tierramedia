package AdminArchivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Logica.Atraccion;
import Logica.Promocion;
import Logica.PromocionAXB;
import Logica.PromocionAbsoluta;
import Logica.PromocionPorcentual;
import Logica.TipoDescuento;

public class LeerPromociones {
	private String nombreArchivo;
	private ArrayList<Promocion> promociones;
	double costo = 0;
	double tiempo = 0;

	public LeerPromociones(String nombreArchivo, ArrayList<Promocion> promociones) {
		this.nombreArchivo = nombreArchivo;
		this.promociones = promociones;
	}

	public void leerArchivoPromociones(ArrayList<Atraccion> atraccionesDisponibles) {

		try {
			FileReader input = new FileReader(this.nombreArchivo);
			BufferedReader bufInput = new BufferedReader(input);
			String linea;
			String[] datos;
			while ((linea = bufInput.readLine()) != null) {
				datos = linea.split(";");
				String nombrePromocion = datos[0].trim();
				TipoDescuento tipoDescuento = TipoDescuento.valueOf(datos[1].trim());
				ArrayList<Atraccion> atraccionesEnPromocion = new ArrayList<Atraccion>();
				this.costo = 0;
				this.tiempo = 0;
				if (tipoDescuento == TipoDescuento.AXB) {
					obtenerDatosDeAtracciones(2, datos, atraccionesDisponibles, atraccionesEnPromocion);
					Promocion p = new PromocionAXB(nombrePromocion, this.costo, this.tiempo,
							atraccionesEnPromocion);
					this.promociones.add(p);
				} else if (tipoDescuento == TipoDescuento.PORCENTUAL) {
					double aDescontar = Double.parseDouble(datos[2]);
					obtenerDatosDeAtracciones(2, datos, atraccionesDisponibles, atraccionesEnPromocion);
					Promocion p = new PromocionPorcentual(nombrePromocion, this.costo, this.tiempo,
							atraccionesEnPromocion, aDescontar);

					this.promociones.add(p);
				} else {
					double aDescontar = Double.parseDouble(datos[2]);
					obtenerDatosDeAtracciones(2, datos, atraccionesDisponibles, atraccionesEnPromocion);
					Promocion p = new PromocionAbsoluta(nombrePromocion, this.costo, this.tiempo,
							atraccionesEnPromocion, aDescontar);

					this.promociones.add(p);
				}
			}
			bufInput.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void obtenerDatosDeAtracciones(int j, String[] datos, ArrayList<Atraccion> atraccionesDisponibles,
			ArrayList<Atraccion> atraccionesEnPromocion) {
		for (int i = j; i < datos.length; i++) {
			for (Atraccion atraccionDisponible : atraccionesDisponibles) {
				if (atraccionDisponible.getNombreAtraccion().equals(datos[i].trim())) {
					atraccionesEnPromocion.add(atraccionDisponible);
					this.costo += atraccionDisponible.getCosto();
					this.tiempo += atraccionDisponible.getTiempo();
					break;
				}
			}
		}
	}

	public void listarPromociones() {
		for (Promocion promocion : this.promociones) {
			System.out.println(promocion.toString());
		}
	}
}
