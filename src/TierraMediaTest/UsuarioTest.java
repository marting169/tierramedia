package TierraMediaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Logica.Atraccion;
import Logica.Producto;
import Logica.Promocion;
import Logica.PromocionPorcentual;
import Logica.Usuario;

class UsuarioTest {

	Usuario usuario;

	@BeforeEach
	public void setUp() {
		usuario = new Usuario("Eowyn", 10, 8);
	}

	@Test
	public void creacionUsuario() {
		assertNotNull(usuario);
	}

	@Test
	public void obtenerPresupuesto() {
		assertEquals(10, usuario.getPresupuesto());
	}
	
	@Test
	public void setearPresupuesto() {
		usuario.setPresupuesto(20);
		assertEquals(20, usuario.getPresupuesto());
	}
	
	@Test
	public void obtenerTiempoDisponible() {
		assertEquals(8, usuario.getTiempo_disponible());
	}
	
	@Test
	public void setearTiempoDisponible() {
		usuario.setTiempo_disponible(15);
		assertEquals(15, usuario.getTiempo_disponible());
	}
	
	@Test
	public void sabeSuNombre() {
		assertEquals("Eowyn", usuario.getNombre());
	}
	
	@Test
	public void conoceSuItinerario() {
		Atraccion comarca = new Atraccion("La Comarca", 3, 6.5, 150);
		Atraccion loth = new Atraccion("Lothl�rien", 35, 1, 30);
		Atraccion bosque = new Atraccion("Bosque Negro", 3, 4, 12);
		
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(loth);
		atracciones.add(bosque);
		Promocion promo = new PromocionPorcentual("Pack Prueba", 38, 5, atracciones, 10);

		ArrayList<Producto> itinerario = new ArrayList<Producto>();
		itinerario.add(comarca);
		itinerario.add(promo);
		
		usuario.setItinerario(itinerario);
		assertEquals(itinerario, usuario.getItinerario());
	}
	
	@Test
	public void conoceSoloLasAtracciones() {
		Atraccion comarca = new Atraccion("La Comarca", 3, 6.5, 150);
		Atraccion loth = new Atraccion("Lothl�rien", 35, 1, 30);
		Atraccion bosque = new Atraccion("Bosque Negro", 3, 4, 12);

		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(comarca);
		atracciones.add(loth);
		atracciones.add(bosque);
		
		usuario.setSoloAtracciones(atracciones);;
		assertEquals(atracciones, usuario.getSoloAtracciones());
	}
	

}
