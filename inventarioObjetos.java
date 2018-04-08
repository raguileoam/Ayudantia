package Ayudantia;
import java.util.ArrayList;

public class inventarioObjetos {
	private ArrayList<objetoEquipable> objetos;
	
	public inventarioObjetos() {
		objetos= new ArrayList<objetoEquipable>();
	}
	public void agregarObjeto() { //Instancia objeto equipable y lo agrega a objetos
		objetos.add(new objetoEquipable());
	}
	public void eliminarObjeto(int indice) { //Borra objeto segun indice
		objetos.remove(indice-1);
	}
	
	public void filtro_estrella(int estrella) { //Estrella==rango
		for (int i=0;i<objetos.size();i++) {
			if (objetos.get(i).getEstrella()==estrella) {
				System.out.println("Objeto nro."+ i+"; Estrella: " + estrella);
				break;
			}
		}

	}
	public void mostrar_objetos() {
		for (int i=0;i<objetos.size();i++) {
			System.out.print("Atributo mejorado: "+ objetos.get(i).getHabilidad_mejorada()
					+ "\n Rango/estrella: "+ objetos.get(i).getEstrella() 
					+ "\n Mejora Total: " + objetos.get(i).getMejora());
			
		}
	}
}
