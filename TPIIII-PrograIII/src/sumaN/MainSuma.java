package sumaN;

import Implementaciones.Vector;
import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class MainSuma {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VectorTDA<Integer> s = new Vector<Integer>();
		int a = 8;
		s.inicializarVector(a);
		VectorTDA<Integer> v = new Vector<Integer>();
		v.inicializarVector(a);
		try {
			v.agregarElemento(0, 1);
			v.agregarElemento(1, 2);
			v.agregarElemento(2, 11);
			v.agregarElemento(3, 8);
			v.agregarElemento(4, 4);
			v.agregarElemento(5, 5);
			v.agregarElemento(6, 4);
			v.agregarElemento(7, 3);
			for (int i = 0; i < a; i++) {
				System.out.print(v.recuperarElemento(i) + ",");
			}
			System.out.println("");
			SumaN.Suma(13, v, s, 0);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}

}
