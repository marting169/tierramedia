package AdminArchivos;

import java.io.*;
import java.util.ArrayList;

import Logica.Atraccion;

public class LeerAtracciones {
	private String nombreArchivo;
	private ArrayList<Atraccion> atracciones;

	public LeerAtracciones(String nombreArchivo, ArrayList<Atraccion> atracciones) {
		this.nombreArchivo = nombreArchivo;
		this.atracciones = atracciones;
	}

	public void leerArchivoAtracciones() {

		try {
			FileReader input = new FileReader(this.nombreArchivo);
			BufferedReader bufInput = new BufferedReader(input);
			String linea;
			String[] datos;

			linea = bufInput.readLine();
			while (linea != null) {
				datos = linea.split(";");
				String nombreAtraccion = datos[0].trim();
				double costo = Double.parseDouble(datos[1]);
				double tiempo = Double.parseDouble(datos[2]);
				int cupo = Integer.parseInt(datos[3]);
				Atraccion a = new Atraccion(nombreAtraccion, costo, tiempo, cupo);
				this.atracciones.add(a);
				linea = bufInput.readLine();
			}
			bufInput.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void listarAtracciones() {
		for(Atraccion atraccion:this.atracciones) {
			System.out.println(atraccion.toString());
		}
	}

}
