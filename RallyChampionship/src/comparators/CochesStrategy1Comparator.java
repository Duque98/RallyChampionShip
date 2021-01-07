package comparators;

import java.util.Comparator;

import coches.Coche;
/**
 * Comparator para comparar los coches segun su combustible restante y en caso de empate por nombre
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class CochesStrategy1Comparator implements Comparator<Coche>{

	@Override
	public int compare(Coche c1, Coche c2) {
		//Combustible restante del coche
		if(c1.getCombustibleRestante() < c2.getCombustibleRestante()) {
			return -1;
		}
		if(c1.getCombustibleRestante() > c2.getCombustibleRestante()) {
			return 1;
		}
		if(Math.abs(c1.getCombustibleRestante() - c2.getCombustibleRestante()) == 0.0) {
			//En caso de empate, por nombre
			return new CochesNombreComparator().compare(c1, c2);
		}
		return 0;
	}

}
