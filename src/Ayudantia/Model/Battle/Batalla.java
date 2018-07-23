package Ayudantia.Model.Battle;

import Ayudantia.Model.Inventory.InventarioLuchadores;
import Ayudantia.Model.Character.Luchador;
import Ayudantia.Model.Character.Monstruo;
import Ayudantia.Model.Character.Personaje;
import Ayudantia.Model.Util.Dado;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Batalla {
    private boolean end;
    private final Monstruo monstro;
    private final InventarioLuchadores luchadores;
    private ArrayList<Luchador> seleccionados;
    private final double ef_dados;
    private int turno;
    
    public ArrayList<Luchador> getSeleccionados() {
        return seleccionados;
    }

    public void setSeleccionados(ArrayList<Luchador> seleccionados) {
        this.seleccionados = seleccionados;
    }

    public Batalla() {
        this.monstro = new Monstruo();
        this.luchadores = new InventarioLuchadores();
        this.seleccionados=new ArrayList<>();
        this.ef_dados = dados();
        this.turno = 0;
    }
  
    public String estado() {
        String resultado = String.format("+----------+\n%s\n%s\n+----------+", luchadores.mostrarLuchadores(), monstro);
        return resultado;
    }

    private double dados() {
        Dado dadito4 = new Dado();
        Dado dadito8 = new Dado();
        dadito4.lanza_dado(4);
        dadito8.lanza_dado(6);
        double valor = dadito8.getNumero() - dadito4.getNumero();
        return valor;
    }

    public String estado_dados(double valor) {
        String estado;
        if (valor > 0) {
            estado = ("El daño que hagan tus personajes se multiplicara por " + valor);
        } else if (valor < 0) {
            estado = ("El daño que le hagan a tus personajes se multiplicara por " + Math.abs(valor));
        } else {
            estado = ("No hay bonificacion");
        }
        return estado;
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

    private String ataque(Personaje atacante, Personaje atacado) {
        double daño;
        String estado = "";
        if (atacante.getHp() > 0 && atacado.getHp() > 0) {
            daño = atacante.getAtk() * caso_faccion(atacante, atacado) - atacado.getDef();

            daño = daño * caso_dados(atacante);
            if (daño < 0) {
                estado = String.format("No hay daño de %s hacia %s",atacante.getNombre(),atacado.getNombre());
            } else {
                estado = (atacante.getNombre() + " ha atacado a " + atacado.getNombre() + " dañandolo en " + daño);
                atacado.setHp(atacado.getHp() - daño);
                if (atacado.getHp() < 0) {
                    atacado.setHp(0);
                }
            }
        }
        return estado;
    }

    public boolean isEnd() {
        if (isDead_luchadores() || monstro.getHp() <= 0) {
            end = true;
        }
        return end;
    }

    private boolean isDead_luchadores() {
        boolean boleano = true;
        for (int i = 0; i < luchadores.cantidadLuchadores(); i++) {
            boleano = boleano && luchadores.getLuchadores().get(i).getHp() <= 0;
        }
        return boleano;
    }

    public String turno() {
        turno += 1;
        String estado = "Turno " + turno+"\n";
        for (int ordenSPD = 0; ordenSPD < luchadores.cantidadLuchadores() + 1; ordenSPD++) {
            for (int indice = 0; indice < luchadores.cantidadLuchadores(); indice++) {
                if (indiceSPD(luchadores.getLuchadores().get(indice)) == ordenSPD) {
                    if (luchadores.getLuchadores().get(indice).getHp() > 0) {
                    estado+=ataque(luchadores.getLuchadores().get(indice), monstro)+"\n";
                    break;
                     }
                } else if (indiceSPD(monstro) == ordenSPD) {
                    if (luchadores.getLuchadores().get(indice).getHp() > 0) {
                        estado+=ataque(monstro, luchadores.getLuchadores().get(indice))+"\n";
                        break;
                    }    
                }
            }
        }
        return estado;
    }

    public int indiceSPD(Personaje s) {
        ArrayList<Personaje> spdd;
        spdd = new ArrayList<>();
        spdd.addAll(luchadores.getLuchadores());
        spdd.add(monstro);
        spdd.sort(Comparator.comparing(Personaje::getSpd).reversed());
        return spdd.indexOf(s);
    }

    public String combate() {
        String estado=estado_dados(ef_dados)+"\n";
        while (!isEnd()) {
            estado+=estado()+"\n"+turno()+"\n";
        }
        estado+=resultado()+"\n"+estado()+"\n";
        return estado;
    }

    public String resultado() {
        String res;
        res = "\t~\tFINAL\t~\t\n";
        if (monstro.getHp() <= 0) {
            res += ("\t~\tHUMANS\t~\t\n");

        } else if (isDead_luchadores()) {
            res += ("\t\tMONSTER\t\t\n"); //Si ocurre esto no apareceran los hp de los luchadores porque se borraron por comodidad en el metodo ataque

        }
        res+=("\t~\tWINS\t~\t\n");
        return res;

    }

    public Monstruo getMonstro() {
        return monstro;
    }

    public InventarioLuchadores getLuchadores() {
        return luchadores;
    }

    public double getEf_dados() {
        return ef_dados;
    }

    public int getTurno() {
        return turno;
    }
    
}
