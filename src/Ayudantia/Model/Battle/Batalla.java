package Ayudantia.Model.Battle;

import Ayudantia.Model.Inventory.InventarioLuchadores;
import Ayudantia.Model.Character.Luchador;
import Ayudantia.Model.Character.Monstruo;
import Ayudantia.Model.Character.Personaje;
import Ayudantia.Model.Inventory.Luchadores_Seleccionados;
import Ayudantia.Model.Util.Dado;
import java.util.ArrayList;
import java.util.Comparator;

public class Batalla {
    private boolean end;
    private final Monstruo monstro;
    private Luchadores_Seleccionados seleccionados;
    private InventarioLuchadores luchadores;
    private final double ef_dados;
    private int turno;
    
   

    public Batalla() {
        this.monstro = new Monstruo();
        this.seleccionados = new Luchadores_Seleccionados();
        this.luchadores=new InventarioLuchadores();;
        this.ef_dados = dados();
        this.turno = 0;
}

    public InventarioLuchadores getLuchadores() {
        return luchadores;
    }

    public void setLuchadores(InventarioLuchadores luchadores) {
        this.luchadores = luchadores;
    }
    
  
    public String estado() {
        String resultado = String.format("+----------+\n%s\n%s\n+----------+", seleccionados.mostrarLuchadores(), monstro);
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
            estado = ("El da�o que hagan tus personajes se multiplicara por " + valor);
        } else if (valor < 0) {
            estado = ("El da�o que le hagan a tus personajes se multiplicara por " + Math.abs(valor));
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
        double da�o;
        String estado = "";
        if (atacante.getHp() > 0 && atacado.getHp() > 0) {
            da�o = atacante.getAtk() * caso_faccion(atacante, atacado) - atacado.getDef();

            da�o = da�o * caso_dados(atacante);
            if (da�o < 0) {
                estado = String.format("No hay da�o de %s hacia %s",atacante.getNombre(),atacado.getNombre());
            } else {
                estado = (atacante.getNombre() + " ha atacado a " + atacado.getNombre() + " da�andolo en " + da�o);
                atacado.setHp(atacado.getHp() - da�o);
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
        for (int i = 0; i < seleccionados.cantidadLuchadores(); i++) {
            boleano = boleano && seleccionados.getLuchadores().get(i).getHp() <= 0;
        }
        return boleano;
    }

    public String turno() {
        turno += 1;
        String estado = "Turno " + turno+"\n";
        for (int ordenSPD = 0; ordenSPD < seleccionados.cantidadLuchadores() + 1; ordenSPD++) {
            for (int indice = 0; indice < seleccionados.cantidadLuchadores(); indice++) {
                if (indiceSPD(seleccionados.getLuchadores().get(indice)) == ordenSPD) {
                    if (seleccionados.getLuchadores().get(indice).getHp() > 0) {
                    estado+=ataque(seleccionados.getLuchadores().get(indice), monstro)+"\n";
                    break;
                     }
                } else if (indiceSPD(monstro) == ordenSPD) {
                    if (seleccionados.getLuchadores().get(indice).getHp() > 0) {
                        estado+=ataque(monstro, seleccionados.getLuchadores().get(indice))+"\n";
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
        spdd.addAll(seleccionados.getLuchadores());
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
            res += ("\t\tMONSTER\t\t\n"); //Si ocurre esto no apareceran los hp de los seleccionados porque se borraron por comodidad en el metodo ataque

        }
        res+=("\t~\tWINS\t~\t\n");
        return res;

    }

    public Monstruo getMonstro() {
        return monstro;
    }

    public InventarioLuchadores getSeleccionados() {
        return seleccionados;
    }

    public double getEf_dados() {
        return ef_dados;
    }

    public int getTurno() {
        return turno;
    }
    
}
