package Ayudantia;

import java.util.Random;

public class Monstruo {
	private double hp;
	private double atk;
	private double def;
	private int spd;
	private String faccion;
	private ObjetoEquipable[] objetoDropeable;
	private String faccion_favorable;
	private String faccion_desfavorable;

	public Monstruo() {
		super();
		crearMonstruo();
		crearObjetosDropeables();
		// TODO Auto-generated constructor stub
	}

	private void crearMonstruo() {
		int indice;
		Random rnd = new Random();
		String[][] facciones = { { "Fuego", "Agua", "Planta" }, { "Agua", "Planta", "Fuego" },
				{ "Planta", "Fuego", "Agua" } }; // faccion, faccion desfavorable,faccion favorable
		setHp(Luchador.random_num(3500, 4000)); // HP
		setAtk(Luchador.random_num(1000, 1500)); // ATK
		setDef(Luchador.random_num(5, 25)); // DEF
		setSpd(Luchador.random_num(10, 100)); // SPD
		setFaccion(facciones[indice = rnd.nextInt(facciones.length)][0]);
		setFaccion_desfavorable(facciones[indice][1]);
		setFaccion_favorable(facciones[indice][2]);
	}

	public ObjetoEquipable[] getObjetoDropeable() {
		return objetoDropeable;
	}

	public void setObjetoDropeable(ObjetoEquipable[] objetoDropeable) {
		this.objetoDropeable = objetoDropeable;
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

	public String getFaccion() {
		return faccion;
	}

	public void setFaccion(String faccion) {
		this.faccion = faccion;
	}

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

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	private void crearObjetosDropeables() {
		objetoDropeable[0] = new ObjetoEquipable(1);
		objetoDropeable[1] = new ObjetoEquipable(3);
		objetoDropeable[0] = new ObjetoEquipable(5);
	}

	public void mostrarObjetoDropeables() {
		for (int i = 0; i < objetoDropeable.length; i++) {
			System.out.println("Objeto Dropeable: " + objetoDropeable[i].getNombre());
		}
	}

}
