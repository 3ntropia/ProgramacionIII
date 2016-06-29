package maxMin;

import java.util.Random;

import Implementaciones.Vector;
import TDA.VectorTDA;

public class ManMaxMin {

	
	public static void main(String[] args) {
		int valor=10;
		VectorTDA <Integer> nuevo=new Vector<Integer>();
		nuevo.inicializarVector(valor);
		Random aleatorio=new Random();
		for(int i=0;i<valor;i++){			
			try {
				nuevo.agregarElemento(i, aleatorio.nextInt());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		try {
			nuevo=MaxMin.determinar(nuevo, 0, valor-1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("El numero menor en el vector es: "+nuevo.recuperarElemento(0)+" y el mayor es: "+nuevo.recuperarElemento(1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
