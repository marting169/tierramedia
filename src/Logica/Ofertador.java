package Logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Ofertador {
	private ArrayList<Producto> itinerarios;
	private ArrayList<Atraccion> soloAtracciones;

	public Ofertador() {
	}

	@SuppressWarnings("resource")
	public void generarOferta(ArrayList<Atraccion> atraccionesA, ArrayList<Promocion> promocionesP,
			ArrayList<Usuario> usuariosU) {
		double presupuesto = 0;
		double tiempoDisponible = 0;
		System.out.println("Bienvenido/a a la Tierra Media");
		System.out.println("-----------------------------------------------------\n");
		for (Usuario usuario : usuariosU) {
			itinerarios = new ArrayList<Producto>();
			soloAtracciones = new ArrayList<Atraccion>();
			presupuesto = usuario.getPresupuesto();
			tiempoDisponible = usuario.getTiempo_disponible();
			System.out.println("Nombre de visitante: " + usuario.getNombre() + "\n");
			for (Promocion promocion : promocionesP) {
				String input;
				Scanner sc = new Scanner(System.in);
				if (presupuesto >= promocion.getConDescuento() && tiempoDisponible >= promocion.getTiempo()
						&& promocion.obtenerCupoMinimo() > 0
						&& !promocion.atraccionIncluidaEnPromocion(soloAtracciones)) {
					System.out.println(promocion.toString());
					System.out.println("\nAcepta sugerencia? Ingrese S o N");
					input = sc.next();
					boolean band = false;
					while (band == false) {
						if (input.equals("S") || input.equals("s")) {
							this.itinerarios.add(promocion);
							this.soloAtracciones.addAll(promocion.obtenerAtracciones());

							System.out.println("Aceptada!");
							band = true;
							promocion.decrementarCupos();
							presupuesto -= promocion.getConDescuento();
							tiempoDisponible -= promocion.getTiempo();
							System.out.println("-----------------------------------------------------\n");
						} else if (input.equals("N") || input.equals("n")) {
							System.out.println("Descartado");
							band = true;
							System.out.println("-----------------------------------------------------\n");
						} else {
							System.out.println("Intente nuevamente: Ingrese S o N");
							input = sc.nextLine();
						}
					}
				}
			}
			for (Atraccion atraccion : atraccionesA) {
				String input;
				Scanner sc = new Scanner(System.in);
				if (presupuesto >= atraccion.getCosto() && tiempoDisponible >= atraccion.getTiempo()
						&& atraccion.getCupo() > 0 && !soloAtracciones.contains(atraccion)) {
					System.out.println(atraccion.toString());
					System.out.println("\nAcepta sugerencia? Ingrese S o N");
					input = sc.nextLine();
					boolean band = false;
					while (band == false) {
						if (input.equals("S") || input.equals("s")) {
							this.itinerarios.add(atraccion);
							this.soloAtracciones.add(atraccion);
							System.out.println("Aceptada!");
							band = true;
							atraccion.usarUnCupo();
							presupuesto -= atraccion.getCosto();
							tiempoDisponible -= atraccion.getTiempo();
							System.out.println("-----------------------------------------------------\n");
						} else if (input.equals("N") || input.equals("n")) {
							System.out.println("Descartado");
							band = true;
							System.out.println("-----------------------------------------------------\n");
						} else {
							System.out.println("Intente nuevamente: Ingrese S o N");
							input = sc.nextLine();
						}
					}
				}
			}
			usuario.setPresupuesto(presupuesto);
			usuario.setTiempo_disponible(tiempoDisponible);
			usuario.setItinerario(itinerarios);
			usuario.setSoloAtracciones(soloAtracciones);
			System.out.println("-----------------------------------------------------\n");
		}
	}
}
