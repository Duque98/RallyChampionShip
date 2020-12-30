package comparators;

import java.util.Comparator;

import pilotos.Piloto;

public class PilotoDestrezaComparator implements Comparator<Piloto>{

	@Override
	public int compare(Piloto p1, Piloto p2) {
		if(p1.getDestreza() < p2.getDestreza()) {
			return -1;
		}
		if(p1.getDestreza() > p2.getDestreza()) {
			return 1;
		}
		if(Math.abs(p1.getDestreza() - p2.getDestreza()) == 0.0) {
			//En caso de empate, por nombre
			return new PilotoNombreComparator().compare(p1, p2);
		}
		return 0;
	}

}
