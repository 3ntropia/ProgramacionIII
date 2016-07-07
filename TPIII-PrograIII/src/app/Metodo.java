package app;

import Implementaciones.Matriz;
import Implementaciones.Vector;
import TDA.MatrizTDA;
import TDA.VectorTDA;

/**
 * Caminos mínimos entre todas las ciudades. Dado un conjunto de n ciudades de una región y la distancia entre cada
 * par de ciudades vecinas si es que existe (ciudades unidas por una ruta directa sin ciudades intermedias),
 * encontrar el costo del camino mínimo entre cada par de ellas.  
 * 
 * @author martinh
 *
 */
public class Metodo {
	public static MatrizTDA<Integer> minCambio(VectorTDA<Integer> denominacion, int n) throws Exception {
		MatrizTDA<Integer> resultado = new Matriz<Integer>();
		resultado.inicializarMatriz(max(denominacion.capacidadVector(), n + 1));
		for (int i = 0; i < denominacion.capacidadVector(); i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j < denominacion.recuperarElemento(i)) {
					resultado.setearValor(i, j, 0);
				} else {
					if (i == 0) {
						resultado.setearValor(i, j, 1 + resultado.obtenerValor(i, j - 1));
					} else {
						if (j < denominacion.recuperarElemento(i)) {
							resultado.setearValor(i, j, resultado.obtenerValor(i - 1, j));
						} else {
							resultado.setearValor(i, j, min(resultado.obtenerValor(i - 1, j),
									1 + resultado.obtenerValor(i, j - denominacion.recuperarElemento(i))));
						}
					}
				}
			}
		}
		return resultado;
	}

	public static VectorTDA<Integer> monedas(MatrizTDA<Integer> m, VectorTDA<Integer> denominacion, int n)
			throws Exception {
		VectorTDA<Integer> r = new Vector<Integer>();
		r.inicializarVector(denominacion.capacidadVector());
		int cambio = m.obtenerValor(denominacion.capacidadVector(), n), a = 0, i = denominacion.capacidadVector() - 1,
				j = n;
		while (cambio > 0 && i >= 0 && j >= 0) {
			if (m.obtenerValor(i - 1, j) < 1 + m.obtenerValor(i, j - denominacion.recuperarElemento(i))) {
				r.agregarElemento(a++, denominacion.recuperarElemento(i - 1));
				i--;
			} else {
				r.agregarElemento(a++, denominacion.recuperarElemento(i));
				j -= denominacion.recuperarElemento(i);
			}
		}
		return r;
	}

	public static int max(int a, int b) {
		if (a == b) {
			return a;
		}
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	public static int min(int a, int b) {
		if (a == b) {
			return a;
		}
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}
}
