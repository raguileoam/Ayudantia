package Ayudantia;

public class Batalla {
	private InventarioLuchadores luchones;
	private Monstruo monstro;
	private double da�o_luchadores;
	private double da�o_monstruo;
	private boolean end;

	public Batalla() {
		super();
		luchones = new InventarioLuchadores();
		monstro = new Monstruo();
		random_num_luchadores();
		caso_faccion_luchadores();
		caso_faccion_montruo();
		casos_da�o();
		end = false;
	}

	private int dados() {
		Dado dadito4 = new Dado();
		Dado dadito8 = new Dado();
		dadito4.lanza_dado(4);
		dadito8.lanza_dado(6);
		int valor = dadito8.getNumero() - dadito4.getNumero();
		return valor;
	}

	private void casos_da�o() {
		int valor = dados();
		if (valor > 0) {
			da�o_luchadores = da�o_luchadores * valor;
		} else if (valor == 0) {
		} else if (valor < 0) {
			da�o_monstruo = da�o_monstruo * Math.abs(valor);
		}
	}

	private void random_num_luchadores() {
		int num_luchadores = Ayudantia.Luchador.random_num(0, 5); // En el caso luchador v/s montruo de tarea5 se pueden
																	// de 1 a 6 luchadores, como 1 se crea
																	// automaticamente el max es 5 y el min 0
		for (int i = 0; i <= num_luchadores; i++) {
			luchones.agregarLuchador();
		}
	}

	public void setDa�o_luchadores(int indice_luchador) {
		this.da�o_luchadores = luchones.getLuchadores().get(indice_luchador).getAtk() - monstro.getDef();
		casos_da�o();
		if (da�o_luchadores < 0) {
			da�o_luchadores = 0;
		}
	}

	public void setDa�o_monstruo(int indice_luchador) {
		this.da�o_monstruo = monstro.getAtk() - luchones.getLuchadores().get(indice_luchador).getDef();
		casos_da�o();
		if (da�o_monstruo < 0) {
			da�o_monstruo = 0;
		}
	}

	public double getDa�o_monstruo() {
		return da�o_monstruo;
	}

	public double getDa�o_luchadores() {
		return da�o_luchadores;
	}

	public void caso_faccion_luchadores() {
		for (int indice_luchadores = 0; indice_luchadores < luchones.getMax_luchadores(); indice_luchadores++) {
			if (luchones.getLuchadores().get(indice_luchadores).getFaccion()
					.equals(monstro.getFaccion_desfavorable())) {
				luchones.getLuchadores().get(indice_luchadores)
						.setAtk(luchones.getLuchadores().get(indice_luchadores).getAtk() * 1.5); // favorable para
																									// luchador
			} else if (luchones.getLuchadores().get(indice_luchadores).getFaccion()
					.equals(monstro.getFaccion_favorable())) {
				luchones.getLuchadores().get(indice_luchadores)
						.setAtk(luchones.getLuchadores().get(indice_luchadores).getAtk() * 0.75); // desfavorable para
																									// luchador
			}
		}
	}

	public void caso_faccion_montruo() {
		for (int indice_luchadores = 0; indice_luchadores < luchones.getMax_luchadores(); indice_luchadores++) {
			if (monstro.getFaccion()
					.equals(luchones.getLuchadores().get(indice_luchadores).getFaccion_desfavorable())) {
				monstro.setAtk(monstro.getAtk() * 1.5); // favorable para monstruo
			} else if (monstro.getFaccion()
					.equals(luchones.getLuchadores().get(indice_luchadores).getFaccion_favorable())) {
				monstro.setAtk(monstro.getAtk() * 0.75); // desfavorable para monstruo
			}
		}
	}

	public void ataque() {
		while (end == false) {
			for (int i = 0; i < luchones.getMax_luchadores(); i++) {
				if (luchones.getLuchadores().get(i).getSpd() > monstro.getSpd()) {
					setDa�o_luchadores(i);
					monstro.setHp(monstro.getHp() - getDa�o_luchadores());
					if (monstro.getHp() > 0) {
						setDa�o_monstruo(i);
						luchones.getLuchadores().get(i)
								.setHp(luchones.getLuchadores().get(i).getHp() - getDa�o_monstruo());
					} else {
						end = true;
						break;
					}
				} else {
					setDa�o_monstruo(i);
					luchones.getLuchadores().get(i).setHp(luchones.getLuchadores().get(i).getHp() - getDa�o_monstruo());
					if (luchones.getLuchadores().get(i).getHp() > 0) {
						setDa�o_luchadores(i);
						monstro.setHp(monstro.getHp() - getDa�o_luchadores());
					} else {
						luchones.getLuchadores().remove(i);
						i = i - 1;
						if (luchones.getLuchadores().size() == 0) {
							end = true;
							break;
						}
					}
				}
			}
		}
	}

}
