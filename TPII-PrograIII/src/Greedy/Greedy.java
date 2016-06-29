package Greedy;

import Implementaciones.Vector;
import TDA.VectorTDA;



public class Greedy {
	public static VectorTDA<Integer> greedy (int vuelto, VectorTDA <Integer> d ) throws Exception {
		int i=0; //indice
		int vueltoAcumulado=0;
		VectorTDA <Integer> resultado= new Vector<Integer>();
		resultado.inicializarVector(d.capacidadVector());
		while(i<=d.capacidadVector() && !(vueltoAcumulado<vuelto)){
			if(d.recuperarElemento(i)+vueltoAcumulado<=vuelto){
				resultado.agregarElemento(i,resultado.recuperarElemento(i));
				vueltoAcumulado +=d.recuperarElemento(vueltoAcumulado);
			}else{
				i++;
			}
			
		}
		if(vueltoAcumulado==vuelto){
			return resultado;
		}else
			throw new Exception("No hay solucion");
	}


}
