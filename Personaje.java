package Ayudantia;

public class Personaje {
	private String nombre;
	private int hp;
	private int atk;
	private int def;
	private int spd;
	private int rango;

	public Personaje() {
		super();
		this.nombre = "";
		this.hp = 1;
		this.atk = 1;
		this.def = 1;
		this.spd = 1;
		this.rango=1;
	}

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

	
}