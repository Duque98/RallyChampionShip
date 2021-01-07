package strategy;

import java.util.List;

import coches.Coche;
import pilotos.Piloto;

/**
 * Interfaz para aplicar correctamente una estrategia de ordenacion de los pilotos y coches de una escuderia (strategy)
 * @author Jose Ignacio Duque Blazquez
 *
 */
public interface IStrategy {
	public void ordenar(List<Piloto> aPilotos, List<Coche> aCoches);
}
