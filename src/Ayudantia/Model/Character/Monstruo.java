package Ayudantia.Model.Character;

import Ayudantia.Model.Inventory.ObjetoEquipable;

public class Monstruo extends Personaje {

    private ObjetoEquipable[] objetoDropeable;

    public Monstruo() {
        super();
        crearMonstruo();
        crearObjetosDropeables();
        // TODO Auto-generated constructor stub
    }

    private void crearMonstruo() {
        setNombre("Monstruo");
        setHp(Luchador.random_num(3500, 4000)); // HP
        setAtk(Luchador.random_num(1000, 1500)); // ATK
        setDef(Luchador.random_num(5, 25)); // DEF
        setSpd(Luchador.random_num(10, 100)); // SPD
        ordenFaccion(); //Faccion
    }

    private void crearObjetosDropeables() {
        objetoDropeable = new ObjetoEquipable[3];
        objetoDropeable[0] = new ObjetoEquipable(1);
        objetoDropeable[1] = new ObjetoEquipable(3);
        objetoDropeable[2] = new ObjetoEquipable(5);
    }

    public ObjetoEquipable dropearObjeto() { //esto no deberia ir aqui...
        ObjetoEquipable objetoDropeado = objetoDropeable[probabilidadDropeo()];
        return objetoDropeado;
    }

    public ObjetoEquipable[] getObjetoDropeable() {
        return objetoDropeable;
    }

    public void mostrarObjetoDropeables() {
        for (ObjetoEquipable objetoDropeable1 : objetoDropeable) {
            System.out.println("Objeto Dropeable: " + objetoDropeable1.getNombre());
        }
    }

    private int probabilidadDropeo() {
        int indice_OD; //OD=objetoDropeable 
        int probabilidad = Luchador.random_num(0, 100);
        if (probabilidad <= 60) {
            indice_OD = 0;
        } else if (probabilidad <= 90) {
            indice_OD = 1;
        } else {
            indice_OD = 2;
        }
        return indice_OD;
    }

    public void setObjetoDropeable(ObjetoEquipable[] objetoDropeable) {
        this.objetoDropeable = objetoDropeable;
    }

    @Override
    public String toString() {
        return ("Monstruo \tHP:" + getHp() + "\tATK:" + getAtk()
                + "\tDEF:" + getDef() + "\tSPD:" + getSpd() + "\tFaccion:" + getFaccion());
    }

}
