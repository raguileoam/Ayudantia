package Ayudantia.Model.Util;

import Ayudantia.Model.Character.Luchador;

public class Dado {

    private int cara;
    private int numero;

    public Dado() {
        super();
    }

    public int getCara() {
        return cara;
    }

    public int getNumero() {
        return numero;
    }

    public int lanza_dado(int carita) {
        cara = carita;
        numero = Luchador.random_num(1, cara);
        return numero;
    }

    public void setCara(int cara) {
        this.cara = cara;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
