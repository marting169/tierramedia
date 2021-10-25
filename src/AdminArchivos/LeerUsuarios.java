package AdminArchivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Logica.Usuario;

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
				Usuario user = new Usuario(nombreUsuario, presupuesto, tiempo);
				this.usuarios.add(user);
				linea = bufInput.readLine();
			}
			bufInput.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public ArrayList<String> listarUsuarios() {
		ArrayList<String> resultado = new ArrayList<String>();
		for(Usuario usuario : usuarios) {
			resultado.add(usuario.toString());
		}
		return resultado;
	}
	
}