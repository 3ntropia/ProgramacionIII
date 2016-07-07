package greedy;

import Implementaciones.Vector;
import TDA.VectorTDA;

/**
 * Cambio de monedas: Dado un conjunto C de N tipos de monedas con un número ilimitado de ejemplares
 * de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo número de ellas.
 * Por ejemplo, un cajero automático dispone de billetes de distintos valores: 100$, 25$, 10$, 5$ y 1$,
 * si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de 100$, 3 de 25$, 1 de 10$ y 4 de 1$.
 * 
 * @author martinh
 *
 */
public class Greedy {
	public static VectorTDA<Integer> greedy(int vuelto, VectorTDA<Integer> d) throws Exception {
		int i = 0; // indice
		int vueltoAcumulado = 0;
		VectorTDA<Integer> resultado = new Vector<Integer>();
		resultado.inicializarVector(d.capacidadVector());
		while (i <= d.capacidadVector() && !(vueltoAcumulado < vuelto)) {
			if (d.recuperarElemento(i) + vueltoAcumulado <= vuelto) {
				resultado.agregarElemento(i, resultado.recuperarElemento(i));
				vueltoAcumulado += d.recuperarElemento(vueltoAcumulado);
			} else {
				i++;
			}

		}
		if (vueltoAcumulado == vuelto) {
			return resultado;
		} else
			throw new Exception("No hay solucion");
	}

}
