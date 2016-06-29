package ordenamiento;

import Implementaciones.Vector;
import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class Quicksort {
	public static void ordenar(VectorTDA<Integer> v, int inicio, int tam) throws Exception {
		if (tam > inicio) {
			int pivot = (int) (tam + inicio) / 2;
			pivotear(v, inicio, tam, pivot);
			ordenar(v, inicio, pivot - 1);
			ordenar(v, pivot + 1, tam);
		}
	}

	public static void pivotear(VectorTDA<Integer> v, int inicio, int tam, int pivot) throws Exception {
		VectorTDA<Integer> vAux = new Vector<Integer>();
		vAux.inicializarVector(tam);
		vAux.agregarElemento(inicio, v.recuperarElemento(pivot));
		for (int i = inicio; i < pivot; i++) {
			if (v.recuperarElemento(i) > v.recuperarElemento(pivot)) {
				int aux = v.recuperarElemento(i);
				for (int j = i; j < pivot; j++) {
					v.agregarElemento(j, v.recuperarElemento(j + 1));
				}
				v.agregarElemento(pivot--, aux);
			}
		}
		for (int i = pivot + 1; i < tam; i++) {
			if (v.recuperarElemento(i) < v.recuperarElemento(pivot)) {
				int aux = v.recuperarElemento(i);
				for (int j = i; j > pivot; j++) {
					v.agregarElemento(j, v.recuperarElemento(j - 1));
				}
				v.agregarElemento(pivot++, aux);
			}
		}
	}

}