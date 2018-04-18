package Ayudantia;

public class Monstruo extends Personaje{ //nombre,hp,atk,def,spd,rango + setters and getters desde clase Personaje
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
	private void crearObjetoDropeable() {
		objetoDropeable=new ObjetoEquipable();	
	}
	public void mostrarObjetoDropeable() {
		System.out.println("Objeto Dropeable: " + objetoDropeable.getNombre());
	}
	
}
