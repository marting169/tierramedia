package TierraMediaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdminArchivos.ArchivoSalida;
import Logica.Atraccion;
import Logica.Ofertador;
import Logica.Producto;
import Logica.Promocion;
import Logica.PromocionPorcentual;
import Logica.Usuario;

class OfertadorTest {

	Ofertador oferta;
	Usuario eowyn;

	Producto comarca;
	Producto loth;
	Producto bosque;

	Producto promo;
	ArrayList<Atraccion> atracciones;

	@BeforeEach
	public void setUp() {
		oferta = new Ofertador();
		eowyn = new Usuario("Eowyn", 10, 8);

		comarca = new Atraccion("La Comarca", 3, 6.5, 150);
		loth = new Atraccion("Lothl�rien", 35, 1, 30);
		bosque = new Atraccion("Bosque Negro", 3, 4, 12);

		atracciones = new ArrayList<Atraccion>();
		atracciones.add((Atraccion) loth);
		atracciones.add((Atraccion) bosque);
		promo = new PromocionPorcentual("Pack Prueba", 38, 5, atracciones, 10);
	}

	@Test
	public void creacionesInstancias() {
		assertNotNull(oferta);
		assertNotNull(eowyn);
		assertNotNull(comarca);
		assertNotNull(loth);
		assertNotNull(bosque);
		assertNotNull(promo);
	}

	@Test
	public void pruebaGeneradorOferta() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(eowyn);
		ArrayList<Promocion> promociones = new ArrayList<Promocion>();
		promociones.add((Promocion) promo);
		
		oferta.generarOferta(atracciones, promociones, usuarios);
		ArchivoSalida archivoSalida = new ArchivoSalida();
		archivoSalida.guardarEnArchivo(usuarios, "archivos/itinerario_Eowyn.csv");

		BufferedInputStream ArchivoSalidaObtenido = null;
		BufferedInputStream ArchivoSalidaEsperado = null;
		try {
			ArchivoSalidaObtenido = new BufferedInputStream(
					new FileInputStream("archivos/archivos_Junit/itinerario_Obtenido.csv"));
			ArchivoSalidaEsperado = new BufferedInputStream(
					new FileInputStream("archivos/archivos_Junit/itinerario_Esperado.csv"));

			assertArrayEquals(ArchivoSalidaEsperado.readAllBytes(), ArchivoSalidaObtenido.readAllBytes());
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

}
