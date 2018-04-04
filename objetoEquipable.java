package Ayudantia;

import Ayudantia.luchador;

public class objetoEquipable {
	
	private int estrella;
	private int mejora_base;
	private String habilidad_mejorada;
	private String nombre;

	
	public objetoEquipable() {
		this.estrella=probabilidad_estrella();
		this.mejora_base=luchador.random_num(1, 9)*getEstrella();
		this.habilidad_mejorada=azar_caracteristica();
	}

	private int probabilidad_estrella() {
		int local_estrella=0;
		int probabilidad = luchador.random_num(1, 100);
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
	
	private String azar_caracteristica() { //aleatoriza para caracteristica mejorada junto a su respectivo tipo de objeto
		String[][] caracteristicas= {{"HP","ATK","DEF","SPD"},{"Armadura","Arma","Escudo","Botas"}};
		int indice_random;
		String caracteristica_elegida=caracteristicas[0][indice_random=luchador.random_num(0, caracteristicas[0].length-1)];
		this.setNombre(caracteristicas[1][indice_random]);
		return caracteristica_elegida;
	}
	
	public void setEstrella(int estrella) {
		this.estrella = estrella;
	}
	public void setMejora_base(int mejora_base) {
		this.mejora_base = mejora_base;
	}
	public void setHabilidad_mejorada(String habilidad_mejorada) {
		this.habilidad_mejorada = habilidad_mejorada;
	}
	public int getEstrella() {
		return estrella;
	}
	public int getMejora_base() {
		return mejora_base;
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
		System.out.println("Mejora base: " + getMejora_base() +
				"\n Estrellas: " + getEstrella() + "\n Habilidad mejorada: " + getHabilidad_mejorada());	
	}


	
}
