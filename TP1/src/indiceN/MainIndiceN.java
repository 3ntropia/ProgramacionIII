package indiceN;

import Implementaciones.Vector;
import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class MainIndiceN {

	public static void main(String[] args) {
		try {
			VectorTDA<Integer> vec = new Vector<Integer>();
			vec.inicializarVector(50);
			for (int i = 0; i < 50; i++) {
				vec.agregarElemento(i, i + 1);
			}
			vec.agregarElemento(20, 20);
			int a = Metodo.indiceNatural(vec, 0, 50);
			System.out.print(a);
		} catch (

		Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
