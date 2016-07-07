Desarrollo de un algoritmo heurístico para la determinación en tiempo real del camino de mínimo costo entre dos puntos cualesquiera definidos como origen – destino, dentro de un marco de referencia. Contemplando la representación visual en la implementación.
Resolución. 

El método utilizado para el desarrollo del problema es el de Ramificación y poda o Branch and Bound del ingles, se aplica mayoritariamente para resolver cuestiones o problemas de optimización. La técnica de Ramificación y poda se suele interpretar como un árbol de soluciones, donde cada rama nos lleva a una posible solución posterior a la actual. La característica de esta técnica con respecto a otras anteriores (y a la que debe su nombre) es que el algoritmo se encarga de detectar en qué ramificación las soluciones dadas ya no están siendo óptimas, para «podar» esa rama del árbol y no continuar malgastando recursos y procesos en casos que se alejan de la solución óptima.
La estructura de la Ramificación y poda es la siguiente para el caso es la siguiente:  

Creo nodo raíz
Actualizo cota
Agrego raíz a pendientes
Mientras pendientes tenga nodo
  Nodo < sacar(pendiente)
  Hijos < generarHijos(nodo)
  Para cada hijo
    Si esSolucion(hijo)
      Actualizo mejorSolucion
      Actualizo cota
    Sino
      Agrego hijo en pendientes
      
Vale aclarar que en este caso se trabajo sin cota superior.

#Costo. 
El costo en cuanto orden para el peor de los casos es de o (n^4)  este va a estar dado por la cantidad de nodos hijos que se generen. La cantidad de hijos va a ir variando según la cantidad de adyacentes que tenga un punto, para casos muy extremos puede llegar a ser un solo hijo. 
En lo que respecta a orden espacial, va a estar dado por la etapa del árbol en la que se esté. Para el peor de los casos puede ser un árbol cuaternario completo. Este sería si no se puede ramificar ni podar nada. 

#Ventaja. 
Ofrece una solución cuando la mayoría de los planteos no llegan a una. 
#Desventaja.
La gran desventaja de este tipo de solución es el tiempo que puede llegar a demandar debido a su orden de tiempo. 
