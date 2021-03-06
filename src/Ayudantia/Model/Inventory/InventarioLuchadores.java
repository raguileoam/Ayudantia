package Ayudantia.Model.Inventory;

import Ayudantia.Model.Character.Luchador;
import java.util.ArrayList;

public class InventarioLuchadores {

    protected ArrayList<Luchador> luchadores;
    protected int max_luchadores;

    public InventarioLuchadores() { // Constructor que inicializa la lista de luchadores
        luchadores = new ArrayList<>();
        max_luchadores = 25;
        // I.L tiene que tener de 1 a 25 luchadores
        agregarLuchador();
    }

    public void agregarLuchador() { // Agrega luchador secuencialmente
        if (isComplete()) { // Limite de luchadores=25
            luchadores.add(new Luchador());
        } else {
            System.out.println("Se ha sobrepasado el limite");
        }
    }
    public void agregarLuchador(Luchador luchador) { // Agrega luchador secuencialmente
        if (luchadores.size() < max_luchadores) { // Limite de luchadores=25
            luchadores.add(luchador);
        } else {
            System.out.println("Se ha sobrepasado el limite");
        }
    }
    public boolean isComplete(){
    return luchadores.size() < max_luchadores;
    }

    public int cantidadLuchadores() {
        return luchadores.size();
    }

    public void eliminarLuchador(int indice) { // Elimina luchador segun su indice [1,...]
        if (indice < luchadores.size()) {
            luchadores.remove(indice - 1);
        } else {
            System.out.println("Se ha sobrepasado del tamaño actual del inventario");
        }
    }

    public void filtro_faccion(String faccion) { // Muestra los luchadores con cierta faccion
        if ("Agua".equals(faccion) || "Fuego".equals(faccion) || "Tierra".equals(faccion)) {
            for (int i = 0; i < luchadores.size(); i++) {
                if (luchadores.get(i).getFaccion().equals(faccion)) {
                    System.out.println(faccion + ": " + luchadores.get(i).getNombre());
                }
            }
        } else {
            System.out.println("La faccion no se encuentra");
        }
    }

    public void filtro_rango(int rango) {
        if (0 < rango && rango < 5) {
            for (int i = 0; i < luchadores.size(); i++) {
                if (luchadores.get(i).getRango() == rango) {
                    System.out.println(rango + ": " + luchadores.get(i).getNombre());
                }
            }
        } else {
            System.out.println("El rango no se encuentra");
        }
    }

    public ArrayList<Luchador> getLuchadores() {
        return luchadores;
    }

    public int getMax_luchadores() {
        return max_luchadores;
    }

    public String mostrarLuchador(int indice) { // Muestra el luchador segun indice
        String resultado;
        if (indice > luchadores.size()) {
            resultado = "El luchador no existe";
        } else {
            resultado = "Luchador " + luchadores.get(indice).toString();
        }
        return resultado;
    }

    public String mostrarLuchadores() { // Muestra todos los luchados con su nombre,faccion y rango       
        String mostrar = "";
        for (Luchador luchador : getLuchadores()) {
            mostrar += luchador.toString();
            mostrar += "\n";
        }
        return mostrar;
    }

    public void setLuchadores(ArrayList<Luchador> luchadores) {
        this.luchadores = luchadores;
    }

    public void setMax_luchadores(int max_luchadores) {
        this.max_luchadores = max_luchadores;
    }
}
