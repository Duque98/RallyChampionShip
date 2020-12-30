package comparators;

import java.util.Comparator;

import pilotos.Piloto;

public class PilotoNombreComparator implements Comparator<Piloto>{
	
	@Override
	public int compare(Piloto p1, Piloto p2) {
		if(p1.getNombre().compareTo(p2.getNombre()) > 0) {
			return 1;
		}
		if(p1.getNombre().compareTo(p2.getNombre()) < 0) {
			return -1;
		}
		if(p1.getNombre().compareTo(p2.getNombre()) == 0) {
			return 0;
		}
		return 0;
	}
}
