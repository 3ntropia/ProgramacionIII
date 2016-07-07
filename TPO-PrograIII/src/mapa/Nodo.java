/*
 * Es la unidad del camino.
 * El camino es una lista de nodos que identifican a las celdas por donde se pasa.
 * Se compone:
 * 	Objeto Punto que indica la posición en la grilla.
 *  Objeto Nodo  que referencia al Nodo padre (Nodo anterior)
 */

package mapa;

import mapa.NodoTDA;
import grafico.Punto;
import grafico.PuntoTDA;

public class Nodo implements NodoTDA{
	private PuntoTDA ubicacion; // representa la celda actual
	private NodoTDA padre;		 // representa la celda de donde viene
	
	private int H; // distancia al destino
	private int G; // peso acumulado
	
	public Nodo(PuntoTDA ubicacion){
		this.ubicacion = ubicacion;
		this.padre = null;
	}
	public Nodo(PuntoTDA ubicacion, Nodo padre) {
		this.ubicacion = ubicacion;
		this.padre = padre;
	}
	
	public PuntoTDA getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Punto ubicacion) {
		this.ubicacion = ubicacion;
	}

	public NodoTDA getPadre() {
		return padre;
	}
	public void setPadre(NodoTDA padre) {
		this.padre = padre;
	}
	
	public int getH(){
		return this.H;
	}
	
	public void setH(PuntoTDA p){
		this.H = Math.abs(this.ubicacion.getX()-p.getX())+Math.abs(this.ubicacion.getY()-p.getY());
	}
	
	public int getG(){
		return this.G;
	}
	public void setG(int g){
		this.G = g;
		if(this.padre != null){
			this.G += this.padre.getG();
		}
	}
	
	public int f(){
		return this.G + this.H;
	}
	
	public boolean esIgual(NodoTDA n){
		return ((this.ubicacion.getX() == n.getUbicacion().getX())&&(this.ubicacion.getY() == n.getUbicacion().getY()));
	}
	
	public String codigo(){
		return this.ubicacion.toString();
	}
	
	public int compareTo(NodoTDA n){
		if(n.f() < this.f()){
			return 1;
		}else if(n.f() == this.f()){
			return 0;
		}else{
			return -1;
		}
	}
	
}
