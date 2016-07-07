package alfabeticamente;

import TDA.VectorTDA;

/**
 * Determinar si una secuencia de n caracteres está ordenada alfabéticamente.
 * @author martinh
 *
 */
public class Verificar {
	public static boolean ordenados(VectorTDA<Integer> v, int inicio, int fin) throws Exception {
		boolean control = true;
		if (fin == inicio)
			return control;
		else {

			if (v.recuperarElemento(inicio) <= v.recuperarElemento(fin)) {
				int mitad = (inicio + fin) / 2;
				control = ordenados(v, inicio, mitad);
				control = ordenados(v, mitad + 1, fin);
			} else
				return control = false;
		}
		return control;

	}
}
