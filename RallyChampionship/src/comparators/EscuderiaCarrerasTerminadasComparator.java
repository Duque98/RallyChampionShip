package comparators;

import java.util.Comparator;

import escuderias.Escuderia;
/**
 * Comparator para comparar las escuderias segun su total de carreras terminadas y en caso de empate por nombre
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class EscuderiaCarrerasTerminadasComparator implements Comparator<Escuderia>{
	@Override
	public int compare(Escuderia e1, Escuderia e2) {
		if(e1.totalCarrerasTerminadas() < e2.totalCarrerasTerminadas()) {
			return -1;
		}
		if(e1.totalCarrerasTerminadas() > e2.totalCarrerasTerminadas()) {
			return 1;
		}
		if(e1.totalCarrerasTerminadas() - e2.totalCarrerasTerminadas() == 0) {
			return new EscuderiaNombreComparator().compare(e1,e2);
		}
		return 0;
	}
}
