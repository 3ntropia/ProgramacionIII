package mochila;

import Implementaciones.ColaPrioridad;
import Implementaciones.Vector;
import TDA.ColaPrioridadTDA;
import TDA.VectorTDA;

/**
 * Problema de la Mochila: Se tienen n objetos y una mochila.
 * Para i = 1,2,..n, el objeto i tiene un peso positivo pi y un valor positivo vi.
 * La mochila puede llevar un peso que no sobrepase P. El objetivo es llenar la mochila
 * de tal manera que se maximice el valor de los objetos transportados, respetando la
 * limitación de capacidad impuesta. Los objetos pueden ser fraccionados, si una fracción xi (0 < xi < 1)
 * del objeto i es ubicada en la mochila contribuye en xi*pi al peso total de la mochila y en xi*vi al valor de la carga.
 * 
 * @author martinh
 *
 */
public class Mochila {
	public static VectorTDA<Float> resolver(VectorTDA<Integer> pesos, VectorTDA<Integer> valor, int p)
			throws Exception {
		VectorTDA<Float> S = new Vector<Float>();
		S.inicializarVector(pesos.capacidadVector());
		ColaPrioridadTDA<Integer> c = new ColaPrioridad<Integer>();
		int pesoAcumulado = 0, candidato;
		c.InicializarCola();
		for (int i = 0; i < pesos.capacidadVector(); i++)
			c.AgregarElemento(i, (float) valor.recuperarElemento(i) / pesos.recuperarElemento(i));
		while (!c.ColaVacia() && pesoAcumulado < p) {
			candidato = (int) c.RecuperarMaxPrioridad();
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
}
