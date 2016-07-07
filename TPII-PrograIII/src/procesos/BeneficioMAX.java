package procesos;

import Implementaciones.ColaPrioridad;
import Implementaciones.Vector;
import TDA.ColaPrioridadTDA;
import TDA.VectorTDA;

/**
 * Planificación de tareas con plazo fijo: Se deben procesar n tareas en un único procesador.
 * Cada tarea se procesa en una unidad de tiempo y debe ser ejecutada en un plazo no superior a  ti.
 * La tarea i produce una ganancia gi > 0 si se procesa en un instante anterior a ti.
 * Una solución es factible si existe al menos una  secuencia S de tareas que se ejecuten antes de sus respectivos plazos.
 * 
 * @author martinh
 *
 */
public class BeneficioMAX {
	public static int BeneficioResultado(VectorTDA<Integer> b, VectorTDA<Integer> t) throws Exception {
		int bm = 0, cant = 0;
		ColaPrioridadTDA<Integer> c = new ColaPrioridad<Integer>();
		c.InicializarCola();
		for (int i = 0; i < b.capacidadVector(); i++) {
			c.AgregarElemento(i, b.recuperarElemento(i));
		}
		VectorTDA<Integer> s = new Vector<Integer>();
		s.inicializarVector(b.capacidadVector());
		while (!c.ColaVacia()) {
			int candidato = (int) c.RecuperarMaxElemento();
			c.EliminarMaxPrioridad();
			if (esFactible(t, s, candidato, cant)) {
				agregar(t, s, candidato, cant);
				cant++;
				System.out.println(b.recuperarElemento(candidato));
				bm += b.recuperarElemento(candidato);
				// s.agregarElemento(0, bm+=b.recuperarElemento(candidato));
			}
		}
		return bm;
	}

	private static boolean esFactible(VectorTDA<Integer> t, VectorTDA<Integer> s, int candidato, int cant)
			throws Exception {
		int i = cant - 1;
		while (i >= 0 && t.recuperarElemento(s.recuperarElemento(i)) >= i + 1)
			i--;
		if (i < 0 || t.recuperarElemento(s.recuperarElemento(candidato)) >= i + 1) {
			// System.out.println(t.recuperarElemento(s.recuperarElemento(candidato))+">="+(i+1));
			return true;
		} else {
			return false;
		}
	}

	private static void agregar(VectorTDA<Integer> t, VectorTDA<Integer> s, int candidato, int cant) throws Exception {
		int i = cant - 1;
		while (i >= 0 && t.recuperarElemento(s.recuperarElemento(i)) >= i + 1) {
			s.agregarElemento(i + 1, s.recuperarElemento(i));
			i--;
		}
		s.agregarElemento(i + 1, candidato);
	}
}
