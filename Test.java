package Ayudantia;

public class Test {
	public static void main(String[] args) {
		Batalla batallon=new Batalla();
		batallon.ataque();
		batallon.resultado();
		System.out.println(batallon.getMonstro().getAtk());
		
	}
}
