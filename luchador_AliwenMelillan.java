package Ayudantia;
import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;
public class luchador_AliwenMelillan
{
	private String nombre;
	private int HP;
	private int ATK;
	private int DEF;
	private int SPD;
	private int rango;
	private String fraccion;
	String[] nombres = { "Rambo", "Rocky", "John Cena", "Luchin", "Vega", "Ryu", "Ken", "Goku", "Mario", "Luigi",
			"Putin", "Java", "Python", "Chapolin Colorado" };
	String[] fracciones = { "Fuego", "Agua", "Tierra" };
	
	public static void main (String[] args) throws ArrayIndexOutOfBoundsException
	{
	 int op=0;
	 Scanner sc=new Scanner(System.in);
	 luchador_AliwenMelillan luchin_1 = new luchador_AliwenMelillan();

	 do{
		 try {
			 System.out.println("------------------------------------------------------------");
			 System.out.println("1) Aleatorizar estadisticas 2) Mostrar estadisticas 0) Salir");
			 op=sc.nextInt();

			 switch(op) 
			 {
			 case 1: 	 luchin_1.random_estadisticas(); 
			 System.out.println("Luchador con estadisticas randomizadas");break;
			 case 2: 	 luchin_1.mostrar_estadisticas(); break;
			 }
		 }
		 catch(ArrayIndexOutOfBoundsException e) {
			 System.out.println("Error, intentelo nuevamente");
		 }
	 }
		 while (op!=0);
	}
	
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
	}

	public luchador_AliwenMelillan(String nombre, int rango, int hP, int aTK, int dEF, int sPD, String fraccion) {
		super();
		this.nombre = nombre;
		this.rango = rango;
		HP = hP;
		ATK = aTK;
		DEF = dEF;
		SPD = sPD;
		this.fraccion = fraccion;
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
