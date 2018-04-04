package Ayudantia;

public class Main {
	public static void main(String[] args) {
		try {
			inventarioLuchadores inventario = new inventarioLuchadores();
			inventario.agregarLuchador();;
			inventario.mostrarLuchadores();;
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			main(args);
		}

	}
}
