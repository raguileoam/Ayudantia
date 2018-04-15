package Ayudantia;

public class Personaje {
	private int hp;
	private int atk;
	private int def;
	private int spd;
	private String faccion;

	public Personaje() {
		super();
		this.hp = 1;
		this.atk = 1;
		this.def = 1;
		this.spd = 1;;
		this.faccion="";
	}

	public String getFaccion() {
		return faccion;
	}

	public void setFaccion(String faccion) {
		this.faccion = faccion;
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

	
}