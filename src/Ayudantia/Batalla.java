package Ayudantia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Batalla {

    private boolean end;
    private final Monstruo monstro;
    private final InventarioLuchadores luchones;
    private final double ef_dados;
    private int turno;

    public Batalla() {
        this.monstro = new Monstruo();
        this.luchones = new InventarioLuchadores();
        crearLuchadores();
        this.ef_dados = dados();
        this.turno = 0;
        System.out.println(estado());
    }

    private void crearLuchadores() {
        int num = new Random().nextInt(6); //Se crea uno automaticamente
        for (int i = 0; i < num; i++) { //OJO el num luchadores no es lo mismo que el indice del luchador, si el numluchadores es 0 no (se deberia) se crean luchadores
            luchones.agregarLuchador();
        }
    }

    public String estado() {
        String resultado = String.format("+----------+\n%s\n%s\n+----------+", luchones.mostrarLuchadores(), monstro);
        return resultado;
    }

    private double dados() {
        Dado dadito4 = new Dado();
        Dado dadito8 = new Dado();
        dadito4.lanza_dado(4);
        dadito8.lanza_dado(6);
        double valor = dadito8.getNumero() - dadito4.getNumero();
        if (valor > 0) {
            System.out.println("El daño que hagan tus personajes se multiplicará por " + valor);
        } else if (valor < 0) {
            System.out.println("El daño que le hagan a tus personajes se multiplicará por " + Math.abs(valor));
        } else {
            System.out.println("No hay bonificación de daño ");
        }
        return valor;
    }

    private double caso_dados(Personaje atacante) {
        double valor;
        if (atacante instanceof Luchador && ef_dados > 0) {
            valor = ef_dados;
        } else if (atacante instanceof Monstruo && ef_dados < 0) {
            valor = Math.abs(ef_dados);
        } else {
            valor = 1;
        }
        return valor;
    }

    private double caso_faccion(Personaje a, Personaje b) {
        double ef_faccion = 1;
        if (a.getFaccion().equals(b.getFaccion_desfavorable())) {
            ef_faccion = 1.50;

        } else if (a.getFaccion().equals(b.getFaccion_favorable())) {
            ef_faccion = 0.75;
        }
        return ef_faccion;
    }

    public void ataque(Personaje atacante, Personaje atacado) {
        double daño;
        if (atacante.getHp() > 0 && atacado.getHp() > 0) {
            daño = atacante.getAtk() * caso_faccion(atacante, atacado) - atacado.getDef();

            daño = daño * caso_dados(atacante);
            if (daño < 0) {
                System.out.println("No hay daño");
            } else {
                System.out.println(atacante.getNombre() + " ha atacado a " + atacado.getNombre() + " dañandolo en " + daño);
                atacado.setHp(atacado.getHp() - daño);
                if (atacado.getHp() < 0) {
                    atacado.setHp(0);
                }
            }
        }
    }

    public boolean isEnd() {
        if (isDead_luchadores() || monstro.getHp() <= 0) {
            end = true;
        }
        return end;
    }

    private boolean isDead_luchadores() {
        boolean boleano = true;
        for (int i = 0; i < luchones.cantidadLuchadores(); i++) {
            boleano = boleano && luchones.getLuchadores().get(i).getHp() <= 0;
        }
        return boleano;
    }

    public void turno() {
        turno += 1;
        for (int ordenSPD = 0; ordenSPD < luchones.cantidadLuchadores() + 1; ordenSPD++) {
            for (int indice = 0; indice < luchones.cantidadLuchadores(); indice++) {
                if (indiceSPD(luchones.getLuchadores().get(indice)) == ordenSPD) {
                    ataque(luchones.getLuchadores().get(indice), monstro);
                    break;
                } else if (indiceSPD(monstro) == ordenSPD) {
                    if (luchones.getLuchadores().get(indice).getHp() > 0) {
                        ataque(monstro, luchones.getLuchadores().get(indice));
                        break;
                    }
                }
            }
        }
    }

    public int indiceSPD(Personaje s) {
        ArrayList<Personaje> spdd;
        spdd = new ArrayList<>();
        spdd.addAll(luchones.getLuchadores());
        spdd.add(monstro);
        spdd.sort(Comparator.comparing(Personaje::getSpd).reversed());
        return spdd.indexOf(s);
    }

    public void combate() {
        while (!isEnd()) {
            System.out.println("Turno " + (turno + 1));
            turno();
            System.out.println(estado());
        }
    }

    public String resultado() {
        String res;
        res = "------FINAL------\n";
        if (monstro.getHp() <= 0) {
            res += ("Ganaron los luchadores");

        } else if (isDead_luchadores()) {
            res += ("Gano monstruo"); //Si ocurre esto no apareceran los hp de los luchadores porque se borraron por comodidad en el metodo ataque

        }
        res += "\n" + estado();
        return res;

    }
}
