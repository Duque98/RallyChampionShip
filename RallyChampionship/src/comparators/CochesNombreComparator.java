package comparators;

import java.util.Comparator;

import coches.Coche;

public class CochesNombreComparator  implements Comparator<Coche>{

	@Override
	public int compare(Coche c1, Coche c2) {
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
