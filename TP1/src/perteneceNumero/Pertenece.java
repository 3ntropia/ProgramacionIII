package perteneceNumero;

import TDA.VectorTDA;

/**
 * Dado un vector de n números naturales ordenados crecientemente, determinar si un número x  dado pertenece al vector.
 * @author martinh
 *
 */
public class Pertenece {
	public static boolean pertenece(VectorTDA<Integer> v, int inicio, int fin, int numero) throws Exception {
		boolean control = false;
		if (inicio == fin) {
			if (v.recuperarElemento(inicio) == numero)
				return control = true;
		} else {
			int mitad = (fin + inicio) / 2;
			if (numero <= v.recuperarElemento(mitad))
				return pertenece(v, inicio, mitad, numero);
			else
				return pertenece(v, mitad + 1, fin, numero);
		}
		return control;
	}
}
