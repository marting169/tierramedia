package TierraMediaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Logica.Atraccion;

class AtraccionTest {

	Atraccion atraccion;

	@BeforeEach
	public void setUp() {
		atraccion = new Atraccion("La Comarca", 3, 6.5, 150);
	}

	@Test
	public void crearAtraccion() {
		assertNotNull(atraccion);
	}

	@Test
	public void obtenerCupo() {
		assertEquals(150, atraccion.getCupo());
	}
	
	@Test
	public void setearCupo() {
		atraccion.setCupo(140);
		assertEquals(140, atraccion.getCupo());
	}
	
	@Test
	public void usarCupo() {
		atraccion.usarUnCupo();
		assertEquals(149, atraccion.getCupo());
	}


}
