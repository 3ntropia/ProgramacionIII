package alfabeticamente;

import java.util.Random;

import Implementaciones.Vector;
import TDA.VectorTDA;

/**
 * @author martinh
 *
 */
public class MainOrdenarAlfabeticamente {

	/**
	 * Disparador para crear el vector inicializado con numeros. Para ordenar
	 * alfabeticamente deberia ser igual, solo hay que comprar los char.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int valor = 10;
		boolean prueba;
		VectorTDA<Integer> nuevo = new Vector<Integer>();
		nuevo.inicializarVector(valor);
		Random aleatorio = new Random();
		try {
			for (int i = 0; i < valor; i++) {
				nuevo.agregarElemento(i, aleatorio.nextInt());
			}

			prueba = Verificar.ordenados(nuevo, 0, valor - 1);
			if (prueba)
				System.out.println("Estan ordenados");
			else
				System.out.println("No estan ordenados");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
