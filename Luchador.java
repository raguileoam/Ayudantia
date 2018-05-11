package Ayudantia;

import java.util.Comparator;
import java.util.Random;

public class Luchador extends Personaje{
	private String nombre;
	private double rango;
	private ObjetoEquipable objeto;

	public static int random_num(int min, int max) { // Metodo estatico que genera numero aleatorio
		int num_generado = (int) (Math.random() * ((max - min) + 1) + min);

		return num_generado;
	}

	private int probabilidad_rango() { // Devuelve numero aleatorio segun probabilidad
		int probabilidad = random_num(0, 100);
		int rango = 0;
		if (probabilidad <= 40) {
			rango = 1;
		}
		else if (probabilidad <= 70) {
			rango = 2;
		} 
		else if (probabilidad <= 85) {
			rango = 3;
		} 
		else if (probabilidad <= 95) {
			rango = 4;
		} 
		else{
			rango = 5;
		}
		return rango;
	}

	private String random_string(String stringPorAleatorizar) // genera nombre aleatorio a partir de String[]
	{
		Random rnd = new Random();
		String nombre_generado = null;
		String[] nombres = { "Rambo", "Rocky", "John Cena", "Luchin", "Vega", "Ryu", "Ken", "Goku", "Mario", "Luigi",
				"Putin", "Java", "Python", "Chapulin Colorado" };
		String[][] facciones = { { "Fuego", "Agua", "Planta" }, { "Agua", "Planta", "Fuego" },
				{ "Planta", "Fuego", "Agua" } }; // faccion, faccion desfavorable,faccion favorable
		if (stringPorAleatorizar.equals("nombres")) {
			nombre_generado = nombres[rnd.nextInt(nombres.length)];
		} else if (stringPorAleatorizar.equals("facciones")) {
			int indice;
			nombre_generado = facciones[indice = rnd.nextInt(facciones.length)][0];
			setFaccion_desfavorable(facciones[indice][1]);
			setFaccion_favorable(facciones[indice][2]);
		}
		return nombre_generado;
	}

	public Luchador() { // Constructor con estadisticas bases
		super(random_num(200, 500),random_num(20, 70),random_num(5, 25),random_num(10, 100),"");
		this.nombre = " ";
		random_estadisticas();
	}

	// ---- Setters and getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public ObjetoEquipable getObjeto() {
		return objeto;
	}

	public void setObjeto(ObjetoEquipable objeto) {
		this.objeto = objeto;
	}
	
	public double getRango() {
		return rango;
	}

	public void setRango(double rango) {
		this.rango = rango;
	}


	// ------ --------
	private void random_estadisticas() // Estadisticas aleatorias a partir del constructor con paramentros vacios
	{
		setNombre(random_string("nombres"));		
		setRango(probabilidad_rango());
		setHp(getHp() * getRango());
		setAtk(getAtk() * getRango());
		setDef(getDef() * getRango());
		setSpd(getSpd() * getRango());
		setFaccion(random_string("facciones"));

	}

	public String mostrar_estadisticas() { // Muestra estadisticas
		return("Nombre: " + getNombre() + "\tRango:" + getRango() + "\tHP:" + getHp() + "\tATK:" + getAtk()
				+ "\tDEF:" + getDef() + "\tSPD:" + getSpd() + "\tFaccion:" + getFaccion());

	}

	public void equipar_objeto() {
		setObjeto(new ObjetoEquipable());
		if(objeto.getHabilidad_mejorada()=="atk") {
			setAtk(getAtk()+objeto.getMejora());
		}
		else if(objeto.getHabilidad_mejorada()=="def") {
			setDef(getDef()+objeto.getMejora());
		}
		else if(objeto.getHabilidad_mejorada()=="spd") {
			setSpd(getSpd()+objeto.getMejora());
		}
		else if(objeto.getHabilidad_mejorada()=="hp") {
			setHp(getHp()+objeto.getMejora());
		}
		
	}
	
}
class orden implements Comparator<Luchador> {
    public int compare(Luchador l1, Luchador l2) {
        return (int) (l2.getSpd() - l1.getSpd());
    }
}