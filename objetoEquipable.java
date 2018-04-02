package Ayudantia;
import java.lang.reflect.Field;

import Ayudantia.luchador_AliwenMelillan;

public class objetoEquipable {
	/**
	 * @param estrella
	 */
	private int estrella;
	private int mejora_base;
	private String habilidad_mejorada;

	
	public objetoEquipable() {
		this.estrella=probabilidad_estrella();
		this.mejora_base=Ayudantia.luchador_AliwenMelillan.random_num(1, 9)*getEstrella();
		this.habilidad_mejorada=azar_caracteristica();
	}

	public objetoEquipable(int estrella, int mejora_base, String habilidad_mejorada) {
		super();
		this.estrella = estrella;
		this.mejora_base = mejora_base;
		this.habilidad_mejorada = habilidad_mejorada;
	}

	public int probabilidad_estrella() {
		int local_estrella=0;
		int probabilidad = luchador_AliwenMelillan.random_num(1, 100);
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
		return estrella;
	}
	
	public String azar_caracteristica() { //
		String[] caracteristicas= {"HP","ATK","DEF","SPD"};
		String caracteristica_elegida;
		caracteristica_elegida=caracteristicas[Ayudantia.luchador_AliwenMelillan.random_num(0, caracteristicas.length)];
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
	
	public void mostrar_caracteristicas() {
		System.out.println("Mejora base: " + getMejora_base() +
				"\n Estrellas: " + getEstrella() + "\n Habilidad mejorada: " + getHabilidad_mejorada());	
	}
	
}
