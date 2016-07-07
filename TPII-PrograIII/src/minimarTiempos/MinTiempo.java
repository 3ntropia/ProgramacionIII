package minimarTiempos;

import Implementaciones.ColaPrioridad;
import Implementaciones.Vector;
import TDA.ColaPrioridadTDA;
import TDA.VectorTDA;

/**
 * Minimizar tiempo de espera: Un procesador debe atender n procesos.
 * Se conoce de antemano el tiempo que necesita cada uno de ellos.
 * Determinar en qué orden el procesador debe atender dichos procesos para minimizar la suma
 * del tiempo que los procesos están en el sistema. 
 * 
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
