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
		} else if (valor < 0) {
			da�o_monstruo = da�o_monstruo * Math.abs(valor);
		}
	}

	private void random_num_luchadores() {
		int num_luchadores = Ayudantia.Luchador.random_num(0, 5); // En el caso luchador v/s montruo de tarea5 se pueden
																	// de 1 a 6 luchadores, como 1 se crea
  															// automaticamente el max es 5 y el min 0
		for (int i = 0; i < num_luchadores; i++) { //OJO el num luchadores no es lo mismo que el indice del luchador, si el numluchadores es 0 no (se deberia) se crean luchadores
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
		for (int indice_luchadores = 0; indice_luchadores < luchones.cantidadLuchadores(); indice_luchadores++) {
			if (luchones.getLuchadores().get(indice_luchadores).getFaccion().equals(monstro.getFaccion_desfavorable())) {
				luchones.getLuchadores().get(indice_luchadores).setAtk(luchones.getLuchadores().get(indice_luchadores).getAtk() * 1.5); // favorable para// luchador
			} else if (luchones.getLuchadores().get(indice_luchadores).getFaccion().equals(monstro.getFaccion_favorable())) {
				luchones.getLuchadores().get(indice_luchadores)
						.setAtk(luchones.getLuchadores().get(indice_luchadores).getAtk() * 0.75); // desfavorable para
																									// luchador
			}
		}
	}

	public void caso_faccion_montruo() {
		for (int indice_luchadores = 0; indice_luchadores < luchones.cantidadLuchadores(); indice_luchadores++) {
			if (monstro.getFaccion()
					.equals(luchones.getLuchadores().get(indice_luchadores).getFaccion_desfavorable())) {
				monstro.setAtk(monstro.getAtk() * 1.5); // favorable para monstruo
			} else if (monstro.getFaccion()
					.equals(luchones.getLuchadores().get(indice_luchadores).getFaccion_favorable())) {
				monstro.setAtk(monstro.getAtk() * 0.75); // desfavorable para monstruo
			}
		}
	}
	public void turno_luchador(int i) {
		setDa�o_luchadores(i);
		monstro.setHp(monstro.getHp() - getDa�o_luchadores());
		System.out.println("Vida monstruo: "+monstro.getHp());
	}
	public void turno_monstruo(int i){
		setDa�o_monstruo(i);
		luchones.getLuchadores().get(i).setHp(luchones.getLuchadores().get(i).getHp() - getDa�o_monstruo());
		System.out.println("Vida luchador" + (i+1) +": "+luchones.getLuchadores().get(i).getHp());
	}

	public void ataque() {
		while (end == false) {
			for (int i = 0; i < luchones.cantidadLuchadores(); i++) {
				if (luchones.getLuchadores().get(i).getSpd() > monstro.getSpd()) {
					turno_luchador(i);
					if (monstro.getHp() > 0) {
						turno_monstruo(i);
					} else {
						end = true;
						break;
					}
				} else {
					turno_monstruo(i);
					if (luchones.getLuchadores().get(i).getHp() > 0) {
						turno_luchador(i);
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
	public void resultado() {
		if(monstro.getHp()<=0) {
			//monstro.setHp(0);
			System.out.println("Ganaron los luchadores");
			
		}
		else {
			System.out.println("Gano monstruo"); //Si ocurre esto no apareceran los hp de los luchadores porque se borraron por comodidad en el metodo ataque
		}
		for (int index=0;index<luchones.cantidadLuchadores();index++) {
		System.out.println("luchador n� "+ luchones.getLuchadores().get(index).getNombre() +": HP " +luchones.getLuchadores().get(index).getHp());
		}
		System.out.println(monstro.toString());
	}

	public InventarioLuchadores getLuchones() {
		return luchones;
	}

	public Monstruo getMonstro() {
		return monstro;
	}

	public void setLuchones(InventarioLuchadores luchones) {
		this.luchones = luchones;
	}

	public void setMonstro(Monstruo monstro) {
		this.monstro = monstro;
	}
}