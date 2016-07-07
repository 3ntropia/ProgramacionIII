/*
 * Interface pracialmente implementada en la clase abstracta MapaBase
 */


package mapa;

import java.util.List;
import grafico.Area;
import grafico.PuntoTDA;

public interface MapaTDA {

	/*
	 * Métodos implementados 
	 */
	public int[][] getGrilla();
	public void setArea(Area area);
	public int getDensidad(int x, int y);
	public int getDensidad(PuntoTDA p);
	public boolean puntoValido(PuntoTDA p);
	
	/*
	 * Método no implementado
	 */
	public List<PuntoTDA> getAdyacentes(PuntoTDA ubicacion);
}
