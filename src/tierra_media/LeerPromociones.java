package tierra_media;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerPromociones {
	private String nombreArchivo;
	private ArrayList<Promocion> promociones;
	double costo = 0;
	double tiempo = 0;
	int cupoMin = 1000;

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
				this.cupoMin = 1000;
				if (tipoDescuento == TipoDescuento.AXB) {
					obtenerDatosDeAtracciones(2, datos, atraccionesDisponibles, atraccionesEnPromocion);
					Promocion p = new PromocionAXB(nombrePromocion, this.costo, this.tiempo, this.cupoMin,
							atraccionesEnPromocion);
					this.promociones.add(p);
				} else if (tipoDescuento == TipoDescuento.PORCENTUAL) {
					double aDescontar = Double.parseDouble(datos[2]);
					obtenerDatosDeAtracciones(2, datos, atraccionesDisponibles, atraccionesEnPromocion);
					Promocion p = new PromocionPorcentual(nombrePromocion, this.costo, this.tiempo, this.cupoMin,
							atraccionesEnPromocion, aDescontar);

					this.promociones.add(p);
				} else {
					double aDescontar = Double.parseDouble(datos[2]);
					obtenerDatosDeAtracciones(2, datos, atraccionesDisponibles, atraccionesEnPromocion);
					Promocion p = new PromocionAbsoluta(nombrePromocion, this.costo, this.tiempo, this.cupoMin,
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
					if (this.cupoMin > atraccionDisponible.getCupo()) {
						this.cupoMin = atraccionDisponible.getCupo();
					}
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
