package Ayudantia.Model.Character;

import Ayudantia.Model.Inventory.ObjetoEquipable;
import java.util.Random;

public class Luchador extends Personaje {

    public static int random_num(int min, int max) { // Metodo estatico que genera numero aleatorio
        int num_generado = (int) (Math.random() * ((max - min) + 1) + min);
        return num_generado;
    }

    private ObjetoEquipable objeto;
    private double rango;

    public Luchador() { // Constructor con estadisticas bases
        super();
        this.hp = random_num(200, 500);
        this.atk = random_num(20, 70);
        this.def = random_num(5, 25);
        this.spd = random_num(10, 100);
        this.rango = 0;
        this.nombre = " ";
        random_estadisticas();
    }

    public void equipar_objeto() {
        setObjeto(new ObjetoEquipable());
        if (null != objeto.getHabilidad_mejorada()) {
            switch (objeto.getHabilidad_mejorada()) {
                case "atk":
                    setAtk(getAtk() + objeto.getMejora());
                    break;
                case "def":
                    setDef(getDef() + objeto.getMejora());
                    break;
                case "spd":
                    setSpd(getSpd() + objeto.getMejora());
                    break;
                case "hp":
                    setHp(getHp() + objeto.getMejora());
                    break;
                default:
                    break;
            }
        }
    }

    public ObjetoEquipable getObjeto() {
        return objeto;
    }

    public double getRango() {
        return rango;
    }

    @Override
    public String toString() { // Muestra estadisticas
        return (getNombre() + "  Rango:" + getRango() + "  HP:" + getHp() + "  ATK:" + getAtk()
                + "  DEF:" + getDef() + "  SPD:" + getSpd() + "  Faccion:" + getFaccion());
    }

    private void probabilidad_rango() { // Devuelve numero aleatorio segun probabilidad
        int probabilidad = random_num(0, 100);
        if (probabilidad <= 40) {
            rango = 1;
        } else if (probabilidad <= 70) {
            rango = 2;
        } else if (probabilidad <= 85) {
            rango = 3;
        } else if (probabilidad <= 95) {
            rango = 4;
        } else {
            rango = 5;
        }
    }

    private void random_estadisticas() { // Estadisticas aleatorias a partir del constructor con paramentros vacios
        setNombre(randomNombre());
        probabilidad_rango();
        setHp(getHp() * getRango());
        setAtk(getAtk() * getRango());
        setDef(getDef() * getRango());
        setSpd(getSpd() * getRango());
        ordenFaccion();
    }

    private String randomNombre() { // genera nombre aleatorio a partir de String[]
        Nombre_Personaje[] nombres=Nombre_Personaje.values();
        String nombre_generado = nombres[new Random().nextInt(nombres.length)].name();
        return nombre_generado;
    }

    public void setObjeto(ObjetoEquipable objeto) {
        this.objeto = objeto;
    }

    public void setRango(double rango) {
        this.rango = rango;
    }
}
