package tierra_media2;

import java.util.ArrayList;

public class main {

	public static void main(String args[]) {
		
		ArrayList<Atraccion> atraccionesDisponibles=new ArrayList<Atraccion>();
		LeerAtracciones listaDeAtracciones=new LeerAtracciones("archivos/atracciones.csv",atraccionesDisponibles);
		listaDeAtracciones.leerArchivoAtracciones();
		listaDeAtracciones.listarAtracciones();
		ArrayList<Promocion>promocionesDisponibles=new ArrayList<Promocion>();
		LeerPromociones listaDePromociones=new LeerPromociones("archivos/promociones.csv",promocionesDisponibles);
		listaDePromociones.leerArchivoPromociones(atraccionesDisponibles);
		listaDePromociones.listarPromociones();
		
	}

}
