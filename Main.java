package Ayudantia;

public class Main {
	public static void main(String[] args) {
		try {
			InventarioLuchadores inventario = new InventarioLuchadores();
			inventario.agregarLuchador();;
			inventario.mostrarLuchadores();;
			Monstruo malo = new Monstruo();
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			main(args);
		}

	}
}
