package mapa;


import grafico.PuntoTDA;

public interface NodoTDA extends Comparable<NodoTDA>{

	

	/*
	 * representa la ubicación (un PuntoTDA)
	 */
	public PuntoTDA getUbicacion();
	
	/*
	 * representa el NodoTDA anterior (de donde viene)
	 */
	public NodoTDA getPadre();
	public void setPadre(NodoTDA padre);
	
	/*
	 * representa la distancia heurística al punto destino
	 */
	public int getH();
	public void setH(PuntoTDA p);
	
	/*
	 * representa el peso acumulado (el heredado del padre más el propio)
	 */
	public int getG();
	public void setG(int g);
	
	/*
	 * representa el peso total ( g + h )
	 */
	public int f();
	
	/*
	 * retorna verdadero si es igual al otro NodoTDA 
	 */
	public boolean esIgual(NodoTDA n);
	
	/*
	 * Retornar el método toString() del PuntoTDA (la ubicacion)
	 */
	public String codigo();
	
}	
