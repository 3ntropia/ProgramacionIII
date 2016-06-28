package Mayoritario;
import java.util.Random;
import TDA.VectorTDA;
import Implementaciones.Vector;
import java.util.Date;

public class Principal3 {
	
	public static void main(String[] args)throws Exception{
		int mayoritario=0;
		int tamanio =1000000;
		VectorTDA<Integer> v = new Vector<Integer>();
		v.inicializarVector(tamanio);
		
		Random r = new Random();
		
		for(int i = 0; i<tamanio;i++){
			int k =r.nextInt(2);
			v.agregarElemento(i,k);
			//System.out.print(k+ " ");
		}
		Date hora1 = new Date();
		try{
			mayoritario = Metodos.elementoMayoritario(v, tamanio);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Date hora2 = new Date();
		System.out.println("");
		System.out.println("Numero mayoritario es: " + mayoritario +" y tardo: "+(hora2.getTime()-hora1.getTime()));
	}
}
