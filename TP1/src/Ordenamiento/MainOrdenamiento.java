package Ordenamiento;

import java.util.Date;
import java.util.Random;

import Implementaciones.ColaPrioridad;
import Implementaciones.Vector;
import TDA.VectorTDA;



public class MainOrdenamiento {

	public static void main(String[] args) throws Exception {
		Date hora1=new Date();
		Date hora2=new Date();
		VectorTDA <Integer> principal=new Vector <Integer>();
		ColaPrioridad <Integer> cola=new ColaPrioridad <Integer>();
		cola.InicializarCola();
		int valor=10000;
		
		principal.inicializarVector(valor);
		cargar(principal,valor); //me carga con valores inferiores a 0 
	
		hora1=new Date();
		//////////////////////////insercion//////////////////////
		try {
			Insercion.ordenar(principal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		hora2=new Date();
		System.out.println("Insercion tardo: "+(hora2.getTime()-hora1.getTime()));	
		
		//imprimir(principal,valor);
		//////////////////////////seleccion//////////////////////
		cargar(principal,valor);
		hora1=new Date();
		try {
			Seleccion.ordenar(principal,valor);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		hora2=new Date();
		System.out.println("Seleccion tardo: "+(hora2.getTime()-hora1.getTime()));
		
		//////////////////////////mergesort//////////////////////
		cargar(principal,valor);
		hora1=new Date();
		try {
			Mergesort.ordenar(principal, 0, valor-1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		hora2=new Date();
		System.out.println("Mergersort tardo: "+(hora2.getTime()-hora1.getTime()));
		
		//imprimir(principal,valor);
		//////////////////////////quicksort//////////////////////
		cargar(principal,valor);
		hora1=new Date();
		try {
			Quicksort.ordenar(principal, 0, valor-1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		hora2=new Date();
		System.out.println("Quicksort tardo: "+(hora2.getTime()-hora1.getTime()));
		//////////////////////////Colaprioridad//////////////////////
		hora1=new Date();
		for(int i=0;i<valor;i++){
			Random aleatorio=new Random();
			try {
				cola.AgregarElemento(aleatorio.nextInt(),aleatorio.nextInt());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		hora2=new Date();
		System.out.println("ColaPrioridad tardo: "+(hora2.getTime()-hora1.getTime()));
	}
	
	public static void cargar(VectorTDA <Integer> principal,int valor){
		for(int i=0;i<valor;i++){
			Random aleatorio=new Random();
			try {
				principal.agregarElemento(i, aleatorio.nextInt());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void imprimir(VectorTDA <Integer> principal,int valor) throws Exception{
		for(int i=0;i<valor;i++)
		{
			System.out.println(principal.recuperarElemento(i)+" ");
		}
	}
	
}
