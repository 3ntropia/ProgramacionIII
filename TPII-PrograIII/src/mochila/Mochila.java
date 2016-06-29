package mochila;

import Implementaciones.ColaPrioridad;
import Implementaciones.Vector;
import TDA.ColaPrioridadTDA;
import TDA.VectorTDA;

/**
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
