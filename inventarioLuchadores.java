package Ayudantia;
import java.util.ArrayList;
public class inventarioLuchadores {
	private ArrayList<luchador_AliwenMelillan> luchadores;	
	
	public inventarioLuchadores() {
		super();
		luchadores=new ArrayList<luchador_AliwenMelillan>();
	}
	public void cantidadLuchadores() {
		System.out.println(luchadores.size());
	}
	
	public void agregarLuchador() {
		if (luchadores.size()<=25) {
			luchadores.add(new luchador_AliwenMelillan());
			luchadores.get(luchadores.size()-1).random_estadisticas();
		}	
		else {
			System.out.println("Se ha sobrepasado el límite");
		}
	}
	public void eliminarLuchador(int indice) {
		luchadores.remove(indice-1);
	}
	
	public void filtro_fraccion(String fraccion) {
		for (int i=0;i<luchadores.size();i++) {
			if (luchadores.get(i).getFraccion()==fraccion) {
				System.out.println(luchadores.get(i).getNombre());
			}
		}
	}
	
	public void filtro_rango(int rango) {
		for (int i=0;i<luchadores.size();i++) {
				if (luchadores.get(i).getRango()==rango) {
				System.out.println(luchadores.get(i).getNombre());
			}
		}
	}
	
	public void mostrarLuchadores() {
		for (int i=0;i<luchadores.size();i++) {
			System.out.println("--- \n"+ (i+1));
			System.out.println("Nombre: "+luchadores.get(i).getNombre()
			+ "\nFraccion: "+luchadores.get(i).getFraccion()
			+ "\nRango: "+ luchadores.get(i).getRango());
			
		}
	}
	
	public void mostrarLuchador(int indice) {
		if(indice>luchadores.size()) {
			System.out.println("El luchador no existe");
		}
		else {
			luchadores.get(indice-1).mostrar_estadisticas();
		}
	}
}
