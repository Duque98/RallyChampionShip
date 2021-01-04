package comparators;

import java.util.Comparator;

import escuderias.Escuderia;
import pilotos.Piloto;

public class EscuderiaNombreComparator implements Comparator<Escuderia>{
	@Override
	public int compare(Escuderia e1, Escuderia e2) {
		if(e1.getNombre().compareTo(e2.getNombre()) > 0) {
			return 1;
		}
		if(e1.getNombre().compareTo(e2.getNombre()) < 0) {
			return -1;
		}
		if(e1.getNombre().compareTo(e2.getNombre()) == 0) {
			return 0;
		}
		return 0;
	}
}
