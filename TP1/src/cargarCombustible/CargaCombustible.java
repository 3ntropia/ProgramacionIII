package cargarCombustible;

import Implementaciones.Vector;
import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class CargaCombustible {
	static VectorTDA<Integer> obtenerEstaciones(VectorTDA<Integer> ruta, int a, int b, int n) throws Exception {
		VectorTDA<Integer> resultado = new Vector<Integer>();
		resultado.inicializarVector(ruta.capacidadVector());
		int i = a, j = 0, aux = n;
		while (i != b && ruta.recuperarElemento(i) < n) {
			aux -= ruta.recuperarElemento(i);
			if (aux > 0) {
				i++;
			} else {
				resultado.agregarElemento(j++, i - 1);
				aux = n;
			}
		}
		if (aux < 0) {
			throw new Exception("No hay solucion");
		} else {
			return resultado;
		}
	}
}
