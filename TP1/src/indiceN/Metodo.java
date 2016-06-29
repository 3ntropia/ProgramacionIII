package indiceN;

import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class Metodo {
	public static int indiceNatural(VectorTDA<Integer> vec, int pos, int tam) throws Exception {
		if (vec.recuperarElemento(pos) == pos) {
			return pos;
		} else {
			int mitad = (pos + tam) / 2;
			indiceNatural(vec, pos, mitad);
			indiceNatural(vec, mitad + 1, tam);
		}
		return pos;
		// return tam;

	}
}
