package mapa;

import grafico.Punto;
import grafico.PuntoTDA;

import java.util.List;
import java.util.Vector;

import mapa.MapaBase;

public class Mapa extends MapaBase{

	public List<PuntoTDA> getAdyacentes(PuntoTDA ubicacion) {
		
		List<PuntoTDA> hijos = new Vector<PuntoTDA>();

		int i, j;
		int[] dX = {-1,0,1,0};
		int[] dY = {0,-1,0,1};
		
		for(int k = 0; k < 4; k++){
			i = ubicacion.getX() + dX[k];
			j = ubicacion.getY() + dY[k];
			PuntoTDA p = new Punto(i,j);
			if(this.puntoValido(p)){
				hijos.add(p);
			}
		}
		return hijos;
	}

}
