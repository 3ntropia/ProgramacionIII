package mapa;

import grafico.PuntoTDA;
import java.util.List;

public interface CaminoTDA {
	/*
	 * Retorna las celdas seleccionadas entre el origen y el destino
	 */
	public List<PuntoTDA> buscarCamino();
	
	/*
	 * represeta al nodo origen
	 */
	public NodoTDA getOrigen();
	public void setOrigen(NodoTDA origen);
	public void setOrigen(PuntoTDA punto);
	
	/*
	 * representa al nodo destino
	 */
	public NodoTDA getDestino();
	public void setDestino(NodoTDA destino);
	public void setDestino(PuntoTDA punto);
}
