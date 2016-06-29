package app;

import Implementaciones.Matriz;
import Implementaciones.Vector;
import TDA.MatrizTDA;
import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VectorTDA<Integer> v1 = new Vector<Integer>();
		VectorTDA<Integer> v2 = new Vector<Integer>();
		MatrizTDA<Integer> m = new Matriz<Integer>();

		v1.inicializarVector(3);
		try {
			v1.agregarElemento(0, 1);
			v1.agregarElemento(1, 4);
			v1.agregarElemento(2, 8);
			m = Metodo.minCambio(v1, 8);
			v2 = Metodo.monedas(m, v1, 8);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
