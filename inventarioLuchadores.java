package Ayudantia;
import java.util.ArrayList;
public class inventarioLuchadores {
	private ArrayList<luchador> luchadores;	
	
	public inventarioLuchadores() { //Constructor que inicializa la lista de luchadores
		luchadores=new ArrayList<luchador>();
	}
	
	public ArrayList<luchador> getLuchadores() {
		return luchadores;
	}
	public void setLuchadores(ArrayList<luchador> luchadores) {
		this.luchadores = luchadores;
	}

	public void cantidadLuchadores() {
		System.out.println(luchadores.size());
	}
	
	public void agregarLuchador() { //Agrega luchador secuencialmente
		if (luchadores.size()<=25) { //Limite de luchadores=25
			luchadores.add(new luchador());;
		}	
		else {
			System.out.println("Se ha sobrepasado el límite");
		}
	}
	public void eliminarLuchador(int indice) { //Elimina luchador segun su indice [1,...]
		if (indice<luchadores.size()){
			luchadores.remove(indice-1);
		}
		else {
			System.out.println("Se ha sobrepasado del tamaño actual del inventario");
		}
	}
	
	public void filtro_faccion(String faccion) { //Muestra los luchadores con cierta faccion
		if(faccion=="Agua" || faccion=="Fuego" || faccion=="Tierra") {
			for (int i=0;i<luchadores.size();i++) {
				if (luchadores.get(i).getFaccion()==faccion) {
					System.out.println(faccion +": "+ luchadores.get(i).getNombre());
				}
			}
		}
		else {
			System.out.println("La faccion no se encuentra");
		}
	}
	
	public void filtro_rango(int rango) {
		if(0<rango && rango<5) {
			for (int i=0;i<luchadores.size();i++) {
				if (luchadores.get(i).getRango()==rango) {
					System.out.println(rango +": "+ luchadores.get(i).getNombre());
				}
			}
		}
		else {
			System.out.println("El rango no se encuentra");
		}
			
	}
	
	
	public void mostrarLuchadores() { //Muestra todos los luchados con su nombre,faccion y rango
		for (int i=0;i<luchadores.size();i++) {
			System.out.println("--- \n"+ (i+1));
			System.out.println("Nombre: "+luchadores.get(i).getNombre()
			+ "\nFaccion: "+luchadores.get(i).getFaccion()
			+ "\nRango: "+ luchadores.get(i).getRango());
			
		}
	}
	
	public void mostrarLuchador(int indice) { //Muestra el luchador segun indice
		if(indice>luchadores.size()) {
			System.out.println("El luchador no existe");
		}
		else {
			luchadores.get(indice-1).mostrar_estadisticas();
		}
	}
}
