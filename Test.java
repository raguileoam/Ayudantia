package Ayudantia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Test {
	public static void main(String[] args) {
		//Batalla batallon=new Batalla();
		//batallon.ataque();
		//batallon.resultado();
		  ArrayList<Integer> al = new ArrayList<Integer>();

		    al.add(1);
		    al.add(2);
		    al.add(1,3);
		    Iterator<Integer> itr = al.iterator();
		    while (itr.hasNext()) {
		      int element = itr.next();
		      System.out.print(element + " ");
		    }
		    System.out.println();


	}
}
