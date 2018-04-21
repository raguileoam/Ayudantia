package Ayudantia;

import Ayudantia.Luchador;

public class Dado {
	private int numero;
	private int cara;

	public int lanza_dado(int carita) {
		cara = carita;
		numero = Luchador.random_num(1, cara);
		return numero;
	}
	
	public Dado() {
		super();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCara() {
		return cara;
	}

	public void setCara(int cara) {
		this.cara = cara;
	}

}
