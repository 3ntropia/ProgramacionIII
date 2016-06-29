package ordenamiento;

import Implementaciones.Vector;
import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class Mergesort {
	public static void ordenar(VectorTDA<Integer> v, int inicio, int fin) throws Exception {
		if (fin > inicio) {
			int mitad = (inicio + fin) / 2;
			ordenar(v, inicio, mitad);// separo la primera parte (dividir)
			ordenar(v, mitad + 1, fin);// separa la segunda parte (dividir)
			mezclar(v, inicio, mitad + 1, fin);// resolver
		}
	}

	private static void mezclar(VectorTDA<Integer> v, int inicioI, int inicioD, int finD) throws Exception {

		int finI = inicioD - 1, numElementos = finD - inicioI + 1, pos = inicioI;
		VectorTDA<Integer> aux = new Vector<Integer>();
		aux.inicializarVector(finD + 1);
		while (inicioI <= finI && inicioD <= finD) {
			if (v.recuperarElemento(inicioI) < v.recuperarElemento(inicioD))
				aux.agregarElemento(pos++, v.recuperarElemento(inicioI++));
			else
				aux.agregarElemento(pos++, v.recuperarElemento(inicioD++));
		}

		while (inicioI <= finI)
			aux.agregarElemento(pos++, v.recuperarElemento(inicioI++));

		while (inicioD <= finD)
			aux.agregarElemento(pos++, v.recuperarElemento(inicioD++));

		for (int i = 0; i < numElementos; i++, finD--)
			v.agregarElemento(finD, aux.recuperarElemento(finD));
	}
}
