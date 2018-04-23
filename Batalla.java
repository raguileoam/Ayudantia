package Ayudantia;

public class Batalla {
	private InventarioLuchadores luchones;
	private Monstruo monstro;
	private double daño_luchadores;
	private double daño_monstruo;
	private boolean end;

	public Batalla() {
		super();
		luchones = new InventarioLuchadores();
		monstro = new Monstruo();
		random_num_luchadores();
		caso_faccion_luchadores();
		caso_faccion_montruo();
		casos_daño();
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

	private void casos_daño() {
		int valor = dados();
		if (valor > 0) {
			daño_luchadores = daño_luchadores * valor;
		} else if (valor < 0) {
			daño_monstruo = daño_monstruo * Math.abs(valor);
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

	public void setDaño_luchadores(int indice_luchador) {
		this.daño_luchadores = luchones.getLuchadores().get(indice_luchador).getAtk() - monstro.getDef();
		casos_daño();
		if (daño_luchadores < 0) {
			daño_luchadores = 0;
		}
	}

	public void setDaño_monstruo(int indice_luchador) {
		this.daño_monstruo = monstro.getAtk() - luchones.getLuchadores().get(indice_luchador).getDef();
		casos_daño();
		if (daño_monstruo < 0) {
			daño_monstruo = 0;
		}
	}

	public double getDaño_monstruo() {
		return daño_monstruo;
	}

	public double getDaño_luchadores() {
		return daño_luchadores;
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
		setDaño_luchadores(i);
		monstro.setHp(monstro.getHp() - getDaño_luchadores());
		System.out.println("Vida monstruo: "+monstro.getHp());
	}
	public void turno_monstruo(int i){
		setDaño_monstruo(i);
		luchones.getLuchadores().get(i).setHp(luchones.getLuchadores().get(i).getHp() - getDaño_monstruo());
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
		System.out.println("luchador n° "+ luchones.getLuchadores().get(index).getNombre() +": HP " +luchones.getLuchadores().get(index).getHp());
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