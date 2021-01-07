package strategy;

import java.util.Collections;
import java.util.List;

import coches.Coche;
import comparators.CochesStrategy1Comparator;
import comparators.PilotosStrategy1Comparator;
import pilotos.Piloto;

public class Estrategia3 extends StrategyAbs{
	//ordenaciónPilotos: descendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
	//ordenaciónCoches: ascendente por Combustible restante del Coche , en caso de empate por nombre);
	@Override
	public void ordenar(List<Piloto> aPilotos, List<Coche> aCoches) {
		ordenarPilotos(aPilotos);
		ordenarCoches(aCoches);
	}

	public void ordenarPilotos(List<Piloto> aPilotos) {
			Collections.sort(aPilotos, Collections.reverseOrder(new PilotosStrategy1Comparator()));
	}
	
	public void ordenarCoches(List<Coche> aCoches) {
			Collections.sort(aCoches, new CochesStrategy1Comparator());
	}
}
