package Ayudantia;
import java.util.Random;
public class Luchador
{
	private String nombre;
	private int hp;
	private int atk;
	private int def;
	private int spd;
	private int rango;
	private String faccion;
	//private ObjetoEquipable objeto;
	
	public static int random_num(int min, int max) { //Metodo estatico que genera numero aleatorio
		int num_generado = (int) (Math.random() * ((max - min) + 1) + min);

		return num_generado;
	}

	private int probabilidad_rango() { //Devuelve numero aleatorio segun probabilidad
		int probabilidad = random_num(0, 100);
		int rango = 0;
		if (probabilidad <= 40) {
			rango = 1;
		} else if (probabilidad <= 70) {
			rango = 2;
		} else if (probabilidad <= 85) {
			rango = 3;
		} else if (probabilidad <= 95) {
			rango = 4;
		} else if (probabilidad <= 100) {
			rango = 5;
		}
		return rango;
	}

	private String random_string(String stringPorAleatorizar) //genera nombre aleatorio a partir de String[]
	{
		Random rnd=new Random();
		String nombre_generado = null;
		String[] nombres = { "Rambo", "Rocky", "John Cena", "Luchin", "Vega", "Ryu", "Ken", "Goku", "Mario", "Luigi",
				"Putin", "Java", "Python", "Chapulin Colorado" };
		String[] facciones = { "Fuego", "Agua", "Tierra" };
		if (stringPorAleatorizar.equals("nombres")) {
			nombre_generado=nombres[rnd.nextInt(nombres.length)];
		}
		else if (stringPorAleatorizar.equals("facciones")) {
			nombre_generado=facciones[rnd.nextInt(facciones.length)];
		}
		return nombre_generado;
	}

	public Luchador(){ //Constructor con estadisticas bases
		this.nombre = " ";
		rango = 0;
		hp = random_num(200, 500);
		atk = random_num(20, 70);
		def = random_num(5, 25);
		spd = random_num(10, 100);
		faccion = "";
		random_estadisticas();
	}
	
	// ---- Setters and getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public String getFaccion() {
		return faccion;
	}

	public void setFaccion(String faccion) {
		this.faccion = faccion;
	}

	/*public ObjetoEquipable getObjeto() {
		return objeto;
	}

	public void setObjeto(ObjetoEquipable objeto) {
		this.objeto = objeto;
	}
*/
	//------         --------
	private void random_estadisticas() //Estadisticas aleatorias a partir del constructor con paramentros vacios
	{
		setNombre(random_string("nombres"));
		setRango(probabilidad_rango());
		setHp(getHp() * getRango());
		setAtk(getAtk() * getRango());
		setDef(getDef() * getRango());
		setSpd(getSpd() * getRango());
		setFaccion(random_string("facciones"));
		
	}
	
	public void mostrar_estadisticas() { //Muestra estadisticas
		System.out.println("Nombre: " + getNombre() 
				+"\nRango:" + getRango()
				+ "\nHP:" + getHp() 
				+"\nATK:" + getAtk()
				+"\nDEF:" + getDef()
				+"\nSPD:" + getSpd()
				+"\nFaccion:" + getFaccion());
		
	}
	//Tarea 5 Objeto

}
