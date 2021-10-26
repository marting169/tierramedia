package TierraMediaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Logica.Atraccion;
import Logica.Producto;
import Logica.PromocionPorcentual;

class ProductoTest {

	Producto comarca;
	Producto loth;
	Producto promo;
	ArrayList<Atraccion> atracciones;

	@BeforeEach
	public void setUp() {
		comarca = new Atraccion("La Comarca", 3, 6.5, 150);
		loth = new Atraccion("Lothl�rien", 35, 1, 30);
		
		atracciones = new ArrayList<Atraccion>();
		atracciones.add((Atraccion) comarca);
		atracciones.add((Atraccion) loth);
		
		promo = new PromocionPorcentual("Pack Prueba", 38, 7.5, atracciones, 10);
	}

	@Test
	public void crearAtraccion() {
		assertNotNull(comarca);
		assertNotNull(loth);
		assertNotNull(promo);
	}
	
	@Test
	public void sabeSuNombre() {
		assertEquals("La Comarca", comarca.getNombreAtraccion());
	}
	
	@Test
	public void setearNombre() {
		comarca.setNombreAtraccion("The Shire");
		assertEquals("The Shire", comarca.getNombreAtraccion());
	}
	
	@Test
	public void sabeSuCosto() {
		assertEquals(35, loth.getCosto());
	}
	
	@Test
	public void setearCosto() {
		loth.setCosto(40);
		assertEquals(40, loth.getCosto());
	}
	
	@Test
	public void sabeSuDuracion() {
		assertEquals(7.5, promo.getTiempo());
	}
	
	@Test
	public void setearDuracion() {
		promo.setTiempo(8);
		assertEquals(8, promo.getTiempo());
	}



}
