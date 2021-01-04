package comparators;

import java.util.Comparator;

import escuderias.Escuderia;

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
