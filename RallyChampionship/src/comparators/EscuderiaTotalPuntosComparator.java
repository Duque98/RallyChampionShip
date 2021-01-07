package comparators;

import java.util.Comparator;

import escuderias.Escuderia;
/**
 * Comparator para comparar las escuderias por el total de puntos y en caso de empate por las carreras terminadas
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class EscuderiaTotalPuntosComparator implements Comparator<Escuderia>{

	@Override
	public int compare(Escuderia e1, Escuderia e2) {
		if(e1.puntosTotales() < e2.puntosTotales()) {
			return -1;
		}
		if(e1.puntosTotales() > e2.puntosTotales()) {
			return 1;
		}
		if(e1.puntosTotales() - e2.puntosTotales() == 0) {
			return new EscuderiaCarrerasTerminadasComparator().compare(e1,e2);
		}
		return 0;
	}

}
