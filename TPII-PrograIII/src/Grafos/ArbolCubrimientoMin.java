package Grafos;

import Implementaciones.ColaPrioridad;
import Implementaciones.Conjunto;
import Implementaciones.Grafo;
import Implementaciones.Vector;
import TDA.ConjuntoTDA;
import TDA.GrafoTDA;
import TDA.VectorTDA;
import auxiliares.Par;

/*
 * PRIM elijo un vertice al azar, despues busco todas las aritas de los
 * adyancentes y elegimos la menor vuelvo a actualizar y elijo el vertice de la
 * arista de menor peso. Agrego las aristas de ese vertice. Vuelvo a hacer todo
 * esto....
 * 
 */
public class ArbolCubrimientoMin {
	GrafoTDA<Integer> Prim(GrafoTDA<Integer> g) {
		GrafoTDA<Integer> resultado = new Grafo<Integer>();
		ConjuntoTDA<Integer> P = new Conjunto<Integer>();
		ConjuntoTDA<Integer> C_aux = new Conjunto<Integer>();
		ConjuntoTDA<Integer> c_aux = g.Vertices();
		int v_aux, mejorV = 0, mejorP, v_seleccion;
		resultado.InicializarGrafo();
		while (!c_aux.conjuntoVacio()) {
			v_aux = c_aux.elegir();
			c_aux.sacar(v_aux);
			resultado.AgregarVertice(v_aux);
		}
		P = g.Vertices();
		v_seleccion = P.elegir();
		P.sacar(v_seleccion);
		c_aux = g.Adyacentes(v_seleccion);
		while (!c_aux.conjuntoVacio()) {
			v_aux = c_aux.elegir();
			c_aux.sacar(v_aux);
			resultado.AgregarArista(v_seleccion, v_aux, g.PesoArista(v_seleccion, v_aux));
		}
		while (!P.conjuntoVacio()) {
			mejorP = -1;
			while (!P.conjuntoVacio()) {
				v_aux = P.elegir();
				P.sacar(v_aux);
				c_aux.agregar(v_aux);
				if (resultado.Adyacentes(v_aux).conjuntoVacio()
						// esta unido a los vertices que tngo
						&& (mejorP == -1 || mejorP > resultado.PesoArista(v_aux, resultado.Adyacentes(v_aux).elegir())))
				{
					mejorV = v_aux;
					mejorP = resultado.PesoArista(v_aux, resultado.Adyacentes(v_aux).elegir());
				}
			}
			// hasta aca se que mejorV tiene el qeu me conviene
			c_aux.sacar(mejorV);
			while (!c_aux.conjuntoVacio()) {
				v_aux = c_aux.elegir();
				c_aux.sacar(v_aux);
				P.agregar(v_aux);
				if (g.ExisteArista(mejorV, v_aux)) {
					if (!resultado.ExisteArista(resultado.Adyacentes(v_aux).elegir(), v_aux)) {
						resultado.AgregarArista(mejorV, v_aux, g.PesoArista(mejorV, v_aux));
					} else {
						if (g.PesoArista(mejorV, v_aux) < resultado.PesoArista(resultado.Adyacentes(v_aux).elegir(), v_aux)) {
							resultado.EliminarArista(v_aux, g.Adyacentes(v_aux).elegir());
							resultado.AgregarArista(v_aux, mejorV, mejorP);
						}
					}
				}
			}

		}
		return resultado;
	}

	GrafoTDA<Integer> Kruskal(GrafoTDA<Integer> g) throws Exception {
		/*
		 * necesitas un "conjunto de conjuntos"(conjunto disjuntos) y una lista
		 * ordenada por peso de menor a mayor la lista la hacemos con una cola
		 * con prioridadad en el qeu el Prioridad-> peso elemento -> par (par va
		 * a ser el Origen y destino)
		 */
		GrafoTDA<Integer> r = new Grafo<Integer>();
		ConjuntoTDA<Integer> c_aux;
		ConjuntoTDA<Integer> c_aux2;
		r.InicializarGrafo();
		int i = 0, c1 = 0, c2 = 0;
		VectorTDA<Par> c = new Vector<Par>();// vector de pares
		ColaPrioridad<Par> a = new ColaPrioridad<Par>(); // cola de aristas
		Par p_aux = new Par();
		c_aux = g.Vertices();
		c.inicializarVector(c.capacidadVector());
		while (!c_aux.conjuntoVacio()) {
			// agregar vertices al grafo resultado
			int v_aux = c_aux.elegir();
			c_aux.sacar(v_aux);
			r.AgregarVertice(v_aux);
			i++;// cuento vertices

		}

		// inicializa el vector de conjunto
		c.inicializarVector(i);
		i = 0;
		while (!c_aux.conjuntoVacio()) {
			// agrego el par
			int v_aux = c_aux.elegir();
			c_aux.sacar(v_aux);
			p_aux.valor1 = v_aux;
			p_aux.valor2 = v_aux;
			c.agregarElemento(i++, p_aux);

		}
		a.InicializarCola();
		c_aux = r.Vertices();
		while (!c_aux.conjuntoVacio()) {

			int v_aux = c_aux.elegir();
			c_aux.sacar(v_aux);
			c_aux2 = g.Adyacentes(v_aux);
			while (!c_aux2.conjuntoVacio()) {
				int v_aux2 = c_aux2.elegir();
				c_aux2.sacar(v_aux2);
				if (v_aux < v_aux2) {// controla de no agregarlo 2 veces
					p_aux = new Par();
					p_aux.valor1 = v_aux;
					p_aux.valor2 = v_aux2;
					a.AgregarElemento(p_aux, g.PesoArista(v_aux, v_aux2));
				}
			}
		}
		i = 1;
		// hasta aca esta todo inicializado
		while (i < c.capacidadVector()) {
			p_aux = a.RecuperarMinElemento();
			a.RecuperarMinElemento();
			// vuscio eb qey cibhybti esta ek irugeb y el destino
			for (int j = 0; j < c.capacidadVector(); j++) {
				if (c.recuperarElemento(j).valor1 == p_aux.valor1) {
					c1 = c.recuperarElemento(j).valor2;
				}
				if (c.recuperarElemento(j).valor1 == p_aux.valor2) {
					c2 = c.recuperarElemento(j).valor2;
				}
			}
			if (c1 != c2) {
				i++;// marca la cantidad de conjuntos
				r.AgregarArista(p_aux.valor1, p_aux.valor2, g.PesoArista(p_aux.valor1, p_aux.valor2));
				// uno los conjuntos
				for (int j = 0; j < c.capacidadVector(); j++) {
					if (c.recuperarElemento(j).valor2 == c2) {
						p_aux = c.recuperarElemento(j);
						p_aux.valor2 = c1;
						c.agregarElemento(j, p_aux);
					}
				}
			}
		}
		return r;
	}
}
