package comparators;

import java.util.Comparator;

import circuitos.Circuito;

public class CircuitoNombreComparator implements Comparator<Circuito>{

	@Override
	public int compare(Circuito c1, Circuito c2) {
		if(c1.getNombre().compareTo(c2.getNombre()) > 0) {
			return 1;
		}
		if(c1.getNombre().compareTo(c2.getNombre()) < 0) {
			return -1;
		}
		if(c1.getNombre().compareTo(c2.getNombre()) == 0) {
			return 0;
		}
		return 0;
	}

}
