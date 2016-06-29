package procesos;

import Implementaciones.Vector;
import TDA.VectorTDA;

public class MainProcesos {

	public static void main(String[] args) {
		VectorTDA <Integer> beneficio=new Vector <Integer>();
		VectorTDA <Integer> tiempo=new Vector <Integer>();
		//VectorTDA <Integer> resultado=new Vector <Integer>();
		int bm=0;
		beneficio.inicializarVector(4);
		tiempo.inicializarVector(4);
		//resultado.inicializarVector(beneficio.capacidadVector()+1);
		try {
			beneficio.agregarElemento(0, 50);
			beneficio.agregarElemento(1, 15);
			beneficio.agregarElemento(2, 10);
			beneficio.agregarElemento(3, 30);
			tiempo.agregarElemento(0, 2);
			tiempo.agregarElemento(1, 1);
			tiempo.agregarElemento(2, 2);
			tiempo.agregarElemento(3, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			bm=BeneficioMAX.BeneficioResultado(beneficio,tiempo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("El beneficio maximo es: "+bm);
		/*try {
			System.out.println("El beneficio maximo es: "+resultado.recuperarElemento(0)+"\n");
			System.out.println("El mejor orden para atender los procesos es: ");
			for(int i=1;i<beneficio.capacidadVector()+1;i++)
				System.out.println(resultado.recuperarElemento(i)+" ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		

	}

}
