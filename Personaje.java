package Ayudantia;
import java.util.Random;

public class Personaje {
	protected String nombre;
	protected double atk;
	protected double def;
	protected String faccion;
	protected String faccion_desfavorable;
	protected String faccion_favorable;
	protected double hp;
	protected double spd;
	
	public Personaje() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getAtk() {
		return atk;
	}
	public double getDef() {
		return def;
	}
	public String getFaccion() {
		return faccion;
	}
	public String getFaccion_desfavorable() {
		return faccion_desfavorable;
	}
	public String getFaccion_favorable() {
		return faccion_favorable;
	}
	public double getHp() {
		return hp;
	}
	public double getSpd() {
		return spd;
	}
	public void setAtk(double atk) {
		this.atk = atk;
	}
	public void setDef(double def) {
		this.def = def;
	}
	public void setFaccion(String faccion) {
		this.faccion = faccion;
	}
	public void setFaccion_desfavorable(String faccion_desfavorable) {
		this.faccion_desfavorable = faccion_desfavorable;
	}
	public void setFaccion_favorable(String faccion_favorable) {
		this.faccion_favorable = faccion_favorable;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public void setSpd(double spd) {
		this.spd = spd;
	}
	public void ordenFaccion() {
		String[][] facciones = {{ "Agua","Fuego","Planta" },{ "Fuego",  "Planta","Agua" }, 
				{ "Planta","Agua","Fuego" }};
		int indice= new Random().nextInt(3);
		setFaccion(facciones[indice][0]);
		setFaccion_favorable(facciones[indice][1]);
		setFaccion_desfavorable(facciones[indice][2]);
	}
	
}

