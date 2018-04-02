package Ayudantia;
public class luchador_AliwenMelillan
{
	private String nombre;
	private int HP;
	private int ATK;
	private int DEF;
	private int SPD;
	private int rango;
	private String fraccion;
	private objetoEquipable objeto;
	
	public String[] nombres = { "Rambo", "Rocky", "John Cena", "Luchin", "Vega", "Ryu", "Ken", "Goku", "Mario", "Luigi",
			"Putin", "Java", "Python", "Chapolin Colorado" };
	public String[] fracciones = { "Fuego", "Agua", "Tierra" };
	
	public static int random_num(int min, int max) {
		int num_generado = (int) (Math.random() * ((max - min) + 1) + min);

		return num_generado;
	}

	public static int probabilidad_rango() {
		int probabilidad = random_num(0, 100);
		int rango = 0;
		if (probabilidad <= 40) {
			rango = 1;
		} else if (probabilidad <= 70) {
			rango = 2;
		} else if (probabilidad <= 85) {
			rango = 3;
		} else if (probabilidad <= 95) {
			rango = 4;
		} else if (probabilidad <= 100) {
			rango = 5;
		}
		return rango;
	}

	public static String random_nombre(String[] nombres)
	{
		int i = random_num(0, nombres.length);
		String nombre_generado = nombres[i];
		return nombre_generado;
	}

	public luchador_AliwenMelillan(){
		this.nombre = " ";
		rango = 0;
		HP = random_num(200, 500);
		ATK = random_num(20, 70);
		DEF = random_num(5, 25);
		SPD = random_num(10, 100);
		fraccion = "";
		this.objeto=new objetoEquipable();;
	}

	public luchador_AliwenMelillan(String nombre, int hP, int aTK, int dEF, int sPD, int rango, String fraccion,
			objetoEquipable objeto) {
		super();
		this.nombre = nombre;
		HP = hP;
		ATK = aTK;
		DEF = dEF;
		SPD = sPD;
		this.rango = rango;
		this.fraccion = fraccion;
		this.objeto = objeto;
	}


	public objetoEquipable getObjeto() {
		return objeto;
	}

	public void setObjeto(objetoEquipable objeto) {
		this.objeto = objeto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getATK() {
		return ATK;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}

	public int getDEF() {
		return DEF;
	}

	public void setDEF(int dEF) {
		DEF = dEF;
	}

	public int getSPD() {
		return SPD;
	}

	public void setSPD(int sPD) {
		SPD = sPD;
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public String getFraccion() {
		return fraccion;
	}

	public void setFraccion(String fraccion) {
		this.fraccion = fraccion;
	}

	public void random_estadisticas()
	{
		setNombre(random_nombre(nombres));
		setRango(probabilidad_rango());
		setHP(getHP() * getRango());
		setATK(getATK() * getRango());
		setDEF(getDEF() * getRango());
		setSPD(getSPD() * getRango());
		setFraccion(random_nombre(fracciones));

	}

	public void mostrar_estadisticas() {
		System.out.println("Nombre: " + getNombre());
		System.out.println("Rango:" + getRango());
		System.out.println("HP:" + getHP());
		System.out.println("ATK:" + getATK());
		System.out.println("DEF:" + getDEF());
		System.out.println("SPD:" + getSPD());
		System.out.println("Fraccion:" + getFraccion());
	}
}
