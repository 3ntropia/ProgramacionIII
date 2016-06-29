package mayoritario;
import TDA.VectorTDA;
import Implementaciones.Vector;;

public class Metodos {
	
	public static int elementoMayoritario(VectorTDA<Integer> v,int tamanio)throws Exception{
		int candidato = buscarCandidato(v,tamanio);
		
		int mayoria=tamanio/2+1;
		int cantidadCandidato =0;
		
		for(int i =0;i<tamanio;i++){
			if(v.recuperarElemento(i)==candidato){
				cantidadCandidato++;
			}
		}
		if(cantidadCandidato>=mayoria){
			return candidato;
		}else{
			throw new Exception("No hay elemento mayoritario");
		}
	}
	
	public static int buscarCandidato(VectorTDA<Integer> v, int tamanio)throws Exception{
		if(tamanio==0){
			throw new Exception("No existe candidato");
		}else{
			if(tamanio==1){
				return v.recuperarElemento(0);
			}else{
				if(tamanio%2==0){
					VectorTDA<Integer> candidatos = new Vector<Integer>();
					candidatos.inicializarVector(tamanio/2);
					int cantidadCandidatos=0;
					for(int i=1;i<tamanio;i=i+2){
						if(v.recuperarElemento(i)==v.recuperarElemento(i-1)){
							candidatos.agregarElemento(cantidadCandidatos, v.recuperarElemento(i));
							cantidadCandidatos++;
						}
					}
					return buscarCandidato(candidatos,cantidadCandidatos);
				}else{
					VectorTDA<Integer> candidatos = new Vector<Integer>();
					candidatos.inicializarVector(tamanio/2);
					int cantidadCandidatos=0;
					for(int i = 1; i<tamanio;i=i+2){
						if(v.recuperarElemento(i)==v.recuperarElemento(i-1)){
							candidatos.agregarElemento(cantidadCandidatos, v.recuperarElemento(i-1));
							cantidadCandidatos++;
						}
					}
					try{
						return buscarCandidato(candidatos, cantidadCandidatos);
					}catch(Exception e){
						return v.recuperarElemento(tamanio-1);
					}
				}
			}
		}
	}

}
