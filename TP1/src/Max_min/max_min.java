package Max_min;

import Implementaciones.Vector;
import TDA.VectorTDA;

public class max_min {
	public static VectorTDA<Integer> determinar(VectorTDA <Integer>v,int inicio,int fin) throws Exception{
		VectorTDA <Integer> resultado=new Vector <Integer>();
		resultado.inicializarVector(2);
		resultado.agregarElemento(1, v.recuperarElemento(0));
		resultado.agregarElemento(0, v.recuperarElemento(0));
		if(fin==inicio){
			//lo mas chicos los pongo en la posicion 0//
			if(v.recuperarElemento(inicio)<resultado.recuperarElemento(0))
				resultado.agregarElemento(0, v.recuperarElemento(inicio));
			//lo mas grandes los pongo en la posicion 1//
			if(v.recuperarElemento(inicio)>resultado.recuperarElemento(1))
				resultado.agregarElemento(1, v.recuperarElemento(inicio));
			return resultado;
		}
		else if(fin>inicio)
		{
			int mitad=(fin+inicio)/2;
			resultado=determinar(v,inicio,mitad);
			resultado=determinar(v,mitad+1,fin);
		}
		return resultado;
	}
}
