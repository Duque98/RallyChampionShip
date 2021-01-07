package strategy;

import java.util.Collections;
import java.util.List;

import coches.Coche;
import comparators.CochesStrategy1Comparator;
import comparators.PilotosStrategy1Comparator;
import pilotos.Piloto;

/**
 * Clase que aplica la ordenacion de los pilotos y coches de una escuderia (strategy)
 *  - ordenaciónPilotos: DESCENDENTE por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
 *  - ordenaciónCoches: DESCENDENTE por Combustible restante del Coche , en caso de empate por nombre
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class Estrategia2 extends StrategyAbs{
	@Override
	public void ordenar(List<Piloto> aPilotos, List<Coche> aCoches) {
		ordenarPilotos(aPilotos);
		ordenarCoches(aCoches);
	}
	/**
	 * Ordena los pilotos 
	 * @param aPilotos
	 */
	public void ordenarPilotos(List<Piloto> aPilotos) {
			Collections.sort(aPilotos, Collections.reverseOrder(new PilotosStrategy1Comparator()));
	}
	/**
	 * Ordena los coches
	 * @param aCoches
	 */
	public void ordenarCoches(List<Coche> aCoches) {
			Collections.sort(aCoches, Collections.reverseOrder(new CochesStrategy1Comparator()));
	}
}
