package comparators;

import java.util.Comparator;

import pilotos.Piloto;
/**
 * Comparator para comparar los pilotos segun su destreza y en caso de empate por su nombre
 * @author Jose Ignacio Duque Blazquez
 *
 */
public class PilotoDestrezaComparator implements Comparator<Piloto>{

	@Override
	public int compare(Piloto p1, Piloto p2) {
		if(p1.calcularDestreza() < p2.calcularDestreza()) {
			return -1;
		}
		if(p1.calcularDestreza() > p2.calcularDestreza()) {
			return 1;
		}
		if(Math.abs(p1.calcularDestreza() - p2.calcularDestreza()) == 0.0) {
			//En caso de empate, por nombre
			return new PilotoNombreComparator().compare(p1, p2);
		}
		return 0;
	}

}
