package Ayudantia;

public class Monstruo{ 
	private int hp;
	private int atk;
	private int def;
	private int spd;
	private String faccion;
	private ObjetoEquipable objetoDropeable;
	
	public Monstruo() {
		super();
		crearMonstruo();
		crearObjetoDropeable();
		// TODO Auto-generated constructor stub
	}

	private void crearMonstruo() {
		setHp(Luchador.random_num(3500, 4000)); //HP
		setAtk(Luchador.random_num(1000, 1500)); //ATK
		setDef(Luchador.random_num(5, 25)); //DEF
		setSpd(Luchador.random_num(10, 100)); //SPD
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
	private void crearObjetoDropeable() {
		objetoDropeable=new ObjetoEquipable();	
	}
	public void mostrarObjetoDropeable() {
		System.out.println("Objeto Dropeable: " + objetoDropeable.getNombre());
	}
	
}
