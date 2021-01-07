package comparators;

import java.util.Comparator;

import coches.Coche;
/**
 * Comparator para comparar los coches segun su nombre
 * @author Jose Ignacio Duque Blazquez
 *
 */
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
