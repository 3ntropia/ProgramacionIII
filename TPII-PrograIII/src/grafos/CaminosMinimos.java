package grafos;

import Implementaciones.Conjunto;
import Implementaciones.GrafoDir;
import TDA.ConjuntoTDA;
import TDA.GrafoDirTDA;

/**
 * @author martinh
 *
 */
public class CaminosMinimos {
	GrafoDirTDA<Integer> Dijstra(GrafoDirTDA<Integer> g, int nodo) {
		GrafoDirTDA<Integer> gr = new GrafoDir<Integer>();
		ConjuntoTDA<Integer> cp = g.Vertices();
		ConjuntoTDA<Integer> c_aux = new Conjunto<Integer>();
		int auxC, mejorP, mejorV = 0;
		gr.InicializarGrafo();
		cp.sacar(nodo);
		// agrego todos los vertices a gr y si existe las aristas nodo y sus
		// adyacentes...
		while (!cp.conjuntoVacio()) {
			auxC = cp.elegir();
			cp.sacar(auxC);
			gr.AgregarVertice(auxC);
			if (g.ExisteArista(nodo, auxC))
				gr.AgregarArista(nodo, auxC, g.PesoArista(nodo, auxC));
		}
		cp = g.Vertices();
		cp.sacar(nodo);
		while (!cp.conjuntoVacio()) {
			mejorP = -1;
			c_aux.inicializarConjunto();
			while (!cp.conjuntoVacio()) {
				auxC = cp.elegir();// elijo alguno de los vertices
				cp.sacar(auxC);
				c_aux.agregar(auxC);
				if (gr.ExisteArista(nodo, auxC) && (mejorP == -1 || gr.PesoArista(nodo, auxC) < mejorP)) {
					mejorP = gr.PesoArista(nodo, auxC);
					mejorV = auxC;
				}
				if (mejorP != 1)// si es igual a -1 es xq no existe la arista...
				{
					c_aux.sacar(mejorV);
					while (!c_aux.conjuntoVacio()) {
						auxC = c_aux.elegir();
						c_aux.sacar(auxC);
						cp.agregar(auxC);
						// para verificar con el nuevo vertice qeu puse, si hay mejores caminos...
						// es como volver a atras para verificar...
						if (g.ExisteArista(mejorV, auxC)) {
							if (!gr.ExisteArista(nodo, auxC)) {
								gr.AgregarArista(nodo, auxC, gr.PesoArista(mejorV, auxC) + g.PesoArista(nodo, auxC));
							} else {
								if (gr.PesoArista(nodo, mejorV) + g.PesoArista(mejorV, auxC) < gr.PesoArista(nodo,
										auxC)) {
									gr.AgregarArista(nodo, auxC,
											gr.PesoArista(mejorV, auxC) + g.PesoArista(nodo, auxC));
								}
							}
						}
					}
				}
			}
		}
		return gr;
	}
}
