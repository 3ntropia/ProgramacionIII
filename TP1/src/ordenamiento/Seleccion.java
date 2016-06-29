package ordenamiento;

import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class Seleccion {
	static public void ordenar(VectorTDA<Integer> v, int fin) throws Exception {
		int ind = 0;
		for (int a = 0; a < fin; a++) {
			int b = a, menor = v.recuperarElemento(a);
			while (b < fin) {
				if (v.recuperarElemento(b) <= menor) {
					ind = b;
					menor = v.recuperarElemento(b);
				}
				b++;
			}
			int aux = v.recuperarElemento(a);
			v.agregarElemento(a, menor);
			v.agregarElemento(ind, aux);
		}
	}

}
