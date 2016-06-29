package sumaN;

import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class SumaN {
	public static void Suma(int n, VectorTDA<Integer> v, VectorTDA<Integer> s, int nivel) throws Exception {
		for (int i = 0; i < 2; i++) {
			s.agregarElemento(nivel, i);
			if (nivel + 1 == v.capacidadVector() && sumaV(v, s, nivel) == n) {
				mostrar(v, s);
			} else {
				if (nivel + 1 < v.capacidadVector() && sumaV(v, s, nivel) <= n) {
					Suma(n, v, s, nivel + 1);
				}
			}
		}
	}

	private static int sumaV(VectorTDA<Integer> v, VectorTDA<Integer> s, int nivel) throws Exception {
		int suma = 0;
		for (int i = 0; i < nivel + 1; i++) {
			if (s.recuperarElemento(i) == 0) {
				suma += v.recuperarElemento(i);
			}
		}
		return suma;
	}

	private static void mostrar(VectorTDA<Integer> v, VectorTDA<Integer> s) throws Exception {
		for (int i = 0; i < s.capacidadVector(); i++) {
			System.out.print(s.recuperarElemento(i) + ",");
		}
		System.out.println("");

	}
}
