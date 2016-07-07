package indiceN;

import TDA.VectorTDA;

/**
 * Sea A[1..n], n >= 1, un vector de enteros diferentes y ordenados crecientemente, 
 * tal que algunos de los valores pueden ser negativos. Diseñar un algoritmo que devuelva un 
 * índice natural k, 1<= k <= n, tal que A[k] = k, siempre que tal índice exista. 
 * 
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
