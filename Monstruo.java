package Ayudantia;

import java.util.Random;

public class Monstruo extends Personaje{
	private ObjetoEquipable[] objetoDropeable;

	public Monstruo() {
		super(0,0,0,0,"");
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

	private void crearObjetosDropeables() {
		objetoDropeable=new ObjetoEquipable[3];
		objetoDropeable[0] = new ObjetoEquipable(1);
		objetoDropeable[1] = new ObjetoEquipable(3);
		objetoDropeable[2] = new ObjetoEquipable(5);
	}

	public void mostrarObjetoDropeables() {
		for (int i = 0; i < objetoDropeable.length; i++) {
			System.out.println("Objeto Dropeable: " + objetoDropeable[i].getNombre());
		}
	}
	public ObjetoEquipable dropearObjeto() { //esto no deberia ir aqui...
		ObjetoEquipable objetoDropeado=objetoDropeable[probabilidadDropeo()];
		return objetoDropeado;
	}
	private int probabilidadDropeo() {
		int indice_OD=0; //OD=objetoDropeable 
		int probabilidad = Luchador.random_num(0, 100);
		if (probabilidad<=60) {
			indice_OD=0;
		}
		else if(probabilidad<=90){
			indice_OD=1;
		}
		else {
			indice_OD=2;
		}
		return indice_OD;
	}
	public String toString() {
		return("Monstruo \tHP:" + getHp() + "\tATK:" + getAtk()
		+ "\tDEF:" + getDef() + "\tSPD:" + getSpd() + "\tFaccion:" + getFaccion());
	}

}
