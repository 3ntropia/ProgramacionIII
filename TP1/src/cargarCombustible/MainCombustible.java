package cargarCombustible;
import Implementaciones.Vector;
import TDA.VectorTDA;


/**
 * @author martinh
 *
 */
public class MainCombustible {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VectorTDA <Integer> rutas=new Vector <Integer>();
			VectorTDA <Integer> resultado=new Vector <Integer>();
			resultado.inicializarVector(7);
			rutas.inicializarVector(7);
		
			rutas.agregarElemento(0,10);
			rutas.agregarElemento(1, 20);
			rutas.agregarElemento(2, 10);
			rutas.agregarElemento(3, 30);
			rutas.agregarElemento(4, 50);
			rutas.agregarElemento(5, 60);
			rutas.agregarElemento(6, 20);
			
			//Hasta caga seteo para pruebas.
			
			resultado=CargaCombustible.obtenerEstaciones(rutas, 0, 7, 100);
			System.out.print("Tenes que para en las estaciones: ");
			for(int i=0;i<resultado.capacidadVector();i++)
			{
				if(resultado.recuperarElemento(i)!=null)
				{
					System.out.print(resultado.recuperarElemento(i)+" ");
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}

}
