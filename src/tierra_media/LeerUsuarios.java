package tierra_media;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerUsuarios {
	private String nombreArchivo;
	private ArrayList<Usuario> usuarios;

	public LeerUsuarios(String nombreArchivo, ArrayList<Usuario> usuarios) {
		this.nombreArchivo = nombreArchivo;
		this.usuarios = usuarios;
	}

	public void leerArchivoUsuarios() {

		try {
			FileReader input = new FileReader(this.nombreArchivo);
			BufferedReader bufInput = new BufferedReader(input);
			String linea;
			String[] datos;

			linea = bufInput.readLine();
			while (linea != null) {
				datos = linea.split(";");
				String nombreUsuario = datos[0].trim();
				double presupuesto = Double.parseDouble(datos[1]);
				double tiempo = Double.parseDouble(datos[2]);
				Usuario u = new Usuario(nombreUsuario, presupuesto, tiempo);
				this.usuarios.add(u);
				linea = bufInput.readLine();
			}
			bufInput.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void listarUsuarios() {
		for(Usuario usuario:this.usuarios) {
			System.out.println(usuario.toString());
		}
	}
}