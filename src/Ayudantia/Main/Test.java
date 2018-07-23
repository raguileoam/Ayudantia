package Ayudantia.Main;

import Ayudantia.GUI.GUI_Ingreso;
import Ayudantia.GUI.GUI_Resultados;
import Ayudantia.Model.Character.Nombre_Personaje;

public class Test {

    public static void main(String[] args) {
        GUI_Ingreso f=new GUI_Ingreso();
        f.setVisible(true);
        
        Nombre_Personaje[] d = Nombre_Personaje.values();
        System.out.print(d[0]);
    }
}
