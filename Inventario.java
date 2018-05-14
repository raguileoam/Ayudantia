package Ayudantia;

import java.util.ArrayList;

public class Inventario {
private int cantMax;
private ArrayList<Object> clase;

public Inventario(int maxCant, ArrayList<Object> clase) {
	super();
	this.cantMax = maxCant;
	this.clase = clase;
}
public void add() {
	if (clase.size() <= this.cantMax) { 
		clase.add(new Object());
	} 
	else {
		System.out.println("Se ha sobrepasado el limite");
	}
}
public int cantidadActual() {
	return this.clase.size();
	}
public void del(int indice) {
	if (indice < cantidadActual()) {
		clase.remove(indice - 1);
	} else {
		System.out.println("Se ha sobrepasado del tamaño actual del inventario");
	}
	
}

public int getCantMax() {
	return cantMax;
}
public ArrayList<Object> getClase() {
	return clase;
}
public void setCantMax(int cantMax) {
	this.cantMax = cantMax;
}
public void setClase(ArrayList<Object> clase) {
	this.clase = clase;
}
public void mostrar_clases() {
	for (Object cosa:getClase()) {
		System.out.println(cosa.toString());
	}
}

}
