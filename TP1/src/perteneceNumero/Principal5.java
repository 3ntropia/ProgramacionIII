package perteneceNumero;

import Implementaciones.Vector;
import TDA.VectorTDA;

public class Principal5 {
	public static void main(String[] args) {
		int valor=10;
		boolean prueba;
		VectorTDA <Integer> nuevo=new Vector<Integer>();
		nuevo.inicializarVector(valor);
		for(int i=0;i<valor;i++){
			try {
				nuevo.agregarElemento(i, i);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		try {
			prueba=Pertenece.pertenece(nuevo, 0, valor-1, 11);
			if(prueba)
				System.out.println("El numero pertenece");
			else
				System.out.println("El numero no pertenece");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
