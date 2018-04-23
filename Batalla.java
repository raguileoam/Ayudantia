package Ayudantia;

public class Batalla {
	private InventarioLuchadores luchones;
	private Monstruo monstro;
	private double multi_daño;
	private double daño_luchadores;
	private double daño_monstruo;
	private boolean end;
	public Batalla() {
		super();
		luchones = new InventarioLuchadores();
		monstro = new Monstruo();
		random_num_luchadores();
		estado();
		multi_daño=dados();
		caso_faccion_luchadores();
		caso_faccion_montruo();
		end =false;
	}
	public boolean luchadores_muertos(){
		boolean boleano = true;
		for (int i=0;i<luchones.cantidadLuchadores();i++) {
		boleano= boleano && luchones.getLuchadores().get(i).getHp()<=0;
	}
		return boleano;
	}
	public boolean end() {
		if(luchadores_muertos() || monstro.getHp()<0) {
			end=true;
		}
		return end;
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
	public void setDaño_luchadores(int indice_luchador) {
	
		this.daño_luchadores = (luchones.getLuchadores().get(indice_luchador).getAtk() - monstro.getDef());
		if (daño_luchadores < 0) {
			daño_luchadores = 0;
		}
		
	}

	public void setDaño_monstruo(int indice_luchador) {
		this.daño_monstruo = (monstro.getAtk() - luchones.getLuchadores().get(indice_luchador).getDef());
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
	
	private void random_num_luchadores() {
		int num_luchadores = Ayudantia.Luchador.random_num(0, 5); // En el caso luchador v/s montruo de tarea5 se pueden de 1 a 6 luchadores, como 1 se crea automaticamente el max es 5 y el min 0
		for (int i = 0; i < num_luchadores; i++) { //OJO el num luchadores no es lo mismo que el indice del luchador, si el numluchadores es 0 no (se deberia) se crean luchadores
			luchones.agregarLuchador();
			
		}
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
		if (multi_daño > 0) {
			daño_luchadores=daño_luchadores*multi_daño;
		} else if (multi_daño < 0) {
			daño_monstruo=daño_monstruo*Math.abs(multi_daño);
		} 
	}

	public void caso_faccion_luchadores() {
		for (int i= 0; i < luchones.cantidadLuchadores(); i++) {
			if (luchones.getLuchadores().get(i).getFaccion().equals(monstro.getFaccion_desfavorable())) {
				luchones.getLuchadores().get(i).setAtk(luchones.getLuchadores().get(i).getAtk() * 1.5); // favorable para luchador
			} else if (luchones.getLuchadores().get(i).getFaccion().equals(monstro.getFaccion_favorable())) {
				luchones.getLuchadores().get(i).setAtk(luchones.getLuchadores().get(i).getAtk() * 0.75); // desfavorable para luchador
			}
		}
	}

	public void caso_faccion_montruo() {
		for (int indice_luchadores = 0; indice_luchadores < luchones.cantidadLuchadores(); indice_luchadores++) {
			if (monstro.getFaccion().equals(luchones.getLuchadores().get(indice_luchadores).getFaccion_desfavorable())) {
				monstro.setAtk(monstro.getAtk() * 1.5); // favorable para monstruo
			} else if (monstro.getFaccion().equals(luchones.getLuchadores().get(indice_luchadores).getFaccion_favorable())) {
				monstro.setAtk(monstro.getAtk() * 0.75); // desfavorable para monstruo
			}
		}
	}
	public void turno_luchador(int i) {
		if (luchones.getLuchadores().get(i).getHp() > 0 && monstro.getHp()>0) {		
			setDaño_luchadores(i);
			casos_daño();
			String luchador = luchones.getLuchadores().get(i).getNombre();
			double vida = monstro.getHp() - getDaño_luchadores();
			monstro.setHp(vida);
			System.out.println(luchador + " ataca " + daño_luchadores);
			if(monstro.getHp()<0) {
				monstro.setHp(0);
			}
			System.out.println("Vida monstruo: " + monstro.getHp());
		}
	
	}
	
	public void turno_monstruo(int i){
		if(monstro.getHp()>0 && luchones.getLuchadores().get(i).getHp() > 0) {
		setDaño_monstruo(i);
		casos_daño();
		double vida=luchones.getLuchadores().get(i).getHp() - getDaño_monstruo();
		luchones.getLuchadores().get(i).setHp(vida);
		System.out.println("Monstruo ataca "+getDaño_monstruo() );
		if(luchones.getLuchadores().get(i).getHp()<0) {
			luchones.getLuchadores().get(i).setHp(0);
		}
		System.out.println("Vida luchador " + luchones.getLuchadores().get(i).getNombre() +": "+luchones.getLuchadores().get(i).getHp());
		}
	}
	                      
	public void ataque() {
		while (end==false) {
			for (int i = 0; i < luchones.cantidadLuchadores(); i++) {
				if (luchones.getLuchadores().get(i).getSpd() > monstro.getSpd()) {
						turno_luchador(i);
						turno_monstruo(i);

				} else {
					turno_monstruo(i);
					turno_luchador(i);

				}
			}
			end();
		}
	}

	public void resultado() {
		if(monstro.getHp()<=0) {
			//monstro.setHp(0);
			System.out.println("------\nGanaron los luchadores");		
		}else if(luchadores_muertos()) {
			System.out.println("-----\nGano monstruo"); //Si ocurre esto no apareceran los hp de los luchadores porque se borraron por comodidad en el metodo ataque
		}
		estado();

	}
	public void estado() {
		System.out.println("----------");
		for (int index=0;index<luchones.cantidadLuchadores();index++) {
		System.out.println("luchador "+ luchones.getLuchadores().get(index).getNombre() +": HP " +luchones.getLuchadores().get(index).getHp());
		}
		System.out.println(monstro.toString());
		System.out.println("----------");
	}
}