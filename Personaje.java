package Ayudantia;

public class Personaje {
	private double hp;
	private double atk;
	private double def;
	private double spd;
	private String faccion;
	private String faccion_favorable;
	private String faccion_desfavorable;

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public double getAtk() {
		return atk;
	}

	public void setAtk(double atk) {
		this.atk = atk;
	}

	public double getDef() {
		return def;
	}

	public void setDef(double def) {
		this.def = def;
	}

	public double getSpd() {
		return spd;
	}

	public void setSpd(double spd) {
		this.spd = spd;
	}

	public String getFaccion() {
		return faccion;
	}

	public void setFaccion(String faccion) {
		this.faccion = faccion;
	}
	public String getFaccion_favorable() {
		return faccion_favorable;
	}

	public void setFaccion_favorable(String faccion_favorable) {
		this.faccion_favorable = faccion_favorable;
	}

	public String getFaccion_desfavorable() {
		return faccion_desfavorable;
	}

	public void setFaccion_desfavorable(String faccion_desfavorable) {
		this.faccion_desfavorable = faccion_desfavorable;
	}

	/**
	 * @param hp
	 * @param atk
	 * @param def
	 * @param spd
	 * @param faccion
	 */
	public Personaje(double hp, double atk, double def, double spd, String faccion) {
		super();
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.spd = spd;
		this.faccion = faccion;
	}

}
