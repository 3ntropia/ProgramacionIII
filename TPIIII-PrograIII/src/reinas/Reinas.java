package reinas;

import Implementaciones.Matriz;
import TDA.MatrizTDA;
import TDA.VectorTDA;

/**
 * Ocho reinas: Construir un algoritmo que ubique ocho reinas en un tablero de ajedrez de
 * modo tal queno se puedan capturar entre sí
 * 
 * @author martinh
 *
 */
public class Reinas {
	public static void reinas(int n, VectorTDA<Integer> s, int nivel) throws Exception {
		for (int i = 0; i < n; i++) {
			s.agregarElemento(nivel, i);
			if (valido(s, nivel)) {
				if (nivel + 1 == n) {
					mostrar(s);
				} else {
					reinas(n, s, nivel + 1);
				}
			}
		}
	}

	private static boolean valido(VectorTDA<Integer> s, int i) throws Exception {
		for (int j = 0; j < i; j++) {
			if (s.recuperarElemento(i) == s.recuperarElemento(j)) {
				return false;
			}
		}
		for (int j = 0; j < i; j++) {
			if (Math.abs(s.recuperarElemento(i) - s.recuperarElemento(j)) == Math.abs(i - j)) {
				return false;
			}
		}
		return true;
	}

	private static void mostrar(VectorTDA<Integer> s) throws Exception {
		MatrizTDA<Integer> aux = new Matriz<Integer>();
		aux.inicializarMatriz(s.capacidadVector());
		for (int i = 0; i < s.capacidadVector(); i++) {
			/*
			 * if(i==0) { System.out.print("__"); }
			 */
			for (int j = 0; j < s.capacidadVector(); j++) {

				if (j == s.recuperarElemento(i)) {
					// System.out.print("|x ");
					aux.setearValor(j, i, 1);
				} else {
					aux.setearValor(j, i, 0);
					// System.out.print("| ");
				}

			}
			// System.out.print("\n");
		}
		for (int i = 0; i < s.capacidadVector(); i++) {
			if (i == 0) {
				System.out.print("__");
			}
			for (int j = 0; j < s.capacidadVector(); j++) {
				if (aux.obtenerValor(i, j) != 0) {
					System.out.print("|x ");
				} else {
					System.out.print("| ");
				}
			}
			System.out.print("\n");
		}

	}

}
