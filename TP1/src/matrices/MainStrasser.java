package matrices;



import Implementaciones.Matriz;
import TDA.MatrizTDA;

public class MainStrasser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MatrizTDA <Integer> m1=new Matriz<Integer>();
		MatrizTDA <Integer> m2=new Matriz<Integer>();
		m1.inicializarMatriz(20);
		m2.inicializarMatriz(20);
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<20;j++)
			{
				int aleatorio = (int)(Math.random()*100);
				m1.setearValor(i, j, aleatorio);
				m2.setearValor(i, j, aleatorio);
			}
		}
		Strasser.Multiplicar(m1, m2, 20, 0, 0);
	}

}
