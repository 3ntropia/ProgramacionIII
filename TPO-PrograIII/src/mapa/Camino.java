package mapa;

import grafico.PuntoTDA;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import mapa.CaminoTDA;
import mapa.MapaTDA;
import mapa.NodoTDA;

public class Camino implements CaminoTDA{
	
	private NodoTDA origen;
	private NodoTDA destino;
	private MapaTDA mapa;

	public Camino(MapaTDA mapa){
		this.mapa = mapa;
	}

	public List<PuntoTDA> buscarCamino() {
		
		java.util.Date d1 = new java.util.Date();
		System.out.println("Buscando camino desde: "+this.origen.getUbicacion()+" a "+this.destino.getUbicacion());
		NodoTDA mejorCamino = buscarCaminoByB();
		List<PuntoTDA> camino = new ArrayList<PuntoTDA>();
		while(mejorCamino != null){
			camino.add(mejorCamino.getUbicacion());
			mejorCamino = mejorCamino.getPadre();
		}
		java.util.Date d2 = new java.util.Date();
		System.out.println("tarda "+(d2.getTime()-d1.getTime()));
		return camino;
	}

	NodoTDA buscarCaminoByB(){
		
		int Cota = -1;
		
		NodoTDA mejorSolucion = new Nodo(this.destino.getUbicacion());

		// matriz de mejores G
		int[][] m = new int[this.mapa.getGrilla().length][this.mapa.getGrilla().length];
		for(int i = 0; i<this.mapa.getGrilla().length;i++){
			for(int j = 0; j < this.mapa.getGrilla().length; j++){
				m[i][j] = -1;
			}			
		}
		
		PriorityQueue<NodoTDA> Lnv = new PriorityQueue<NodoTDA>();
		nodoRaiz();
		Lnv.add(this.origen);
		m[this.origen.getUbicacion().getX()][this.origen.getUbicacion().getY()] = 0;
		while(!Lnv.isEmpty()){

			NodoTDA x = Lnv.poll();
			if(Cota == -1 || x.f() < mejorSolucion.f()){
				List<NodoTDA> hijos = generarHijos(x,m);
				Cota = agregarHijosLnv(hijos,mejorSolucion,Lnv,Cota);
				for(int i = 0; i < hijos.size(); i++){
					if(Cota == -1 || hijos.get(i).f() < Cota ){
						if(hijos.get(i).esIgual(this.destino)){
							mejorSolucion.setPadre(hijos.get(i).getPadre());
							mejorSolucion.setG(hijos.get(i).getG());
							Cota = hijos.get(i).f();
						}else{
							Lnv.add(hijos.get(i));
						}
					}
				}
				
			}

		}
		return mejorSolucion;
	}
	
	void nodoRaiz(){
		
		int[][] m = new int[this.mapa.getGrilla().length][this.mapa.getGrilla().length];
		m[this.origen.getUbicacion().getX()][this.origen.getUbicacion().getY()] = 1;
		this.origen.setG(0);
		this.origen.setH(this.destino.getUbicacion());
	}
	
	List<NodoTDA> generarHijos(NodoTDA padre,int[][] m){
		
		
		List<PuntoTDA> hijos = this.mapa.getAdyacentes(padre.getUbicacion());
		
		List<NodoTDA> hijosNodos = new ArrayList<NodoTDA>();
		
		NodoTDA nAux;
		PuntoTDA pAux;
	
		for(int i = 0; i < hijos.size();i++){
			pAux = hijos.get(i);
			nAux = new Nodo(pAux);
			nAux.setPadre(padre);
			nAux.setG(1+this.mapa.getDensidad(pAux));// la densidad 0 cuenta como 1, la 1 como dos, etc.
			nAux.setH(this.destino.getUbicacion());
			if(m[pAux.getX()][pAux.getY()]==-1 || m[pAux.getX()][pAux.getY()]>nAux.getG()){
				m[pAux.getX()][pAux.getY()] = nAux.getG();
				hijosNodos.add(nAux);
			}

		}
		return hijosNodos;
	}
	
	int agregarHijosLnv(List<NodoTDA> hijos, NodoTDA mejorSol, PriorityQueue<NodoTDA> Lnv, int Cota){
		
		for(int i = 0; i < hijos.size(); i++){
			if(Cota == -1 || hijos.get(i).f() < Cota ){
				if(hijos.get(i).esIgual(this.destino)){
					mejorSol.setPadre(hijos.get(i).getPadre());
					mejorSol.setG(hijos.get(i).getG());
					Cota = hijos.get(i).f();
				}else{
					Lnv.add(hijos.get(i));
				}
			}
		}
		return Cota;
	}
	
	public NodoTDA getDestino() {

		return this.destino;
	}

	public NodoTDA getOrigen() {
	
		return this.origen;
	}

	public void setDestino(NodoTDA destino) {

		this.destino = destino;
	}

	public void setDestino(PuntoTDA punto) {
		
		this.destino = new Nodo(punto);
	}

	public void setOrigen(NodoTDA origen) {
		this.origen = origen;
	}

	public void setOrigen(PuntoTDA punto) {

		this.origen = new Nodo(punto);
	}

}
