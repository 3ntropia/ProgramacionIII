package mochila;

import Implementaciones.ColaPrioridad;
import Implementaciones.Matriz;
import Implementaciones.Vector;
import TDA.ColaPrioridadTDA;
import TDA.MatrizTDA;
import TDA.VectorTDA;

/**
 * Problema de la Mochila: Se tienen n objetos y una mochila. Para i = 1, 2,..n, el objeto i tiene un peso positivo
 * pi y un valor positivo vi. La mochila puede llevar un peso que no sobrepase P. Los objetos no pueden ser fraccionados.
 * El objetivo es llenar la mochila de manera tal que se maximice el valor de los objetos transportados,
 * respetando la limitación de capacidad impuesta. El algoritmo debe determinar el valor máximo que se podrá cargar. 
 * 
 * @author martinh
 *
 */
public class Metodo {
	public static MatrizTDA<Integer> mochila(VectorTDA<Integer> peso, VectorTDA<Integer> valor, int capacidad)
			throws Exception {

		MatrizTDA<Integer> m = new Matriz<Integer>();
		int i, j;
		m.inicializarMatriz(max((peso.capacidadVector()), capacidad + 1));
		if (capacidad == 0) {
			return m;
		} else {
			for (i = 0; i < peso.capacidadVector(); i++) {
				for (j = 0; j < capacidad + 1; j++) {
					// llenar la primer columna con 0
					if (i == 0 && j < peso.recuperarElemento(i))
						m.setearValor(i, j, 0);
					else {
						if (i == 0 && j >= peso.recuperarElemento(i)) {
							m.setearValor(i, j, valor.recuperarElemento(i));
						} else {
							if (i > 0 && j < peso.recuperarElemento(i)) {
								m.setearValor(i, j, m.obtenerValor(i - 1, j));
							} else {
								m.setearValor(i, j,
										max(valor.recuperarElemento(i)
												+ m.obtenerValor(i, j - peso.recuperarElemento(i)),
												m.obtenerValor(i - 1, j)));
							}
						}
					}
				}
			}
		}
		// int valorM=m.obtenerValor(peso.capacidadVector()-1,capacidad);
		// imprimir(m,peso);
		return m;
	}

	private static int max(int a, int b) {
		if (a == b)
			return a;
		if (a > b)
			return a;
		else
			return b;
	}

	public static VectorTDA<Float> resolver(VectorTDA<Integer> pesos, VectorTDA<Integer> valor, int p)
			throws Exception {
		/*
		 * esto seria en la forma greedy
		 * 
		 */
		VectorTDA<Float> S = new Vector<Float>();
		S.inicializarVector(pesos.capacidadVector());
		ColaPrioridadTDA<Integer> c = new ColaPrioridad<Integer>();
		int pesoAcumulado = 0, candidato;
		c.InicializarCola();
		for (int i = 0; i < pesos.capacidadVector(); i++) {
			c.AgregarElemento(i, (float) valor.recuperarElemento(i) / pesos.recuperarElemento(i));
		}
		while (!c.ColaVacia() && pesoAcumulado < p) {
			candidato = c.RecuperarMaxElemento();

			if (p - pesoAcumulado > pesos.recuperarElemento(candidato)) {
				S.agregarElemento(candidato, (float) 1);
				pesoAcumulado += pesos.recuperarElemento(candidato);
			} else {
				S.agregarElemento(candidato, (float) (p - pesoAcumulado) / (pesos.recuperarElemento(candidato)));
				pesoAcumulado += (float) (p - pesoAcumulado) / (pesos.recuperarElemento(candidato));
			}
			c.EliminarMaxPrioridad();
		}
		return S;
	}

	public static VectorTDA<Integer> elementos(MatrizTDA<Integer> m, VectorTDA<Integer> peso, VectorTDA<Integer> valor,
			int n) throws Exception {
		VectorTDA<Integer> resultado = new Vector<Integer>();
		int j = n - 1, i = peso.capacidadVector() - 1, a = 0;
		while (n > 0 && i >= 0 && j >= 0) {
			if (m.obtenerValor(i - 1,
					j) < (valor.recuperarElemento(i) + m.obtenerValor(i, j - peso.recuperarElemento(i)))) {
				resultado.agregarElemento(a++, i);
				j -= -peso.recuperarElemento(i);
				n -= peso.recuperarElemento(i);
			} else {
				resultado.agregarElemento(a++, i - 1);
				i--;
				n -= peso.recuperarElemento(i);
			}
		}
		return resultado;
	}

	public static void imprimir(MatrizTDA<Integer> a, VectorTDA<Integer> peso) throws Exception {

		for (int j = 0; j < a.obtenerDimension(); j++) {
			System.out.print(j + " ");
		}
		System.out.print("\n");
		for (int i = 0; i < a.obtenerDimension(); i++) {
			System.out.print(peso.recuperarElemento(i) + " ");
			for (int j = 0; j < a.obtenerDimension(); j++) {
				System.out.print(a.obtenerValor(i, j) + " ");
			}
			System.out.print("\n");
		}
	}
}