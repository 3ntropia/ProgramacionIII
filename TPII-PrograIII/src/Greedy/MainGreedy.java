package Greedy;

import Implementaciones.Vector;
import TDA.VectorTDA;

public class MainGreedy {
	public MainGreedy(String [] args)throws Exception{
		try{
			VectorTDA <Integer> v = new Vector<Integer>();
			v.inicializarVector(6);
			v.agregarElemento(0, 100);
			v.agregarElemento(1, 50);
			v.agregarElemento(2, 25);
			v.agregarElemento(3, 10);
			v.agregarElemento(4, 5);
			v.agregarElemento(5, 1);
			int vuelto=93;
			VectorTDA <Integer> resultado=Greedy.greedy(vuelto, v);
			System.out.println("La forma de devolver "+vuelto+" es: ");
			for(int i=0;i<6;i++)
			{
				if(resultado.recuperarElemento(i)!=0)
				System.out.println(resultado.recuperarElemento(i)+"de"+v.recuperarElemento(i));
				
			}
		}catch(Exception e){
		System.out.println(e.getMessage());//si le queres poner un mensaje personalisado,  
		//cambias el g.getmessage por el mensaje que vos queres...
		}
	}
}
