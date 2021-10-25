package AdminArchivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Logica.Usuario;

public class ArchivoSalida {

	public void guardarEnArchivo(ArrayList<Usuario> usuarios, String nombreDeRuta) {
		PrintWriter salida = null;

for (Usuario usuario : usuarios) {
			try {
			salida = new PrintWriter(new FileWriter(nombreDeRuta + "itinerario_"+usuario.getNombre()+".csv"));
			String itinerarioDeUsuarios = usuario.toString();
				salida.print(itinerarioDeUsuarios);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			try {
				if (salida != null) {
					salida.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		}
	}
}
