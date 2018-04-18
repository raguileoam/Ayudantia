package Ayudantia;

import Ayudantia.Luchador;

public class ObjetoEquipable {
	
	private int estrella;
	private int mejora;
	private String habilidad_mejorada;
	private String nombre;

	
	public ObjetoEquipable() {
		this.estrella=probabilidad_estrella();
		this.mejora=Luchador.random_num(1, 9)*getEstrella(); //mejora base de 1 a 9 * estrella/rango
		this.habilidad_mejorada="";
		this.nombre="";
		azar_caracteristica_y_nombre();
	}

	private int probabilidad_estrella() {
		int local_estrella=0;
		int probabilidad = Luchador.random_num(1, 100);
		if (probabilidad <= 20) {
			local_estrella = 1;
		} else if (probabilidad <= 40) {
			local_estrella = 2;
		} else if (probabilidad <= 60) {
			local_estrella = 3;
		} else if (probabilidad <= 75) {
			local_estrella = 4;
		} else if (probabilidad <= 85) {
			local_estrella = 5;
		} else if (probabilidad <= 90) {
			local_estrella = 6;
		} else if (probabilidad <= 94) {
			local_estrella = 7;
		} else if (probabilidad <= 97) {
			local_estrella = 8;
		} else if (probabilidad <= 99) {
			local_estrella = 9;
		} else {
			local_estrella = 10;
		}
		return local_estrella;
	}
	
	private void azar_caracteristica_y_nombre() { //aleatoriza para caracteristica mejorada junto a su respectivo tipo de objeto
		String[][] caracteristicas= {{"HP","ATK","DEF","SPD"},{"Armadura","Arma","Escudo","Botas"}};
		int indice_random;
		this.setHabilidad_mejorada(caracteristicas[0][indice_random=Luchador.random_num(0, caracteristicas[0].length-1)]);
		this.setNombre(caracteristicas[1][indice_random]);
	}
	
	public void setEstrella(int estrella) {
		this.estrella = estrella;
	}
	public void setMejora(int mejora) {
		this.mejora = mejora;
	}
	public void setHabilidad_mejorada(String habilidad_mejorada) {
		this.habilidad_mejorada = habilidad_mejorada;
	}
	public int getEstrella() {
		return estrella;
	}
	public int getMejora() {
		return mejora;
	}
	public String getHabilidad_mejorada() {
		return habilidad_mejorada;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void mostrar_caracteristicas() {
		System.out.println("Mejora base: " + getMejora() +
				"\n Estrellas: " + getEstrella() + "\n Habilidad mejorada: " + getHabilidad_mejorada());	
	}


	
}
