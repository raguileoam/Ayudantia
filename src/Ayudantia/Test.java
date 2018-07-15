package Ayudantia;

public class Test {

    public static void main(String[] args) {
        Batalla d = new Batalla();
        System.out.println(d.combate());
        GUI_Resultados f=new GUI_Resultados();
        f.setVisible(true);

    }
}
