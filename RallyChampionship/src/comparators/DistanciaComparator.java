package comparators;

import java.util.Comparator;

import circuitos.Circuito;

public class DistanciaComparator implements Comparator<Circuito>{
	@Override
	public int compare(Circuito c1, Circuito c2) {
		if(c1.getDistanciaModificada() < c2.getDistanciaModificada()) {
			return -1;
		}
		if(c1.getDistanciaModificada() > c2.getDistanciaModificada()) {
			return 1;
		}
		if(Math.abs(c1.getDistanciaModificada() - c2.getDistanciaModificada()) == 0.0) {
			//En caso de empate, por nombre
			return new CircuitoNombreComparator().compare(c1, c2);
		}
		return 0;
	}
}
