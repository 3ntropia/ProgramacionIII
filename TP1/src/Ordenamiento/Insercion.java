package Ordenamiento;



import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class Insercion {
	public static void ordenar(VectorTDA <Integer>v) throws Exception
	{
		int temp;
		int t = v.capacidadVector();
		for (int i = 1; i < t; i++) {
			for (int k = t- 1; k >= i; k--) {
				if(v.recuperarElemento(k) < v.recuperarElemento(k-1)){
					temp = v.recuperarElemento(k);
					v.agregarElemento(k, v.recuperarElemento(k-1));
					v.agregarElemento(k-1, temp);
				}
			}
		}

	}
}
