package comparators;

import java.util.Comparator;

import circuitos.Circuito;
/**
 * Comparator para comparar los circuitos segun su complejidad y en caso de empate por nombre
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class ComplejidadComparator implements Comparator<Circuito>{

	@Override
	public int compare(Circuito c1, Circuito c2) {
		if(c1.getComplejidadModificada() < c2.getComplejidadModificada()) {
			return -1;
		}
		if(c1.getComplejidadModificada() > c2.getComplejidadModificada()) {
			return 1;
		}
		if(Math.abs(c1.getComplejidadModificada() - c2.getComplejidadModificada()) == 0.0) {
			//En caso de empate, por nombre
			return new CircuitoNombreComparator().compare(c1, c2);
		}
		return 0;
	}

}
