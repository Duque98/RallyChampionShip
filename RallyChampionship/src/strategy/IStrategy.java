package strategy;

import java.util.List;

import coches.Coche;
import pilotos.Piloto;

public interface IStrategy {
	public void ordenar(List<Piloto> aPilotos, List<Coche> aCoches);
}
