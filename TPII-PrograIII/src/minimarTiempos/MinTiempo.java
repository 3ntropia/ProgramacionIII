package minimarTiempos;

import Implementaciones.ColaPrioridad;
import Implementaciones.Vector;
import TDA.ColaPrioridadTDA;
import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class MinTiempo {
	public static VectorTDA<Integer> minTiempo(VectorTDA<Integer> tiempos) throws Exception {
		VectorTDA<Integer> r = new Vector<Integer>();
		r.inicializarVector(tiempos.capacidadVector());
		ColaPrioridadTDA<Integer> aux = new ColaPrioridad<Integer>();
		for (int i = 0; i < tiempos.capacidadVector(); i++) {
			aux.AgregarElemento(i, tiempos.recuperarElemento(i));
		}
		int a = 0;
		if (!aux.ColaVacia()) {
			r.agregarElemento(a++, aux.RecuperarMaxElemento());
			aux.EliminarMaxPrioridad();
		}
		return r;
	}
}
