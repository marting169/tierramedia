package AdminArchivos;

import java.util.ArrayList;

import Logica.Atraccion;
import Logica.Ofertador;
import Logica.Promocion;
import Logica.Usuario;

public class MainTierraMedia {

	public static void main(String[] args) {
		
		ArrayList<Atraccion> atraccionesDisponibles=new ArrayList<Atraccion>();
		LeerAtracciones listaDeAtracciones=new LeerAtracciones("archivos/atracciones.csv",atraccionesDisponibles);
		listaDeAtracciones.leerArchivoAtracciones();
		//listaDeAtracciones.listarAtracciones();
		
		ArrayList<Promocion>promocionesDisponibles=new ArrayList<Promocion>();
		LeerPromociones listaDePromociones=new LeerPromociones("archivos/promociones.csv",promocionesDisponibles);
		listaDePromociones.leerArchivoPromociones(atraccionesDisponibles);
		//listaDePromociones.listarPromociones();
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		LeerUsuarios listaDeUsuarios=new LeerUsuarios("archivos/usuarios.csv",usuarios);
		listaDeUsuarios.leerArchivoUsuarios();
		//listaDeUsuarios.listarUsuarios();
		
		Ofertador ofertas=new Ofertador();
		ofertas.generarOferta(atraccionesDisponibles, promocionesDisponibles, usuarios);
		listaDeUsuarios.listarUsuarios();
		
		//listaDeAtracciones.listarAtracciones();
		//listaDePromociones.listarPromociones();
		
		ArchivoSalida salida = new ArchivoSalida();		
		salida.guardarEnArchivo(usuarios, "archivos/");
		
	}

}
