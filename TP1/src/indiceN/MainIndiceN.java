package indiceN;

import Implementaciones.Vector;
import TDA.VectorTDA;

public class MainIndiceN {

	
	public static void main(String[] args) {
		VectorTDA <Integer>vec=new Vector<Integer>();
		vec.inicializarVector(50);
		for(int i=0;i<50;i++)
		{
			try {
				vec.agregarElemento(i, i+1);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}
		try {
			vec.agregarElemento(20, 20);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		try {
			int a=Metodo.indiceNatural(vec, 0, 50);
			System.out.print(a);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
