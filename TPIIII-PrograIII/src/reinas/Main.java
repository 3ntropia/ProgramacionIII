package reinas;

import Implementaciones.Vector;
import TDA.VectorTDA;

/**
 * 
 * @author martinh
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VectorTDA<Integer> solucion = new Vector<Integer>();
		solucion.inicializarVector(8);
		int a = 4;
		try {
			Reinas.reinas(a, solucion, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
