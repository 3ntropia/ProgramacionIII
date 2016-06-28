package perteneceNumero;

import TDA.VectorTDA;

public class Pertenece {
	public static boolean pertenece (VectorTDA <Integer> v,int inicio,int fin,int numero) throws Exception
	{
		boolean control=false;
		if(inicio==fin){
			if(v.recuperarElemento(inicio)==numero)
				return control=true;
		}
		else
		{
			int mitad=(fin+inicio)/2;
			if(numero<=v.recuperarElemento(mitad))
				return pertenece(v,inicio,mitad,numero);
			else
				return pertenece(v,mitad+1,fin,numero);
		}
		return control;
	}
}
