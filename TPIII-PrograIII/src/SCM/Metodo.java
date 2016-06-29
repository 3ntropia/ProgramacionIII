package SCM;

import Implementaciones.Matriz;
import TDA.MatrizTDA;
import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class Metodo {
	int secComunMax(VectorTDA<Integer> v1, VectorTDA<Integer> v2) throws Exception {
		MatrizTDA<Integer> m1 = new Matriz<Integer>();
		m1.inicializarMatriz(1 + max(v1.capacidadVector(), v2.capacidadVector()));
		for (int i = 0; i < v1.capacidadVector(); i++) {
			for (int j = 0; j < v2.capacidadVector(); j++) {
				if (i == 0 || j == 0) {
					m1.setearValor(i, j, 0);
				} else {
					if (v1.recuperarElemento(i - 1) == v2.recuperarElemento(i - 1)) {
						m1.setearValor(i, j, 1 + m1.obtenerValor(i - 1, j - 1));
					} else {
						m1.setearValor(i, j, max(m1.obtenerValor(i, j - 1), m1.obtenerValor(i - 1, j)));
					}
				}
			}
		}
		return m1.obtenerValor(v1.capacidadVector(), v2.capacidadVector());
	}

	private static int max(int a, int b) {
		if (a == b)
			return a;
		if (a > b)
			return a;
		else
			return b;
	}
}
