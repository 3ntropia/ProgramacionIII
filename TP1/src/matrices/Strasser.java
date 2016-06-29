package matrices;

import Implementaciones.Matriz;
import TDA.MatrizTDA;

/**
 * @author martinh
 *
 */
public class Strasser {
	public static MatrizTDA<Integer> Multiplicar(MatrizTDA<Integer> matriz1, MatrizTDA<Integer> matriz2, int tam, int i,
			int j) {
		MatrizTDA<Integer> resultado = new Matriz<Integer>();
		if (tam < 2) {
			return (multimplicacion(matriz1, matriz2));
			// para cuando son de tamaño 2
		} else {

			MatrizTDA<Integer> a11 = new Matriz<Integer>();
			MatrizTDA<Integer> a12 = new Matriz<Integer>();
			MatrizTDA<Integer> a21 = new Matriz<Integer>();
			MatrizTDA<Integer> a22 = new Matriz<Integer>();
			MatrizTDA<Integer> b11 = new Matriz<Integer>();
			MatrizTDA<Integer> b12 = new Matriz<Integer>();
			MatrizTDA<Integer> b21 = new Matriz<Integer>();
			MatrizTDA<Integer> b22 = new Matriz<Integer>();
			MatrizTDA<Integer> m1 = new Matriz<Integer>();
			MatrizTDA<Integer> m2 = new Matriz<Integer>();
			MatrizTDA<Integer> m3 = new Matriz<Integer>();
			MatrizTDA<Integer> m4 = new Matriz<Integer>();
			MatrizTDA<Integer> m5 = new Matriz<Integer>();
			MatrizTDA<Integer> m6 = new Matriz<Integer>();
			MatrizTDA<Integer> m7 = new Matriz<Integer>();
			resultado.inicializarMatriz(tam);
			int mitad = (int) tam / 2;
			//////////////// dividir////////////////
			a11 = dividir(matriz1, mitad, i, j);
			a12 = dividir(matriz1, mitad, i, j + mitad);
			a21 = dividir(matriz1, mitad, i + mitad, j);
			a22 = dividir(matriz1, mitad, i + mitad, j + mitad);
			b11 = dividir(matriz2, mitad, i, j);
			b12 = dividir(matriz2, mitad, i, j + mitad);
			b21 = dividir(matriz2, mitad, i + mitad, j);
			b22 = dividir(matriz2, mitad, i + mitad, j + mitad);
			//////////////// resolver////////////////
			m1 = Multiplicar(suma(a11, a12, mitad), (suma(b11, b22, mitad)), mitad, i, j);
			m2 = Multiplicar(suma(a21, a22, mitad), b11, mitad, i, j);
			m3 = Multiplicar(a11, resta(b12, b22, mitad), mitad, i, j);
			m4 = Multiplicar(a22, resta(b22, b11, mitad), mitad, i, j);
			m5 = Multiplicar(suma(a11, a12, mitad), b22, mitad, i, j);
			m6 = Multiplicar(resta(a21, a11, mitad), suma(b11, b12, mitad), mitad, i, j);
			m7 = Multiplicar(resta(a12, a22, mitad), suma(b21, b22, mitad), mitad, i, j);
			//////////////// combinar////////////////
			a11 = suma(m1, m4, mitad);
			a12 = suma(m5, m7, mitad);
			b11 = resta(a11, a12, mitad);
			b12 = suma(m3, m5, mitad);
			b21 = suma(m2, m4, mitad);
			a11 = suma(m1, m3, mitad);
			a12 = suma(m2, m6, mitad);
			b22 = resta(a11, a12, mitad);
			resultado = combinar(b11, b12, b21, b22, tam);

		}
		return resultado;

	}

	private static MatrizTDA<Integer> dividir(MatrizTDA<Integer> m1, int tam, int i, int j) {
		MatrizTDA<Integer> auxM1 = new Matriz<Integer>();
		auxM1.inicializarMatriz(tam);
		for (int a = 0; i < tam; i++) {
			for (int b = 0; j < tam; j++) {
				auxM1.setearValor(a, b, m1.obtenerValor(i + a, j + b));
			}
		}
		return auxM1;
	}

	private static MatrizTDA<Integer> suma(MatrizTDA<Integer> m1, MatrizTDA<Integer> m2, int tam) {
		MatrizTDA<Integer> auxM1 = new Matriz<Integer>();
		auxM1.inicializarMatriz(tam);
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				auxM1.setearValor(i, j, (m1.obtenerValor(i, j) + m2.obtenerValor(i, j)));
			}
		}
		return auxM1;
	}

	private static MatrizTDA<Integer> resta(MatrizTDA<Integer> m1, MatrizTDA<Integer> m2, int tam) {
		MatrizTDA<Integer> auxM1 = new Matriz<Integer>();
		auxM1.inicializarMatriz(tam);
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				auxM1.setearValor(i, j, (m1.obtenerValor(i, j) + m2.obtenerValor(i, j)));
			}
		}
		return auxM1;
	}

	private static MatrizTDA<Integer> multimplicacion(MatrizTDA<Integer> m1, MatrizTDA<Integer> m2) {
		MatrizTDA<Integer> auxM1 = new Matriz<Integer>();
		auxM1.inicializarMatriz(2);

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int aux = 0;
				for (int k = 0; k < 2; k++) {
					auxM1.setearValor(i, j, aux = +(m1.obtenerValor(i, k) * m2.obtenerValor(k, j)));
				}
			}
		}
		return auxM1;
	}

	private static MatrizTDA<Integer> combinar(MatrizTDA<Integer> m1, MatrizTDA<Integer> m2, MatrizTDA<Integer> m3,
			MatrizTDA<Integer> m4, int tam) {
		MatrizTDA<Integer> auxM1 = new Matriz<Integer>();
		auxM1.inicializarMatriz(tam);
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {

			}
		}
		return auxM1;
	}

}