package mochila;

import Implementaciones.Matriz;
import Implementaciones.Vector;
import TDA.MatrizTDA;
import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class MainMochila {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VectorTDA<Integer> peso = new Vector<Integer>();
		VectorTDA<Integer> valor = new Vector<Integer>();
		VectorTDA<Float> resultado2 = new Vector<Float>();
		MatrizTDA<Integer> m = new Matriz<Integer>();
		resultado2.inicializarVector(5);
		peso.inicializarVector(5);
		valor.inicializarVector(5);
		try {
			peso.agregarElemento(0, 1);
			peso.agregarElemento(1, 3);
			peso.agregarElemento(2, 4);
			peso.agregarElemento(3, 5);
			peso.agregarElemento(4, 9);
			valor.agregarElemento(0, 4);
			valor.agregarElemento(1, 3);
			valor.agregarElemento(2, 2);
			valor.agregarElemento(3, 1);
			valor.agregarElemento(4, 8);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			m = Metodo.mochila(peso, valor, 14);
			Metodo.imprimir(m, peso);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
